package com.logistics_management.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * create by dongjiayao zhangningbo zhangkuatb_device/7
 */
@Table(name = "tb_device")
public class Device implements Serializable {
    private Integer id;//设备id
    private String community_name;//所属小区名称
    private Integer community_id;//所属小区id
    private String code;//设备编号
    private String name;//设备名称
    private String brand;//设备品牌
    private Integer unit_price;//购买单价（单位分）
    private Integer num; //购买数量
    private Integer expected_useful_life;//预计使用年限
    private Date create_time;//创建时间
    private Date update_time;//更新时间
    private Date purchase_date;//购买日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    public Integer getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(Integer community_id) {
        this.community_id = community_id;
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

    public Integer getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Integer unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getExpected_useful_life() {
        return expected_useful_life;
    }

    public void setExpected_useful_life(Integer expected_useful_life) {
        this.expected_useful_life = expected_useful_life;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }
}
