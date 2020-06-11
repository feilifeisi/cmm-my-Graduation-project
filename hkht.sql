/*
Navicat MySQL Data Transfer

Source Server         : bendi
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : jiudian

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2020-04-17 14:29:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for instrument
-- ----------------------------
DROP TABLE IF EXISTS `instrument`;
CREATE TABLE `instrument` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `wastage` int(11) DEFAULT '100' COMMENT '损耗度',
  `count` int(255) DEFAULT '0' COMMENT '仪器数量',
  `state` varchar(1) DEFAULT NULL COMMENT '0：零件，1：仪器',
  `employ` varchar(255) DEFAULT '0' COMMENT '用了多少',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of instrument
-- ----------------------------
INSERT INTO `instrument` VALUES ('3', '手机1', '2020-04-17 11:16:20', '100', '8', '1', '3');
INSERT INTO `instrument` VALUES ('5', 'sss', '2020-04-17 13:39:46', '100', '1', '0', '4');
INSERT INTO `instrument` VALUES ('6', '电脑', '2020-04-17 14:25:15', '100', '9', '1', '1');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cause` varchar(255) DEFAULT NULL COMMENT '操作原因',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '用户id:2已启用,时间为:2020-04-15 17:02:26', '2020-04-15 17:02:26');
INSERT INTO `log` VALUES ('2', '用户id:3已启用,时间为:2020-04-15 17:02:30', '2020-04-15 17:02:30');
INSERT INTO `log` VALUES ('3', '用户id:3已停用,时间为:2020-04-15 17:02:35', '2020-04-15 17:02:35');
INSERT INTO `log` VALUES ('4', '用户id:2已停用,时间为:2020-04-15 17:02:39', '2020-04-15 17:02:39');
INSERT INTO `log` VALUES ('5', '用户id:2已启用,时间为:2020-04-15 17:04:40', '2020-04-15 17:04:40');
INSERT INTO `log` VALUES ('6', '用户id:5已停用,时间为:2020-04-15 18:43:32', '2020-04-15 18:43:32');
INSERT INTO `log` VALUES ('7', '用户id:6已停用,时间为:2020-04-15 18:44:00', '2020-04-15 18:44:00');
INSERT INTO `log` VALUES ('8', '用户id:7已停用,时间为:2020-04-15 18:48:58', '2020-04-15 18:48:58');
INSERT INTO `log` VALUES ('9', '用户id:5已启用,时间为:2020-04-15 18:49:02', '2020-04-15 18:49:02');
INSERT INTO `log` VALUES ('10', '用户id:6已启用,时间为:2020-04-15 18:50:54', '2020-04-15 18:50:54');
INSERT INTO `log` VALUES ('11', '用户id:1已调用仪器id:1,时间为:2020-04-16 15:03:43', '2020-04-16 15:03:43');
INSERT INTO `log` VALUES ('12', '用户id:4已调用仪器id:1,时间为:2020-04-16 15:31:06', '2020-04-16 15:31:06');
INSERT INTO `log` VALUES ('13', '用户id:1已取消调用仪器id:9,时间为:2020-04-16 15:35:31', '2020-04-16 15:35:31');
INSERT INTO `log` VALUES ('14', '用户id:1已取消调用仪器id:null,时间为:2020-04-16 15:42:02', '2020-04-16 15:42:02');
INSERT INTO `log` VALUES ('15', '用户id:4已调用仪器id:1,时间为:2020-04-16 15:49:04', '2020-04-16 15:49:04');
INSERT INTO `log` VALUES ('16', '用户id:1已取消调用仪器id:1,时间为:2020-04-16 15:49:34', '2020-04-16 15:49:34');
INSERT INTO `log` VALUES ('17', '用户id:5被用户id:1已停用,时间为:2020-04-17 11:51:03', '2020-04-17 11:51:03');
INSERT INTO `log` VALUES ('18', '用户id:1已调用仪器id:4,时间为:2020-04-17 11:52:16', '2020-04-17 11:52:16');
INSERT INTO `log` VALUES ('19', '用户id:2已调用仪器id:4,时间为:2020-04-17 11:54:01', '2020-04-17 11:54:01');
INSERT INTO `log` VALUES ('20', '用户id:1已取消调用仪器id:4,时间为:2020-04-17 11:54:21', '2020-04-17 11:54:21');
INSERT INTO `log` VALUES ('21', '用户id:5被用户id:1已启用,时间为:2020-04-17 13:37:10', '2020-04-17 13:37:10');
INSERT INTO `log` VALUES ('22', '用户id:1已调用零件id:5,时间为:2020-04-17 13:39:53', '2020-04-17 13:39:53');
INSERT INTO `log` VALUES ('23', '用户id:1已调用零件id:5,时间为:2020-04-17 13:39:56', '2020-04-17 13:39:56');
INSERT INTO `log` VALUES ('24', '用户id:1已调用仪器id:3,时间为:2020-04-17 13:40:05', '2020-04-17 13:40:05');
INSERT INTO `log` VALUES ('25', '用户id:4已调用仪器id:3,时间为:2020-04-17 13:40:40', '2020-04-17 13:40:40');
INSERT INTO `log` VALUES ('26', '用户id:4已调用仪器id:4,时间为:2020-04-17 13:40:43', '2020-04-17 13:40:43');
INSERT INTO `log` VALUES ('27', '用户id:4已调用零件id:5,时间为:2020-04-17 13:40:48', '2020-04-17 13:40:48');
INSERT INTO `log` VALUES ('28', '用户id:1已取消调用仪器id:5,时间为:2020-04-17 13:41:45', '2020-04-17 13:41:45');
INSERT INTO `log` VALUES ('29', '用户id:10被用户id:1已停用,时间为:2020-04-17 14:24:09', '2020-04-17 14:24:09');
INSERT INTO `log` VALUES ('30', '用户id:10被用户id:9已启用,时间为:2020-04-17 14:26:22', '2020-04-17 14:26:22');
INSERT INTO `log` VALUES ('31', '用户id:9已调用仪器id:6,时间为:2020-04-17 14:26:30', '2020-04-17 14:26:30');
INSERT INTO `log` VALUES ('32', '用户id:10已调用零件id:5,时间为:2020-04-17 14:27:08', '2020-04-17 14:27:08');
INSERT INTO `log` VALUES ('33', '用户id:10已调用仪器id:3,时间为:2020-04-17 14:27:14', '2020-04-17 14:27:14');
INSERT INTO `log` VALUES ('34', '用户id:9已取消调用仪器id:3,时间为:2020-04-17 14:27:40', '2020-04-17 14:27:40');

-- ----------------------------
-- Table structure for transfer
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usersId` int(11) DEFAULT NULL COMMENT '用户id',
  `instruId` int(11) DEFAULT NULL COMMENT '零件仪器表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transfer
-- ----------------------------
INSERT INTO `transfer` VALUES ('1', '1', '1');
INSERT INTO `transfer` VALUES ('2', '1', '1');
INSERT INTO `transfer` VALUES ('3', '1', '1');
INSERT INTO `transfer` VALUES ('4', '1', '1');
INSERT INTO `transfer` VALUES ('5', '1', '1');
INSERT INTO `transfer` VALUES ('6', '1', '1');
INSERT INTO `transfer` VALUES ('7', '1', '1');
INSERT INTO `transfer` VALUES ('8', '1', '1');
INSERT INTO `transfer` VALUES ('9', '1', '4');
INSERT INTO `transfer` VALUES ('11', '1', '5');
INSERT INTO `transfer` VALUES ('12', '1', '5');
INSERT INTO `transfer` VALUES ('13', '1', '3');
INSERT INTO `transfer` VALUES ('14', '4', '3');
INSERT INTO `transfer` VALUES ('15', '4', '4');
INSERT INTO `transfer` VALUES ('17', '9', '6');
INSERT INTO `transfer` VALUES ('18', '10', '5');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `pwd` varchar(255) DEFAULT NULL COMMENT '密码',
  `tel` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别，1：男，2：女',
  `role` int(1) DEFAULT NULL COMMENT '人员权限：1：超级管理员，2：酒店人员，3.会员',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `stopstate` varchar(1) DEFAULT NULL COMMENT '是否停用：0：停用，1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '123123', '15513098144', '1', '0', '2020-04-15 16:17:55', '1');
INSERT INTO `users` VALUES ('4', 'guanli', '123456', '15513098165', '1', '1', '2020-04-15 17:07:17', '1');
INSERT INTO `users` VALUES ('5', '管理员', '123456', '15513065443', '1', '1', '2020-04-17 13:37:10', '1');
INSERT INTO `users` VALUES ('7', '管理员01', '123456', '15513098441', '1', '1', '2020-04-15 18:48:58', '0');
INSERT INTO `users` VALUES ('9', '管理员02', '123456', '15513065489', '1', '1', '2020-04-17 14:23:32', '1');
INSERT INTO `users` VALUES ('10', '用户01', '123456', '15513098457', '1', '2', '2020-04-17 14:26:22', '1');
