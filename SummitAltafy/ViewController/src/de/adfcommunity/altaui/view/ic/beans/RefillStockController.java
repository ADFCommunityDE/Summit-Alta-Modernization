package de.adfcommunity.altaui.view.ic.beans;


public class RefillStockController {
    
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
    
    
    
}
