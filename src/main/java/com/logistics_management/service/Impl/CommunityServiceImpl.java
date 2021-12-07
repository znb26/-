package com.logistics_management.service.Impl;

import com.logistics_management.dao.CommunityDao;
import com.logistics_management.domain.Community;
import com.logistics_management.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * create by dongjiayao zhangningbo zhangkuan on 2021/12/6
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
}
