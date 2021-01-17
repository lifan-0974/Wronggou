package com.hopu.model;

import lombok.Data;
import oracle.sql.NUMBER;

@Data
public class Contract_c {
    String CONTRACT_ID;
    String OFFEROR;
    String CONTRACT_NO;
    String SIGNING_DATE;
    String INPUT_BY;
    String CHECK_BY;
    String INSPECTOR;
    Integer TOTAL_AMOUNT;
    String REQUEST;
    String CUSTOM_NAME;
    String SHIP_TIME;
    Integer IMPORT_NUM;
    String DELIVERY_PERIOD;
    String REMARK;
    String PRINT_STYLE;
    Integer OLD_STATE;
    String STATE;
    Integer OUT_STATE;
    String CREATE_BY;
    String CREATE_DEPT;
    String CREATE_TIME;
    String cpnum;
    String extnum;
}
