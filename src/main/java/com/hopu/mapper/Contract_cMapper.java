package com.hopu.mapper;

import com.hopu.model.Contract_c;

import java.util.List;

public interface Contract_cMapper {
    List<Contract_c> selectconall();

    int insertcont(Contract_c contract_c);

    int deletecont(String i);

    Contract_c selectcontbyid(String contract_c);

    int updatecont(Contract_c contract_c);

    int updatesatet(String contract_c);

    int updatesatet1(String contract_c);

    List<Contract_c> outcontract(String out);

}
