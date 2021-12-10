package com.logistics_management.service;



import com.github.pagehelper.Page;
import com.logistics_management.domain.ChargeItem;

import java.util.List;
import java.util.Map;

public interface ChargeItemService {

    //查询所以收费项目
    public List<ChargeItem> findAllItem();
    
    Page<ChargeItem> search(Map searchMap);

    Boolean add(ChargeItem chargeItem);

    ChargeItem findById(Integer id);

    Boolean update(ChargeItem chargeItem);

    Boolean updateStatus(String status, Integer id);

    Boolean del(List<Integer> ids);
}
