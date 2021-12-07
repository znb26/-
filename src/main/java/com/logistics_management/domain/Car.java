package com.logistics_management.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * create by dongjiayao zhangningbo zhangkuan on 2021/12/7
 */
@Table(name = "tb_car")
public class Car implements Serializable {
    private Integer id;//车辆id
    private String picture;//车辆照片
    private Integer owner_id;//所属成员（业主）
    private String color;//车辆颜色
    private String car_number;//车牌号
    private String remark;//备注
    private Date create_time;//创建时间
    private Date update_time;//更新时间
}
