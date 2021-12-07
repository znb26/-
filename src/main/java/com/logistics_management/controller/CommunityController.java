package com.logistics_management.controller;

import com.logistics_management.common.Result;
import com.logistics_management.domain.Community;
import com.logistics_management.service.CommunityService;
import com.logistics_management.service.Impl.CommunityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auth: 董嘉耀、张宽、张宁波
 * @Desc: 小区管理控制层:只负责接收前端浏览器发送的请求和请求参数，调用service层获取业务逻辑加工处理后的数据
 */
@RestController
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService = new CommunityServiceImpl();
    @RequestMapping("/find")
    public Result find(){
        List<Community> all = communityService.findAll();
        return new Result(false,200,"请求成功",all);
    }
}
