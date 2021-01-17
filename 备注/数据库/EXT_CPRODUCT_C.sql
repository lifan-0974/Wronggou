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

 Date: 25/10/2020 16:40:44
*/


-- ----------------------------
-- Table structure for EXT_CPRODUCT_C
-- ----------------------------
DROP TABLE "LIFAN"."EXT_CPRODUCT_C";
CREATE TABLE "LIFAN"."EXT_CPRODUCT_C" (
  "EXT_CPRODUCT_ID" VARCHAR2(40 BYTE) NOT NULL,
  "CONTRACT_PRODUCT_ID" VARCHAR2(40 BYTE),
  "FACTORY_ID" VARCHAR2(40 BYTE),
  "FACTORY_NAME" VARCHAR2(50 BYTE),
  "CTYPE" NUMBER,
  "PRODUCT_NO" VARCHAR2(50 BYTE),
  "PRODUCT_IMAGE" VARCHAR2(200 BYTE),
  "PRODUCT_DESC" VARCHAR2(600 BYTE),
  "CNUMBER" NUMBER,
  "PACKING_UNIT" VARCHAR2(10 BYTE),
  "PRICE" NUMBER(10,2),
  "AMOUNT" NUMBER(10,2),
  "PRODUCT_REQUEST" VARCHAR2(2000 BYTE),
  "ORDER_NO" NUMBER
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
-- Records of EXT_CPRODUCT_C
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table EXT_CPRODUCT_C
-- ----------------------------
ALTER TABLE "LIFAN"."EXT_CPRODUCT_C" ADD CONSTRAINT "SYS_C0011204" PRIMARY KEY ("EXT_CPRODUCT_ID");

-- ----------------------------
-- Checks structure for table EXT_CPRODUCT_C
-- ----------------------------
ALTER TABLE "LIFAN"."EXT_CPRODUCT_C" ADD CONSTRAINT "SYS_C0011203" CHECK ("EXT_CPRODUCT_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
