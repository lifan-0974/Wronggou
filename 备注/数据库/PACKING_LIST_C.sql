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

 Date: 25/10/2020 16:41:39
*/


-- ----------------------------
-- Table structure for PACKING_LIST_C
-- ----------------------------
DROP TABLE "LIFAN"."PACKING_LIST_C";
CREATE TABLE "LIFAN"."PACKING_LIST_C" (
  "PACKING_LIST_ID" VARCHAR2(40 BYTE) NOT NULL,
  "SELLER" VARCHAR2(200 BYTE),
  "BUYER" VARCHAR2(200 BYTE),
  "INVOICE_NO" VARCHAR2(30 BYTE),
  "INVOICE_DATE" VARCHAR2(30 BYTE),
  "MARKS" VARCHAR2(200 BYTE),
  "DESCRIPTIONS" VARCHAR2(200 BYTE),
  "EXPORT_IDS" VARCHAR2(200 BYTE),
  "EXPORT_NOS" VARCHAR2(200 BYTE),
  "STATE" NUMBER,
  "CREATE_BY" VARCHAR2(40 BYTE),
  "CREATE_DEPT" VARCHAR2(40 BYTE),
  "CREATE_TIME" VARCHAR2(30 BYTE)
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
-- Records of PACKING_LIST_C
-- ----------------------------
INSERT INTO "LIFAN"."PACKING_LIST_C" VALUES ('ceeeaa09-75ab-4c56-b333-26191a3db1ee', '111', '41', '21', '10-10-2018 00:00:00.000000', '老师，可不可以在DivData中再加一个name为exportNos的input隐藏域，是不就不用拼字符串来啊？', '51', 'a81f5a3f-386d-4b31-a03f-e81a8fe28a1d', 'C/3817/11 11JK1080', '0', NULL, NULL, NULL);
INSERT INTO "LIFAN"."PACKING_LIST_C" VALUES ('a7dc5cf0-f41f-4eb7-9ed3-ebf387138ce7', '张某', '李某', '20201', '2020-03-03', '1', '无描述', 'da0d888c-670e-4482-8639-4081554a19be|c8d4456d-c264-4f36-8c1a-6a752e4694f6', '20201012 20201012 20201011|20201012 20201012', '0', NULL, NULL, NULL);

-- ----------------------------
-- Checks structure for table PACKING_LIST_C
-- ----------------------------
ALTER TABLE "LIFAN"."PACKING_LIST_C" ADD CONSTRAINT "SYS_C0011588" CHECK ("PACKING_LIST_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
