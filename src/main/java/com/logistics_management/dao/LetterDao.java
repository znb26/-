package com.logistics_management.dao;

import com.logistics_management.domain.Letter;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface LetterDao extends Mapper<Letter> {
}
