package de.adfcommunity.altaui.view.ic.beans;

import java.io.Serializable;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.AttributeBinding;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;


public class RefillStockController implements Serializable {
    @SuppressWarnings("compatibility:-1864568424941810539")
    private static final long serialVersionUID = 1L;

    private Integer warehouseToRestock;
    private Integer productToRestock;

    public void setWarehouseToRestock(Integer warehouseToRestock) {
        this.warehouseToRestock = warehouseToRestock;
    }

    public Integer getWarehouseToRestock() {
        return warehouseToRestock;
    }

    public void setProductToRestock(Integer productToRestock) {
        this.productToRestock = productToRestock;
    }

    public Integer getProductToRestock() {
        return productToRestock;
    }

    public RefillStockController() {
        super();
    }


    /**
     * Any stock that is substracted from a warehouse is added to the main warehouse.
     *
     * @param valueChangeEvent Event that is fired by slider components in refill-stock component
     */
    @SuppressWarnings("unchecked")
    public void onSliderChange(ValueChangeEvent valueChangeEvent) {
        
        // update initial value of slider to model
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        
        // get difference of valueChangeEvent
        Integer newValue = (Integer)valueChangeEvent.getNewValue();
        Integer oldValue = (Integer)valueChangeEvent.getOldValue();
        Integer difference = oldValue - newValue;
        
        // acquire main warehouse product infos
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding amountInStock = (AttributeBinding)bindings.findCtrlBinding("AmountInStockMainWarehouse");
        Integer currentItemsInStock = (Integer)amountInStock.getInputValue();
        Integer maxItemsInStock = (Integer)((AttributeBinding)bindings.findCtrlBinding("MaxInStock")).getInputValue();
        
        if(difference > 0){
            // in case we draw more items than necessary, reset the slider to the needed amount
            if(currentItemsInStock + difference > maxItemsInStock){
                Integer leftovers = difference - (maxItemsInStock - currentItemsInStock);
                newValue += leftovers;
                amountInStock.setInputValue(maxItemsInStock);
                
                // call method on view object to update the slider once again
                OperationBinding changeStockToValueOperation = bindings.getOperationBinding("changeStockToValue");
                Map map = changeStockToValueOperation.getParamsMap();
                map.put("warehouseId", valueChangeEvent.getComponent().getAttributes().get("WarehouseId"));
                map.put("amountInStock", newValue);
                changeStockToValueOperation.execute();
                
                // refresh slider UI Component
                AdfFacesContext.getCurrentInstance().addPartialTarget(valueChangeEvent.getComponent());
            }
            else 
                amountInStock.setInputValue(currentItemsInStock + difference);
        }
        else{
            amountInStock.setInputValue(currentItemsInStock + difference);
        }
        
    }
}
