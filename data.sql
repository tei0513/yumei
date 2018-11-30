/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : yumei

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-23 22:09:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
`DICTIONARY_CODE`  varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '字典CODE' ,
`DICTIONARY_VALUE`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '字典值' ,
`STATUS`  int(11) NOT NULL COMMENT '状态(0.启用,1.停用)' ,
`ID`  int(11) NOT NULL AUTO_INCREMENT COMMENT '字典ID' ,
`CREATE_USER`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人' ,
`CREATE_DATE`  datetime NULL DEFAULT NULL COMMENT '创建日期' ,
`UPDATE_USER`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人' ,
`UPDATE_DATE`  datetime NULL DEFAULT NULL COMMENT '修改日期' ,
PRIMARY KEY (`ID`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=1
ROW_FORMAT=Dynamic

;

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `sys_message`
-- ----------------------------
DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message` (
`RESULT_CODE`  varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '状态码' ,
`MESSAGE`  varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '状态信息' ,
PRIMARY KEY (`RESULT_CODE`),
UNIQUE INDEX `INDEX_MSG_CODE` (`RESULT_CODE`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
ROW_FORMAT=Dynamic

;

-- ----------------------------
-- Records of sys_message
-- ----------------------------
BEGIN;
INSERT INTO `sys_message` (`RESULT_CODE`, `MESSAGE`) VALUES ('ME000P', '请输入密码'), ('ME000U', '请输入用户名'), ('ME001A', '用户未激活'), ('ME001L', '用户未登录'), ('ME001P', '密码错误'), ('ME001R', '注册用户失败'), ('ME001U', '用户名不存在'), ('ME001V', '验证失败'), ('ME002L', '登陆码错误'), ('ME002R', '请填写正确的邮箱地址'), ('ME003R', '请填写正确的手机号码'), ('ME00RP', '请填写密码'), ('ME00RU', '请填写正确的用户名'), ('ME01RP', '手机已被绑定'), ('ME01RU', '用户已被注册'), ('MS0000', '成功'), ('SE0403', '权限不足'), ('SE0500', '账号在其他场所登陆');
COMMIT;

-- ----------------------------
-- Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
`RESOURCE_ID`  int(11) NOT NULL AUTO_INCREMENT COMMENT '资源ID' ,
`LEVEL`  int(11) NOT NULL COMMENT '资源层级' ,
`RESOURCE_NAME`  varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '资源名称' ,
`URL`  varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '资源路径' ,
`STATUS`  int(11) NOT NULL COMMENT '状态(1.启用,0.停用)' ,
`RESOURCE_CODE`  varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '资源CODE' ,
`PARENT_CODE`  varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '父类CODE' ,
`CREATE_USER`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人' ,
`CREATE_DATE`  datetime NULL DEFAULT NULL COMMENT '创建日期' ,
`UPDATE_USER`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人' ,
`UPDATE_DATE`  datetime NULL DEFAULT NULL COMMENT '修改日期' ,
`RESOURCE_TYPE`  int(11) NULL DEFAULT NULL COMMENT '资源类型(1.菜单,2.按钮)' ,
PRIMARY KEY (`RESOURCE_ID`, `RESOURCE_CODE`),
INDEX `RESOURCE_CODE` (`RESOURCE_CODE`) USING BTREE ,
INDEX `RESOURCE_ID` (`RESOURCE_ID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=10
ROW_FORMAT=Dynamic

;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
BEGIN;
INSERT INTO `sys_resource` (`RESOURCE_ID`, `LEVEL`, `RESOURCE_NAME`, `URL`, `STATUS`, `RESOURCE_CODE`, `PARENT_CODE`, `CREATE_USER`, `CREATE_DATE`, `UPDATE_USER`, `UPDATE_DATE`, `RESOURCE_TYPE`) VALUES ('1', '1', '用户管理', '', '1', 'S1000000', null, null, null, null, null, '1'), ('2', '2', '添加用户', '', '1', 'S1000001', 'S1000000', null, null, null, null, '2'), ('3', '2', '修改用户', '', '1', 'S1000002', 'S1000000', null, null, null, null, '2'), ('4', '2', '删除用户', '', '1', 'S1000003', 'S1000000', null, null, null, null, '2'), ('5', '1', '角色管理', '', '1', 'S1100000', null, null, null, null, null, '1'), ('6', '2', '添加角色', '', '1', 'S1100001', 'S1100000', null, null, null, null, '2'), ('7', '2', '修改角色', '', '1', 'S1100002', 'S1100000', null, null, null, null, '2'), ('8', '2', '删除角色', '', '1', 'S1100003', 'S1100000', null, null, null, null, '2');
COMMIT;

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
`ROLE_ID`  int(11) NOT NULL COMMENT '角色ID' ,
`ROLE_NAME`  varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色名称' ,
`STATUS`  int(11) NOT NULL COMMENT '状态(1.启用,0.停用)' ,
`ROLE_CODE`  varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色CODE' ,
`CREATE_USER`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人' ,
`CREATE_DATE`  datetime NULL DEFAULT NULL COMMENT '创建日期' ,
`UPDATE_USER`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人' ,
`UPDATE_DATE`  datetime NULL DEFAULT NULL COMMENT '修改日期' ,
PRIMARY KEY (`ROLE_ID`, `ROLE_CODE`),
INDEX `ROLE_CODE` (`ROLE_CODE`) USING BTREE ,
INDEX `ROLE_ID` (`ROLE_ID`) USING BTREE ,
INDEX `ROLE_CODE_2` (`ROLE_CODE`, `ROLE_ID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
ROW_FORMAT=Dynamic

;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` (`ROLE_ID`, `ROLE_NAME`, `STATUS`, `ROLE_CODE`, `CREATE_USER`, `CREATE_DATE`, `UPDATE_USER`, `UPDATE_DATE`) VALUES ('1', '管理员', '1', 'R0000000', null, null, null, null), ('2', '技术测试', '1', 'R0000001', null, null, null, null), ('3', '技术实施', '0', 'R0000002', null, null, null, null);
COMMIT;

-- ----------------------------
-- Table structure for `sys_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
`ROLE_CODE`  varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色CODE' ,
`RESOURCE_CODE`  varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '资源CODE' ,
`CREATE_USER`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人' ,
`CREATE_DATE`  datetime NULL DEFAULT NULL COMMENT '创建日期' ,
`UPDATE_USER`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人' ,
`UPDATE_DATE`  datetime NULL DEFAULT NULL COMMENT '修改日期' ,
FOREIGN KEY (`RESOURCE_CODE`) REFERENCES `sys_resource` (`RESOURCE_CODE`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`ROLE_CODE`) REFERENCES `sys_role` (`ROLE_CODE`) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX `FK_ROLE_CODE` (`ROLE_CODE`) USING BTREE ,
INDEX `FK_RESOURCE_CODE` (`RESOURCE_CODE`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
ROW_FORMAT=Dynamic

;

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_resource` (`ROLE_CODE`, `RESOURCE_CODE`, `CREATE_USER`, `CREATE_DATE`, `UPDATE_USER`, `UPDATE_DATE`) VALUES ('R0000000', 'S1000000', null, null, null, null), ('R0000000', 'S1000001', null, null, null, null), ('R0000000', 'S1000002', null, null, null, null), ('R0000001', 'S1000003', null, null, null, null);
COMMIT;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
`USER_ID`  int(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID' ,
`LOGIN_NAME`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登陆用户名' ,
`NICK_NAME`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户昵称' ,
`PASSWORD`  varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登陆密码' ,
`PHONE`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '手机号' ,
`EMAIL`  varchar(80) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '邮箱' ,
`TOKEN`  varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户登陆令牌' ,
`STATUS`  int(1) NULL DEFAULT 1 COMMENT '状态(1.激活用户,2.注销用户)' ,
`CREATE_USER`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人' ,
`CREATE_DATE`  datetime NULL DEFAULT NULL COMMENT '创建日期' ,
`UPDATE_USER`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人' ,
`UPDATE_DATE`  datetime NULL DEFAULT NULL COMMENT '修改日期' ,
PRIMARY KEY (`USER_ID`, `PHONE`),
UNIQUE INDEX `INDEX_PHONE` (`PHONE`) USING BTREE ,
UNIQUE INDEX `INDEX_LP` (`LOGIN_NAME`, `PHONE`) USING BTREE ,
INDEX `USER_ID` (`USER_ID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=15
ROW_FORMAT=Dynamic

;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` (`USER_ID`, `LOGIN_NAME`, `NICK_NAME`, `PASSWORD`, `PHONE`, `EMAIL`, `TOKEN`, `STATUS`, `CREATE_USER`, `CREATE_DATE`, `UPDATE_USER`, `UPDATE_DATE`) VALUES ('11', 'tei0513', 'Tei', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '1234', '1@qq.com', '8939', '1', null, '2018-11-18 17:00:00', null, '2018-11-18 17:00:00');
COMMIT;

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
`USER_ID`  int(11) NOT NULL COMMENT '资源ID' ,
`ROLE_CODE`  varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色CODE' ,
`CREATE_USER`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人' ,
`CREATE_DATE`  datetime NULL DEFAULT NULL COMMENT '创建日期' ,
`UPDATE_USER`  varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人' ,
`UPDATE_DATE`  datetime NULL DEFAULT NULL COMMENT '修改日期' ,
FOREIGN KEY (`ROLE_CODE`) REFERENCES `sys_role` (`ROLE_CODE`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`USER_ID`) REFERENCES `sys_user` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX `FK_U_USERID` (`USER_ID`) USING BTREE ,
INDEX `FK_U_ROLE_CODE` (`ROLE_CODE`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
ROW_FORMAT=Dynamic

;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` (`USER_ID`, `ROLE_CODE`, `CREATE_USER`, `CREATE_DATE`, `UPDATE_USER`, `UPDATE_DATE`) VALUES ('11', 'R0000001', null, null, null, null), ('11', 'R0000002', null, null, null, null), ('11', 'R0000000', null, null, null, null);
COMMIT;

-- ----------------------------
-- Auto increment value for `sys_dictionary`
-- ----------------------------
ALTER TABLE `sys_dictionary` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `sys_resource`
-- ----------------------------
ALTER TABLE `sys_resource` AUTO_INCREMENT=10;

-- ----------------------------
-- Auto increment value for `sys_user`
-- ----------------------------
ALTER TABLE `sys_user` AUTO_INCREMENT=15;
