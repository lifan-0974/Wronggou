package com.hopu.mapper;

import com.hopu.model.Export;

import java.util.List;

public interface ExportMapper {
    List<Export> find();

    int insertexport(Export export);

    Export selectbyid(String id);
}
