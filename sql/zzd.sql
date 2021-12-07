CREATE DATABASE zzd_Property;

/*
SQLyog Ultimate v8.32
MySQL - 5.5.27 : Database - heima-estate
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `tb_activity` */

DROP TABLE IF EXISTS `tb_activity`;

/*小区活动表*/
CREATE TABLE `tb_activity` (
                               `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '活动ID',
                               `community_name` VARCHAR(50) DEFAULT NULL COMMENT '所属小区名称',
                               `community_id` INT(11) DEFAULT NULL COMMENT '所属小区ID',
                               `title` VARCHAR(100) DEFAULT NULL COMMENT '活动标题',
                               `address` VARCHAR(200) DEFAULT NULL COMMENT '活动地点',
                               `organizer` VARCHAR(100) DEFAULT NULL COMMENT '举办单位',
                               `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                               `start_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动开始时间',
                               `end_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动截止时间',
                               `status` CHAR(1) DEFAULT '0' COMMENT '状态:0-活动未开始（默认），1-活动进行中，2-活动已结束',
                               PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='活动表';

/*Data for the table `tb_activity` */

/*Table structure for table `tb_building` */

DROP TABLE IF EXISTS `tb_building`;

CREATE TABLE `tb_building` (
                               `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '楼栋ID',
                               `community_name` VARCHAR(50) DEFAULT NULL COMMENT '所属小区名称',
                               `community_id` INT(11) DEFAULT NULL COMMENT '所属小区ID',
                               `name` VARCHAR(50) DEFAULT NULL COMMENT '栋数名称',
                               `total_households` INT(11) DEFAULT NULL COMMENT '总户数',
                               `description` VARCHAR(500) DEFAULT NULL COMMENT '描述',
                               `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                               PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='楼栋表';

/*Data for the table `tb_building` */

/*Table structure for table `tb_car` */

DROP TABLE IF EXISTS `tb_car`;

CREATE TABLE `tb_car` (
                          `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '车辆ID',
                          `picture` VARCHAR(100) DEFAULT NULL COMMENT '车辆照片',
                          `owner_id` INT(11) DEFAULT NULL COMMENT '所属成员（业主）',
                          `color` VARCHAR(10) DEFAULT NULL COMMENT '车辆颜色',
                          `car_number` VARCHAR(20) DEFAULT NULL COMMENT '车牌号',
                          `remark` VARCHAR(500) DEFAULT NULL COMMENT '备注',
                          `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                          PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='车辆表';

/*Data for the table `tb_car` */

/*Table structure for table `tb_charge_detail` */

DROP TABLE IF EXISTS `tb_charge_detail`;

CREATE TABLE `tb_charge_detail` (
                                    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '收费明细ID',
                                    `community_id` INT(11) DEFAULT NULL COMMENT '所属小区ID',
                                    `community_name` VARCHAR(50) DEFAULT NULL COMMENT '所属小区名称',
                                    `charge_item_id` INT(11) DEFAULT NULL COMMENT '收费项目ID',
                                    `charge_item_name` VARCHAR(50) DEFAULT NULL COMMENT '收费项目名称',
                                    `contractor` VARCHAR(50) DEFAULT NULL COMMENT '承办人名称',
                                    `telephone` INT(20) DEFAULT NULL COMMENT '承办人联系电话',
                                    `pay_money` INT(11) DEFAULT NULL COMMENT '应收金额(￥)，单位分',
                                    `actual_money` INT(11) DEFAULT NULL COMMENT '实收金额(￥)，单位分',
                                    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                                    `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                                    `pay_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '缴费时间',
                                    `status` CHAR(1) DEFAULT '0' COMMENT '状态：0-生效中（默认），1-已过期',
                                    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='收费名细表';

/*Data for the table `tb_charge_detail` */

/*Table structure for table `tb_charge_item` */

DROP TABLE IF EXISTS `tb_charge_item`;

CREATE TABLE `tb_charge_item` (
                                  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '收费项目ID',
                                  `community_id` INT(11) DEFAULT NULL COMMENT '所属小区ID',
                                  `community_name` VARCHAR(50) DEFAULT NULL COMMENT '所属小区名称',
                                  `code` VARCHAR(20) DEFAULT NULL COMMENT '收费编号',
                                  `name` VARCHAR(50) DEFAULT NULL COMMENT '项目名称',
                                  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                                  `money` INT(11) DEFAULT NULL COMMENT '项目收费金额（年），单位分',
                                  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='收费项目表';

/*Data for the table `tb_charge_item` */

/*Table structure for table `tb_community` */

DROP TABLE IF EXISTS `tb_community`;

CREATE TABLE `tb_community` (
                                `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '小区id',
                                `code` VARCHAR(20) NOT NULL COMMENT '小区编号',
                                `name` VARCHAR(50) NOT NULL COMMENT '小区名称',
                                `address` VARCHAR(200) DEFAULT NULL COMMENT '坐落地址',
                                `area` DOUBLE DEFAULT NULL COMMENT '占地面积（m2）',
                                `total_buildings` INT(11) DEFAULT NULL COMMENT '总栋数',
                                `total_households` INT(11) DEFAULT NULL COMMENT '总户数',
                                `greening_rate` INT(11) DEFAULT NULL COMMENT '绿化率（%）',
                                `thumbnail` VARCHAR(200) DEFAULT NULL COMMENT '缩略图',
                                `developer` VARCHAR(100) DEFAULT NULL COMMENT '开发商名称',
                                `estate_company` VARCHAR(100) DEFAULT NULL COMMENT '物业公司名称',
                                `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_time` TIMESTAMP NULL DEFAULT NULL COMMENT '更新时间',
                                `status` CHAR(1) DEFAULT '0' COMMENT '状态:0-启用（默认），1-不启用',
                                PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='小区表';

/*Data for the table `tb_community` */

INSERT  INTO `tb_community`(`id`,`code`,`name`,`address`,`area`,`total_buildings`,`total_households`,`greening_rate`,`thumbnail`,`developer`,`estate_company`,`create_time`,`update_time`,`status`) VALUES (1,'HX19960101001','化纤小区','历城区花园路5号',22222,66,2432,30,'/fileupload/d2cea885-a986-463a-97da-7073c9e6fbf6.jpg','济南齐鲁化纤集团有限责任公司','上海新长宁集团新华物业有限公司','2020-12-13 09:12:04','2020-12-13 09:26:12','0');
INSERT  INTO `tb_community`(`id`,`code`,`name`,`address`,`area`,`total_buildings`,`total_households`,`greening_rate`,`thumbnail`,`developer`,`estate_company`,`create_time`,`update_time`,`status`) VALUES (2,'DH19960101002','东风小区','历城区花园路6号',33000,50,2222,40,'/images/dongfeng.jpg','济南齐鲁化纤集团有限责任公司','上海新长宁集团新华物业有限公司','2020-12-13 09:24:42','2020-12-13 09:26:14','0');
INSERT  INTO `tb_community`(`id`,`code`,`name`,`address`,`area`,`total_buildings`,`total_households`,`greening_rate`,`thumbnail`,`developer`,`estate_company`,`create_time`,`update_time`,`status`) VALUES (3,'BH19960101003','百花小区','历城区花园路7号',44444,88,3000,50,'/fileupload/e6daae7d-17f6-4053-9e44-81cf5a4c5d82.jpg','济南齐鲁化纤集团有限责任公司','上海新长宁集团新华物业有限公司','2020-12-13 09:24:42','2020-12-13 09:24:42','0');
INSERT  INTO `tb_community`(`id`,`code`,`name`,`address`,`area`,`total_buildings`,`total_households`,`greening_rate`,`thumbnail`,`developer`,`estate_company`,`create_time`,`update_time`,`status`) VALUES (28,'JYHF20160101001','金域华府','齐鲁软件园',66666,66,2195,35,'/fileupload/1faae278-4fc7-4561-b1bf-3770f0a7c75c.jpg','万达地产集团','万科物业','2020-12-14 19:29:48',NULL,'0');

/*Table structure for table `tb_complaint` */

DROP TABLE IF EXISTS `tb_complaint`;

CREATE TABLE `tb_complaint` (
                                `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '投诉ID',
                                `community_name` VARCHAR(50) DEFAULT NULL COMMENT '所属小区名称',
                                `community_id` INT(11) DEFAULT NULL COMMENT '所属小区ID',
                                `owner_id` INT(11) DEFAULT NULL COMMENT '投诉人员（业主）ID',
                                `owner_name` VARCHAR(40) DEFAULT NULL COMMENT '投诉人员（业主）名称',
                                `description` VARCHAR(500) DEFAULT NULL COMMENT '投诉具体描述',
                                `reason` VARCHAR(100) DEFAULT NULL COMMENT '投诉事由',
                                `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                                `status` CHAR(1) DEFAULT '0' COMMENT '状态：0-未受理，1-已受理（默认），2-已处理完毕',
                                PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='投诉表';

/*Data for the table `tb_complaint` */

/*Table structure for table `tb_device` */

DROP TABLE IF EXISTS `tb_device`;

CREATE TABLE `tb_device` (
                             `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '设备ID',
                             `community_name` VARCHAR(50) DEFAULT NULL COMMENT '所属小区名称',
                             `community_id` INT(11) DEFAULT NULL COMMENT '所属小区ID',
                             `code` VARCHAR(20) DEFAULT NULL COMMENT '设备编号',
                             `name` VARCHAR(50) DEFAULT NULL COMMENT '设备名称',
                             `brand` VARCHAR(40) DEFAULT NULL COMMENT '设备品牌',
                             `unit_price` INT(11) DEFAULT NULL COMMENT '购买单价(￥)，单位分',
                             `num` INT(11) DEFAULT NULL COMMENT '购买数量',
                             `expected_useful_life` INT(11) DEFAULT NULL COMMENT '预计使用年限(年)',
                             `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                             `purchase_date` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '购买日期',
                             PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='设备表';

/*Data for the table `tb_device` */

/*Table structure for table `tb_estate_manager` */

DROP TABLE IF EXISTS `tb_estate_manager`;

CREATE TABLE `tb_estate_manager` (
                                     `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '物业管理人员ID',
                                     `community_name` VARCHAR(50) DEFAULT NULL COMMENT '所属小区名称',
                                     `community_id` INT(11) DEFAULT NULL COMMENT '所属小区ID',
                                     `login_name` VARCHAR(20) DEFAULT NULL COMMENT '登录名:登录时使用的名称',
                                     `name` VARCHAR(50) DEFAULT NULL COMMENT '真实名称',
                                     `password` VARCHAR(60) DEFAULT NULL COMMENT '密码',
                                     `telephone` INT(20) DEFAULT NULL COMMENT '手机',
                                     `email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
                                     `role_id` INT(11) DEFAULT '0' COMMENT '角色ID：0-普通用户（默认0），1-管理员用户',
                                     `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                                     PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='物业管理人员表';

/*Data for the table `tb_estate_manager` */

INSERT  INTO `tb_estate_manager`(`id`,`community_name`,`community_id`,`login_name`,`name`,`password`,`telephone`,`email`,`role_id`,`create_time`,`update_time`) VALUES (1,'化纤小区',1,'15900000000','张三','123456',2147483647,'123@163.com',0,'2020-12-14 10:17:49','2020-12-14 10:17:49');
INSERT  INTO `tb_estate_manager`(`id`,`community_name`,`community_id`,`login_name`,`name`,`password`,`telephone`,`email`,`role_id`,`create_time`,`update_time`) VALUES (2,'百花小区',3,'15911111111','李四','123456',2147483647,'456@163.com',0,'2020-12-14 10:17:55','2020-12-14 10:17:55');
INSERT  INTO `tb_estate_manager`(`id`,`community_name`,`community_id`,`login_name`,`name`,`password`,`telephone`,`email`,`role_id`,`create_time`,`update_time`) VALUES (3,'东风小区',2,'15922222222','王五','123456',2147483647,'789@163.com',0,'2020-12-14 10:18:03','2020-12-14 10:18:03');

/*Table structure for table `tb_house` */

DROP TABLE IF EXISTS `tb_house`;

CREATE TABLE `tb_house` (
                            `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '房屋ID',
                            `community_name` VARCHAR(50) DEFAULT NULL COMMENT '所属小区名称',
                            `community_id` INT(11) DEFAULT NULL COMMENT '所属小区ID',
                            `building_name` VARCHAR(50) DEFAULT NULL COMMENT '所属栋数名称',
                            `building_id` INT(11) DEFAULT NULL COMMENT '所属栋数ID',
                            `code` VARCHAR(50) DEFAULT NULL COMMENT '房产编码',
                            `name` VARCHAR(100) DEFAULT NULL COMMENT '房产名称',
                            `owner_id` INT(11) DEFAULT NULL COMMENT '户主（业主）ID',
                            `owner_name` VARCHAR(50) DEFAULT NULL COMMENT '户主（业主）名称',
                            `telephone` INT(20) DEFAULT NULL COMMENT '联系方式',
                            `room_num` INT(11) DEFAULT NULL COMMENT '房间数',
                            `unit` INT(2) DEFAULT NULL COMMENT '单元',
                            `floor` INT(3) DEFAULT NULL COMMENT '楼层',
                            `description` VARCHAR(500) DEFAULT NULL COMMENT '描述',
                            `live_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入住时间',
                            PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='房屋表';

/*Data for the table `tb_house` */

/*Table structure for table `tb_letter` */

DROP TABLE IF EXISTS `tb_letter`;

CREATE TABLE `tb_letter` (
                             `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '信件ID',
                             `community_id` INT(11) DEFAULT NULL COMMENT '所属小区ID',
                             `community_name` VARCHAR(50) DEFAULT NULL COMMENT '所属小区名称',
                             `owner_id` INT(11) DEFAULT NULL COMMENT '信件发送者（业主）ID',
                             `owner_name` VARCHAR(50) DEFAULT NULL COMMENT '信件发送者（业主）名称',
                             `origin` CHAR(1) DEFAULT '0' COMMENT '信件来源：0-信箱（默认），1-邮件，2-微信，3-公众号，4-app,5-pc',
                             `title` VARCHAR(100) DEFAULT NULL COMMENT '信件标题',
                             `content` VARCHAR(2000) DEFAULT NULL COMMENT '信箱内容',
                             `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                             `status` CHAR(1) DEFAULT '0' COMMENT '状态:0-未读（默认），1-已读',
                             PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='信件表';

/*Data for the table `tb_letter` */

/*Table structure for table `tb_owner` */

DROP TABLE IF EXISTS `tb_owner`;

CREATE TABLE `tb_owner` (
                            `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '业主ID',
                            `community_id` INT(11) DEFAULT NULL COMMENT '所属小区',
                            `house_id` INT(11) DEFAULT NULL COMMENT '所属房产',
                            `name` VARCHAR(50) DEFAULT NULL COMMENT '成员名称',
                            `picture` VARCHAR(100) DEFAULT NULL COMMENT '成员照片',
                            `idcard` VARCHAR(18) DEFAULT NULL COMMENT '身份证号',
                            `telephone` INT(20) DEFAULT NULL COMMENT '联系方式',
                            `profession` VARCHAR(20) DEFAULT NULL COMMENT '职业',
                            `sex` CHAR(1) DEFAULT '0' COMMENT '性别:0-男（默认），1-女',
                            `type` CHAR(1) DEFAULT '0' COMMENT '类型:0-房主（默认），1-租客',
                            `remark` VARCHAR(200) DEFAULT '无' COMMENT '备注（默认无）',
                            `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                            `birthday` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '出生日期',
                            PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='业主表';

/*Data for the table `tb_owner` */

/*Table structure for table `tb_parking` */

DROP TABLE IF EXISTS `tb_parking`;

CREATE TABLE `tb_parking` (
                              `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '车位ID',
                              `community_name` VARCHAR(50) DEFAULT NULL COMMENT '所属小区名称',
                              `community_id` INT(11) DEFAULT NULL COMMENT '所属小区ID',
                              `picture` VARCHAR(100) DEFAULT NULL COMMENT '车位图片',
                              `code` VARCHAR(20) DEFAULT NULL COMMENT '车位编号',
                              `name` VARCHAR(50) DEFAULT NULL COMMENT '车位名称',
                              `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                              PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='车位表';

/*Data for the table `tb_parking` */

/*Table structure for table `tb_parking_use` */

DROP TABLE IF EXISTS `tb_parking_use`;

CREATE TABLE `tb_parking_use` (
                                  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '车位使用ID',
                                  `community_name` VARCHAR(50) DEFAULT NULL COMMENT '所属小区名称',
                                  `community_id` INT(11) DEFAULT NULL COMMENT '所属小区ID',
                                  `code` VARCHAR(20) DEFAULT NULL COMMENT '车位编号',
                                  `car_number` VARCHAR(20) DEFAULT NULL COMMENT '车牌号码',
                                  `picture` VARCHAR(100) DEFAULT NULL COMMENT '车辆牌照（照片）',
                                  `owner_name` VARCHAR(50) DEFAULT NULL COMMENT '车辆所有人（业主）名称',
                                  `owner_id` INT(11) DEFAULT NULL COMMENT '车辆所有人（业主）ID',
                                  `telephone` INT(20) DEFAULT NULL COMMENT '联系方式',
                                  `use_type` CHAR(1) DEFAULT '0' COMMENT '使用性质：0-购买(默认)，1-月租，2-年租',
                                  `total_fee` INT(11) DEFAULT NULL COMMENT '总费用(￥)，以分为单位',
                                  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                                  `start_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '（使用）开始时间',
                                  `end_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '（使用）结束时间',
                                  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='车位使用表';

/*Data for the table `tb_parking_use` */

/*Table structure for table `tb_pet` */

DROP TABLE IF EXISTS `tb_pet`;

CREATE TABLE `tb_pet` (
                          `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '宠物ID',
                          `picture` VARCHAR(100) DEFAULT NULL COMMENT '宠物照片',
                          `owner_name` VARCHAR(50) DEFAULT NULL COMMENT '所属成员（业主）名称',
                          `owner_id` INT(11) DEFAULT NULL COMMENT '所属成员（业主）ID',
                          `name` VARCHAR(50) DEFAULT NULL COMMENT '宠物名称',
                          `color` VARCHAR(10) DEFAULT NULL COMMENT '宠物颜色',
                          `remark` VARCHAR(500) DEFAULT NULL COMMENT '备注',
                          `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                          `adopt_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '收养时间',
                          PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='宠物表';

/*Data for the table `tb_pet` */

/*Table structure for table `tb_repair` */

DROP TABLE IF EXISTS `tb_repair`;

CREATE TABLE `tb_repair` (
                             `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '维修ID',
                             `community_name` VARCHAR(50) DEFAULT NULL COMMENT '所属小区名称',
                             `community_id` INT(11) DEFAULT NULL COMMENT '所属小区ID',
                             `building_name` VARCHAR(50) DEFAULT NULL COMMENT '所属楼栋名称',
                             `building_id` INT(11) DEFAULT NULL COMMENT '所属楼栋ID',
                             `owner_name` VARCHAR(50) DEFAULT NULL COMMENT '报修人员（业主）名称',
                             `owner_id` INT(11) DEFAULT NULL COMMENT '报修人员（业主）ID',
                             `device_name` VARCHAR(50) DEFAULT NULL COMMENT '设备名称',
                             `device_id` INT(11) DEFAULT NULL COMMENT '设备编号ID',
                             `description` VARCHAR(500) DEFAULT NULL COMMENT '报修描述',
                             `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                             `status` CHAR(1) DEFAULT '0' COMMENT '状态：0-待受理，1-已受理，2-修理完毕',
                             PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='维修表';

/*Data for the table `tb_repair` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
