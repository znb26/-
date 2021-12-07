package com.logistics_management.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * create by dongjiayao zhangningbo zhangkuan on 2021/12/7
 */
@Table(name = "tb_charge_detail")
public class Charge_detail implements Serializable {
    private Integer id;//收费明细ID
    private Integer community_id;//所属小区ID
    private String community_name;//所属小区名称
    private Integer charge_item_id;//收费项目id
    private String charge_item_name;//收费项目名称
    private String contractor;//承办人名称
    private Integer telephone;//承办人联系电话
    private Integer pay_money;//应收金额（单位：分）
    private Integer actual_money;//实收金额（单位：分）
    private Date create_time;//创建时间
    private Date update_time;//更新时间
    private Date pay_time;//缴费时间
    private String status;//状态：0-生效中（默认），1-已过期

}
