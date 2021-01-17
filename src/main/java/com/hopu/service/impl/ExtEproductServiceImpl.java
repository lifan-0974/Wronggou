package com.hopu.service.impl;

import com.hopu.mapper.ExtEproductMapper;
import com.hopu.model.ExtEproduct;
import com.hopu.service.ExtEproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtEproductServiceImpl implements ExtEproductService {
    @Autowired
    private ExtEproductMapper extEproductMapper;

    @Override
    public int insertexe(ExtEproduct extEproduct) {
        return extEproductMapper.insertexe(extEproduct);
    }
}
