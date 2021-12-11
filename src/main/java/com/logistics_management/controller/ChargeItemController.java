package com.logistics_management.controller;

import com.github.pagehelper.Page;
import com.logistics_management.common.MessageConstant;
import com.logistics_management.common.PageResult;
import com.logistics_management.common.Result;
import com.logistics_management.common.StatusCode;
import com.logistics_management.domain.ChargeItem;
import com.logistics_management.service.ChargeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 收费项目控制层
 */
@RestController
@RequestMapping("/chargeItem")
public class ChargeItemController {

    @Autowired
    private ChargeItemService chargeItemService;



    @RequestMapping("/findItem")
    public Result findItem(){
        List<ChargeItem> all = chargeItemService.findAllItem();
        return new Result(false,StatusCode.OK,"请求成功",all);
    }

    /**
     * 分页查询
     * @param searchMap
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<ChargeItem> page = chargeItemService.search(searchMap);
        return new PageResult(true,StatusCode.OK,MessageConstant.CHARGE_ITEM_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    /**
     * 添加活动
     * @return
     */
    @RequestMapping("/add")
    public Result addActivity(@RequestBody ChargeItem chargeItem){
        Boolean b = chargeItemService.add(chargeItem);
        return new Result(true, StatusCode.OK, MessageConstant.CHARGE_ITEM_ADD_SUCCESS);
    }

    /**
     * 根据id查询活动
     * @return
     */
    @RequestMapping("/findById")
    public Result findActivityById(Integer id){
        ChargeItem chargeItem = chargeItemService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.CHARGE_ITEM_FIND_BY_ID_SUCCESS,chargeItem);
    }

    /**
     * 更新
     * @param
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody ChargeItem chargeItem){
        Boolean b = chargeItemService.update(chargeItem);
        return new Result(true, StatusCode.OK, MessageConstant.CHARGE_ITEM_UPDATE_SUCCESS);
    }

    /**
     * 更新状态
     * @param status
     * @param id
     * @return
     */
    @RequestMapping("/updateStatus/{status}/{id}")
    public Result updateStatus(@PathVariable("status") String status, @PathVariable("id") Integer id){
        Boolean b = chargeItemService.updateStatus(status,id);
        return new Result(true,StatusCode.OK,MessageConstant.CHARGE_ITEM_UPDATE_STATUS_SUCCESS);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        Boolean b = chargeItemService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.CHARGE_ITEM_DELETE_SUCCESS);
    }

}
