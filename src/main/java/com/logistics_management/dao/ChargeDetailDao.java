package com.logistics_management.dao;

import com.logistics_management.domain.ChargeDetail;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ChargeDetailDao extends Mapper<ChargeDetail> {
}
