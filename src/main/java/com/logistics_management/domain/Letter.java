package com.logistics_management.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name="tb_letter")
public class Letter {
    @Id
    private Integer id;//信件id
    private Integer communityId;//所属小区id
    private String communityName;//所属小区名称
    private Integer ownerId;//信件发送者id
    private String ownerName;//新建发送者名称
    private String origin;//信件来源：0-信箱（默认），1-邮件，2-微信，3-公众号，4-app,5-pc
    private String title;//信件标题
    private String content;//信件内容
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String status;//状态:0-未读（默认），1-已读

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
