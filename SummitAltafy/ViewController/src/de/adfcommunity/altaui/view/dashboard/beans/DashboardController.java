package de.adfcommunity.altaui.view.dashboard.beans;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import oracle.jbo.Key;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class DashboardController {
    
    private Integer selectedLowStockWarehouseId;
    private Integer selectedLowStockProductId;
    
    public DashboardController() {
        super();
    }


    public void setSelectedLowStockWarehouseId(Integer selectedLowStockWarehouseId) {
        this.selectedLowStockWarehouseId = selectedLowStockWarehouseId;
    }

    public Integer getSelectedLowStockWarehouseId() {
        return selectedLowStockWarehouseId;
    }

    public void setSelectedLowStockProductId(Integer selectedLowStockProductId) {
        this.selectedLowStockProductId = selectedLowStockProductId;
    }

    public Integer getSelectedLowStockProductId() {
        return selectedLowStockProductId;
    }

    public void onLowStockBarSelection(SelectionEvent selectionEvent) {
        
        // get selected bar info
        RowKeySet keyset = selectionEvent.getAddedSet();
        Iterator iter = keyset.iterator();
        
        Integer selectedWarehouseId = 0;
        Integer selectedProductId = 0;
        
        while(iter.hasNext()){
            // obtain oracle key from keyset
            List list = (List)iter.next();
            Key key = (Key)list.get(0);

            // gather values of key
            // TODO: less hard coded approach please
            selectedWarehouseId = (Integer) key.getKeyValues()[1];
            selectedProductId = (Integer)key.getKeyValues()[0];
        
        }
        
        // set found key id's to process further in refill stock tf
        setSelectedLowStockProductId(selectedProductId);
        setSelectedLowStockWarehouseId(selectedWarehouseId); 
        
        // since this is a non navigation event, find a button and process its action
        // TODO: replace by JSFUtils.findComponentInRoot(...)
        UIComponent item = selectionEvent.getComponent();
        UIComponent group = item.getParent();
        ActionEvent actionEvent = new ActionEvent(group.getChildren().get(0));
        actionEvent.queue();


    }
}
