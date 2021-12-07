package com.logistics_management.domain;

import javax.persistence.Table;
import java.util.Date;
import java.io.Serializable;

/**
 * create by dongjiayao zhangningbo zhangkuan on 2021/12/7
 */
@Table(name = "tb_building")
public class Building implements Serializable {
    private Integer id;  //楼栋id
    private String community_name;//所属小区名称
    private Integer community_id; //所属小区id
    private String name;//楼栋名称
    private Integer total_households;//总户数
    private String description;//描述
    private Date create_time;//创建时间
    private Date update_time;//更新时间



}
