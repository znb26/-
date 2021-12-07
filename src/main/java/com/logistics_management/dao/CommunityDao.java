package com.logistics_management.dao;

import com.logistics_management.domain.Community;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CommunityDao extends Mapper<Community> {
}
