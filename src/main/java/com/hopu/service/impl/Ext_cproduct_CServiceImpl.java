package com.hopu.service.impl;

import com.hopu.mapper.Ext_cproduct_CMapper;
import com.hopu.model.Ext_cproduct_C;
import com.hopu.service.Ext_cproduct_CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ext_cproduct_CServiceImpl implements Ext_cproduct_CService {
    @Autowired
    private Ext_cproduct_CMapper ext_cproduct_cMapper;

    @Override
    public List<Ext_cproduct_C> selectthree(String i) {
        return ext_cproduct_cMapper.selectthree(i);
    }

    @Override
    public int insertthree(Ext_cproduct_C ext_cproduct_c) {
        return ext_cproduct_cMapper.insertthree(ext_cproduct_c);
    }

    @Override
    public int deletethreee(String ext_cproduct_c) {
        return ext_cproduct_cMapper.deletethreee(ext_cproduct_c);
    }

    @Override
    public Ext_cproduct_C selectthreebyid(String ext_cproduct_c) {
        return ext_cproduct_cMapper.selectthreebyid(ext_cproduct_c);
    }

    @Override
    public int updatethree(Ext_cproduct_C ext_cproduct_c) {
        return ext_cproduct_cMapper.updatethree(ext_cproduct_c);
    }

    @Override
    public int deleteByCONTRACT_PRODUCT_ID(String c) {
        return ext_cproduct_cMapper.deleteByCONTRACT_PRODUCT_ID(c);
    }
}
