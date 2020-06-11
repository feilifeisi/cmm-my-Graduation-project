/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : 4qa004

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-04-03 19:35:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bar
-- ----------------------------
DROP TABLE IF EXISTS `bar`;
CREATE TABLE `bar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) DEFAULT NULL COMMENT '留言内容',
  `uid` int(11) DEFAULT NULL COMMENT '留言用户id',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='留言表';

-- ----------------------------
-- Records of bar
-- ----------------------------
INSERT INTO `bar` VALUES ('3', '测试', '5', '2020-04-03 19:21:49');
INSERT INTO `bar` VALUES ('4', '不错', '2', '2020-04-03 19:24:31');
INSERT INTO `bar` VALUES ('5', '测试留言', '6', '2020-04-03 19:33:48');
INSERT INTO `bar` VALUES ('6', '很不错的', '2', '2020-04-03 19:34:30');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '健身器材名称',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  `text` text COMMENT '介绍',
  `num` int(11) DEFAULT '0' COMMENT '点赞数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='器材表';

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('1', '双人漫步机', 'http://localhost:8080/hc-sys/files/20200403184515737v9t.jpg', '双人漫步机双人漫步机双人漫步机双人漫步机双人漫步机双人漫步机双人漫步机双人漫步机', '13');
INSERT INTO `equipment` VALUES ('2', 'G1综合训练器', 'http://localhost:8080/hc-sys/files/20200403184725816Kl4.jpg', '综合训练器家用单人站力量运动健身训练器材', '2');
INSERT INTO `equipment` VALUES ('4', '划船器', 'http://localhost:8080/hc-sys/files/20200403184943725P92.jpg', '划船器划船器划船器划船器划船器', '2');
INSERT INTO `equipment` VALUES ('5', '双杠', 'http://localhost:8080/hc-sys/files/20200403185038555H9o.jpg', '双杠 引体向上', '3');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '账户',
  `pwd` varchar(255) DEFAULT NULL COMMENT '密码',
  `role` varchar(255) DEFAULT NULL COMMENT '角色 0-超级管理员 1-普通用户 2-教练',
  `nickname` varchar(255) DEFAULT NULL COMMENT '姓名/昵称',
  `tel` varchar(255) DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `sex` int(1) DEFAULT NULL COMMENT '性别 1-男 2-女',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '123456', '0', 'admin', null, null, '0', '2020-04-03 18:09:12');
INSERT INTO `users` VALUES ('2', 'xiaohua', '123123', '1', '花花一世', '13752154245', '1212121@qq.com', '1', '2020-04-03 18:12:58');
INSERT INTO `users` VALUES ('5', '小豆腐', '123123', '2', '小豆腐', '13856564121', '153dad@qq.com', '2', '2020-04-03 19:06:24');
INSERT INTO `users` VALUES ('6', '姜军', '123123', '2', '姜军', '15236598565', '1513@qq.com', '1', '2020-04-03 19:31:03');
