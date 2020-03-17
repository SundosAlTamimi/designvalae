package com.example.user54.InventoryApp.Model;

public class ItemCard {

    private String itemCode;
    private String itemName;
    private String costPrc;
    private String salePrc;
    private String AVLQty;
    private String FDPRC;
    private String branchId;
    private String branchName;
    private String departmentId;
    private String departmentName;
    private String itemG;
    private String itemK;
    private String itemL;
    private String itemDiv;
    private String itemGs;
    private String orgPrice;
    private String inDate;
    private boolean check;
    public ItemCard() {

    }

    public ItemCard(String itemCode, String itemName, String costPrc, String salePrc,
                    String AVLQty, String FDPRC, String branchId, String branchName, String departmentId,
                    String departmentName, String itemG, String itemK, String itemL
            , String itemDiv, String itemGs, String orgPrice, String inDate, boolean check) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.costPrc = costPrc;
        this.salePrc = salePrc;
        this.AVLQty = AVLQty;
        this.FDPRC = FDPRC;
        this.branchId = branchId;
        this.branchName = branchName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.itemG = itemG;
        this.itemK = itemK;
        this.itemL = itemL;
        this.itemDiv = itemDiv;
        this.itemGs = itemGs;
        this.orgPrice = orgPrice;
        this.inDate = inDate;
        this.check = check;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCostPrc() {
        return costPrc;
    }

    public void setCostPrc(String costPrc) {
        this.costPrc = costPrc;
    }

    public String getSalePrc() {
        return salePrc;
    }

    public void setSalePrc(String salePrc) {
        this.salePrc = salePrc;
    }

    public String getAVLQty() {
        return AVLQty;
    }

    public void setAVLQty(String AVLQty) {
        this.AVLQty = AVLQty;
    }

    public String getFDPRC() {
        return FDPRC;
    }

    public void setFDPRC(String FDPRC) {
        this.FDPRC = FDPRC;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getItemG() {
        return itemG;
    }

    public void setItemG(String itemG) {
        this.itemG = itemG;
    }

    public String getItemK() {
        return itemK;
    }

    public void setItemK(String itemK) {
        this.itemK = itemK;
    }

    public String getItemL() {
        return itemL;
    }

    public void setItemL(String itemL) {
        this.itemL = itemL;
    }

    public String getItemDiv() {
        return itemDiv;
    }

    public void setItemDiv(String itemDiv) {
        this.itemDiv = itemDiv;
    }

    public String getItemGs() {
        return itemGs;
    }

    public void setItemGs(String itemGs) {
        this.itemGs = itemGs;
    }

    public String getOrgPrice() {
        return orgPrice;
    }

    public void setOrgPrice(String orgPrice) {
        this.orgPrice = orgPrice;
    }

    public boolean getCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }
}
