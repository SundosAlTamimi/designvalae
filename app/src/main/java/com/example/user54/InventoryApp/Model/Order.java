package com.example.user54.InventoryApp.Model;

public class Order  {

    private int stockNo;
    private String loadDate;
    private float loadQty;
    private float netQty ;
    private String itemBarcode ;
    private String itemCode ;

    public Order() {
    }

    public Order(int stockNo, String loadDate, float loadQty,
                 float netQty, String itemBarcode, String itemCode) {
        this.stockNo = stockNo;
        this.loadDate = loadDate;
        this.loadQty = loadQty;
        this.netQty = netQty;
        this.itemBarcode = itemBarcode;
        this.itemCode = itemCode;
    }

    public void setStockNo(int stockNo) {
        this.stockNo = stockNo;
    }

    public void setLoadDate(String loadDate) {
        this.loadDate = loadDate;
    }

    public void setLoadQty(float loadQty) {
        this.loadQty = loadQty;
    }

    public void setNetQty(float netQty) {
        this.netQty = netQty;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    //_______________________________________________________________________
    public int getStockNo() {
        return stockNo;
    }

    public String getLoadDate() {
        return loadDate;
    }

    public float getLoadQty() {
        return loadQty;
    }

    public float getNetQty() {
        return netQty;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public String getItemCode() {
        return itemCode;
    }
}
