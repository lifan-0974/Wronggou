package com.hopu.model;

import lombok.Data;

@Data
public class Export {
    String EXPORT_ID;
    String INPUT_DATE;
    String CONTRACT_IDS;
    String CUSTOMER_CONTRACT;
    String LCNO;
    String CONSIGNEE;
    String MARKS;
    String SHIPMENT_PORT;
    String DESTINATION_PORT;
    String TRANSPORT_MODE;
    String PRICE_CONDITION;
    String REMARK;
    Integer BOX_NUM;
    Integer CNUMBER;
    String PACKING_UNIT;
    Integer GROSS_WEIGHT;
    Integer NET_WEIGHT;
    Integer SIZE_LENGHT;
    Integer SIZE_WIDTH;
    Integer SIZE_HEIGHT;
    Integer CSIZE;
    Integer AMOUNT;
    Integer NO_TAX;
    Integer TAX;
    Integer COST_PRICE;
    Integer COST_TAX;
    Integer STATE;
    Integer INSPECTOR;
    String CREATE_BY;
    String CREATE_DEPT;
    String CREATE_TIME;
    Integer EPNUM;
    Integer EXTNUM;
}
