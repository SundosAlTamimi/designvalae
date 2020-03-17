package com.example.user54.InventoryApp.Model;

public class ItemInfoExp  {

    private String itemCode ;
    private String itemName ;
    private float itemQty;
    private String expDate;
    private String batchNo;
    private float rowIndex;
    private String AVLQTY;
    private String costPrc;
    private String salePrc;
    private String receiptNo;
    private int serialNo;


    public ItemInfoExp() {

    }

    public ItemInfoExp(String itemCode, String itemName, float itemQty, String expDate
                        , String batchNo, float rowIndex, String AVLQTY,
                       String costPrc, String salePrc, String receiptNo, int serialNo) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.expDate = expDate;
        this.batchNo = batchNo;
        this.rowIndex = rowIndex;
        this.AVLQTY = AVLQTY;
        this.costPrc = costPrc;
        this.salePrc = salePrc;
        this.receiptNo = receiptNo;
        this.serialNo = serialNo;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemQty(float itemQty) {
        this.itemQty = itemQty;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public void setRowIndex(float rowIndex) {
        this.rowIndex = rowIndex;
    }

    public void setAVLQTY(String AVLQTY) {
        this.AVLQTY = AVLQTY;
    }

    public void setCostPrc(String costPrc) {
        this.costPrc = costPrc;
    }

    public void setSalePrc(String salePrc) {
        this.salePrc = salePrc;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public float getItemQty() {
        return itemQty;
    }

    public String getExpDate() {
        return expDate;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public float getRowIndex() {
        return rowIndex;
    }

    public String getAVLQTY() {
        return AVLQTY;
    }

    public String getCostPrc() {
        return costPrc;
    }

    public String getSalePrc() {
        return salePrc;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public int getSerialNo() {
        return serialNo;
    }
}
