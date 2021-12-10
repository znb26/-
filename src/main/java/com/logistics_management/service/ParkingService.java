package com.logistics_management.service;


import com.github.pagehelper.Page;
import com.logistics_management.domain.Parking;

import java.util.List;
import java.util.Map;

public interface ParkingService {
    
    Page<Parking> search(Map searchMap);

    Boolean del(List<Integer> ids);

    Boolean updateStatus(String status, Integer id);

    Boolean update(Parking parking);

    Parking findById(Integer id);

    Boolean add(Parking parking);
}
