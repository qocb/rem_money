/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.62-community : Database - rem_money
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rem_money` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rem_money`;

/*Table structure for table `budget` */

DROP TABLE IF EXISTS `budget`;

CREATE TABLE `budget` (
  `budget_id` varchar(20) NOT NULL,
  `budget_money` varchar(20) DEFAULT NULL,
  `budget_remain` varchar(20) DEFAULT NULL,
  `budget_out` varchar(20) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `budget_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`budget_id`),
  KEY `FK_Reference_4` (`user_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `budget` */

insert  into `budget`(`budget_id`,`budget_money`,`budget_remain`,`budget_out`,`user_id`,`budget_name`) values ('bd1','1000','1000','0','u1','12月支出预算');

/*Table structure for table `getall` */

DROP TABLE IF EXISTS `getall`;

CREATE TABLE `getall` (
  `getall_id` varchar(20) NOT NULL,
  `get_day_money` varchar(20) DEFAULT NULL,
  `get_month_money` varchar(20) DEFAULT NULL,
  `get_year_money` varchar(20) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`getall_id`),
  KEY `FK_Reference_5` (`user_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `getall` */

insert  into `getall`(`getall_id`,`get_day_money`,`get_month_money`,`get_year_money`,`user_id`) values ('gt1','5000','5000','5000','u1');

/*Table structure for table `getkind` */

DROP TABLE IF EXISTS `getkind`;

CREATE TABLE `getkind` (
  `get_type` int(11) NOT NULL AUTO_INCREMENT,
  `get_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`get_type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `getkind` */

insert  into `getkind`(`get_type`,`get_name`) values (1,'薪资'),(2,'奖金'),(3,'借入'),(4,'收债'),(5,'利息'),(6,'投资');

/*Table structure for table `gets` */

DROP TABLE IF EXISTS `gets`;

CREATE TABLE `gets` (
  `get_id` varchar(20) NOT NULL,
  `get_money` varchar(20) DEFAULT NULL,
  `get_type` int(11) DEFAULT NULL,
  `get_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` varchar(20) DEFAULT NULL,
  `get_rem` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`get_id`),
  KEY `FK_Reference_1` (`get_type`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`get_type`) REFERENCES `getkind` (`get_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `gets` */

insert  into `gets`(`get_id`,`get_money`,`get_type`,`get_date`,`user_id`,`get_rem`) values ('g1','5000',1,'2020-12-22 11:24:23','u1','本月薪资收入5000元');

/*Table structure for table `outall` */

DROP TABLE IF EXISTS `outall`;

CREATE TABLE `outall` (
  `outall_id` varchar(20) NOT NULL,
  `out_day_money` varchar(20) DEFAULT NULL,
  `out_month_money` varchar(20) DEFAULT NULL,
  `out_year_money` varchar(20) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`outall_id`),
  KEY `FK_Reference_6` (`user_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `outall` */

insert  into `outall`(`outall_id`,`out_day_money`,`out_month_money`,`out_year_money`,`user_id`) values ('oa','30','30','30','u1');

/*Table structure for table `outkind` */

DROP TABLE IF EXISTS `outkind`;

CREATE TABLE `outkind` (
  `out_type` int(11) NOT NULL AUTO_INCREMENT,
  `out_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`out_type`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `outkind` */

insert  into `outkind`(`out_type`,`out_name`) values (1,'出行'),(2,'医疗'),(3,'税务'),(4,'生活'),(5,'其他');

/*Table structure for table `outs` */

DROP TABLE IF EXISTS `outs`;

CREATE TABLE `outs` (
  `out_id` varchar(20) NOT NULL,
  `out_money` varchar(20) DEFAULT NULL,
  `out_type` int(11) DEFAULT NULL,
  `out_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` varchar(20) DEFAULT NULL,
  `out_rem` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`out_id`),
  KEY `FK_Reference_2` (`out_type`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`out_type`) REFERENCES `outkind` (`out_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `outs` */

insert  into `outs`(`out_id`,`out_money`,`out_type`,`out_date`,`user_id`,`out_rem`) values ('o1','30',1,'2020-12-22 11:23:20','u1','今天打车花了30元');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` varchar(20) NOT NULL,
  `user_uname` varchar(20) DEFAULT NULL,
  `user_password` varchar(20) DEFAULT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_state` varchar(5) DEFAULT NULL,
  `user_code` varchar(50) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `user_img` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_Reference_3` (`user_type`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`user_type`) REFERENCES `user_type` (`user_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_uname`,`user_password`,`user_email`,`user_state`,`user_code`,`user_type`,`user_img`) values ('u1','zhangsan','123456','2677615497@qq.com','Y','123QAZ',1,'1.jpg'),('u2','lisi','456789','2677615497@qq.com','N','321QWE',1,'2.jpg');

/*Table structure for table `user_type` */

DROP TABLE IF EXISTS `user_type`;

CREATE TABLE `user_type` (
  `user_type` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user_type` */

insert  into `user_type`(`user_type`,`type_name`) values (1,'普通用户'),(2,'企业用户'),(3,'vip用户');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
