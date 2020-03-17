package com.example.user54.InventoryApp.Model;

public class ItemUnit {

    private String itemOCode;
    private String itemBarcode ;
    private float salePrice;
    private String itemU;
    private int UQty;
    private int uSerial;
    private int calcQty;
    private float wholeSalePrc;
    private float purchasePrc;
    private float pclAss1;
    private float pclAss2;
    private float pclAss3;
    private String inDate;
    private String unitName;

    public ItemUnit() {
    }

    public ItemUnit(String itemOCode, String itemBarcode, float salePrice,
                    String itemU, int UQty, int uesrIal, int calcQty, float wholeSalePrc,
                    float purchasePrc, float pclAss1, float pclAss2, float pclAss3,
                    String inDate, String unitName) {

        this.itemOCode = itemOCode;
        this.itemBarcode = itemBarcode;
        this.salePrice = salePrice;
        this.itemU = itemU;
        this.UQty = UQty;
        this.uSerial = uesrIal;
        this.calcQty = calcQty;
        this.wholeSalePrc = wholeSalePrc;
        this.purchasePrc = purchasePrc;
        this.pclAss1 = pclAss1;
        this.pclAss2 = pclAss2;
        this.pclAss3 = pclAss3;
        this.inDate = inDate;
        this.unitName = unitName;
    }

    public void setItemOCode(String itemOCode) {
        this.itemOCode = itemOCode;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public void setItemU(String itemU) {
        this.itemU = itemU;
    }

    public void setUQty(int UQty) {
        this.UQty = UQty;
    }

    public void setUSerial(int uesrIal) {
        this.uSerial = uesrIal;
    }

    public void setCalcQty(int calcQty) {
        this.calcQty = calcQty;
    }

    public void setWholeSalePrc(float wholeSalePrc) {
        this.wholeSalePrc = wholeSalePrc;
    }

    public void setPurchasePrc(float purchasePrc) {
        this.purchasePrc = purchasePrc;
    }

    public void setPclAss1(float pclAss1) {
        this.pclAss1 = pclAss1;
    }

    public void setPclAss2(float pclAss2) {
        this.pclAss2 = pclAss2;
    }

    public void setPclAss3(float pclAss3) {
        this.pclAss3 = pclAss3;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    //_________________________________________________________________________

    public String getItemOCode() {
        return itemOCode;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public String getItemU() {
        return itemU;
    }

    public int getUQty() {
        return UQty;
    }

    public int getuSerial() {
        return uSerial;
    }

    public int getCalcQty() {
        return calcQty;
    }

    public float getWholeSalePrc() {
        return wholeSalePrc;
    }

    public float getPurchasePrc() {
        return purchasePrc;
    }

    public float getPclAss1() {
        return pclAss1;
    }

    public float getPclAss2() {
        return pclAss2;
    }

    public float getPclAss3() {
        return pclAss3;
    }

    public String getInDate() {
        return inDate;
    }

    public String getUnitName() {
        return unitName;
    }
}
