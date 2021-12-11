package com.logistics_management.controller;

import com.github.pagehelper.Page;
import com.logistics_management.common.MessageConstant;
import com.logistics_management.common.PageResult;
import com.logistics_management.common.Result;
import com.logistics_management.common.StatusCode;
import com.logistics_management.domain.Parking;
import com.logistics_management.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    /**
     * 分页查询
     * @param searchMap
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Parking> page = parkingService.search(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.PARKING_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    /**
     * 添加活动
     * @return
     */
    @RequestMapping("/add")
    public Result addActivity(@RequestBody Parking parking){
        Boolean b = parkingService.add(parking);
        return new Result(true, StatusCode.OK, MessageConstant.PARKING_ADD_SUCCESS);
    }

    /**
     * 根据id查询活动
     * @return
     */
    @RequestMapping("/findById")
    public Result findActivityById(Integer id){
        Parking parking = parkingService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.PARKING_FIND_BY_ID_SUCCESS,parking);
    }

    /**
     * 更新
     * @param
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Parking parking){
        Boolean b = parkingService.update(parking);
        return new Result(true, StatusCode.OK, MessageConstant.PARKING_UPDATE_SUCCESS);
    }

    /**
     * 更新状态
     * @param status
     * @param id
     * @return
     */
    @RequestMapping("/updateStatus/{status}/{id}")
    public Result updateStatus(@PathVariable("status") String status, @PathVariable("id") Integer id){
        Boolean b = parkingService.updateStatus(status,id);
        return new Result(true,StatusCode.OK,MessageConstant.PARKING_UPDATE_STATUS_SUCCESS);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        Boolean b = parkingService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.PARKING_DELETE_SUCCESS);
    }
}
