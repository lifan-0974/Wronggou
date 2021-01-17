package com.hopu.model;

import lombok.Data;

@Data
public class OutProductVO {
    private String customName;
    private String contractNo;
    private String productNo;
    private String cnumber;
    private String deliveryPeriod;
    private String shipTime;
    private Factory_c Factory;
}
