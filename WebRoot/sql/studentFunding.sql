/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.27 : Database - studentfunding
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentfunding` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `studentfunding`;

/*Table structure for table `t_department` */

DROP TABLE IF EXISTS `t_department`;

CREATE TABLE `t_department` (
  `did` char(10) NOT NULL,
  `dpassword` varchar(20) NOT NULL,
  `department` char(10) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_department` */

insert  into `t_department`(`did`,`dpassword`,`department`) values ('2020101','12345','信息工程系'),('2020102','12345','土木工程系');

/*Table structure for table `t_headmaster` */

DROP TABLE IF EXISTS `t_headmaster`;

CREATE TABLE `t_headmaster` (
  `hid` char(10) NOT NULL,
  `hpassword` varchar(20) NOT NULL,
  `department` char(10) DEFAULT NULL,
  `major` char(10) DEFAULT NULL,
  `grade` char(10) DEFAULT NULL,
  `class` char(5) DEFAULT NULL,
  `selectno` char(10) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_headmaster` */

insert  into `t_headmaster`(`hid`,`hpassword`,`department`,`major`,`grade`,`class`,`selectno`) values ('15031503','12345','土木工程系','造价','15','1503',NULL),('16051605','12345','信息工程系','计算机科学与技术','16','1605',NULL);

/*Table structure for table `t_institute` */

DROP TABLE IF EXISTS `t_institute`;

CREATE TABLE `t_institute` (
  `iid` char(10) NOT NULL,
  `ipassword` varchar(20) NOT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_institute` */

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `sid` char(20) NOT NULL,
  `sname` char(10) NOT NULL,
  `department` varchar(50) DEFAULT NULL,
  `major` varchar(50) DEFAULT NULL,
  `grade` varchar(20) DEFAULT NULL,
  `classno` char(5) DEFAULT NULL,
  `spassword` varchar(20) DEFAULT NULL,
  `formno` varchar(30) DEFAULT NULL,
  `classverify` char(10) DEFAULT '正在审核',
  `dpverify` char(10) DEFAULT '正在审核',
  `lastverify` char(10) DEFAULT '正在审核',
  PRIMARY KEY (`sid`),
  UNIQUE KEY `formno` (`formno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`sid`,`sname`,`department`,`major`,`grade`,`classno`,`spassword`,`formno`,`classverify`,`dpverify`,`lastverify`) values ('165150505','陈劭瑀','土木工程系','造价','15','1503','19980630',NULL,'正在审核','正在审核','正在审核'),('165150528','杨逸云','信息工程系','计算机科学与技术','16','1605','sd1234',NULL,'正在审核','正在审核','正在审核'),('165150530','姚慧','信息工程系','计算机科学与技术','16','1605','19980718',NULL,'正在审核','正在审核','正在审核');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
