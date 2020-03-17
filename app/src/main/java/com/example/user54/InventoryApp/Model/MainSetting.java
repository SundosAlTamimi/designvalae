package com.example.user54.InventoryApp.Model;

public class MainSetting {

    private String IP;
    private String StorNo;

    public MainSetting() {
    }

    public MainSetting(String IP, String storNo) {
        this.IP = IP;
        this.StorNo = storNo;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getStorNo() {
        return StorNo;
    }

    public void setStorNo(String storNo) {
        StorNo = storNo;
    }
}
