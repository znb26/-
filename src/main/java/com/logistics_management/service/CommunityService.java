package com.logistics_management.service;

import com.github.pagehelper.Page;
import com.logistics_management.domain.Community;

import java.util.List;
import java.util.Map;

public interface CommunityService {

    /**
     * 查询所有小区信息
     * @return
     */
    public List<Community> findAll();

    public Page<Community> search(Map searchMap);


    /**
     * 添加
     * @param community
     * @return
     */
    public Boolean add(Community community);

    /**
     * 根据id 查询
     * @param id
     * @return
     */
    Community findById(Integer id);

    /**
     * 更新
     * @param community
     * @return
     */
    Boolean update(Community community);

    /**
     * 更新小区状态
     * @param status
     * @param id
     * @return
     */
    Boolean updateStatus(String status, Integer id);

    Boolean del(List<Integer> ids);
}
