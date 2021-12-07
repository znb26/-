package com.logistics_management.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * create by dongjiayao zhangningbo zhangkuan on 2021/12/7
 */
@Table(name = "tb_charge_detail")
public class Charge_detail implements Serializable {
    private Integer id;//收费明细ID
    private Integer community_id;//所属小区ID
    private String community_name;//所属小区名称
    private Integer charge_item_id;//收费项目id
    private String charge_item_name;//收费项目名称
    private String contractor;//承办人名称
    private Integer telephone;//承办人联系电话
    private Integer pay_money;//应收金额（单位：分）
    private Integer actual_money;//实收金额（单位：分）
    private Date create_time;//创建时间
    private Date update_time;//更新时间
    private Date pay_time;//缴费时间
    private String status;//状态：0-生效中（默认），1-已过期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(Integer community_id) {
        this.community_id = community_id;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    public Integer getCharge_item_id() {
        return charge_item_id;
    }

    public void setCharge_item_id(Integer charge_item_id) {
        this.charge_item_id = charge_item_id;
    }

    public String getCharge_item_name() {
        return charge_item_name;
    }

    public void setCharge_item_name(String charge_item_name) {
        this.charge_item_name = charge_item_name;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Integer getPay_money() {
        return pay_money;
    }

    public void setPay_money(Integer pay_money) {
        this.pay_money = pay_money;
    }

    public Integer getActual_money() {
        return actual_money;
    }

    public void setActual_money(Integer actual_money) {
        this.actual_money = actual_money;
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

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
