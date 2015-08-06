package oracle.summit.backing;

import java.util.List;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.event.CarouselSpinEvent;

import oracle.jbo.Key;

public class InventoryControl {


    public void handleCarouselSpin(CarouselSpinEvent event) {
    // This method is invoked when there is a spin event on the carousel in InventoryControl.jsff
    // The purpose is to get the newly selected item in the carousel and update the iterator current row with the value   

    // get the bindingContainer    
        DCBindingContainer dcBindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
    // get the NewItemKey from the event object. The first entry in the list is the currently selected item
        List itemKeyList = (List) event.getNewItemKey();
    // create a Key ojbect instance and set it to the first key in the list
        Key currentItemKey = (Key) itemKeyList.get(0);
    // get the iteratorBinding    
        DCIteratorBinding inventoryIterator = dcBindings.findIteratorBinding("LowStockIterator");
    // set the iterator 
        inventoryIterator.setCurrentRowWithKey(currentItemKey.toStringFormat(true));

    }
}