package com.hopu.service.impl;

import com.hopu.mapper.ExportproductMapper;
import com.hopu.model.Exportproduct;
import com.hopu.service.ExportproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExportproductServiceImpl implements ExportproductService {
    @Autowired
    private ExportproductMapper exportproductMapper;

    @Override
    public int insertexport(Exportproduct exportproduct) {
        return exportproductMapper.insertexport(exportproduct);
    }
}
