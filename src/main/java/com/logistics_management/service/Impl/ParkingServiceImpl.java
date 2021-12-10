package com.logistics_management.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.logistics_management.dao.ParkingDao;
import com.logistics_management.domain.Parking;
import com.logistics_management.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * ok
 */
@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingDao parkingDao;


    @Override
    public Page<Parking> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Parking.class);//指定查询的表tb_community
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
        Page<Parking> parkings = (Page<Parking>) parkingDao.selectByExample(example);
        return parkings;
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            parkingDao.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    public Boolean updateStatus(String status, Integer id) {
        Parking parking = new Parking();
        return null;
    }

    @Override
    public Boolean update(Parking parking) {
        parkingDao.updateByPrimaryKeySelective(parking);
        return true;
    }

    @Override
    public Parking findById(Integer id) {
        Parking parking = parkingDao.selectByPrimaryKey(id);
        return parking;
    }

    @Override
    public Boolean add(Parking parking) {
        parkingDao.insert(parking);
        return true;
    }
}
