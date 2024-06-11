/*
 Navicat Premium Data Transfer

 Source Server         : MySQL80_win
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : localhost:3306
 Source Schema         : backup

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 09/03/2024 11:21:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for backup_info
-- ----------------------------
DROP TABLE IF EXISTS `backup_info`;
CREATE TABLE `backup_info`  (
  `backup_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `file_folder` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件夹路径',
  `file_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件名称',
  `backup_folder` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备份文件夹',
  `backup_file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备份文件名称',
  `backup_time` datetime(0) NULL DEFAULT NULL COMMENT '备份时间',
  PRIMARY KEY (`backup_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of backup_info
-- ----------------------------
INSERT INTO `backup_info` VALUES (1, 'D:\\peng\\Pictures\\博客_图片', '四大引用.jpg', 'C:\\Users\\peng\\Desktop\\backup', '四大引用-3.jpg', '2024-03-06 10:27:20');
INSERT INTO `backup_info` VALUES (2, 'D:\\peng\\Pictures\\博客_图片', '四大引用.jpg', 'C:\\Users\\peng\\Desktop\\backup', '四大引用-4.jpg', '2024-03-06 10:38:20');
INSERT INTO `backup_info` VALUES (4, 'D:\\peng\\Pictures\\博客_图片', '四大引用.jpg', 'C:\\Users\\peng\\Desktop\\backup', '四大引用-5.jpg', '2024-03-06 11:00:35');
INSERT INTO `backup_info` VALUES (5, 'D:\\peng\\Pictures\\博客_图片', '四大引用.jpg', 'C:\\Users\\peng\\Desktop\\backup', '四大引用-6.jpg', '2024-03-06 14:42:16');
INSERT INTO `backup_info` VALUES (6, 'D:\\peng\\Pictures\\博客_图片', '四大引用.jpg', 'C:\\Users\\peng\\Desktop\\backup', '四大引用-7.jpg', '2024-03-06 14:42:16');
INSERT INTO `backup_info` VALUES (7, 'D:\\peng\\Pictures\\博客_图片', '四大引用.jpg', 'C:\\Users\\peng\\Desktop\\backup', '四大引用-8.jpg', '2024-03-06 15:10:37');
INSERT INTO `backup_info` VALUES (8, 'D:\\peng\\Pictures\\博客_图片', '四大引用.jpg', 'C:\\Users\\peng\\Desktop\\backup', '四大引用-9.jpg', '2024-03-06 15:19:13');
INSERT INTO `backup_info` VALUES (9, 'D:\\peng\\Pictures\\博客_图片', '四大引用.jpg', 'C:\\Users\\peng\\Desktop\\backup', '四大引用-10.jpg', '2024-03-06 15:47:37');
INSERT INTO `backup_info` VALUES (10, 'D:\\peng\\Pictures\\博客_图片', '四大引用.jpg', 'C:\\Users\\peng\\Desktop\\backup', '四大引用-12.jpg', '2024-03-06 16:00:23');
INSERT INTO `backup_info` VALUES (11, 'D:\\peng\\Pictures\\博客_图片', '四大引用.jpg', 'C:\\Users\\peng\\Desktop\\backup', '四大引用-13.jpg', '2024-03-06 16:00:44');
INSERT INTO `backup_info` VALUES (12, 'D:\\peng\\Pictures\\博客_图片\\框架', NULL, 'C:\\Users\\peng\\Desktop\\backup\\框架-1', NULL, '2024-03-06 17:02:16');
INSERT INTO `backup_info` VALUES (13, 'D:\\peng\\Pictures\\博客_图片\\框架', NULL, 'C:\\Users\\peng\\Desktop\\backup\\框架-2', NULL, '2024-03-06 17:03:13');
INSERT INTO `backup_info` VALUES (14, 'D:\\', '2月4汕头行_第一版.pdf', 'C:\\Users\\peng\\Desktop\\backup', '2月4汕头行_第一版.pdf', '2024-03-06 20:42:22');
INSERT INTO `backup_info` VALUES (15, 'D:\\peng\\Pictures\\博客_图片\\框架', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-06_22-20-56', NULL, '2024-03-06 22:20:57');
INSERT INTO `backup_info` VALUES (16, 'D:\\peng\\Pictures\\博客_图片\\框架', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-06_22-21-06', NULL, '2024-03-06 22:21:06');
INSERT INTO `backup_info` VALUES (17, 'D:\\peng\\Pictures\\博客_图片\\框架', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-06_22-21-16', NULL, '2024-03-06 22:21:17');
INSERT INTO `backup_info` VALUES (18, 'D:\\peng\\Pictures\\博客_图片\\框架', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-06_22-21-26', NULL, '2024-03-06 22:21:26');
INSERT INTO `backup_info` VALUES (19, 'D:\\peng\\Pictures\\博客_图片\\JVM', 'JVM简述.jpg', 'C:\\Users\\peng\\Desktop\\backup', 'JVM简述.jpg', '2024-03-06 22:22:40');
INSERT INTO `backup_info` VALUES (20, 'D:\\peng\\Pictures\\博客_图片\\JVM', 'JVM简述.jpg', 'C:\\Users\\peng\\Desktop\\backup', 'JVM简述-2.jpg', '2024-03-06 22:22:52');
INSERT INTO `backup_info` VALUES (21, 'D:\\peng\\Pictures\\博客_图片\\JVM', NULL, 'C:\\Users\\peng\\Desktop\\backup\\JVM-2', NULL, '2024-03-06 22:23:23');
INSERT INTO `backup_info` VALUES (22, 'D:\\peng\\Pictures\\博客_图片\\JVM\\垃圾', NULL, 'C:\\Users\\peng\\Desktop\\backup\\JVM-3\\垃圾', NULL, '2024-03-06 23:12:43');
INSERT INTO `backup_info` VALUES (23, 'D:\\peng\\Pictures\\博客_图片\\JVM', NULL, 'C:\\Users\\peng\\Desktop\\backup\\JVM-3', NULL, '2024-03-06 23:12:43');
INSERT INTO `backup_info` VALUES (24, 'D:\\peng\\Pictures\\博客_图片\\JVM', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-06_23-13-15', NULL, '2024-03-06 23:13:15');
INSERT INTO `backup_info` VALUES (25, 'D:\\peng\\Pictures\\博客_图片\\JVM', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-06_23-13-25', NULL, '2024-03-06 23:13:25');
INSERT INTO `backup_info` VALUES (26, 'D:\\peng\\Pictures\\博客_图片\\JVM', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-06_23-13-35', NULL, '2024-03-06 23:13:35');
INSERT INTO `backup_info` VALUES (27, 'D:\\peng\\仲园2021-2025\\笔记\\专业课笔记\\课设(C语言、Java面向对象、软件工程、操作系统)\\操作系统', '计算机214-19-林海鹏.docx', 'C:\\Users\\peng\\Desktop\\backup', '计算机214-19-林海鹏.docx', '2024-03-08 14:57:23');
INSERT INTO `backup_info` VALUES (28, 'D:\\peng\\仲园2021-2025\\笔记\\专业课笔记\\课设(C语言、Java面向对象、软件工程、操作系统)\\操作系统', '计算机214-19-林海鹏.docx', 'C:\\Users\\peng\\Desktop\\backup', '计算机214-19-林海鹏-2.docx', '2024-03-08 14:57:48');
INSERT INTO `backup_info` VALUES (29, 'D:\\peng\\Pictures\\博客_图片', '设计模式.jpg', 'C:\\Users\\peng\\Desktop\\backup', '设计模式.jpg', '2024-03-08 15:54:03');
INSERT INTO `backup_info` VALUES (30, 'D:\\peng\\Pictures\\博客_图片\\JVM', NULL, 'C:\\Users\\peng\\Desktop\\backup\\2024-03-08_15-55-17', NULL, '2024-03-08 15:55:18');
INSERT INTO `backup_info` VALUES (31, 'D:\\peng\\Pictures\\博客_图片\\JVM', NULL, 'C:\\Users\\peng\\Desktop\\backup\\2024-03-08_15-55-27', NULL, '2024-03-08 15:55:28');
INSERT INTO `backup_info` VALUES (32, 'D:\\peng\\Pictures\\博客_图片\\JVM', NULL, 'C:\\Users\\peng\\Desktop\\backup\\2024-03-08_15-55-37', NULL, '2024-03-08 15:55:38');
INSERT INTO `backup_info` VALUES (33, 'D:\\peng\\Pictures\\博客_图片\\MySQL', 'MySQL索引.jpg', 'C:\\Users\\peng\\Desktop\\backup', 'MySQL索引.jpg', '2024-03-08 16:57:57');
INSERT INTO `backup_info` VALUES (34, 'D:\\peng\\Pictures\\博客_图片\\MySQL', 'MySQL索引.jpg', 'C:\\Users\\peng\\Desktop\\backup', 'MySQL索引-2.jpg', '2024-03-08 16:59:35');
INSERT INTO `backup_info` VALUES (35, 'D:\\peng\\Pictures\\博客_图片\\MySQL', '执行顺序.jpg', 'C:\\Users\\peng\\Desktop\\backup', '执行顺序.jpg', '2024-03-09 10:55:31');
INSERT INTO `backup_info` VALUES (36, 'D:\\peng\\Pictures\\博客_图片\\MySQL', '执行顺序.jpg', 'C:\\Users\\peng\\Desktop\\backup', '执行顺序-2.jpg', '2024-03-09 10:56:16');
INSERT INTO `backup_info` VALUES (37, 'D:\\peng\\Pictures\\博客_图片\\MySQL', NULL, 'C:\\Users\\peng\\Desktop\\backup\\MySQL', NULL, '2024-03-09 10:58:51');
INSERT INTO `backup_info` VALUES (38, 'D:\\peng\\Pictures\\博客_图片\\MySQL', NULL, 'C:\\Users\\peng\\Desktop\\backup\\MySQL-2', NULL, '2024-03-09 10:59:17');
INSERT INTO `backup_info` VALUES (39, 'D:\\peng\\Pictures\\博客_图片\\MySQL', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-09_11-01-43', NULL, '2024-03-09 11:01:44');
INSERT INTO `backup_info` VALUES (40, 'D:\\peng\\Pictures\\博客_图片\\MySQL', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-09_11-01-53', NULL, '2024-03-09 11:01:54');
INSERT INTO `backup_info` VALUES (41, 'D:\\peng\\Pictures\\博客_图片\\MySQL', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-09_11-02-03', NULL, '2024-03-09 11:02:04');
INSERT INTO `backup_info` VALUES (42, 'D:\\peng\\Pictures\\博客_图片\\MySQL', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-09_11-02-13', NULL, '2024-03-09 11:02:14');
INSERT INTO `backup_info` VALUES (43, 'D:\\peng\\Pictures\\博客_图片\\MySQL', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-09_11-02-23', NULL, '2024-03-09 11:02:24');
INSERT INTO `backup_info` VALUES (44, 'D:\\peng\\Pictures\\博客_图片\\MySQL', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-09_11-02-33', NULL, '2024-03-09 11:02:34');
INSERT INTO `backup_info` VALUES (45, 'D:\\peng\\Pictures\\博客_图片\\MySQL', NULL, 'C:\\Users\\peng\\Desktop\\backup\\定时\\2024-03-09_11-02-43', NULL, '2024-03-09 11:02:44');

SET FOREIGN_KEY_CHECKS = 1;
