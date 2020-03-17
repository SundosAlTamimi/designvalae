package com.example.user54.InventoryApp.Model;

public class Stk {

    private String StkNo;
    private  String StkName;

    public Stk() {

    }

    public Stk(String stkNo, String stkName) {
        StkNo = stkNo;
        StkName = stkName;
    }

    public String getStkNo() {
        return StkNo;
    }

    public void setStkNo(String stkNo) {
        StkNo = stkNo;
    }

    public String getStkName() {
        return StkName;
    }

    public void setStkName(String stkName) {
        StkName = stkName;
    }
}
