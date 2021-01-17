package com.hopu.service.impl;

import com.hopu.mapper.Contract_ProductMapper;
import com.hopu.mapper.Contract_cMapper;
import com.hopu.mapper.Ext_cproduct_CMapper;
import com.hopu.model.CONTRACT_PRODUCT_C;
import com.hopu.model.Contract_c;
import com.hopu.service.Contract_cService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Contract_cServiceImpl implements Contract_cService {
    @Autowired
    private Contract_cMapper contract_cMapper;

    @Override
    public List<Contract_c> selectconall() {
        return contract_cMapper.selectconall();
    }

    @Override
    public int insertcont(Contract_c contract_c) {
        return contract_cMapper.insertcont(contract_c);
    }

    @Override
    public int deletecont(String i) {

        return contract_cMapper.deletecont(i);
    }

    @Override
    public Contract_c selectcontbyid(String contract_c) {
        return contract_cMapper.selectcontbyid(contract_c);
    }

    @Override
    public int updatecont(Contract_c contract_c) {
        return contract_cMapper.updatecont(contract_c);
    }

    @Override
    public int updatesatet(String contract_c) {
        return contract_cMapper.updatesatet(contract_c);
    }

    @Override
    public int updatesatet1(String contract_c) {
        return contract_cMapper.updatesatet1(contract_c);
    }

    @Override
    public List<Contract_c> outcontract(String out) {
        return contract_cMapper.outcontract(out);
    }
}
