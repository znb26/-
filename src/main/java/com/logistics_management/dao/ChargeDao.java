package com.logistics_management.dao;

import com.logistics_management.domain.ChargeItem;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ChargeDao extends Mapper<ChargeItem> {
}
