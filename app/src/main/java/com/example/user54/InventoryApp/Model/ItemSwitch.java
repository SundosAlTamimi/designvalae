package com.example.user54.InventoryApp.Model;

public class ItemSwitch {

    private String itemOCode;
    private String itemNCode;
    private String itemNameA;
    private String itemNameE;
    private String inDate;

    public ItemSwitch() {

    }

    public ItemSwitch(String itemOCode, String itemNCode, String itemNameA, String itemNameE, String inDate) {
        this.itemOCode = itemOCode;
        this.itemNCode = itemNCode;
        this.itemNameA = itemNameA;
        this.itemNameE = itemNameE;
        this.inDate = inDate;
    }

    public void setItemOCode(String itemOCode) {
        this.itemOCode = itemOCode;
    }

    public void setItemNCode(String itemNCode) {
        this.itemNCode = itemNCode;
    }

    public void setItemNameA(String itemNameA) {
        this.itemNameA = itemNameA;
    }

    public void setItemNameE(String itemNameE) {
        this.itemNameE = itemNameE;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }
    //__________________________________________________________________________________

    public String getItemOCode() {
        return itemOCode;
    }

    public String getItemNCode() {
        return itemNCode;
    }

    public String getItemNameA() {
        return itemNameA;
    }

    public String getItemNameE() {
        return itemNameE;
    }

    public String getInDate() {
        return inDate;
    }
}
