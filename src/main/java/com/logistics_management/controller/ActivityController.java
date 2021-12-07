package com.logistics_management.controller;

import com.logistics_management.common.Result;
import com.logistics_management.domain.Activity;
import com.logistics_management.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("/find")
    public Result find(){
        List<Activity> all = activityService.findAll();
        return new Result(false,2000,"请求成功",all);
    }
}
