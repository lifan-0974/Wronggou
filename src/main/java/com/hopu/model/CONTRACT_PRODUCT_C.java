package com.hopu.model;

import lombok.Data;

@Data
public class CONTRACT_PRODUCT_C {
    String CONTRACT_PRODUCT_ID;
    String CONTRACT_ID;
    String FACTORY_ID;
    String PRODUCT_NAME;
    String PRODUCT_NO;
    String PRODUCT_IMAGE;
    String PRODUCT_DESC;
    String LOADING_RATE;
    String PACKING_UNIT;
    Integer CNUMBER;
    Integer OUT_NUMBER;
    String FINISHED;
    Double GROSS_WEIGHT;
    Double NET_WEIGHT;
    Double SIZE_LENGHT;
    Double SIZE_WIDTH;
    Double SIZE_HEIGHT;
    String PRODUCT_REQUEST;
    String FACTORY;
    Double PRICE;
    Double AMOUNT;
    String CUNIT;
    Integer BOX_NUM;
    Double EX_PRICE;
    Integer EX_UNIT;
    Double NO_TAX;
    Double TAX;
    Double COST_PRICE;
    Double COST_TAX;
    String ACCESSORIES;
    Integer ORDER_NO;
    Contract_c contract_c;
    Factory_c factory_c;
    Factory_c Factory_c;
}
