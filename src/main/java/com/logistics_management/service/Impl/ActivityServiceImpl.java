package com.logistics_management.service.Impl;

import com.logistics_management.dao.ActivityDao;
import com.logistics_management.domain.Activity;
import com.logistics_management.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;
    @Override
    public List<Activity> findAll() {
        List<Activity> list = activityDao.selectAll();
        return list;
    }
}
