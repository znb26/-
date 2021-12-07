package com.logistics_management.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.io.Serializable;

/**
 * create by dongjiayao zhangningbo zhangkuan on 2021/12/7
 */
@Table(name = "tb_building")
public class Building implements Serializable {
    @Id
    private Integer id;  //楼栋id
    private String community_name;//所属小区名称
    private Integer community_id; //所属小区id
    private String name;//楼栋名称
    private Integer total_households;//总户数
    private String description;//描述
    private Date create_time;//创建时间
    private Date update_time;//更新时间

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal_households() {
        return total_households;
    }

    public void setTotal_households(Integer total_households) {
        this.total_households = total_households;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
