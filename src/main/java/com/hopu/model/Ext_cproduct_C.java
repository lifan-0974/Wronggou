package com.hopu.model;

import lombok.Data;

@Data
public class Ext_cproduct_C {
    String EXT_CPRODUCT_ID;
    String CONTRACT_PRODUCT_ID;
    String FACTORY_ID;
    String FACTORY_NAME;
    Integer CTYPE;
    String PRODUCT_NO;
    String PRODUCT_IMAGE;
    String PRODUCT_DESC;
    Integer CNUMBER;
    String PACKING_UNIT;
    Integer PRICE;
    Integer AMOUNT;
    String PRODUCT_REQUEST;
    Integer ORDER_NO;
    CONTRACT_PRODUCT_C contract_product_c;
    Factory_c factory_c;

}
