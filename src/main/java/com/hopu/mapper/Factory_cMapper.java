package com.hopu.mapper;

import com.hopu.model.Factory_c;

import java.util.List;

public interface Factory_cMapper {
    List<Factory_c> selectAll();

    int insert(Factory_c factory_c);

    Factory_c selectbyid(Factory_c factory_c);

    int update(Factory_c factory_c);

    int delete(int i);
}