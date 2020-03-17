package com.example.user54.InventoryApp.Model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class ItemInfo  {

    private String itemCode ;
    private String itemName ;
    private float itemQty;
    private float rowIndex;
    private String itemLocation ;
    private int serialNo ;
    private String ExpDate ;
    private float salePrice;
    private String TrnDate;
    private String isExport;

    public ItemInfo() {

    }

    public ItemInfo(String itemCode, String itemName, float itemQty, float rowIndex,
                    String itemLocation, int serialNo, String expDate, float salePrice,
                    String trnDate, String isExport) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.rowIndex = rowIndex;
        this.itemLocation = itemLocation;
        this.serialNo = serialNo;
        this.ExpDate = expDate;
        this.salePrice = salePrice;
        this.TrnDate = trnDate;
        this.isExport = isExport;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemQty(float itemQty) {
        this.itemQty = itemQty;
    }

    public void setRowIndex(float rowIndex) {
        this.rowIndex = rowIndex;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public void setExpDate(String expDate) {
        ExpDate = expDate;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
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

    public float getRowIndex() {
        return rowIndex;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public String getExpDate() {
        return ExpDate;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public String getTrnDate() {
        return TrnDate;
    }

    public String getIsExport() {
        return isExport;
    }

    public void setIsExport(String isExport) {
        this.isExport = isExport;
    }

    public void setTrnDate(String trnDate) {
        TrnDate = trnDate;
    }

    //{"JRD":[{"ITEMCODE":"10115","ITEMNAME":"مادة1","STORENO":"1","ITEMQTY":"10","ROWINDEX":"1","EXPIRYDATE":"18/10/2025","TRDATE":"20/02/2020","SALESPRICE":"1.10"},{"ITEMCODE":"10115","ITEMNAME":"مادة1","STORENO":"1","ITEMQTY":"10","ROWINDEX":"1","EXPIRYDATE":"18/10/2025","TRDATE":"20/02/2020","SALESPRICE":"1.11"}]}
    public JSONObject getJSONObject2() { // for server
        JSONObject obj = new JSONObject();
        try {
            obj.put("ITEMCODE", itemCode);
            obj.put("ITEMNAME", itemName);
            obj.put("STORENO", itemLocation);
            obj.put("ITEMQTY", itemQty);
            obj.put("ROWINDEX", rowIndex);
            obj.put("EXPIRYDATE",ExpDate );
            obj.put("TRDATE", TrnDate);
            obj.put("SALESPRICE", salePrice);

        } catch (JSONException e) {
            Log.e("Tag" , "JSONException");
        }
        return obj;
    }
}
