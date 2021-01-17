package com.hopu.service.impl;

import com.hopu.mapper.ExportMapper;
import com.hopu.model.Export;
import com.hopu.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportServiceImpl implements ExportService {
    @Autowired
    private ExportMapper exportMapper;

    @Override
    public List<Export> find() {
        return exportMapper.find();
    }

    @Override
    public int insertexport(Export export) {
        return exportMapper.insertexport(export);
    }

    @Override
    public Export selectbyid(String id) {
        return exportMapper.selectbyid(id);
    }
}
