package com.logistics_management.service.Impl;

import com.logistics_management.dao.ChargeDao;
import com.logistics_management.domain.ChargeItem;
import com.logistics_management.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChargeServiceImpl implements ChargeService {

    @Autowired
    private ChargeDao chargeDao;

    @Override
    public List<ChargeItem> findAll() {
        return chargeDao.selectAll();
    }
}
