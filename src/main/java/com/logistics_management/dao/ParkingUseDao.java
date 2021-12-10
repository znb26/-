package com.logistics_management.dao;

import com.logistics_management.domain.ParkingUse;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ParkingUseDao extends Mapper<ParkingUse> {
}
