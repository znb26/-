package com.logistics_management.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.logistics_management.dao.ActivityDao;
import com.logistics_management.domain.Activity;
import com.logistics_management.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * ok
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;
    @Override
    public List<Activity> findAll() {
        List<Activity> list = activityDao.selectAll();
        return list;
    }

    @Override
    public Boolean addActivity(Activity activity) {
        activityDao.insert(activity);
        return true;
    }

    @Override
    public Page<Activity> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Activity.class);//指定查询的表tb_community
        //1.初始化分页条件
        int pageNum = 1;
        int pageSize = 2;
        if(searchMap != null){
            Example.Criteria criteria = example.createCriteria();//创建查询条件
            //时间区间
            if(StringUtil.isNotEmpty((String) searchMap.get("startTime"))){
                criteria.andGreaterThanOrEqualTo("createTime",searchMap.get("startTime"));
            }
            if(StringUtil.isNotEmpty((String) searchMap.get("endTime"))){
                criteria.andLessThanOrEqualTo("createTime",searchMap.get("endTime"));
                criteria.andLessThanOrEqualTo("createTime",searchMap.get("endTime"));
            }
            //名称模糊搜索
            if(StringUtil.isNotEmpty((String) searchMap.get("name"))){
                criteria.andLike("title", "%"+(String) searchMap.get("name")+"%");
            }
            //分页
            if((Integer) searchMap.get("pageNum") !=null){
                pageNum = (Integer) searchMap.get("pageNum");
            }
            if((Integer) searchMap.get("pageSize") !=null){
                pageSize = (Integer) searchMap.get("pageSize");
            }
        }
        PageHelper.startPage(pageNum,pageSize);//使用PageHelper插件完成分页
        Page<Activity> activities = (Page<Activity>) activityDao.selectByExample(example);
        return activities;
    }




    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Activity findActivityById(Integer id) {
        Activity activity = activityDao.selectByPrimaryKey(id);
        return activity;
    }

    @Override
    public Boolean update(Activity activity) {
        int i = activityDao.updateByPrimaryKeySelective(activity);
        if (i > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            activityDao.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    public Boolean updateStatus(String status, Integer id) {
        Activity activity = new Activity();
        activity.setId(id);
        activity.setStatus(status);
        activityDao.updateByPrimaryKeySelective(activity);
        return null;
    }


}
