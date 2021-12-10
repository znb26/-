package com.logistics_management.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.logistics_management.dao.CommunityDao;
import com.logistics_management.domain.Community;
import com.logistics_management.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * create by dongjiayao zhangningbo zhangkuan on 2021/12/6
 * ok
 */
@Service
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    private CommunityDao communityDao;
    @Override
    public List<Community> findAll() {
        List<Community> list = communityDao.selectAll();
        return list;
        //return communityDao.selectAll();
    }

    @Override
    public Page<Community> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Community.class);//指定查询的表tb_community
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
                criteria.andLike("name", "%"+(String) searchMap.get("name")+"%");
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
        Page<Community> communities = (Page<Community>) communityDao.selectByExample(example);
        return communities;
    }



    /**
     * ok
     * @param community
     * @return
     */
    @Override
    public Boolean add(Community community) {
        communityDao.insert(community);
        return true;
    }

    /**
     * ok
     * @param id
     * @return
     */
    @Override
    public Community findById(Integer id) {
        return communityDao.selectByPrimaryKey(id);
    }

    /**
     * ok
     * @param community
     * @return
     */
    @Override
    public Boolean update(Community community) {
        communityDao.updateByPrimaryKeySelective(community);
        return null;
    }

    @Override
    public Boolean updateStatus(String status, Integer id) {
        Community community = new Community();
        community.setId(id);
        community.setStatus(status);
        int i = communityDao.updateByPrimaryKeySelective(community);
        if(i > 0){
            return true;
        }
        return false;
    }

    /**
     * 删除根据id删除
     * @param ids
     * @return
     */
    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            communityDao.deleteByPrimaryKey(id);
        }
        return true;
    }
}
