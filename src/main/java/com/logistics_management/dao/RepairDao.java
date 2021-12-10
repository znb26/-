package com.logistics_management.dao;

import com.logistics_management.domain.Repair;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface RepairDao extends Mapper<Repair> {
}
