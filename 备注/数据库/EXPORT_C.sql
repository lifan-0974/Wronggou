/*
 Navicat Premium Data Transfer

 Source Server         : zzz
 Source Server Type    : Oracle
 Source Server Version : 110200
 Source Host           : 127.0.0.1:1521
 Source Schema         : LIFAN

 Target Server Type    : Oracle
 Target Server Version : 110200
 File Encoding         : 65001

 Date: 25/10/2020 16:40:23
*/


-- ----------------------------
-- Table structure for EXPORT_C
-- ----------------------------
DROP TABLE "LIFAN"."EXPORT_C";
CREATE TABLE "LIFAN"."EXPORT_C" (
  "EXPORT_ID" VARCHAR2(40 BYTE) NOT NULL,
  "INPUT_DATE" VARCHAR2(40 BYTE),
  "CONTRACT_IDS" VARCHAR2(200 BYTE),
  "CUSTOMER_CONTRACT" VARCHAR2(200 BYTE),
  "LCNO" VARCHAR2(10 BYTE),
  "CONSIGNEE" VARCHAR2(100 BYTE),
  "MARKS" VARCHAR2(1000 BYTE),
  "SHIPMENT_PORT" VARCHAR2(100 BYTE),
  "DESTINATION_PORT" VARCHAR2(100 BYTE),
  "TRANSPORT_MODE" VARCHAR2(10 BYTE),
  "PRICE_CONDITION" VARCHAR2(10 BYTE),
  "REMARK" VARCHAR2(100 BYTE),
  "BOX_NUM" NUMBER,
  "CNUMBER" NUMBER,
  "PACKING_UNIT" VARCHAR2(10 BYTE),
  "GROSS_WEIGHT" NUMBER(10,2),
  "NET_WEIGHT" NUMBER(10,2),
  "SIZE_LENGHT" NUMBER(10,2),
  "SIZE_WIDTH" NUMBER(10,2),
  "SIZE_HEIGHT" NUMBER(10,2),
  "CSIZE" NUMBER(10,2),
  "AMOUNT" NUMBER(10,2),
  "NO_TAX" NUMBER(10,2),
  "TAX" NUMBER(10,2),
  "COST_PRICE" NUMBER(10,2),
  "COST_TAX" NUMBER(10,2),
  "STATE" NUMBER(10,2),
  "INSPECTOR" NUMBER,
  "CREATE_BY" VARCHAR2(40 BYTE),
  "CREATE_DEPT" VARCHAR2(40 BYTE),
  "CREATE_TIME" VARCHAR2(40 BYTE)
)
TABLESPACE "USERS"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of EXPORT_C
-- ----------------------------
INSERT INTO "LIFAN"."EXPORT_C" VALUES ('c8d4456d-c264-4f36-8c1a-6a752e4694f6', NULL, ',,,', '20201012 20201012', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO "LIFAN"."EXPORT_C" VALUES ('da0d888c-670e-4482-8639-4081554a19be', NULL, ',,,,,', '20201012 20201012 20201011', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Primary Key structure for table EXPORT_C
-- ----------------------------
ALTER TABLE "LIFAN"."EXPORT_C" ADD CONSTRAINT "PK_EXPORT_C" PRIMARY KEY ("EXPORT_ID");

-- ----------------------------
-- Checks structure for table EXPORT_C
-- ----------------------------
ALTER TABLE "LIFAN"."EXPORT_C" ADD CONSTRAINT "SYS_C0011496" CHECK ("EXPORT_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
