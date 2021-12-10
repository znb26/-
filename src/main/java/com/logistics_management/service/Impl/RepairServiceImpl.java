package com.logistics_management.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.logistics_management.dao.RepairDao;
import com.logistics_management.domain.Community;
import com.logistics_management.domain.Repair;
import com.logistics_management.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairDao repairDao;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Repair> findAll() {
        List<Repair> list = repairDao.selectAll();
        return list;
    }

    @Override
    public Page<Repair> search(Map searchMap) {
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
        Page<Repair> repairs = (Page<Repair>) repairDao.selectByExample(example);
        return repairs;
    }

    @Override
    public Boolean add(Repair repair) {
        repairDao.insert(repair);
        return true;
    }

    @Override
    public Repair findById(Integer id) {
        Repair repair = repairDao.selectByPrimaryKey(id);
        return repair;
    }

    @Override
    public Boolean update(Repair repair) {
        repairDao.updateByPrimaryKeySelective(repair);
        return true;
    }

    @Override
    public Boolean updateStatus(String status, Integer id) {
        Repair repair = new Repair();
        repair.setStatus(status);
        repair.setId(id);
        repairDao.updateByPrimaryKeySelective(repair);
        return true;
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            repairDao.deleteByPrimaryKey(id);
        }
        return true;
    }

}
