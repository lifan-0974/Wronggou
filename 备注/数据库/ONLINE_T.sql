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

 Date: 25/10/2020 16:41:25
*/


-- ----------------------------
-- Table structure for ONLINE_T
-- ----------------------------
DROP TABLE "LIFAN"."ONLINE_T";
CREATE TABLE "LIFAN"."ONLINE_T" (
  "A1" VARCHAR2(2 BYTE) NOT NULL
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
-- Records of ONLINE_T
-- ----------------------------
INSERT INTO "LIFAN"."ONLINE_T" VALUES ('1');
INSERT INTO "LIFAN"."ONLINE_T" VALUES ('2');
INSERT INTO "LIFAN"."ONLINE_T" VALUES ('3');
INSERT INTO "LIFAN"."ONLINE_T" VALUES ('4');
INSERT INTO "LIFAN"."ONLINE_T" VALUES ('5');
INSERT INTO "LIFAN"."ONLINE_T" VALUES ('6');
INSERT INTO "LIFAN"."ONLINE_T" VALUES ('7');
INSERT INTO "LIFAN"."ONLINE_T" VALUES ('8');
INSERT INTO "LIFAN"."ONLINE_T" VALUES ('9');
INSERT INTO "LIFAN"."ONLINE_T" VALUES ('10');

-- ----------------------------
-- Checks structure for table ONLINE_T
-- ----------------------------
ALTER TABLE "LIFAN"."ONLINE_T" ADD CONSTRAINT "SYS_C0011633" CHECK ("A1" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
