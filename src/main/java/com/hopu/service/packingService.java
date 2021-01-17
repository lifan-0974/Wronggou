package com.hopu.service;

import com.hopu.model.packing;

import java.io.Serializable;
import java.util.List;

public interface packingService {

    public List<packing> find();

    int insert(packing packingList);

    int update(packing packingList);

    public String getDivDataCreate(String[] exportIds);

    public String getDivDataUpdate(String[] exportIds, String[] exportNos);

    public String getDivDataView(String[] exportNos);

    packing selectbyid(String i);
}
