package com.logistics_management.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 维修表
 */
@Table(name = "tb_repair")
public class Repair implements Serializable {
    @Id
    private Integer id;//维修id
    private String communityName;//所属小区名称
    private Integer communityId;//所属小区id
    private String buildingName;//所属楼栋名称
    private Integer buildingId;//所属楼栋id
    private String ownerName;//报修人员名称
    private Integer ownerId;//保修人员id
    private String deviceName;//设备名称
    private Integer deviceId;//设备编号id
    private String description;//报修描述
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String status;//状态：0-待受理，1-已受理，2-修理完毕

    public Repair() {
    }

    public Repair(Integer id, String communityName, Integer communityId, String buildingName, Integer buildingId, String ownerName, Integer ownerId, String deviceName, Integer deviceId, String description, Date createTime, Date updateTime, String status) {
        this.id = id;
        this.communityName = communityName;
        this.communityId = communityId;
        this.buildingName = buildingName;
        this.buildingId = buildingId;
        this.ownerName = ownerName;
        this.ownerId = ownerId;
        this.deviceName = deviceName;
        this.deviceId = deviceId;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", communityName='" + communityName + '\'' +
                ", communityId=" + communityId +
                ", buildingName='" + buildingName + '\'' +
                ", buildingId=" + buildingId +
                ", ownerName='" + ownerName + '\'' +
                ", ownerId=" + ownerId +
                ", deviceName='" + deviceName + '\'' +
                ", deviceId=" + deviceId +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status='" + status + '\'' +
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

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
