package com.logistics_management.service;


import com.github.pagehelper.Page;
import com.logistics_management.domain.Car;

import java.util.List;
import java.util.Map;

public interface CarService {

    /**
     * 查询所有
     * @return
     */
    public List<Car> findAll();
    
    Page<Car> search(Map searchMap);

    Boolean addCar(Car car);

    

    Boolean update(Car car);


    Boolean del(List<Integer> ids);

    Car findCarById(Integer id);
}
