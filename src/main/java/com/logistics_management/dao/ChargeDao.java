package com.logistics_management.dao;

import com.logistics_management.domain.Charge_item;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ChargeDao extends Mapper<Charge_item> {
}
