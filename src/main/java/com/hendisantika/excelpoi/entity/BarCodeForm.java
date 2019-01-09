package com.hendisantika.excelpoi.entity;

/**
 * Created by liuyan on 2019/1/9.
 */
public class BarCodeForm {

    private String itemNo;
    private String itemName;
    private String pym;
    private String itemSize;
    private String unitNo;
    private String productArea;
    private String createTime;
    private String createByName;
    private String updateTime;
    private String updateByName;

    public BarCodeForm(String itemNo, String itemName, String pym, String itemSize, String unitNo, String productArea, String createTime, String createByName, String updateTime, String updateByName) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.pym = pym;
        this.itemSize = itemSize;
        this.unitNo = unitNo;
        this.productArea = productArea;
        this.createTime = createTime;
        this.createByName = createByName;
        this.updateTime = updateTime;
        this.updateByName = updateByName;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPym() {
        return pym;
    }

    public void setPym(String pym) {
        this.pym = pym;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getProductArea() {
        return productArea;
    }

    public void setProductArea(String productArea) {
        this.productArea = productArea;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName;
    }
}
