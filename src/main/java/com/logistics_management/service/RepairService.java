package com.logistics_management.service;

import com.github.pagehelper.Page;
import com.logistics_management.domain.Repair;

import java.util.List;
import java.util.Map;

public interface RepairService {

    /**
     * 查询维修表
     * @return
     */
    public List<Repair> findAll();
    
    Page<Repair> search(Map searchMap);

    Boolean add(Repair repair);

    Repair findById(Integer id);

    Boolean update(Repair repair);

    Boolean updateStatus(String status, Integer id);

    Boolean del(List<Integer> ids);
}
