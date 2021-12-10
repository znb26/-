package com.logistics_management.controller;

import com.github.pagehelper.Page;
import com.logistics_management.common.MessageConstant;
import com.logistics_management.common.PageResult;
import com.logistics_management.common.Result;
import com.logistics_management.common.StatusCode;
import com.logistics_management.domain.ChargeDetail;
import com.logistics_management.service.ChargeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chargeDetail")
public class ChargeDetailController {
    @Autowired
    private ChargeDetailService chargeDetailService;

    @RequestMapping("/findAllChargeDetail")
    public Result findAllChargeDetail(){
        List<ChargeDetail> all = chargeDetailService.findAllChargeDetail();
        return new Result(false,2000,"请求成功",all);
    }
    /**
     * 分页查询
     * @param searchMap
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<ChargeDetail> page = chargeDetailService.search(searchMap);
        return new PageResult(true,2000,"查询小区列表成功",page.getResult(),page.getTotal());
    }

    /**
     * 添加活动
     * @return
     */
    @RequestMapping("/addChargeDetail")
    public Result addActivity(@RequestBody ChargeDetail chargeDetail){
        //Activity activity = new Activity(null,"翻斗花园",30,"红十字互助1","A操场","物业",new Date(),new Date(),new Date(),new Date(),"0");
        Boolean b = chargeDetailService.add(chargeDetail);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_ADD_SUCCESS);
    }

    /**
     * 根据id查询活动
     * @return
     */
    @RequestMapping("/findChargeDetailById")
    public Result findActivityById(Integer id){
        ChargeDetail chargeDetail = chargeDetailService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS,chargeDetail);
    }

    /**
     * 更新
     * @param
     * @return
     */
    @RequestMapping("/updateChargeDetail")
    public Result update(@RequestBody ChargeDetail chargeDetail){
        Boolean b = chargeDetailService.update(chargeDetail);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }

    /**
     * 更新状态
     * @param status
     * @param id
     * @return
     */
    @RequestMapping("/updateStatus/{status}/{id}")
    public Result updateStatus(@PathVariable("status") String status, @PathVariable("id") Integer id){
        Boolean b = chargeDetailService.updateStatus(status,id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_STATUS_SUCCESS);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        Boolean b = chargeDetailService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }
}
