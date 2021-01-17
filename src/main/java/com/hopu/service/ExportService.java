package com.hopu.service;

import com.hopu.model.Export;

import java.util.List;

public interface ExportService {
    List<Export> find();

    int insertexport(Export export);

    Export selectbyid(String id);
}
