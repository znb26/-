package com.logistics_management.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * create by dongjiayao zhangningbo zhangkuatb_complaint/7
 */
@Table(name="tb_community")
public class Complaint implements Serializable {
    private Integer id;//投诉id
    private String community_name;//所属小区名称
    private Integer community_id;//所属小区id
    private Integer owner_id;//投诉人员id
    private String owner_name;//投诉人员名称
    private String description;//投诉具体描述
    private String reason;//投诉事由
    private Date create_time;//创建时间
    private Date update_time;//更新时间
    private String status;//状态：0-未受理，1-已受理（默认），2-已处理完毕
}
