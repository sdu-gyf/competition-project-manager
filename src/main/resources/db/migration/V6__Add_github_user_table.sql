/*
 Navicat Premium Data Transfer

 Source Server         : 49.234.60.116
 Source Server Type    : MySQL
 Source Server Version : 50645
 Source Host           : 49.234.60.116:3306
 Source Schema         : labs

 Target Server Type    : MySQL
 Target Server Version : 50645
 File Encoding         : 65001

 Date: 12/04/2020 00:57:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for github_user
-- ----------------------------
DROP TABLE IF EXISTS `github_user`;
CREATE TABLE `github_user`
(
    `id`         int(11)                          NOT NULL COMMENT '主键',
    `account_id` bigint(50)                       NOT NULL,
    `name`       varchar(50) COLLATE utf8mb4_bin  NOT NULL,
    `token`      varchar(255) COLLATE utf8mb4_bin NOT NULL,
    `avatar_url` varchar(255) COLLATE utf8mb4_bin NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;
