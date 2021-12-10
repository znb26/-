package com.logistics_management.service;

import com.github.pagehelper.Page;
import com.logistics_management.domain.ParkingUse;

import java.util.List;
import java.util.Map;

public interface ParkingUseService {
    Page<ParkingUse> search(Map searchMap);

    Boolean add(ParkingUse parkingUse);

    ParkingUse findById(Integer id);

    Boolean update(ParkingUse parkingUse);

    Boolean updateStatus(String status, Integer id);

    Boolean del(List<Integer> ids);
}
