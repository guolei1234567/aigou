
CREATE TABLE `t_customer`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `gender` int(11) NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wechat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `inputTime` date NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `customerSource_id` bigint(20) NULL DEFAULT NULL,
  `job_id` bigint(20) NULL DEFAULT NULL,
  `salaryLevel_id` bigint(20) NULL DEFAULT NULL,
  `seller_id` bigint(20) NULL DEFAULT NULL,
  `inputUser_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `seller_id`(`seller_id`) USING BTREE,
  INDEX `inputUser_id`(`inputUser_id`) USING BTREE,
  INDEX `job_id`(`job_id`) USING BTREE,
  INDEX `customerSource_id`(`customerSource_id`) USING BTREE,
  INDEX `salaryLevel_id`(`salaryLevel_id`) USING BTREE,
  CONSTRAINT `t_customer_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_customer_ibfk_2` FOREIGN KEY (`inputUser_id`) REFERENCES `t_employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_customer_ibfk_3` FOREIGN KEY (`customerSource_id`) REFERENCES `t_systemdictionaryitem` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_customer_ibfk_4` FOREIGN KEY (`salaryLevel_id`) REFERENCES `t_systemdictionaryitem` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_customer_ibfk_5` FOREIGN KEY (`job_id`) REFERENCES `t_systemdictionaryitem` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES (26, '客户1', 2, 1, '1', '1', '1', '1', '2017-07-23', 998, 1, 1, 1, 43, 44);
INSERT INTO `t_customer` VALUES (38, '客户2', 33, 0, '222', '222', '333', '3333', '2017-07-24', 998, 1, 4, 5, 44, 44);
INSERT INTO `t_customer` VALUES (51, '客户3', 33, 1, '12345', '12345', '12345', '234', '2017-07-18', 666, 4, 5, 6, 45, 50);
INSERT INTO `t_customer` VALUES (52, '客户4', 44, 0, '2345', '324567', '23456', '23456', '2017-07-19', 998, 2, 6, 5, 41, 44);
INSERT INTO `t_customer` VALUES (57, '客户5', 33, 1, '3456', '123456', '123456', '23456', '2017-07-25', 2, 5, 4, 5, 45, 44);
INSERT INTO `t_customer` VALUES (59, '客户4', 22, 1, '2134', '2134', '2134', '123454', '2017-07-19', 2, 2, 4, 5, 41, 50);
INSERT INTO `t_customer` VALUES (60, '客户6', 33, 1, '123456', '123456', '23456', '234567', '2017-07-17', 0, 5, 8, 7, 50, 41);
INSERT INTO `t_customer` VALUES (61, '客户7', 22, 1, '23456', '234567', '1234567', '2345678', '2017-07-19', 1, 10, 4, 5, 46, 44);
INSERT INTO `t_customer` VALUES (62, '客户8', 33, -1, '1234567', '234567', '234567', '234567', '2017-07-27', 2, 10, 8, 7, 45, 44);
INSERT INTO `t_customer` VALUES (63, '客户9', 33, 1, '123456', '1213456', '123456', '12134567', '2017-07-25', 2, 2, 8, 7, 43, 52);
INSERT INTO `t_customer` VALUES (64, '客户10', 234, 1, '234567', '1234567', '123456', '123456', '2017-07-25', 666, 1, 8, 5, 46, 50);
INSERT INTO `t_customer` VALUES (65, '客户11', 44, 1, '123454', '123456', '123456', '123456', '2017-07-26', 666, 1, 8, 2, 46, 50);
INSERT INTO `t_customer` VALUES (66, '客户12', 23, -1, '234567', '234567', '234567', '1234567', '2017-07-27', 998, 2, 4, 5, 50, 44);
INSERT INTO `t_customer` VALUES (67, '客户2', 33, -1, '223456', '2345678', '2345678', '345678', '2017-07-25', 0, 1, 8, 7, 41, 41);

SET FOREIGN_KEY_CHECKS = 1;
