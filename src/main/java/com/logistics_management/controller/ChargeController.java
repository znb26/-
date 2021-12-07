package com.logistics_management.controller;

import com.logistics_management.common.Result;
import com.logistics_management.domain.Charge_item;
import com.logistics_management.domain.Community;
import com.logistics_management.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 收费项目控制层
 */
@RestController
@RequestMapping("/charge")
public class ChargeController {

    @Autowired
    private ChargeService chargeService;

    @RequestMapping("/find")
    public Result find(){
        List<Charge_item> all = chargeService.findAll();
        return new Result(false,200,"请求成功",all);
    }
}
