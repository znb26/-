package com.logistics_management.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.logistics_management.dao.ParkingUseDao;
import com.logistics_management.domain.Community;
import com.logistics_management.domain.ParkingUse;
import com.logistics_management.service.ParkingUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class ParkingUseServiceImpl implements ParkingUseService {
    @Autowired
    private ParkingUseDao parkingUseDao;

    @Override
    public Page<ParkingUse> search(Map searchMap) {
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
            if(StringUtil.isNotEmpty((String) searchMap.get("pageNum"))){
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if(StringUtil.isNotEmpty((String) searchMap.get("pageSize"))){
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }
            /*if((Integer) searchMap.get("pageNum") !=null){
                pageNum = (Integer) searchMap.get("pageNum");
            }
            if((Integer) searchMap.get("pageSize") !=null){
                pageSize = (Integer) searchMap.get("pageSize");
            }*/
        }
        PageHelper.startPage(pageNum,pageSize);//使用PageHelper插件完成分页
        Page<ParkingUse> parkingUses = (Page<ParkingUse>) parkingUseDao.selectByExample(example);
        return parkingUses;
    }

    @Override
    public Boolean add(ParkingUse parkingUse) {
        parkingUseDao.insert(parkingUse);
        return true;
    }

    @Override
    public ParkingUse findById(Integer id) {
        ParkingUse parkingUse = parkingUseDao.selectByPrimaryKey(id);
        return parkingUse;
    }

    @Override
    public Boolean update(ParkingUse parkingUse) {
        parkingUseDao.updateByPrimaryKeySelective(parkingUse);
        return true;
    }

    @Override
    public Boolean updateStatus(String status, Integer id) {
        ParkingUse parkingUse = new ParkingUse();
        return null;
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            parkingUseDao.deleteByExample(id);
        }
        return true;
    }
}
