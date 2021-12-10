package com.logistics_management.service;



import com.github.pagehelper.Page;
import com.logistics_management.domain.ChargeDetail;

import java.util.List;
import java.util.Map;

public interface ChargeDetailService {
    //查询所以收费明细
    public List<ChargeDetail> findAllChargeDetail();

    Page<ChargeDetail> search(Map searchMap);

    Boolean add(ChargeDetail chargeDetail);

    ChargeDetail findById(Integer id);

    Boolean update(ChargeDetail chargeDetail);

    Boolean updateStatus(String status, Integer id);

    Boolean del(List<Integer> ids);
}
