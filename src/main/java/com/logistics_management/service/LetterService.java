package com.logistics_management.service;

import com.github.pagehelper.Page;
import com.logistics_management.domain.Letter;

import java.util.List;
import java.util.Map;

public interface LetterService {
    Page<Letter> search(Map searchMap);

    Boolean add(Letter letter);

    Letter findById(Integer id);

    Boolean update(Letter letter);

    Boolean updateStatus(String status, Integer id);

    Boolean del(List<Integer> ids);
}
