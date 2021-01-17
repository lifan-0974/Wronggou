package com.hopu.service;

import com.hopu.model.Ext_cproduct_C;

import java.util.List;

public interface Ext_cproduct_CService {
    List<Ext_cproduct_C> selectthree(String i);

    int insertthree(Ext_cproduct_C ext_cproduct_c);

    int deletethreee(String ext_cproduct_c);

    Ext_cproduct_C selectthreebyid(String ext_cproduct_c);

    int updatethree(Ext_cproduct_C ext_cproduct_c);

    int deleteByCONTRACT_PRODUCT_ID(String c);
}
