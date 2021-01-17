package com.hopu.service.impl;

import com.hopu.mapper.Contract_ProductMapper;
import com.hopu.model.CONTRACT_PRODUCT_C;
import com.hopu.service.Contract_ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class Contract_ProductServiceImpl implements Contract_ProductService {
    @Autowired
    private Contract_ProductMapper contract_productMapper;

    @Override
    public List<CONTRACT_PRODUCT_C> selecttwo(String i) {
        return contract_productMapper.selecttwo(i);
    }

    @Override
    public int insertcontandfact(CONTRACT_PRODUCT_C c) {
        return contract_productMapper.insertcontandfact(c);
    }

    @Override
    public int deletecontandfact(String c) {
        return contract_productMapper.deletecontandfact(c);
    }

    @Override
    public CONTRACT_PRODUCT_C selecttwobyid(CONTRACT_PRODUCT_C c) {
        return contract_productMapper.selecttwobyid(c);
    }

    @Override
    public int updatecontandfact(CONTRACT_PRODUCT_C c) {
        return contract_productMapper.updatecontandfact(c);
    }

    @Override
    public int deleteByContractId(String c) {
        return contract_productMapper.deleteByContractId(c);
    }


}
