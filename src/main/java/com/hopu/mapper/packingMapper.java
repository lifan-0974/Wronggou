package com.hopu.mapper;

import com.hopu.model.packing;

import java.io.Serializable;
import java.util.List;

public interface packingMapper {
    public List<packing> find();

    int insert(packing packingList);

    int update(packing packingList);

    packing selectbyid(String i);
}

