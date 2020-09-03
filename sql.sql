-- ----------------------------
-- Table structure for hot
-- ----------------------------
DROP TABLE IF EXISTS `hot`;
CREATE TABLE `hot` (
  `hot_name` varchar(80) NOT NULL,
  `hot_number` int(11) DEFAULT NULL COMMENT '数量',
  `hot_last_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`hot_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hot
-- ----------------------------
INSERT INTO `hot` VALUES ('hahff', '2', '2020-09-02 21:16:18');
INSERT INTO `hot` VALUES ('hahff1', '2', '2020-09-02 21:15:46');
INSERT INTO `hot` VALUES ('hehe ', '10', '2020-08-30 00:22:23');
INSERT INTO `hot` VALUES ('你好', '4', '2020-09-03 02:29:21');
INSERT INTO `hot` VALUES ('你很可爱', '2', '2020-09-03 20:57:52');
INSERT INTO `hot` VALUES ('你真的喜欢我吗', '0', '2020-09-03 20:52:55');
INSERT INTO `hot` VALUES ('哈哈', '21', '2020-09-02 12:54:15');
INSERT INTO `hot` VALUES ('喜欢你', '10', '2020-09-02 18:36:29');
INSERT INTO `hot` VALUES ('天亮了', '0', '2020-09-03 02:30:44');
INSERT INTO `hot` VALUES ('谢谢', '3', '2020-09-03 20:58:10');
INSERT INTO `hot` VALUES ('谢谢你', '0', '2020-09-03 20:55:34');

-- ----------------------------
-- Table structure for parameter
-- ----------------------------
DROP TABLE IF EXISTS `parameter`;
CREATE TABLE `parameter` (
  `para_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `para_value` varchar(50) DEFAULT NULL COMMENT '参数值',
  `para_name` varchar(50) DEFAULT NULL COMMENT '描述',
  `para_type` char(1) DEFAULT NULL COMMENT '1：定时，2：k值，3：定时表达式',
  PRIMARY KEY (`para_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parameter
-- ----------------------------
INSERT INTO `parameter` VALUES ('1', '50', '热词个数', '2');
INSERT INTO `parameter` VALUES ('2', '12', '更新周期（小时）', '1');
INSERT INTO `parameter` VALUES ('3', '*/5 * * * * ?', '更新周期表达式', '3');