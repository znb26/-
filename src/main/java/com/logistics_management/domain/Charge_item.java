package com.logistics_management.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * create by dongjiayao zhangningbo zhangkuan on 2021/12/7
 */
@Table(name = "tb_charge_item")
public class Charge_item implements Serializable {
    private Integer id; //收费项目id
    private Integer community_id;//所属小区id
    private String community_name;//所属小区名
    private String code;//收费编号
    private String name;//项目名称
    private Date create_time;//创建时间
    private Date update_time;//更新时间
    private Integer money;//项目收费金额（年），单位分
}
