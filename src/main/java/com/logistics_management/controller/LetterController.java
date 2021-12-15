package com.logistics_management.controller;

import com.github.pagehelper.Page;
import com.logistics_management.common.MessageConstant;
import com.logistics_management.common.PageResult;
import com.logistics_management.common.Result;
import com.logistics_management.common.StatusCode;
import com.logistics_management.domain.Activity;
import com.logistics_management.domain.Letter;
import com.logistics_management.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/letter")
public class LetterController {

    @Autowired
    private LetterService letterService;

    /**
     * 分页
     * @param searchMap
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Letter> page = letterService.search(searchMap);
        return new PageResult(true, StatusCode.OK,"查询活动列表成功",page.getResult(),page.getTotal());
    }

    /**
     * 添加活动
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Letter letter){
        //Activity activity = new Activity(null,"翻斗花园",30,"红十字互助1","A操场","物业",new Date(),new Date(),new Date(),new Date(),"0");
        Boolean b = letterService.add(letter);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_ADD_SUCCESS);
    }

    /**
     * 根据id查询活动
     * @return
     */
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Letter letter = letterService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS,letter);
    }

    /**
     * 更新
     * @param activity
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Letter letter){
        Boolean b = letterService.update(letter);
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
        Boolean b = letterService.updateStatus(status,id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_STATUS_SUCCESS);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestBody List<Integer> ids){
        Boolean b = letterService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }
}
