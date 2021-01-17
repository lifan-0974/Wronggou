package com.hopu.mapper;

import com.hopu.model.CONTRACT_PRODUCT_C;

import java.io.Serializable;
import java.util.List;

public interface Contract_ProductMapper {
    List<CONTRACT_PRODUCT_C> selecttwo(String i);

    int insertcontandfact(CONTRACT_PRODUCT_C c);

    int deletecontandfact(String c);

    CONTRACT_PRODUCT_C selecttwobyid(CONTRACT_PRODUCT_C c);

    int updatecontandfact(CONTRACT_PRODUCT_C c);

    int deleteByContractId(String c);
}
