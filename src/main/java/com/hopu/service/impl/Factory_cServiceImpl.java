package com.hopu.service.impl;

import com.hopu.mapper.Factory_cMapper;
import com.hopu.model.Factory_c;
import com.hopu.service.Factory_cService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Factory_cServiceImpl implements Factory_cService {

    @Autowired
    private Factory_cMapper factory_cMapper;

    @Override
    public List<Factory_c> selectAll() {
        return factory_cMapper.selectAll();
    }

    @Override
    public int insert(Factory_c factory_c) {
        return factory_cMapper.insert(factory_c);
    }

    @Override
    public Factory_c selectbyid(Factory_c factory_c) {
        return factory_cMapper.selectbyid(factory_c);
    }

    @Override
    public int update(Factory_c factory_c) {
        return factory_cMapper.update(factory_c);
    }

    @Override
    public int delete(int i) {
        return factory_cMapper.delete(i);
    }


}
