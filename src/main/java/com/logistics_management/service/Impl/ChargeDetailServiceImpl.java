package com.logistics_management.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.logistics_management.dao.ChargeDetailDao;
import com.logistics_management.domain.ChargeDetail;
import com.logistics_management.service.ChargeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class ChargeDetailServiceImpl implements ChargeDetailService {

    @Autowired
    private ChargeDetailDao chargeDetailDao;


    /**
     * 查询所以收费项目明显表
     * @return
     */
    @Override
    public List<ChargeDetail> findAllChargeDetail() {
        List<ChargeDetail> detailList = chargeDetailDao.selectAll();
        return detailList;
    }

    @Override
    public Page<ChargeDetail> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(ChargeDetail.class);//指定查询的表tb_community
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
        Page<ChargeDetail> chargeDetails = (Page<ChargeDetail>) chargeDetailDao.selectByExample(example);
        return chargeDetails;
    }

    @Override
    public Boolean add(ChargeDetail chargeDetail) {
        int i = chargeDetailDao.insert(chargeDetail);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public ChargeDetail findById(Integer id) {
        ChargeDetail chargeDetail = chargeDetailDao.selectByPrimaryKey(id);
        return chargeDetail;
    }

    @Override
    public Boolean update(ChargeDetail chargeDetail) {
        int i = chargeDetailDao.updateByPrimaryKeySelective(chargeDetail);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateStatus(String status, Integer id) {
        ChargeDetail chargeDetail = new ChargeDetail();
        chargeDetail.setId(id);
        chargeDetail.setStatus(status);
        int i = chargeDetailDao.updateByPrimaryKeySelective(chargeDetail);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            chargeDetailDao.deleteByPrimaryKey(id);
        }
        return true;
    }
}
