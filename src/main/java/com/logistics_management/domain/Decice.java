package com.logistics_management.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * create by dongjiayao zhangningbo zhangkuatb_device/7
 */
@Table(name = "tb_device")
public class Decice implements Serializable {
    private Integer id;//设备id
    private String community_name;//所属小区名称
    private Integer community_id;//所属小区id
    private String code;//设备编号
    private String name;//设备名称
    private String brand;//设备品牌
    private Integer unit_price;//购买单价（单位分）
    private Integer num; //购买数量
    private Integer expected_useful_life;//预计使用年限
    private Date create_time;//创建时间
    private Date update_time;//更新时间
    private Date purchase_date;//购买日期
}
