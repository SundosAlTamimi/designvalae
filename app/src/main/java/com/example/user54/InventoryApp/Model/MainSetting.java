package com.example.user54.InventoryApp.Model;

public class MainSetting {

    private String IP;
    private String StorNo;
    private String isAssest;


    public MainSetting() {
    }

    public MainSetting(String IP, String storNo, String isAssest) {
        this.IP = IP;
        this.StorNo = storNo;
        this.isAssest = isAssest;
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

    public String getIsAssest() {
        return isAssest;
    }

    public void setIsAssest(String isAssest) {
        this.isAssest = isAssest;
    }
}
