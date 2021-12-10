package com.logistics_management.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * create by dongjiayao zhangningbo zhangkuatb_device/7
 */
@Table(name = "tb_device")
public class Device implements Serializable {
    @Id
    private Integer id;//设备id
    private String communityName;//所属小区名称
    private Integer communityId;//所属小区id
    private String code;//设备编号
    private String name;//设备名称
    private String brand;//设备品牌
    private Integer unitPrice;//购买单价（单位分）
    private Integer num; //购买数量
    private Integer expectedUsefulLife;//预计使用年限
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private Date purchaseTate;//购买日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getExpectedUsefulLife() {
        return expectedUsefulLife;
    }

    public void setExpectedUsefulLife(Integer expectedUsefulLife) {
        this.expectedUsefulLife = expectedUsefulLife;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPurchaseTate() {
        return purchaseTate;
    }

    public void setPurchaseTate(Date purchaseTate) {
        this.purchaseTate = purchaseTate;
    }
}
