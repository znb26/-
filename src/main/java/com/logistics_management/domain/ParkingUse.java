package com.logistics_management.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 车位使用表实体类
 */
@Table(name = "tb_parking_use")
public class ParkingUse implements Serializable {
    @Id
    private Integer id;//车位使用id
    private String communityName;//所属小区名称
    private Integer communityId;//所属小区id
    private String code;//车位编号
    private String carNumber;//车牌号码
    private String picture;//车辆牌照
    private String ownerName;//车辆所有人名称
    private Integer ownerId;//车辆所有人id
    private Integer telephone;//联系方式
    private String useType;//使用性质：0-购买(默认)，1-月租，2-年租
    private Integer totalFee;//总费用(￥)，以分为单位
    private  Date createTime;//创建时间
    private Date updateTime;//更新时间
    private Date startTime;//开始时间
    private Date endTime;//结束时间

    public ParkingUse() {
    }

    public ParkingUse(Integer id, String communityName, Integer communityId, String code, String carNumber, String picture, String ownerName, Integer ownerId, Integer telephone, String useType, Integer totalFee, Date createTime, Date updateTime, Date startTime, Date endTime) {
        this.id = id;
        this.communityName = communityName;
        this.communityId = communityId;
        this.code = code;
        this.carNumber = carNumber;
        this.picture = picture;
        this.ownerName = ownerName;
        this.ownerId = ownerId;
        this.telephone = telephone;
        this.useType = useType;
        this.totalFee = totalFee;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "ParkingUse{" +
                "id=" + id +
                ", communityName='" + communityName + '\'' +
                ", communityId=" + communityId +
                ", code='" + code + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", picture='" + picture + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerId=" + ownerId +
                ", telephone=" + telephone +
                ", useType='" + useType + '\'' +
                ", totalFee=" + totalFee +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
