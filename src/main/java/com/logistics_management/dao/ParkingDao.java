package com.logistics_management.dao;

import com.logistics_management.domain.Parking;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ParkingDao extends Mapper<Parking> {
}
