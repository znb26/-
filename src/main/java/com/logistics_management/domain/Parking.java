package com.logistics_management.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 车位表实体类
 * 开始测试
 */
@Table(name = "tb_parking")
public class Parking implements Serializable {
    @Id
    private Integer id;//车位id
    private String communityName;//所属小区名称
    private Integer communityId;//所属小id
    private String picture;//车位图片
    private String code;//车位编号
    private String name;//车位名称
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

    public Parking() {
    }

    public Parking(Integer id, String communityName, Integer communityId, String picture, String code, String name, Date createTime, Date updateTime) {
        this.id = id;
        this.communityName = communityName;
        this.communityId = communityId;
        this.picture = picture;
        this.code = code;
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", communityName='" + communityName + '\'' +
                ", communityId=" + communityId +
                ", picture='" + picture + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
