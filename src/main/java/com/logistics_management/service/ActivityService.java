package com.logistics_management.service;

import com.github.pagehelper.Page;
import com.logistics_management.domain.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityService {

    /**
     * 查询所以活动
     * @return
     */
    List<Activity> findAll();

    /**
     * 分页查询
     * @param searchMap
     * @return
     */
    Page<Activity> search(Map searchMap);

    /**
     * 添加活动
     * @param activity
     * @return
     */
    Boolean addActivity(Activity activity);

    /**
     * 根据id查询活动
     * @param id
     * @return
     */
    Activity findActivityById(Integer id);

    /**
     * 更新活动
     * @param activity
     * @return
     */
    Boolean update(Activity activity);

    /**
     * 删除活动
     * @param ids
     * @return
     */
    Boolean del(List<Integer> ids);

    /**
     * 更新活动信息状态码
     * @param status
     * @param id
     * @return
     */
    Boolean updateStatus(String status, Integer id);
}
