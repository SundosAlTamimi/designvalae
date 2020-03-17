package com.example.user54.InventoryApp.Model;

public class ItemQty {

    private String itemCode ;
    private String itemName ;
    private String Qty;

    public ItemQty() {

    }

    public ItemQty(String itemCode, String itemName, String qty) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.Qty = qty;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    //_______________________________________________________________________

    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public String getQty() {
        return Qty;
    }
}
