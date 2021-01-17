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

 Date: 25/10/2020 16:39:58
*/


-- ----------------------------
-- Table structure for CONTRACT_C
-- ----------------------------
DROP TABLE "LIFAN"."CONTRACT_C";
CREATE TABLE "LIFAN"."CONTRACT_C" (
  "CONTRACT_ID" VARCHAR2(200 BYTE) NOT NULL,
  "OFFEROR" VARCHAR2(200 BYTE),
  "CONTRACT_NO" VARCHAR2(200 BYTE),
  "SIGNING_DATE" VARCHAR2(200 BYTE),
  "INPUT_BY" VARCHAR2(200 BYTE),
  "CHECK_BY" VARCHAR2(200 BYTE),
  "INSPECTOR" VARCHAR2(200 BYTE),
  "TOTAL_AMOUNT" NUMBER,
  "REQUEST" VARCHAR2(200 BYTE),
  "CUSTOM_NAME" VARCHAR2(200 BYTE),
  "SHIP_TIME" VARCHAR2(200 BYTE),
  "IMPORT_NUM" NUMBER,
  "DELIVERY_PERIOD" VARCHAR2(200 BYTE),
  "REMARK" VARCHAR2(600 BYTE),
  "PRINT_STYLE" VARCHAR2(600 BYTE),
  "OLD_STATE" NUMBER,
  "STATE" NUMBER,
  "OUT_STATE" NUMBER,
  "CREATE_BY" VARCHAR2(200 BYTE),
  "CREATE_DEPT" VARCHAR2(200 BYTE),
  "CREATE_TIME" VARCHAR2(200 BYTE)
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
-- Records of CONTRACT_C
-- ----------------------------
INSERT INTO "LIFAN"."CONTRACT_C" VALUES ('1', '李某', '20201012', '2020-09-03', '李某', '张某', '柳某', NULL, '无要求', '大荔贾家', '2020-06-09', '1', '2020-10-10', '无说明', '1', NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO "LIFAN"."CONTRACT_C" VALUES ('2', '张某', '20201012', '2020-09-03', '李某', '张某', '柳某', NULL, '无要求', '张式集团', '2020-06-09', '1', '2020-10-10', '无说明', '1', NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO "LIFAN"."CONTRACT_C" VALUES ('3', '张某', '20201011', '2020-09-03', '李某', '张某', '柳某', NULL, '无要求', '矿上郭家', '2020-06-09', '1', '2020-10-10', '无说明', '1', NULL, '1', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Primary Key structure for table CONTRACT_C
-- ----------------------------
ALTER TABLE "LIFAN"."CONTRACT_C" ADD CONSTRAINT "SYS_C0011174" PRIMARY KEY ("CONTRACT_ID");
