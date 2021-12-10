package com.logistics_management.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.logistics_management.dao.ChargeItemDao;
import com.logistics_management.domain.ChargeItem;
import com.logistics_management.service.ChargeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class ChargeItemServiceImpl implements ChargeItemService {

    @Autowired
    private ChargeItemDao chargeItemDao;

    /**
     * 查询收费项目表
     * @return
     */
    @Override
    public List<ChargeItem> findAllItem() {
        return chargeItemDao.selectAll();
    }


    @Override
    public Page<ChargeItem> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(ChargeItem.class);//指定查询的表tb_community
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
        Page<ChargeItem> chargeItems = (Page<ChargeItem>) chargeItemDao.selectByExample(example);
        return chargeItems;
    }

    @Override
    public Boolean add(ChargeItem chargeItem) {
        chargeItemDao.insert(chargeItem);
        return true;
    }

    @Override
    public ChargeItem findById(Integer id) {
        ChargeItem chargeItem = chargeItemDao.selectByPrimaryKey(id);
        return chargeItem;
    }

    @Override
    public Boolean update(ChargeItem chargeItem) {
        chargeItemDao.updateByPrimaryKeySelective(chargeItem);
        return true;
    }

    @Override
    public Boolean updateStatus(String status, Integer id) {
        ChargeItem chargeItem = new ChargeItem();
        return null;
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            chargeItemDao.deleteByPrimaryKey(id);
        }
        return true;
    }

}
