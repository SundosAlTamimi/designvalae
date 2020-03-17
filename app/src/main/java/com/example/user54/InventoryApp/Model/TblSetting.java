package com.example.user54.InventoryApp.Model;

public class TblSetting {

    private String settingName;
    private int settingIntVal;
    private  String settingStrVal;

    public TblSetting() {
    }

    public TblSetting(String settingName, int settingIntVal, String settingStrVal) {
        this.settingName = settingName;
        this.settingIntVal = settingIntVal;
        this.settingStrVal = settingStrVal;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public void setSettingIntVal(int settingIntVal) {
        this.settingIntVal = settingIntVal;
    }

    public void setSettingStrVal(String settingStrVal) {
        this.settingStrVal = settingStrVal;
    }

    public String getSettingName() {
        return settingName;
    }

    public int getSettingIntVal() {
        return settingIntVal;
    }

    public String getSettingStrVal() {
        return settingStrVal;
    }
}
