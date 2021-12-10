package com.logistics_management.dao;

import com.logistics_management.domain.Car;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CarDao extends Mapper<Car> {
}
