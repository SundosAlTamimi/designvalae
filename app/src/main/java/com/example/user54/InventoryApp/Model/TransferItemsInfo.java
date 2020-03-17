package com.example.user54.InventoryApp.Model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class TransferItemsInfo {

    private String itemCode ;
    private String itemName;
    private float itemQty;
    private String fromStr;
    private String toStr;
    private float rowIndex;
    private int VhfNo;
    private String isExport;
    private String TotalQty;

    public TransferItemsInfo() {

    }

    public TransferItemsInfo(String itemCode, String itemName, float itemQty,
                             String fromStr, String toStr, float rowIndex, int vhfNo, String isExport) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.fromStr = fromStr;
        this.toStr = toStr;
        this.rowIndex = rowIndex;
        this.VhfNo = vhfNo;
        this.isExport = isExport;
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

    public void setFromStr(String fromStr) {
        this.fromStr = fromStr;
    }

    public void setToStr(String toStr) {
        this.toStr = toStr;
    }

    public void setRowIndex(float rowIndex) {
        this.rowIndex = rowIndex;
    }

    public void setVhfNo(int vhfNo) {
        VhfNo = vhfNo;
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

    public String getFromStr() {
        return fromStr;
    }

    public String getToStr() {
        return toStr;
    }

    public float getRowIndex() {
        return rowIndex;
    }

    public int getVhfNo() {
        return VhfNo;
    }

    public String getIsExport() {
        return isExport;
    }

    public void setIsExport(String isExport) {
        this.isExport = isExport;
    }

    public String getTotalQty() {
        return TotalQty;
    }

    public void setTotalQty(String totalQty) {
        TotalQty = totalQty;
    }
    //:[{"ITEMCODE":"10115","ITEMNAME":"AAA","FRMSTR":"1","TOSTR":"2","VHFNO":"1","ITEMQTY":"30","ROWINDEX":"1"},{"ITEMCODE":"10116","ITEMNAME":"BBB","FRMSTR":"2","TOSTR":"3","VHFNO":"1","ITEMQTY":"40","ROWINDEX":"2"},{"ITEMCODE":"10117","ITEMNAME":"CCC","FRMSTR":"3","TOSTR":"4","VHFNO":"1","ITEMQTY":"50","ROWINDEX":"3"},{"ITEMCODE":"10118","ITEMNAME":"DDD","FRMSTR":"4","TOSTR":"5","VHFNO":"1","ITEMQTY":"60","ROWINDEX":"4"},{"ITEMCODE":"10119","ITEMNAME":"EEE","FRMSTR":"5","TOSTR":"1","VHFNO":"1","ITEMQTY":"70","ROWINDEX":"5"}]}

    public JSONObject getJSONObjectTranse() { // for server
        JSONObject obj = new JSONObject();
        try {
            obj.put("ITEMCODE", itemCode);
            obj.put("ITEMNAME", itemName);
            obj.put("FRMSTR", fromStr);
            obj.put("TOSTR", toStr);
            obj.put("VHFNO", VhfNo);
            obj.put("ITEMQTY",itemQty );
            obj.put("ROWINDEX", rowIndex);


        } catch (JSONException e) {
            Log.e("Tag" , "JSONException");
        }
        return obj;
    }
}
