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
    private String communityName;//所属小区名称
    private Integer communityId; //所属小区id
    private String name;//楼栋名称
    private Integer totalHouseholds;//总户数
    private String description;//描述
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalHouseholds() {
        return totalHouseholds;
    }

    public void setTotalHouseholds(Integer totalHouseholds) {
        this.totalHouseholds = totalHouseholds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
