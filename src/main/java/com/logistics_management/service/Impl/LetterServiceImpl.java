package com.logistics_management.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.logistics_management.dao.LetterDao;
import com.logistics_management.domain.Community;
import com.logistics_management.domain.Letter;
import com.logistics_management.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class LetterServiceImpl implements LetterService {
    @Autowired
    private LetterDao letterDao;

    @Override
    public Page<Letter> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Letter.class);//指定查询的表tb_community
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
        Page<Letter> letters = (Page<Letter>) letterDao.selectByExample(example);
        return letters;
    }

    @Override
    public Boolean add(Letter letter) {
        letterDao.insert(letter);
        return true;
    }

    @Override
    public Letter findById(Integer id) {
        Letter letter = letterDao.selectByPrimaryKey(id);
        return letter;
    }

    @Override
    public Boolean update(Letter letter) {
        letterDao.updateByPrimaryKeySelective(letter);
        return true;
    }

    @Override
    public Boolean updateStatus(String status, Integer id) {
        Letter letter = new Letter();
        letter.setStatus(status);
        letter.setId(id);
        letterDao.updateByPrimaryKeySelective(letter);
        return true;
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            letterDao.deleteByPrimaryKey(id);
        }
        return true;
    }
}
