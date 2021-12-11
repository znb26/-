package com.logistics_management.controller;

import com.github.pagehelper.Page;
import com.logistics_management.common.MessageConstant;
import com.logistics_management.common.PageResult;
import com.logistics_management.common.Result;
import com.logistics_management.common.StatusCode;
import com.logistics_management.domain.Car;
import com.logistics_management.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 车辆管理对应 —— vehicle_list
 */
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * 1
     * @return
     */
    @RequestMapping("/find")
    public Result find(){
        List<Car> all = carService.findAll();
        return new Result(false,2000,"请求成功",all);
    }

    /**
     * 分页查询
     * @param searchMap
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Car> page = carService.search(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.VEHICLE_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    /**
     * 添加活动
     * @return
     */
    @RequestMapping("/add")
    public Result addActivity(@RequestBody Car car){
        //Activity activity = new Activity(null,"翻斗花园",30,"红十字互助1","A操场","物业",new Date(),new Date(),new Date(),new Date(),"0");
        Boolean b = carService.addCar(car);
        return new Result(true, StatusCode.OK, MessageConstant.VEHICLE_ADD_SUCCESS);
    }

    /**
     * 根据id查询活动
     * @return
     */
    @RequestMapping("/findById")
    public Result findActivityById(Integer id){
        Car car = carService.findCarById(id);
        return new Result(true, StatusCode.OK, MessageConstant.VEHICLE_FIND_BY_ID_SUCCESS,car);
    }

    /**
     * 更新
     * @param car
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Car car){
        Boolean b = carService.update(car);
        return new Result(true, StatusCode.OK, MessageConstant.VEHICLE_UPDATE_SUCCESS);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        Boolean b = carService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.VEHICLE_DELETE_SUCCESS);
    }
}
