package com.logistics_management.dao;

import com.logistics_management.domain.Activity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ActivityDao extends Mapper<Activity> {
}
