/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : hotelmanage

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 08/06/2020 12:13:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill_info
-- ----------------------------
DROP TABLE IF EXISTS `bill_info`;
CREATE TABLE `bill_info`  (
  `bill_id` int(0) NOT NULL AUTO_INCREMENT,
  `checkin_id` int(0) NOT NULL,
  `room_id` int(0) NOT NULL,
  `deposit` decimal(10, 2) NOT NULL,
  `checkin_price` decimal(10, 2) NOT NULL,
  `days` int(0) NOT NULL,
  `accommodation_fee` decimal(10, 2) NOT NULL,
  `in_store_consumption` decimal(10, 2) NOT NULL,
  `real_income` decimal(10, 2) NOT NULL,
  `income` decimal(10, 2) NOT NULL,
  `return_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '自',
  `return_deposit` decimal(10, 2) NULL DEFAULT NULL COMMENT '自',
  `pay_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `operator` int(0) NULL DEFAULT NULL COMMENT '自',
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bill_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bill_info
-- ----------------------------
INSERT INTO `bill_info` VALUES (7, 1, 1, 100.00, 123.00, 7, 861.00, 3660.00, 4521.00, 4521.00, 0.00, 100.00, '微信', 1, NULL);
INSERT INTO `bill_info` VALUES (8, 19, 1, 100.00, 1.00, 5, 5.00, 0.00, 5.00, 5.00, 0.00, 100.00, '微信', 1, NULL);
INSERT INTO `bill_info` VALUES (9, 20, 1, 100.00, 1.00, 5, 5.00, 0.00, 5.00, 5.00, 0.00, 100.00, '微信', 1, NULL);
INSERT INTO `bill_info` VALUES (10, 21, 1, 100.00, 1.00, 5, 5.00, 0.00, 5.00, 5.00, 0.00, 100.00, '微信', 1, NULL);
INSERT INTO `bill_info` VALUES (11, 22, 1, 100.00, 1.00, 5, 5.00, 0.00, 5.00, 5.00, 0.00, 100.00, '微信', 1, NULL);
INSERT INTO `bill_info` VALUES (12, 23, 1, 100.00, 1.00, 5, 5.00, 0.00, 5.00, 5.00, 0.00, 100.00, '微信', 1, NULL);
INSERT INTO `bill_info` VALUES (13, 25, 1, 100.00, 1.00, 5, 5.00, 0.00, 5.00, 5.00, 0.00, 100.00, '微信', 1, NULL);
INSERT INTO `bill_info` VALUES (14, 1, 2, 100.00, 123.00, 6, 738.00, 1468.00, 2206.00, 2206.00, 0.00, 100.00, '微信', 1, NULL);
INSERT INTO `bill_info` VALUES (15, 26, 1, 100.00, 1.00, 12, 12.00, 0.00, 12.00, 12.00, 0.00, 100.00, '微信', 1, NULL);

-- ----------------------------
-- Table structure for checkin_info
-- ----------------------------
DROP TABLE IF EXISTS `checkin_info`;
CREATE TABLE `checkin_info`  (
  `checkin_id` int(0) NOT NULL AUTO_INCREMENT,
  `old_room_id` int(0) NULL DEFAULT NULL,
  `new_room_id` int(0) NOT NULL,
  `deposit` decimal(10, 2) NOT NULL,
  `checkin_price` decimal(10, 2) NOT NULL,
  `checkiner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ID_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ID_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `arrivals_time` datetime(0) NOT NULL,
  `leave_time` datetime(0) NOT NULL,
  `number` int(0) NOT NULL,
  `operator` int(0) NULL DEFAULT NULL COMMENT '自动',
  `member_id` int(0) NULL DEFAULT NULL,
  `breakfast` int(0) NULL DEFAULT 0,
  `wake` int(0) NULL DEFAULT 0,
  `order_to` int(0) NULL DEFAULT 1,
  PRIMARY KEY (`checkin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of checkin_info
-- ----------------------------
INSERT INTO `checkin_info` VALUES (1, NULL, 1, 100.00, 123.00, '123', '1', '1', '1', '2020-05-21 10:13:42', '2020-05-24 13:24:32', 2, 123, 1, 1, 0, 1);
INSERT INTO `checkin_info` VALUES (2, NULL, 1, 500.00, 1.00, '谢谢谢谢', '身份证', '123123123123123123123', '123123123123', '2020-05-16 10:58:27', '2020-05-16 10:58:27', 1, 1, 1, 0, 0, 1);
INSERT INTO `checkin_info` VALUES (15, NULL, 1, 500.00, 1.00, '谢谢谢谢', '身份证', '123123123123123123123', '123123123123', '2020-05-21 23:04:36', '2020-05-21 23:04:36', 1, 1, 1, 1, 1, 1);
INSERT INTO `checkin_info` VALUES (16, NULL, 1, 500.00, 1.00, '谢谢谢谢', '身份证', '123123123123123123123', '123123123123', '2020-05-21 23:04:39', '2020-05-21 23:04:39', 1, 1, 1, 1, 1, 1);
INSERT INTO `checkin_info` VALUES (17, NULL, 1, 100.00, 1.00, 'shinki', '中华人民共和国居民身份证', '1231233', 'asdf', '2020-05-23 22:43:56', '2020-05-23 22:43:49', 12, 1, 1, 0, 0, 1);
INSERT INTO `checkin_info` VALUES (18, NULL, 1, 100.00, 1.00, 'shinki', '中华人民共和国居民身份证', '1231233', 'asdf', '2020-05-23 22:45:46', '2020-05-23 22:45:38', 12, 1, 1, 0, 0, 1);
INSERT INTO `checkin_info` VALUES (19, NULL, 1, 100.00, 1.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 23:28:29', '2020-05-24 11:22:30', 123, 1, 1, 0, 0, 1);
INSERT INTO `checkin_info` VALUES (20, NULL, 1, 100.00, 1.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 23:28:21', '2020-05-24 11:23:34', 123, 1, 1, 0, 0, 1);
INSERT INTO `checkin_info` VALUES (21, NULL, 1, 100.00, 1.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 23:28:17', '2020-05-24 11:31:34', 123, 1, 1, 0, 0, 1);
INSERT INTO `checkin_info` VALUES (22, NULL, 1, 100.00, 1.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 23:28:14', '2020-05-24 11:32:17', 123, 1, 1, 0, 0, 1);
INSERT INTO `checkin_info` VALUES (23, NULL, 1, 100.00, 1.00, 'shinki', '中华人民共和国居民身份证', '1231233', 'asdf', '2020-05-23 23:28:10', '2020-05-24 11:32:38', 12, 1, 1, 0, 0, 1);
INSERT INTO `checkin_info` VALUES (24, NULL, 1, 500.00, 1.00, '谢谢谢谢', '中华人民共和国居民身份证', '123123123123123123123', '123123123123', '2020-05-23 22:50:07', '2020-05-23 22:46:27', 1, 1, 1, 0, 0, 1);
INSERT INTO `checkin_info` VALUES (25, NULL, 1, 100.00, 1.00, '123123', '中华人民共和国居民身份证', '1231233', '123', '2020-05-23 23:24:45', '2020-05-24 13:22:40', 12, 1, 1, NULL, NULL, 1);
INSERT INTO `checkin_info` VALUES (26, 1, 2, 100.00, 1.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 23:32:49', '2020-05-24 23:12:33', 123, 1, 1, NULL, NULL, 1);
INSERT INTO `checkin_info` VALUES (27, NULL, 1, 100.00, 1.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 23:34:15', '2020-06-04 23:33:45', 123, 1, 1, NULL, NULL, 1);
INSERT INTO `checkin_info` VALUES (28, NULL, 1, 100.00, 1.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 23:41:40', '2020-05-28 23:36:07', 123, 1, 1, NULL, NULL, 1);
INSERT INTO `checkin_info` VALUES (29, NULL, 1, 100.00, 1.00, 'shinki123123', '中华人民共和国居民身份证', '123123', 'asdf', '2020-05-24 08:59:41', '2020-05-23 22:31:31', 12, 1, 1, 0, 0, 1);
INSERT INTO `checkin_info` VALUES (30, 16, 18, 100.00, 1.00, '123', '中华人民共和国居民身份证', '1231233', 'asdf', '2020-05-24 09:43:58', '2020-06-23 22:31:31', 12, 1, NULL, 1, 1, 0);

-- ----------------------------
-- Table structure for cost_info
-- ----------------------------
DROP TABLE IF EXISTS `cost_info`;
CREATE TABLE `cost_info`  (
  `cost_id` int(0) NOT NULL AUTO_INCREMENT,
  `checkin_id` int(0) NOT NULL,
  `room_id` int(0) NOT NULL,
  `goods_id` int(0) NOT NULL,
  `number` int(0) NOT NULL,
  `operator` int(0) NULL DEFAULT NULL COMMENT '自',
  `time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '自',
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cost_price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`cost_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cost_info
-- ----------------------------
INSERT INTO `cost_info` VALUES (2, 2, 1, 1, 2, 1, '2020-05-24 13:57:04', '1231236151', 1.00);
INSERT INTO `cost_info` VALUES (4, 1, 2, 2, 231, 1, '2020-06-01 09:01:15', NULL, 1.00);
INSERT INTO `cost_info` VALUES (6, 1, 3, 2, 2, 1, '2020-05-24 13:17:50', NULL, 1.00);
INSERT INTO `cost_info` VALUES (7, 1, 3, 2, 4, 1, '2020-05-24 13:17:50', NULL, 1.00);
INSERT INTO `cost_info` VALUES (8, 1, 1, 3, 1231, 1, '2020-06-01 09:01:29', '22', 1.00);

-- ----------------------------
-- Table structure for floor_info
-- ----------------------------
DROP TABLE IF EXISTS `floor_info`;
CREATE TABLE `floor_info`  (
  `floor_id` int(0) NOT NULL AUTO_INCREMENT,
  `floor_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`floor_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of floor_info
-- ----------------------------
INSERT INTO `floor_info` VALUES (1, '123', '12');
INSERT INTO `floor_info` VALUES (2, '二楼', '24');
INSERT INTO `floor_info` VALUES (3, '123123123', '123');

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info`  (
  `goods_id` int(0) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type_id` int(0) NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `discount` decimal(10, 2) NOT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods_info
-- ----------------------------
INSERT INTO `goods_info` VALUES (1, '可乐', 2, 10.00, 10.00, '个', '12333');
INSERT INTO `goods_info` VALUES (2, '泡面', 1, 10.00, 10.00, '桶', '123');
INSERT INTO `goods_info` VALUES (3, '宽带', 3, 123.00, 10.00, '天', NULL);
INSERT INTO `goods_info` VALUES (4, '500M宽带', 3, 1.00, 1.00, '天', '123123');
INSERT INTO `goods_info` VALUES (6, '薯条', 1, 1.00, 1.00, '包', '123');
INSERT INTO `goods_info` VALUES (7, '蛋糕', 1, 10.00, 1.00, '块', '123');

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type`  (
  `type_id` int(0) NOT NULL AUTO_INCREMENT,
  `goods_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES (1, '食品', '123');
INSERT INTO `goods_type` VALUES (2, '饮料', '123');
INSERT INTO `goods_type` VALUES (3, '宽带', '123');
INSERT INTO `goods_type` VALUES (4, '下午茶', '111');

-- ----------------------------
-- Table structure for log_info
-- ----------------------------
DROP TABLE IF EXISTS `log_info`;
CREATE TABLE `log_info`  (
  `log_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `operate` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 215 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of log_info
-- ----------------------------
INSERT INTO `log_info` VALUES (2, '1', '对room_type表插入数据 {type=大床房, number=2, details=舒服} ', '2020-05-15 14:43:46', '操作成功');
INSERT INTO `log_info` VALUES (3, '1', '对room_info表插入数据 {room_type_id=1, status=空房, floor_id=1, price=1122.123123, discounted_price=123, member_price=12, vip_price=1} ', '2020-05-15 20:35:12', '操作成功');
INSERT INTO `log_info` VALUES (4, '1', '对room_info表中条件是 {room_id=3} 数据的字段更新为 {room_type_id=2, status=预定, floor_id=2, price=1122.123, discounted_price=12, member_price=2, vip_price=1.1111} ', '2020-05-15 20:43:00', '操作成功');
INSERT INTO `log_info` VALUES (7, '1', '对room_type表条件是 {room_id=3} 的数据进行删除  ', '2020-05-15 20:51:12', '操作失败');
INSERT INTO `log_info` VALUES (8, '1', '对room_type表条件是 {room_id=3} 的数据进行删除  ', '2020-05-15 20:51:34', '操作失败');
INSERT INTO `log_info` VALUES (9, '1', '对room_type表条件是 {room_id=3} 的数据进行删除  ', '2020-05-15 20:51:40', '操作失败');
INSERT INTO `log_info` VALUES (10, '1', '对room_type表条件是 {room_id=3} 的数据进行删除  ', '2020-05-15 20:57:47', '操作失败');
INSERT INTO `log_info` VALUES (11, '1', '对room_info表条件是 {room_id=3} 的数据进行删除  ', '2020-05-15 21:03:04', '操作成功');
INSERT INTO `log_info` VALUES (12, '1', '对checin_info表更新数据 {number=1, id_number=123123123123123123123, leave_time=2020-05-15 23:23:00, phone=123123123123, arrivals_time=Fri May 15 23:26:45 CST 2020, deposit=500.00, id_type=身份证, breakfast=null, new_room_id=1, checkiner=null} ', '2020-05-15 23:26:45', '操作失败');
INSERT INTO `log_info` VALUES (13, '1', '对order_info表更新数据 {status=已入住} ', '2020-05-15 23:26:45', '操作成功');
INSERT INTO `log_info` VALUES (14, '1', '对checin_info表更新数据 {number=1, id_number=123123123123123123123, leave_time=2020-05-15 23:23:00, phone=123123123123, arrivals_time=Fri May 15 23:28:31 CST 2020, deposit=500.00, id_type=身份证, breakfast=null, new_room_id=1, checkiner=谢谢谢谢} ', '2020-05-15 23:28:32', '操作成功');
INSERT INTO `log_info` VALUES (15, '1', '对order_info表更新数据 {status=已入住} ', '2020-05-15 23:28:32', '操作成功');
INSERT INTO `log_info` VALUES (16, '1', '对checin_info表更新数据 {number=1, id_number=123123123123123123123, leave_time=2020-05-15 23:23:00, phone=123123123123, arrivals_time=Fri May 15 23:31:01 CST 2020, deposit=500.00, id_type=身份证, breakfast=null, new_room_id=1, checkiner=谢谢谢谢} ', '2020-05-15 23:31:02', '操作成功');
INSERT INTO `log_info` VALUES (17, '1', '对order_info表更新数据 {status=已入住} ', '2020-05-15 23:31:01', '操作成功');
INSERT INTO `log_info` VALUES (18, '1', '对checin_info表更新数据 {number=1, id_number=123123123123123123123, leave_time=2020-05-15 23:23:00, phone=123123123123, arrivals_time=Fri May 15 23:34:24 CST 2020, deposit=500.00, id_type=身份证, breakfast=null, new_room_id=1, checkiner=谢谢谢谢} ', '2020-05-15 23:34:24', '操作成功');
INSERT INTO `log_info` VALUES (19, '1', '对order_info表更新数据 {status=已入住} ', '2020-05-15 23:34:24', '操作成功');
INSERT INTO `log_info` VALUES (20, '1', '对order_info表更新数据 {status=已入住} ', '2020-05-15 23:40:04', '操作成功');
INSERT INTO `log_info` VALUES (21, '1', '对order_info表更新数据 {status=已入住} ', '2020-05-15 23:41:06', '操作成功');
INSERT INTO `log_info` VALUES (22, '1', '对order_info表更新数据 {status=已入住} ', '2020-05-15 23:42:21', '操作成功');
INSERT INTO `log_info` VALUES (23, '1', '对checin_info表更新数据 {member_id=1, number=1, id_number=123123123123123123123, leave_time=2020-05-15 23:40:50, phone=123123123123, arrivals_time=Fri May 15 23:45:18 CST 2020, deposit=500.00, id_type=身份证, breakfast=null, new_room_id=1, checkiner=谢谢谢谢, checkin_price=1.00} ', '2020-05-15 23:45:19', '操作成功');
INSERT INTO `log_info` VALUES (24, '1', '对order_info表更新数据 {status=已入住} ', '2020-05-15 23:45:18', '操作成功');
INSERT INTO `log_info` VALUES (25, '1', '对checin_info表更新数据 {member_id=1, number=1, id_number=123123123123123123123, leave_time=2020-05-15 23:40:50, phone=123123123123, arrivals_time=Fri May 15 23:49:22 CST 2020, deposit=500.00, id_type=身份证, new_room_id=1, checkiner=谢谢谢谢, checkin_price=1.00} ', '2020-05-15 23:49:23', '操作成功');
INSERT INTO `log_info` VALUES (26, '1', '对order_info表更新数据 {status=已入住} ', '2020-05-15 23:49:22', '操作成功');
INSERT INTO `log_info` VALUES (27, '1', '对checin_info表更新数据 {member_id=1, number=1, id_number=123123123123123123123, leave_time=2020-05-15 23:40:50, phone=123123123123, arrivals_time=Fri May 15 23:51:12 CST 2020, deposit=500.00, id_type=身份证, new_room_id=1, checkiner=谢谢谢谢, operator=1, checkin_price=1.00} ', '2020-05-15 23:51:13', '操作成功');
INSERT INTO `log_info` VALUES (28, '1', '对order_info表更新数据 {status=已入住} ', '2020-05-15 23:51:13', '操作成功');
INSERT INTO `log_info` VALUES (29, '1', '对order_info表更新数据 {status=已取消} ', '2020-05-16 10:15:27', '操作成功');
INSERT INTO `log_info` VALUES (30, '1', '对order_info表更新数据 {status=已取消} ', '2020-05-16 10:16:21', '操作成功');
INSERT INTO `log_info` VALUES (31, '1', '对checkin_info表更新数据 {new_room_id=2, deposit=500, checkiner=谢谢谢谢, ID_type=身份证, ID_number=123123123123123123123, phone=123123123123, arrivals_time=Sat May 16 10:58:10 CST 2020, leave_time=2020-05-18 22:58:44, number=1, breakfast=1, wake=1, checkin_price=1.00, order_to=0, operator=1} ', '2020-05-16 10:58:11', '操作成功');
INSERT INTO `log_info` VALUES (32, '1', '对checkin_info表更新数据 {new_room_id=2, deposit=500, checkiner=谢谢谢谢, ID_type=身份证, ID_number=123123123123123123123, phone=123123123123, arrivals_time=Sat May 16 11:01:18 CST 2020, leave_time=2020-05-18 22:58:44, number=1, member_id=1, breakfast=1, wake=1, checkin_price=1.00, order_to=0, operator=1} ', '2020-05-16 11:01:19', '操作成功');
INSERT INTO `log_info` VALUES (33, '1', '对checkin_info表更新数据 {new_room_id=2, deposit=500, checkiner=谢谢谢谢, ID_type=身份证, ID_number=123123123123123123123, phone=123123123123, arrivals_time=Sat May 16 11:04:18 CST 2020, leave_time=2020-05-18 22:58:44, number=1, member_id=1, breakfast=1, wake=1, checkin_price=1.00, order_to=0, operator=1} ', '2020-05-16 11:04:18', '操作成功');
INSERT INTO `log_info` VALUES (34, '1', '对checkin_info表更新数据 {new_room_id=2, deposit=500, checkiner=谢谢谢谢, ID_type=身份证, ID_number=123123123123123123123, phone=123123123123, arrivals_time=Sat May 16 11:05:43 CST 2020, leave_time=2020-05-18 22:58:44, number=1, member_id=1, breakfast=1, wake=1, checkin_price=1.00, order_to=0, operator=1} ', '2020-05-16 11:05:44', '操作成功');
INSERT INTO `log_info` VALUES (35, '1', '对checin_info表更新数据 {new_room_id=1, old_room_id=1} ', '2020-05-16 11:31:49', '操作失败');
INSERT INTO `log_info` VALUES (36, '1', '对checin_info表更新数据 {new_room_id=1, old_room_id=1} ', '2020-05-16 11:32:30', '操作失败');
INSERT INTO `log_info` VALUES (37, '1', '对checin_info表更新数据 {new_room_id=1, old_room_id=2} ', '2020-05-16 11:34:50', '操作成功');
INSERT INTO `log_info` VALUES (38, '1', '对bill_info表更新数据 {room_id=1, checkin_price=123.00, accommodation_fee=1353.00, in_store_consumption=1270.00, checkin_id=1, deposit=100.00, days=11, real_income=2623.00, income=3000.00, pay_method=现金, return_deposit=100, return_money=377.0, operator=1} ', '2020-05-16 13:36:09', '操作成功');
INSERT INTO `log_info` VALUES (39, '1', '对bill_info表更新数据 {room_id=1, checkin_price=123.00, accommodation_fee=1353.00, in_store_consumption=1270.00, checkin_id=1, deposit=100.00, days=11, real_income=2623.00, income=3000.00, pay_method=现金, return_deposit=100, return_money=377.0, operator=1} ', '2020-05-16 13:37:19', '操作成功');
INSERT INTO `log_info` VALUES (40, '1', '对bill_info表更新数据 {room_id=1, checkin_price=123.00, accommodation_fee=1353.00, in_store_consumption=1270.10, checkin_id=1, deposit=100.00, days=11, real_income=2623.00, income=3000.00, pay_method=现金, return_deposit=100, return_money=377.0, operator=1} ', '2020-05-16 13:37:33', '操作成功');
INSERT INTO `log_info` VALUES (41, '1', '对checin_info表更新数据 {member_id=1, checkin_price=1.00, id_number=123123123123123123123, leave_time=2020-05-16 14:59:51, operator=1, number=1, checkiner=谢谢谢谢, wake=null, phone=123123123123, arrivals_time=Sat May 16 14:59:56 CST 2020, deposit=500.00, id_type=身份证, breakfast=null, new_room_id=1} ', '2020-05-16 14:59:56', '操作成功');
INSERT INTO `log_info` VALUES (42, '1', '对checin_info表更新数据 {member_id=1, checkin_price=1.00, id_number=123123123123123123123, leave_time=2020-05-16 14:59:51, operator=1, number=1, checkiner=谢谢谢谢, wake=null, phone=123123123123, arrivals_time=Sat May 16 15:07:19 CST 2020, deposit=500.00, id_type=身份证, breakfast=null, new_room_id=1} ', '2020-05-16 15:07:19', '操作成功');
INSERT INTO `log_info` VALUES (43, '1', '对cost_info表条件是 {checkin_id=1, room_id=2, goods_id=2, number=231} 的数据进行删除  ', '2020-05-16 20:25:17', '操作成功');
INSERT INTO `log_info` VALUES (44, '1', '对cost_info表条件是 {checkin_id=1, room_id=2, goods_id=2, number=231, operator=1, time=Sat May 16 20:31:22 CST 2020} 的数据进行删除  ', '2020-05-16 20:31:22', '操作成功');
INSERT INTO `log_info` VALUES (45, '1', '对cost_info表条件是 {checkin_id=1, room_id=3, goods_id=2, number=231, operator=1, time=Sat May 16 20:33:18 CST 2020} 的数据进行删除  ', '2020-05-16 20:33:19', '操作成功');
INSERT INTO `log_info` VALUES (46, '1', '对cost_info表条件是 {checkin_id=1, room_id=3, goods_id=2, number=231, operator=1, time=Sat May 16 20:38:22 CST 2020} 的数据进行删除  ', '2020-05-16 20:38:22', '操作成功');
INSERT INTO `log_info` VALUES (47, '1', '对cost_info表中条件是 {cost_id=6} 数据的字段更新为 {number=2, operator=1, time=Sat May 16 20:41:56 CST 2020} ', '2020-05-16 20:41:57', '操作成功');
INSERT INTO `log_info` VALUES (48, '1', '对room_info表中条件是 {room_id=1} 数据的字段更新为 {price=123} ', '2020-05-17 18:40:51', '操作成功');
INSERT INTO `log_info` VALUES (49, '1', '对room_type表插入数据 {} ', '2020-05-18 16:10:23', '操作失败');
INSERT INTO `log_info` VALUES (50, '1', '对room_type表插入数据 {} ', '2020-05-18 16:11:31', '操作失败');
INSERT INTO `log_info` VALUES (51, '1', '对room_type表插入数据 {type=\"单人床\",, number=12,, details=\"123123\"} ', '2020-05-18 16:19:18', '操作失败');
INSERT INTO `log_info` VALUES (52, '1', '对room_type表插入数据 {type=\"单人床\",, number=12, details=\"123123\"} ', '2020-05-18 16:20:32', '操作成功');
INSERT INTO `log_info` VALUES (53, '1', '对room_type表中条件是 {room_id=null} 数据的字段更新为 {type=\"单人床\",, number=12, room_type_id=2} ', '2020-05-18 21:36:01', '操作失败');
INSERT INTO `log_info` VALUES (54, '1', '对room_type表中条件是 {room_type_id=2} 数据的字段更新为 {type=\"单人床\",, number=12} ', '2020-05-18 21:38:04', '操作成功');
INSERT INTO `log_info` VALUES (55, '1', '对room_type表条件是 4,5,6 的数据进行删除  ', '2020-05-18 21:53:56', '操作成功');
INSERT INTO `log_info` VALUES (56, '1', '对room_type表条件是 5,6 的数据进行删除  ', '2020-05-18 21:55:10', '操作成功');
INSERT INTO `log_info` VALUES (57, '1', '对room_type表条件是 5,6 的数据进行删除  ', '2020-05-18 22:01:54', '操作成功');
INSERT INTO `log_info` VALUES (58, '1', '对room_type表条件是 5,6 的数据进行删除  ', '2020-05-18 22:02:58', '操作成功');
INSERT INTO `log_info` VALUES (59, '1', '对room_type表条件是 5,6 的数据进行删除  ', '2020-05-18 22:06:30', '操作成功');
INSERT INTO `log_info` VALUES (60, '1', '对room_type表条件是 5,6 的数据进行删除  ', '2020-05-18 22:08:32', '操作成功');
INSERT INTO `log_info` VALUES (61, '1', '对room_type表条件是 5,6 的数据进行删除  ', '2020-05-18 22:08:32', '操作成功');
INSERT INTO `log_info` VALUES (62, '1', '对room_type表条件是 1 的数据进行删除  ', '2020-05-18 22:09:47', '操作成功');
INSERT INTO `log_info` VALUES (64, '1', '对user_info表条件是  的数据进行删除  ', '2020-05-20 21:42:29', '操作失败');
INSERT INTO `log_info` VALUES (65, '1', '对user_info表条件是 2 的数据进行删除  ', '2020-05-20 21:43:50', '操作成功');
INSERT INTO `log_info` VALUES (66, '1', '对user_info表中条件是 {user_id=1} 数据的字段更新为 {username=admin, password=123456, authority=3, details=123124124} ', '2020-05-20 22:27:14', '操作成功');
INSERT INTO `log_info` VALUES (67, '1', '对floor_info表中条件是 {room_type_id=null} 数据的字段更新为 {floor_id=1, floor_name=123} ', '2020-05-21 16:33:45', '操作失败');
INSERT INTO `log_info` VALUES (68, '1', '对floor_info表中条件是 {floor_id=1} 数据的字段更新为 {floor_name=123} ', '2020-05-21 16:35:44', '操作成功');
INSERT INTO `log_info` VALUES (69, '1', '对user_info表中条件是 {user_id=1} 数据的字段更新为 {details=xxxx} ', '2020-05-22 20:03:58', '操作成功');
INSERT INTO `log_info` VALUES (70, '1', '对user_info表中条件是 {user_id=3} 数据的字段更新为 {details=xxxx} ', '2020-05-22 20:05:11', '操作成功');
INSERT INTO `log_info` VALUES (71, '1', '对user_info表中条件是 {user_id=4} 数据的字段更新为 {details=xxxx} ', '2020-05-22 20:05:12', '操作成功');
INSERT INTO `log_info` VALUES (72, '1', '对user_info表中条件是 {user_id=5} 数据的字段更新为 {details=xxxx} ', '2020-05-22 20:05:19', '操作成功');
INSERT INTO `log_info` VALUES (73, '1', '对user_info表中条件是 {user_id=1} 数据的字段更新为 {details=xxxx} ', '2020-05-22 20:42:48', '操作成功');
INSERT INTO `log_info` VALUES (74, '1', '对user_info表中条件是 {user_id=1} 数据的字段更新为 {details=xxxx} ', '2020-05-22 20:42:53', '操作成功');
INSERT INTO `log_info` VALUES (75, '1', '对user_info表中条件是 {user_id=1} 数据的字段更新为 {details=xxxx} ', '2020-05-22 20:42:55', '操作成功');
INSERT INTO `log_info` VALUES (76, '1', '对user_info表中条件是 {user_id=1} 数据的字段更新为 {details=xxxx} ', '2020-05-22 20:47:13', '操作成功');
INSERT INTO `log_info` VALUES (77, '1', '对user_info表中条件是 {user_id=1} 数据的字段更新为 {details=xxxx} ', '2020-05-23 08:58:21', '操作成功');
INSERT INTO `log_info` VALUES (78, '1', '对user_info表中条件是 {user_id=1} 数据的字段更新为 {details=xxxx} ', '2020-05-23 08:58:22', '操作成功');
INSERT INTO `log_info` VALUES (79, '1', '对user_info表条件是 5 的数据进行删除  ', '2020-05-23 08:58:26', '操作成功');
INSERT INTO `log_info` VALUES (80, '1', '对user_info表插入数据 {username=admin, password=123123, authority=1, details=1231231wewafasdf} ', '2020-05-23 09:25:05', '操作成功');
INSERT INTO `log_info` VALUES (81, '1', '对user_info表插入数据 {username=戎漩, password=123123, authority=1, details=xxxx123123} ', '2020-05-23 09:48:44', '操作成功');
INSERT INTO `log_info` VALUES (82, '1', '对user_info表插入数据 {username=admin, password=123456, authority=1, details=xxxx} ', '2020-05-23 09:50:18', '操作成功');
INSERT INTO `log_info` VALUES (83, '1', '对user_info表中条件是 {user_id=null} 数据的字段更新为 {username=戎漩, password=123123, authority=2, details=xxxx123123} ', '2020-05-23 09:51:46', '操作失败');
INSERT INTO `log_info` VALUES (84, '1', '对user_info表中条件是 {user_id=3} 数据的字段更新为 {username=戎漩, password=123123, authority=2, details=xxxx123123} ', '2020-05-23 09:52:52', '操作成功');
INSERT INTO `log_info` VALUES (85, '1', '对user_info表中条件是 {user_id=3} 数据的字段更新为 {username=戎漩, password=123123, authority=3, details=xxxx123123} ', '2020-05-23 09:53:42', '操作成功');
INSERT INTO `log_info` VALUES (86, '1', '对log_info表条件是 {} 的数据进行删除  ', '2020-05-23 10:02:42', '操作失败');
INSERT INTO `log_info` VALUES (87, '1', '对log_info表条件是 {} 的数据进行删除  ', '2020-05-23 10:02:44', '操作失败');
INSERT INTO `log_info` VALUES (88, '1', '对log_info表条件是 {} 的数据进行删除  ', '2020-05-23 10:02:44', '操作失败');
INSERT INTO `log_info` VALUES (89, '1', '对log_info表条件是 {} 的数据进行删除  ', '2020-05-23 10:02:45', '操作失败');
INSERT INTO `log_info` VALUES (90, '1', '对log_info表条件是 {} 的数据进行删除  ', '2020-05-23 10:02:48', '操作失败');
INSERT INTO `log_info` VALUES (91, '1', '对log_info表条件是 {} 的数据进行删除  ', '2020-05-23 10:03:05', '操作失败');
INSERT INTO `log_info` VALUES (92, '1', '对log_info表条件是 {log_id=5} 的数据进行删除  ', '2020-05-23 10:03:29', '操作成功');
INSERT INTO `log_info` VALUES (93, '1', '对log_info表条件是 {log_id=6} 的数据进行删除  ', '2020-05-23 10:03:35', '操作成功');
INSERT INTO `log_info` VALUES (94, '1', '对log_info表条件是 {log_id=1} 的数据进行删除  ', '2020-05-23 13:52:11', '操作成功');
INSERT INTO `log_info` VALUES (95, '1', '对log_info表条件是 {log_id=63} 的数据进行删除  ', '2020-05-23 13:52:29', '操作成功');
INSERT INTO `log_info` VALUES (96, '1', '对user_info表插入数据 {type=天字一号间, number=10, details=多人运动} ', '2020-05-23 14:22:12', '操作失败');
INSERT INTO `log_info` VALUES (97, '1', '对room_type表插入数据 {type=天字一号间, number=10, details=多人运动} ', '2020-05-23 14:24:20', '操作成功');
INSERT INTO `log_info` VALUES (98, '1', '对room_type表中条件是 {room_type_id=7} 数据的字段更新为 {type=天字一号间, number=10, details=多人运动123123} ', '2020-05-23 14:25:46', '操作成功');
INSERT INTO `log_info` VALUES (99, '1', '对room_type表条件是 7 的数据进行删除  ', '2020-05-23 14:25:50', '操作成功');
INSERT INTO `log_info` VALUES (100, '1', '对room_info表插入数据 {room_type_id=1, status=空房, floor_id=1, price=12312, discounted_price=12312, member_price=12312, vip_price=12312, details=awdawdawd} ', '2020-05-23 16:39:57', '操作成功');
INSERT INTO `log_info` VALUES (101, '1', '对room_info表插入数据 {room_type_id=1, status=空房, floor_id=1, price=12312, discounted_price=12312, member_price=12312, vip_price=12312, details=awdawdawd} ', '2020-05-23 16:40:58', '操作成功');
INSERT INTO `log_info` VALUES (102, '1', '对room_info表条件是 17 的数据进行删除  ', '2020-05-23 16:41:15', '操作成功');
INSERT INTO `log_info` VALUES (103, '1', '对room_info表中条件是 {room_id=16} 数据的字段更新为 {room_type_id=1, status=空房, floor_id=1, price=12312.00, discounted_price=12312.00, member_price=12312.00, vip_price=12312.00, details=awdawdawd123123123123123} ', '2020-05-23 16:42:16', '操作成功');
INSERT INTO `log_info` VALUES (104, '1', '对room_info表插入数据 {room_type_id=1, status=空房, floor_id=1, price=123, discounted_price=123, member_price=123, vip_price=123} ', '2020-05-23 17:02:20', '操作成功');
INSERT INTO `log_info` VALUES (105, '1', '对room_info表中条件是 {room_id=10} 数据的字段更新为 {room_type_id=1, status=入住, floor_id=1, price=1.00, discounted_price=1.00, member_price=1.00, vip_price=1.00, details=1撒打发斯蒂芬} ', '2020-05-23 17:02:46', '操作成功');
INSERT INTO `log_info` VALUES (106, '1', '对floor_info表插入数据 {floor_name=123, details=123} ', '2020-05-23 17:18:52', '操作成功');
INSERT INTO `log_info` VALUES (107, '1', '对floor_info表中条件是 {floor_id=3} 数据的字段更新为 {floor_name=123123123, details=123} ', '2020-05-23 17:20:22', '操作成功');
INSERT INTO `log_info` VALUES (108, '1', '对goods_type表插入数据 {goods_type=qwe, details=qweqwe} ', '2020-05-23 18:54:58', '操作成功');
INSERT INTO `log_info` VALUES (109, '1', '对goods_type表中条件是 {type_id=4} 数据的字段更新为 {goods_type=qwe, details=qweqwe123124} ', '2020-05-23 18:57:04', '操作成功');
INSERT INTO `log_info` VALUES (110, '1', '对goods_type表条件是 4 的数据进行删除  ', '2020-05-23 18:57:09', '操作成功');
INSERT INTO `log_info` VALUES (111, '1', '对goods_info表插入数据 {goods_name=长城宽带, type_id=3, price=1.00, discount=1.00, unit=天, details=123123} ', '2020-05-23 19:28:16', '操作成功');
INSERT INTO `log_info` VALUES (112, '1', '对goods_info表插入数据 {goods_name=长城宽带2, type_id=3, price=123, discount=123, unit=天, details=124124} ', '2020-05-23 19:35:58', '操作成功');
INSERT INTO `log_info` VALUES (113, '1', '对goods_info表插入数据 {goods_name=垃圾食品, type_id=1, price=1.00, discount=1.00, unit=包, details=12312} ', '2020-05-23 19:36:32', '操作成功');
INSERT INTO `log_info` VALUES (114, '1', '对goods_info表中条件是 {goods_id=6} 数据的字段更新为 {goods_name=垃圾食品, type_id=1, price=1.00, discount=1.00, unit=包, details=垃圾食品真好吃} ', '2020-05-23 19:37:17', '操作成功');
INSERT INTO `log_info` VALUES (115, '1', '对goods_info表条件是 5 的数据进行删除  ', '2020-05-23 19:37:38', '操作成功');
INSERT INTO `log_info` VALUES (116, '1', '对member_Info表中条件是 {member_id=1} 数据的字段更新为 {name=asdf, sex=男, password=asdf, phone=asdf, address=asdf, Email=asdf12312@qq.com, integral=3660, level=member, details=123123} ', '2020-05-23 20:26:04', '操作成功');
INSERT INTO `log_info` VALUES (117, '1', '对member_Info表插入数据 {name=shinki, sex=女, password=123123, phone=asdf, address=123@qq.com, Email=asdf12312@qq.com, details=123124124} ', '2020-05-23 20:26:33', '操作成功');
INSERT INTO `log_info` VALUES (118, '1', '对member_Info表插入数据 {name=1124, sex=男, password=123, phone=123, address=123, Email=asdf12312@qq.com, details=124124} ', '2020-05-23 20:29:36', '操作成功');
INSERT INTO `log_info` VALUES (119, '1', '对member_Info表条件是 3 的数据进行删除  ', '2020-05-23 20:29:39', '操作成功');
INSERT INTO `log_info` VALUES (120, '1', '对member_Info表插入数据 {name=asdf, sex=男, password=123123, phone=asdf, address=123@qq.com, Email=asdf12312@qq.com, details=123124} ', '2020-05-23 20:30:35', '操作成功');
INSERT INTO `log_info` VALUES (121, '1', '对member_Info表条件是 4 的数据进行删除  ', '2020-05-23 20:30:43', '操作成功');
INSERT INTO `log_info` VALUES (122, '1', '对order_info表更新数据 {room_id=1, deposit=100.00, orderer=123123, ID_type=中华人民共和国居民身份证, ID_number=1231233, phone=123, arrivals_time=2020-05-23 22:31:31, leave_time=2020-05-23 22:31:31, number=12, member_id=1, order_status=正常, details=123123412412} ', '2020-05-23 22:33:49', '操作成功');
INSERT INTO `log_info` VALUES (123, '1', '对order_info表更新数据 {room_id=1, deposit=100.00, orderer=123123, ID_type=中华人民共和国居民身份证, ID_number=1231233, phone=123, arrivals_time=2020-05-23 22:31:31, leave_time=2020-05-23 22:31:31, number=12, member_id=1, order_status=已取消, details=123123412412} ', '2020-05-23 22:34:14', '操作成功');
INSERT INTO `log_info` VALUES (124, '1', '对order_info表插入数据 {room_id=1, deposit=100.00, orderer=shinki, ID_type=中华人民共和国居民身份证, ID_number=1231233, phone=asdf, arrivals_time=2020-05-23 22:31:31, leave_time=2020-05-23 22:31:31, number=12, member_id=1, order_status=正常, details=124124, operator=1} ', '2020-05-23 22:35:10', '操作成功');
INSERT INTO `log_info` VALUES (125, '1', '对order_info表更新数据 {order_status=已取消} ', '2020-05-23 22:39:50', '操作成功');
INSERT INTO `log_info` VALUES (126, '1', '对order_info表更新数据 {order_status=已取消} ', '2020-05-23 22:40:05', '操作成功');
INSERT INTO `log_info` VALUES (127, '1', '对order_info表更新数据 {order_status=已取消} ', '2020-05-23 22:41:16', '操作成功');
INSERT INTO `log_info` VALUES (128, '1', '对order_info表更新数据 {order_status=已取消} ', '2020-05-23 22:42:16', '操作成功');
INSERT INTO `log_info` VALUES (129, '1', '对order_info表更新数据 {order_status=已取消} ', '2020-05-23 22:43:10', '操作成功');
INSERT INTO `log_info` VALUES (130, '1', '对checin_info表更新数据 {member_id=1, id_number=1231233, leave_time=2020-05-23 22:43:49, operator=1, number=12, phone=asdf, arrivals_time=2020-05-23 22:43:56, deposit=100.00, id_type=中华人民共和国居民身份证, new_room_id=1, checkiner=shinki, checkin_price=1.00} ', '2020-05-23 22:43:57', '操作成功');
INSERT INTO `log_info` VALUES (131, '1', '对order_info表更新数据 {order_status=已入住} ', '2020-05-23 22:43:57', '操作成功');
INSERT INTO `log_info` VALUES (132, '1', '对checin_info表更新数据 {member_id=1, id_number=1231233, leave_time=2020-05-23 22:45:38, operator=1, number=12, phone=asdf, arrivals_time=2020-05-23 22:45:46, deposit=100.00, id_type=中华人民共和国居民身份证, new_room_id=1, checkiner=shinki, checkin_price=1.00} ', '2020-05-23 22:45:46', '操作成功');
INSERT INTO `log_info` VALUES (133, '1', '对order_info表更新数据 {order_status=已入住} ', '2020-05-23 22:45:46', '操作成功');
INSERT INTO `log_info` VALUES (134, '1', '对checin_info表更新数据 {member_id=1, id_number=123, leave_time=2020-05-23 22:31:42, operator=1, number=123, phone=123, arrivals_time=2020-05-23 22:46:06, deposit=100.00, id_type=中华人民共和国居民身份证, new_room_id=1, checkiner=123123, checkin_price=1.00} ', '2020-05-23 22:46:06', '操作成功');
INSERT INTO `log_info` VALUES (135, '1', '对order_info表更新数据 {order_status=已入住} ', '2020-05-23 22:46:06', '操作成功');
INSERT INTO `log_info` VALUES (136, '1', '对checin_info表更新数据 {member_id=1, id_number=123, leave_time=2020-05-23 22:31:43, operator=1, number=123, phone=123, arrivals_time=2020-05-23 22:46:08, deposit=100.00, id_type=中华人民共和国居民身份证, new_room_id=1, checkiner=123123, checkin_price=1.00} ', '2020-05-23 22:46:09', '操作成功');
INSERT INTO `log_info` VALUES (137, '1', '对order_info表更新数据 {order_status=已入住} ', '2020-05-23 22:46:08', '操作成功');
INSERT INTO `log_info` VALUES (138, '1', '对checin_info表更新数据 {member_id=1, id_number=123, leave_time=2020-05-23 22:46:23, operator=1, number=123, phone=123, arrivals_time=2020-05-23 22:46:37, deposit=100.00, id_type=中华人民共和国居民身份证, new_room_id=1, checkiner=123123, checkin_price=1.00} ', '2020-05-23 22:46:37', '操作成功');
INSERT INTO `log_info` VALUES (139, '1', '对order_info表更新数据 {order_status=已入住} ', '2020-05-23 22:46:37', '操作成功');
INSERT INTO `log_info` VALUES (140, '1', '对checin_info表更新数据 {member_id=1, id_number=123, leave_time=2020-05-23 22:46:24, operator=1, number=123, phone=123, arrivals_time=2020-05-23 22:46:38, deposit=100.00, id_type=中华人民共和国居民身份证, new_room_id=1, checkiner=123123, checkin_price=1.00} ', '2020-05-23 22:46:39', '操作成功');
INSERT INTO `log_info` VALUES (141, '1', '对order_info表更新数据 {order_status=已入住} ', '2020-05-23 22:46:39', '操作成功');
INSERT INTO `log_info` VALUES (142, '1', '对order_info表更新数据 {order_status=已取消} ', '2020-05-23 22:47:03', '操作成功');
INSERT INTO `log_info` VALUES (143, '1', '对checin_info表更新数据 {member_id=1, id_number=1231233, leave_time=2020-05-23 22:46:29, operator=1, number=12, phone=asdf, arrivals_time=2020-05-23 22:49:18, deposit=100.00, id_type=中华人民共和国居民身份证, new_room_id=1, checkiner=shinki, checkin_price=1.00} ', '2020-05-23 22:49:19', '操作成功');
INSERT INTO `log_info` VALUES (144, '1', '对order_info表更新数据 {order_status=已入住} ', '2020-05-23 22:49:19', '操作成功');
INSERT INTO `log_info` VALUES (145, '1', '对order_info表更新数据 {order_status=已取消} ', '2020-05-23 22:49:32', '操作成功');
INSERT INTO `log_info` VALUES (146, '1', '对checin_info表更新数据 {member_id=1, number=1, id_number=123123123123123123123, leave_time=2020-05-23 22:46:27, phone=123123123123, arrivals_time=2020-05-23 22:50:07, deposit=500.00, id_type=中华人民共和国居民身份证, new_room_id=1, checkiner=谢谢谢谢, operator=1, checkin_price=1.00} ', '2020-05-23 22:50:08', '操作成功');
INSERT INTO `log_info` VALUES (147, '1', '对order_info表更新数据 {order_status=已入住} ', '2020-05-23 22:50:08', '操作成功');
INSERT INTO `log_info` VALUES (148, '1', '对order_info表更新数据 {order_status=已取消} ', '2020-05-23 22:50:17', '操作成功');
INSERT INTO `log_info` VALUES (149, '1', '对order_info表更新数据 {order_status=已取消} ', '2020-05-23 22:50:24', '操作成功');
INSERT INTO `log_info` VALUES (150, '1', '对checin_info表更新数据 {member_id=1, checkin_price=1.00, id_number=1231233, leave_time=2020-05-23 22:34:27, operator=1, number=12, checkiner=123123, wake=null, phone=123, arrivals_time=2020-05-23 23:22:24, deposit=100.00, id_type=中华人民共和国居民身份证, breakfast=null, new_room_id=1} ', '2020-05-23 23:22:25', '操作失败');
INSERT INTO `log_info` VALUES (151, '1', '对checin_info表更新数据 {member_id=1, checkin_price=1.00, id_number=1231233, leave_time=2020-05-23 22:34:27, operator=1, number=12, checkiner=123123, wake=null, phone=123, arrivals_time=2020-05-23 23:22:26, deposit=100.00, id_type=中华人民共和国居民身份证, breakfast=null, new_room_id=1} ', '2020-05-23 23:22:26', '操作失败');
INSERT INTO `log_info` VALUES (152, '1', '对checin_info表更新数据 {member_id=1, checkin_price=1.00, id_number=1231233, leave_time=2020-05-23 22:34:27, operator=1, number=12, checkiner=123123, wake=null, phone=123, arrivals_time=2020-05-23 23:22:26, deposit=100.00, id_type=中华人民共和国居民身份证, breakfast=null, new_room_id=1} ', '2020-05-23 23:22:27', '操作失败');
INSERT INTO `log_info` VALUES (153, '1', '对checin_info表更新数据 {member_id=1, checkin_price=1.00, id_number=1231233, leave_time=2020-05-23 22:34:27, operator=1, number=12, checkiner=123123, wake=null, phone=123, arrivals_time=2020-05-23 23:22:31, deposit=100.00, id_type=中华人民共和国居民身份证, breakfast=null, new_room_id=1} ', '2020-05-23 23:22:32', '操作失败');
INSERT INTO `log_info` VALUES (154, '1', '对checin_info表更新数据 {member_id=1, checkin_price=1.00, id_number=1231233, leave_time=2020-05-23 22:34:27, operator=1, number=12, checkiner=123123, wake=null, phone=123, arrivals_time=2020-05-23 23:22:32, deposit=100.00, id_type=中华人民共和国居民身份证, breakfast=null, new_room_id=1} ', '2020-05-23 23:22:32', '操作失败');
INSERT INTO `log_info` VALUES (155, '1', '对checin_info表更新数据 {member_id=1, checkin_price=1.00, id_number=1231233, leave_time=2020-05-23 22:34:27, operator=1, number=12, checkiner=123123, wake=null, phone=123, arrivals_time=2020-05-23 23:22:40, deposit=100.00, id_type=中华人民共和国居民身份证, breakfast=null, new_room_id=1} ', '2020-05-23 23:22:41', '操作失败');
INSERT INTO `log_info` VALUES (156, '1', '对checin_info表更新数据 {member_id=1, checkin_price=1.00, id_number=1231233, leave_time=2020-05-23 22:34:27, operator=1, number=12, checkiner=123123, wake=null, phone=123, arrivals_time=2020-05-23 23:23:26, deposit=100.00, id_type=中华人民共和国居民身份证, breakfast=null, new_room_id=1} ', '2020-05-23 23:23:27', '操作成功');
INSERT INTO `log_info` VALUES (157, '1', '对checin_info表更新数据 {member_id=1, checkin_price=1.00, id_number=123, leave_time=2020-06-04 22:31:41, operator=1, number=123, checkiner=123123, wake=null, phone=123, arrivals_time=2020-05-23 23:32:49, deposit=100.00, id_type=中华人民共和国居民身份证, breakfast=null, new_room_id=1} ', '2020-05-23 23:32:50', '操作成功');
INSERT INTO `log_info` VALUES (158, '1', '对checin_info表更新数据 {member_id=1, checkin_price=1.00, id_number=123, leave_time=2020-06-04 23:33:45, operator=1, number=123, checkiner=123123, wake=null, phone=123, arrivals_time=2020-05-23 23:34:15, deposit=100.00, id_type=中华人民共和国居民身份证, breakfast=null, new_room_id=1} ', '2020-05-23 23:34:16', '操作成功');
INSERT INTO `log_info` VALUES (159, '1', '对checin_info表更新数据 {member_id=1, checkin_price=1.00, id_number=123, leave_time=2020-05-28 23:36:07, operator=1, number=123, checkiner=123123, wake=null, phone=123, arrivals_time=2020-05-23 23:41:40, deposit=100.00, id_type=中华人民共和国居民身份证, breakfast=null, new_room_id=1} ', '2020-05-23 23:41:41', '操作成功');
INSERT INTO `log_info` VALUES (160, '1', '对order_info表更新数据 {order_status=已取消} ', '2020-05-24 08:58:46', '操作成功');
INSERT INTO `log_info` VALUES (161, '1', '对order_info表插入数据 {room_id=1, deposit=100.00, orderer=shinki123123, ID_type=中华人民共和国居民身份证, ID_number=123123, phone=asdf, arrivals_time=2020-05-23 22:31:31, leave_time=2020-05-23 22:31:31, number=12, member_id=1, order_status=正常, details=123124124, operator=1} ', '2020-05-24 08:59:29', '操作成功');
INSERT INTO `log_info` VALUES (162, '1', '对checin_info表更新数据 {member_id=1, id_number=123123, leave_time=2020-05-23 22:31:31, operator=1, number=12, phone=asdf, arrivals_time=2020-05-24 08:59:41, deposit=100.00, id_type=中华人民共和国居民身份证, new_room_id=1, checkiner=shinki123123, checkin_price=1.00} ', '2020-05-24 08:59:42', '操作成功');
INSERT INTO `log_info` VALUES (163, '1', '对order_info表更新数据 {order_status=已入住} ', '2020-05-24 08:59:42', '操作成功');
INSERT INTO `log_info` VALUES (164, '1', '对checkin_info表更新数据 {new_room_id=2, deposit=100.00, checkiner=123, ID_type=中华人民共和国居民身份证, ID_number=1231233, phone=asdf, leave_time=2020-06-23 22:31:31, number=12, breakfast=1, wake=1, arrivals_time=Sun May 24 09:43:58 CST 2020, checkin_price=1.00, order_to=0, operator=1} ', '2020-05-24 09:43:58', '操作成功');
INSERT INTO `log_info` VALUES (165, '1', '对checin_info表更新数据 {new_room_id=16, old_room_id=2, operator=1} ', '2020-05-24 10:29:59', '操作成功');
INSERT INTO `log_info` VALUES (166, '1', '对room_info表中条件是 {room_id=4} 数据的字段更新为 {room_type_id=1, status=空房, floor_id=1, price=1.00, discounted_price=1.00, member_price=1.00, vip_price=1.00, details=1} ', '2020-05-24 10:31:12', '操作成功');
INSERT INTO `log_info` VALUES (167, '1', '对bill_info表更新数据 {checkin_id=1, room_id=1, deposit=100.00, checkin_price=123.00, days=7, accommodation_fee=861.00, in_store_consumption=3660.00, real_income=4521.00, income=4521.00, pay_method=微信, return_money=0.0, return_deposit=100.00, operator=1} ', '2020-05-24 10:52:47', '操作成功');
INSERT INTO `log_info` VALUES (168, '1', '对bill_info表更新数据 {checkin_id=1, room_id=1, deposit=100.00, checkin_price=123.00, days=7, accommodation_fee=861.00, in_store_consumption=3660.00, real_income=4521.00, income=4521.00, pay_method=微信, return_money=0.0, return_deposit=100.00, operator=1} ', '2020-05-24 10:53:25', '操作成功');
INSERT INTO `log_info` VALUES (169, '1', '对bill_info表更新数据 {checkin_id=1, room_id=1, deposit=100.00, checkin_price=123.00, days=7, accommodation_fee=861.00, in_store_consumption=3660.00, real_income=4521.00, income=4521.00, pay_method=微信, return_money=0.0, return_deposit=100.00, operator=1} ', '2020-05-24 10:59:31', '操作成功');
INSERT INTO `log_info` VALUES (170, '1', '对bill_info表更新数据 {checkin_id=19, room_id=1, deposit=100.00, checkin_price=1.00, days=5, accommodation_fee=5.00, in_store_consumption=0, real_income=5.00, income=5.00, pay_method=微信, return_money=0.0, return_deposit=100.00, operator=1} ', '2020-05-24 11:22:30', '操作成功');
INSERT INTO `log_info` VALUES (171, '1', '对bill_info表更新数据 {checkin_id=20, room_id=1, deposit=100.00, checkin_price=1.00, days=5, accommodation_fee=5.00, in_store_consumption=0, real_income=5.00, income=5.00, pay_method=微信, return_money=0.0, return_deposit=100.00, operator=1} ', '2020-05-24 11:23:34', '操作成功');
INSERT INTO `log_info` VALUES (172, '1', '对bill_info表更新数据 {checkin_id=21, room_id=1, deposit=100.00, checkin_price=1.00, days=5, accommodation_fee=5.00, in_store_consumption=0, real_income=5.00, income=5.00, pay_method=微信, return_money=0.0, return_deposit=100.00, operator=1} ', '2020-05-24 11:31:34', '操作成功');
INSERT INTO `log_info` VALUES (173, '1', '对bill_info表更新数据 {checkin_id=22, room_id=1, deposit=100.00, checkin_price=1.00, days=5, accommodation_fee=5.00, in_store_consumption=0, real_income=5.00, income=5.00, pay_method=微信, return_money=0.0, return_deposit=100.00, operator=1} ', '2020-05-24 11:32:17', '操作成功');
INSERT INTO `log_info` VALUES (174, '1', '对bill_info表更新数据 {checkin_id=23, room_id=1, deposit=100.00, checkin_price=1.00, days=5, accommodation_fee=5.00, in_store_consumption=0, real_income=5.00, income=5.00, pay_method=微信, return_money=0.0, return_deposit=100.00, operator=1} ', '2020-05-24 11:32:38', '操作成功');
INSERT INTO `log_info` VALUES (175, '1', '对cost_info表条件是 {checkin_id=1, room_id=1, goods_id=3, number=1231, operator=1, time=Sun May 24 12:43:14 CST 2020} 的数据进行删除  ', '2020-05-24 12:43:14', '操作成功');
INSERT INTO `log_info` VALUES (176, '1', '对cost_info表条件是 3 的数据进行删除  ', '2020-05-24 13:18:34', '操作成功');
INSERT INTO `log_info` VALUES (177, '1', '对cost_info表条件是 5 的数据进行删除  ', '2020-05-24 13:18:41', '操作成功');
INSERT INTO `log_info` VALUES (178, '1', '对bill_info表更新数据 {checkin_id=25, room_id=1, deposit=100.00, checkin_price=1.00, days=5, accommodation_fee=5.00, in_store_consumption=0, real_income=5.00, income=5.00, pay_method=微信, return_money=0.0, return_deposit=100.00, operator=1} ', '2020-05-24 13:22:40', '操作成功');
INSERT INTO `log_info` VALUES (179, '1', '对bill_info表更新数据 {checkin_id=1, room_id=2, deposit=100.00, checkin_price=123.00, days=6, accommodation_fee=738.00, in_store_consumption=1468.00, real_income=2206.00, income=2206.00, pay_method=微信, return_money=0.0, return_deposit=100.00, operator=1} ', '2020-05-24 13:24:32', '操作成功');
INSERT INTO `log_info` VALUES (180, '1', '对cost_info表中条件是 {cost_id=2} 数据的字段更新为 {goods_id=1, number=2, cost_price=1.00, details=1231236151, operator=1, time=Sun May 24 13:57:04 CST 2020} ', '2020-05-24 13:57:04', '操作成功');
INSERT INTO `log_info` VALUES (181, '1', '对checin_info表更新数据 {new_room_id=2, old_room_id=1, operator=1} ', '2020-05-24 22:52:11', '操作成功');
INSERT INTO `log_info` VALUES (182, '1', '对bill_info表更新数据 {checkin_id=26, room_id=1, deposit=100.00, checkin_price=1.00, days=12, accommodation_fee=12.00, in_store_consumption=0, real_income=12.00, income=12.00, pay_method=微信, return_money=0.0, return_deposit=100.00, operator=1} ', '2020-05-24 23:12:34', '操作成功');
INSERT INTO `log_info` VALUES (183, '1', '对checin_info表更新数据 {new_room_id=18, old_room_id=16, operator=1} ', '2020-05-26 15:05:01', '操作成功');
INSERT INTO `log_info` VALUES (184, '1', '对goods_info表中条件是 {goods_id=4} 数据的字段更新为 {goods_name=500M宽带, type_id=3, price=1.00, discount=1.00, unit=天, details=123123} ', '2020-05-26 20:02:25', '操作成功');
INSERT INTO `log_info` VALUES (185, '1', '对goods_info表中条件是 {goods_id=6} 数据的字段更新为 {goods_name=薯条, type_id=1, price=1.00, discount=1.00, unit=包, details=垃圾食品真好吃} ', '2020-05-26 20:02:38', '操作成功');
INSERT INTO `log_info` VALUES (186, '1', '对goods_info表中条件是 {goods_id=6} 数据的字段更新为 {goods_name=薯条, type_id=1, price=1.00, discount=1.00, unit=包, details=123} ', '2020-05-26 20:02:45', '操作成功');
INSERT INTO `log_info` VALUES (187, '1', '对member_Info表中条件是 {member_id=1} 数据的字段更新为 {name=wang, sex=男, password=123, phone=4324143, address=asdf, email=2143412312@qq.com, integral=20, level=member, check_in_time=2020-05-24 13:57:04, scheduled_time=2020-05-24 13:57:04, details=123123} ', '2020-05-26 20:03:17', '操作成功');
INSERT INTO `log_info` VALUES (188, '1', '对member_Info表中条件是 {member_id=2} 数据的字段更新为 {name=shinki, sex=女, password=123123, phone=asdf, address=123@qq.com, email=asdf12312@qq.com, integral=0, level=member, check_in_time=undefined, scheduled_time=2020-05-29, details=123124124} ', '2020-05-26 20:03:35', '操作失败');
INSERT INTO `log_info` VALUES (189, '1', '对member_Info表中条件是 {member_id=2} 数据的字段更新为 {name=shinki, sex=女, password=123123, phone=asdf, address=123@qq.com, email=asdf12312@qq.com, integral=0, level=member, check_in_time=undefined, scheduled_time=2020-05-29, details=123124124} ', '2020-05-26 20:03:37', '操作失败');
INSERT INTO `log_info` VALUES (190, '1', '对member_Info表插入数据 {name=1212, sex=12, password=123, phone=773123123, address=12, email=213, integral=123, level=123, check_in_time=2020-05-27, scheduled_time=2020-05-27, details=123} ', '2020-05-27 11:56:21', '操作成功');
INSERT INTO `log_info` VALUES (191, '1', '对member_Info表中条件是 {member_id=3} 数据的字段更新为 {name=1212, sex=12, password=123, phone=13952727188, address=12, email=213, integral=123, level=123, check_in_time=2020-05-27 00:00:00, scheduled_time=2020-05-27 00:00:00, details=123} ', '2020-05-27 11:57:24', '操作成功');
INSERT INTO `log_info` VALUES (192, '1', '对member_Info表插入数据 {name=1212, sex=12, password=123, phone=13902891823, address=12, email=213, integral=123, level=123, check_in_time=2020-05-27, scheduled_time=2020-05-27, details=123} ', '2020-05-27 11:57:41', '操作成功');
INSERT INTO `log_info` VALUES (193, '1', '对member_Info表中条件是 {member_id=4} 数据的字段更新为 {name=1212, sex=12, password=123, phone=777902891823, address=12, email=213, integral=123, level=123, check_in_time=2020-05-27 00:00:00, scheduled_time=2020-05-27 00:00:00, details=123} ', '2020-05-27 11:58:05', '操作成功');
INSERT INTO `log_info` VALUES (194, '1', '对member_Info表插入数据 {name=sissi, sex=女, password=123, phone=66424243, address=南京, email=34, integral=43, level=43, check_in_time=2020-05-27, scheduled_time=2020-05-27, details=11} ', '2020-05-27 16:57:06', '操作成功');
INSERT INTO `log_info` VALUES (195, '1', '对member_Info表条件是 5 的数据进行删除  ', '2020-05-27 16:57:14', '操作成功');
INSERT INTO `log_info` VALUES (196, '1', '对member_Info表条件是 4 的数据进行删除  ', '2020-05-27 16:57:16', '操作成功');
INSERT INTO `log_info` VALUES (197, '1', '对member_Info表条件是 3 的数据进行删除  ', '2020-05-27 16:57:18', '操作成功');
INSERT INTO `log_info` VALUES (198, '1', '对member_Info表插入数据 {name=zhang anna, sex=女, address=香港} ', '2020-05-28 10:05:46', '操作失败');
INSERT INTO `log_info` VALUES (199, '1', '对member_Info表插入数据 {name=zhang anna, sex=女, address=香港} ', '2020-05-28 10:05:53', '操作失败');
INSERT INTO `log_info` VALUES (200, '1', '对member_Info表插入数据 {name=zhang anna, sex=女, address=香港} ', '2020-05-28 10:05:56', '操作失败');
INSERT INTO `log_info` VALUES (201, '1', '对member_Info表插入数据 {name=zhang anna, sex=女, phone=231, address=香港, email=123, integral=123, level=123, check_in_time=123, scheduled_time=123, details=123} ', '2020-05-28 10:06:08', '操作失败');
INSERT INTO `log_info` VALUES (202, '1', '对member_Info表插入数据 {name=zhang, sex=女, phone=231, address=香港, email=123, integral=123, level=123, check_in_time=123, scheduled_time=123, details=123} ', '2020-05-28 10:06:19', '操作失败');
INSERT INTO `log_info` VALUES (203, '1', '对member_Info表插入数据 {name=zhang, sex=女, phone=231, address=香港, email=123, integral=123, level=123, check_in_time=123, scheduled_time=123, details=123} ', '2020-05-28 10:06:20', '操作失败');
INSERT INTO `log_info` VALUES (204, '1', '对member_Info表插入数据 {name=zhang, sex=女, phone=231, address=香港, email=123, integral=123, level=123, check_in_time=123, scheduled_time=123, details=123} ', '2020-05-28 10:06:24', '操作失败');
INSERT INTO `log_info` VALUES (205, '1', '对member_Info表插入数据 {name=zhang, sex=女, phone=231, address=香港, email=123, integral=123, level=123, check_in_time=123, scheduled_time=123, details=123} ', '2020-05-28 10:06:27', '操作失败');
INSERT INTO `log_info` VALUES (206, '1', '对member_Info表插入数据 {name=zhang, sex=女, phone=231, address=香港, email=123, integral=123, level=123, check_in_time=123, scheduled_time=123, details=123} ', '2020-05-28 10:06:33', '操作失败');
INSERT INTO `log_info` VALUES (207, '1', '对member_Info表插入数据 {name=zhang, sex=女, phone=231, address=香港, email=123, integral=123, level=123, check_in_time=123, scheduled_time=123, details=123} ', '2020-05-28 10:06:34', '操作失败');
INSERT INTO `log_info` VALUES (208, '1', '对goods_type表中条件是 {type_id=3} 数据的字段更新为 {goods_type=宽带, details=123} ', '2020-06-01 08:56:21', '操作成功');
INSERT INTO `log_info` VALUES (209, '1', '对goods_type表中条件是 {type_id=3} 数据的字段更新为 {goods_type=宽带, details=123} ', '2020-06-01 08:56:22', '操作成功');
INSERT INTO `log_info` VALUES (210, '1', '对goods_type表插入数据 {goods_type=下午茶, details=111} ', '2020-06-01 08:56:38', '操作成功');
INSERT INTO `log_info` VALUES (211, '1', '对goods_info表插入数据 {goods_name=蛋糕, type_id=1, price=10.00, discount=1.00, unit=块, details=123} ', '2020-06-01 08:57:34', '操作成功');
INSERT INTO `log_info` VALUES (212, '1', '对member_Info表中条件是 {member_id=2} 数据的字段更新为 {name=zhang, sex=女, password=123123, phone=asdf, address=123@qq.com, email=cutezhangq12312@qq.com, integral=0, level=member, check_in_time=undefined, scheduled_time=undefined, details=123124124} ', '2020-06-01 08:58:17', '操作失败');
INSERT INTO `log_info` VALUES (213, '1', '对member_Info表中条件是 {member_id=2} 数据的字段更新为 {name=zhang, sex=女, password=123123, phone=asdf, address=123@qq.com, email=cutezhangq12312@qq.com, integral=0, level=member, check_in_time=2020-06-01, scheduled_time=2020-06-01, details=123124124} ', '2020-06-01 08:58:26', '操作成功');
INSERT INTO `log_info` VALUES (214, '1', '对cost_info表中条件是 {cost_id=8                } 数据的字段更新为 {checkin_id=1                , room_id=1                , goods_id=3                , number=1231                , time=Mon Jun 01 09:01:29 CST 2020, details=22, operator=1} ', '2020-06-01 09:01:29', '操作成功');

-- ----------------------------
-- Table structure for member_info
-- ----------------------------
DROP TABLE IF EXISTS `member_info`;
CREATE TABLE `member_info`  (
  `member_id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `integral` int(0) NULL DEFAULT 0,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'member',
  `check_in_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `scheduled_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of member_info
-- ----------------------------
INSERT INTO `member_info` VALUES (1, 'wang', '男', '123', '4324143', 'asdf', '2143412312@qq.com', 14680, 'vip', '2020-06-01 09:01:29', '2020-06-01 09:01:29', '123123');
INSERT INTO `member_info` VALUES (2, 'zhang', '女', '123123', 'asdf', '123@qq.com', 'cutezhangq12312@qq.com', 0, 'member', '2020-06-01 00:00:00', '2020-06-01 00:00:00', '123124124');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `order_id` int(0) NOT NULL AUTO_INCREMENT,
  `room_id` int(0) NOT NULL,
  `deposit` decimal(10, 2) NOT NULL,
  `orderer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ID_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ID_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `arrivals_time` datetime(0) NOT NULL,
  `leave_time` datetime(0) NOT NULL,
  `number` int(0) NOT NULL,
  `operator` int(0) NULL DEFAULT NULL,
  `member_id` int(0) NULL DEFAULT NULL,
  `order_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '正常',
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1, 1, 100.00, '123123', '中华人民共和国居民身份证', '1231233', '123', '2020-05-23 23:23:26', '2020-05-23 23:23:26', 12, 123, 1, '已入住', '123123412412');
INSERT INTO `order_info` VALUES (2, 1, 100.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 22:50:23', '2020-05-23 22:50:23', 123, 123, 1, '已取消', '123');
INSERT INTO `order_info` VALUES (3, 1, 100.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 22:31:33', '2020-05-23 22:31:33', 123, 123, 1, '已取消', '123');
INSERT INTO `order_info` VALUES (4, 1, 100.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 23:45:19', '2020-05-23 23:45:19', 123, 123, 1, '已入住', '123');
INSERT INTO `order_info` VALUES (5, 1, 100.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 22:31:35', '2020-05-23 22:31:35', 123, 123, 1, '正常', '123');
INSERT INTO `order_info` VALUES (6, 1, 100.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 22:31:36', '2020-05-23 22:31:36', 123, 123, 1, '正常', '123');
INSERT INTO `order_info` VALUES (7, 1, 100.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 22:31:38', '2020-05-23 22:31:38', 123, 123, 1, '正常', '123');
INSERT INTO `order_info` VALUES (8, 1, 100.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 22:31:39', '2020-05-23 22:31:39', 123, 123, 1, '正常', '123');
INSERT INTO `order_info` VALUES (9, 1, 100.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-24 22:31:40', '2020-05-27 22:31:40', 123, 123, 1, '正常', '123');
INSERT INTO `order_info` VALUES (10, 1, 100.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 23:41:40', '2020-05-23 23:41:40', 123, 123, 1, '已入住', '123');
INSERT INTO `order_info` VALUES (11, 1, 100.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 22:46:37', '2020-05-23 22:46:37', 123, 123, 1, '已入住', '123');
INSERT INTO `order_info` VALUES (12, 1, 100.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 22:46:38', '2020-05-23 22:46:38', 123, 123, 1, '已入住', '123');
INSERT INTO `order_info` VALUES (13, 1, 100.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 22:47:02', '2020-05-23 22:47:02', 123, 123, 1, '已取消', '123');
INSERT INTO `order_info` VALUES (14, 1, 100.00, '123123', '中华人民共和国居民身份证', '123', '123', '2020-05-23 22:49:31', '2020-05-23 22:49:31', 123, 123, 1, '已取消', '123');
INSERT INTO `order_info` VALUES (15, 1, 500.00, '谢谢谢谢', '中华人民共和国居民身份证', '123123123123123123123', '123123123123', '2020-05-23 22:50:07', '2020-05-23 22:50:07', 1, NULL, 1, '已入住', NULL);
INSERT INTO `order_info` VALUES (16, 2, 500.00, '谢谢谢谢', '中华人民共和国居民身份证', '123123123123123123123', '123123123123', '2020-05-23 22:50:17', '2020-05-23 22:50:17', 1, NULL, NULL, '已取消', NULL);
INSERT INTO `order_info` VALUES (17, 1, 100.00, 'shinki', '中华人民共和国居民身份证', '1231233', 'asdf', '2020-05-23 22:49:18', '2020-05-23 22:49:18', 12, 1, 1, '已入住', '124124');
INSERT INTO `order_info` VALUES (18, 1, 100.00, 'shinki123123', '中华人民共和国居民身份证', '123123', 'asdf', '2020-05-23 22:31:31', '2020-05-23 22:31:31', 12, 1, 1, '已入住', '123124124');

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info`  (
  `room_id` int(0) NOT NULL AUTO_INCREMENT,
  `room_type_id` int(0) NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `floor_id` int(0) NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `discounted_price` decimal(10, 2) NOT NULL,
  `member_price` decimal(10, 2) NOT NULL,
  `vip_price` decimal(10, 2) NOT NULL,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`room_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room_info
-- ----------------------------
INSERT INTO `room_info` VALUES (1, 1, '空房', 1, 123.00, 12313.12, 1.00, 1.00, '1123123');
INSERT INTO `room_info` VALUES (2, 2, '空房', 1, 1.00, 1.00, 1.00, 1.00, '1');
INSERT INTO `room_info` VALUES (4, 1, '空房', 1, 1.00, 1.00, 1.00, 1.00, '1');
INSERT INTO `room_info` VALUES (5, 1, '入住', 1, 1.00, 1.00, 1.00, 1.00, '1');
INSERT INTO `room_info` VALUES (6, 1, '入住', 1, 1.00, 1.00, 1.00, 1.00, '1');
INSERT INTO `room_info` VALUES (7, 1, '入住', 1, 1.00, 1.00, 1.00, 1.00, '1');
INSERT INTO `room_info` VALUES (8, 1, '入住', 1, 1.00, 1.00, 1.00, 1.00, '1');
INSERT INTO `room_info` VALUES (9, 1, '入住', 1, 1.00, 1.00, 1.00, 1.00, '1');
INSERT INTO `room_info` VALUES (10, 1, '入住', 1, 1.00, 1.00, 1.00, 1.00, '1撒打发斯蒂芬');
INSERT INTO `room_info` VALUES (11, 1, '入住', 1, 1.00, 1.00, 1.00, 1.00, '1');
INSERT INTO `room_info` VALUES (12, 1, '入住', 1, 1.00, 1.00, 1.00, 1.00, '1');
INSERT INTO `room_info` VALUES (13, 1, '入住', 1, 1.00, 1.00, 1.00, 1.00, '1');
INSERT INTO `room_info` VALUES (14, 1, '入住', 1, 1.00, 1.00, 1.00, 1.00, '1');
INSERT INTO `room_info` VALUES (15, 1, '入住', 1, 1.00, 1.00, 1.00, 1.00, '1');
INSERT INTO `room_info` VALUES (16, 1, '空房', 1, 12312.00, 12312.00, 12312.00, 12312.00, 'awdawdawd123123123123123');
INSERT INTO `room_info` VALUES (18, 1, '入住', 1, 123.00, 123.00, 123.00, 123.00, NULL);

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type`  (
  `room_type_id` int(0) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` int(0) NOT NULL DEFAULT 0,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `room_type_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`room_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room_type
-- ----------------------------
INSERT INTO `room_type` VALUES (1, '单人房', 12, '123123', NULL);
INSERT INTO `room_type` VALUES (2, '大床房', 2, '舒服', NULL);
INSERT INTO `room_type` VALUES (3, '双人房', 1, '123', NULL);
INSERT INTO `room_type` VALUES (4, '母婴房', 2, '123', NULL);
INSERT INTO `room_type` VALUES (5, '贵宾房', 2, '123', NULL);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `authority` int(0) NOT NULL,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'admin', '123456', 1, '超级管理员');
INSERT INTO `user_info` VALUES (2, 'zq', '123', 2, '经理');
INSERT INTO `user_info` VALUES (3, 'liu', '123', 3, '前台');

SET FOREIGN_KEY_CHECKS = 1;
