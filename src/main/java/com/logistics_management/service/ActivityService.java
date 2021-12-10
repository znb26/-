package com.logistics_management.service;

import com.github.pagehelper.Page;
import com.logistics_management.domain.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityService {

    List<Activity> findAll();

    Page<Activity> search(Map searchMap);

    Boolean addActivity(Activity activity);

    Activity findActivityById(Integer id);

    Boolean update(Activity activity);

    Boolean del(List<Integer> ids);

    Boolean updateStatus(String status, Integer id);
}
