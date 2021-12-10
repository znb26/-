package com.logistics_management.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.logistics_management.dao.CarDao;
import com.logistics_management.domain.Car;
import com.logistics_management.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * ok
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;
    @Override
    public List<Car> findAll() {
        List<Car> cars = carDao.selectAll();
        return cars;
    }

    @Override
    public Page<Car> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Car.class);//指定查询的表tb_community
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
                criteria.andLike("carNumber", "%"+(String) searchMap.get("name")+"%");
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
        Page<Car> cars = (Page<Car>) carDao.selectByExample(example);
        return cars;
    }

    @Override
    public Boolean addCar(Car car) {
        int i = carDao.insert(car);
        if(i > 0){
            return true;
        }
        return false;
    }



    @Override
    public Boolean update(Car car) {
        int i = carDao.updateByPrimaryKeySelective(car);
        if(i > 0){
            return true;
        }
        return false;
    }


    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            carDao.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    public Car findCarById(Integer id) {
        Car car = carDao.selectByPrimaryKey(id);
        return car;
    }
}
