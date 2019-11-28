# Host: 127.0.0.1  (Version 5.7.28)
# Date: 2019-11-27 18:03:02
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "classroom"
#

DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom` (
  `classroom_id` char(10) NOT NULL DEFAULT '',
  `classroom_name` char(15) DEFAULT NULL,
  `classroom_capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`classroom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "classroom"
#

INSERT INTO `classroom` VALUES ('0001','5-101',140),('0002','5-103',140),('0003','5-105',140);

#
# Structure for table "college"
#

DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `coll_id` char(10) NOT NULL DEFAULT '',
  `coll_name` char(30) DEFAULT NULL,
  PRIMARY KEY (`coll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "college"
#

INSERT INTO `college` VALUES ('0001','计算机科学与技术学院'),('0002','交通学院');

#
# Structure for table "course"
#

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cour_id` char(10) NOT NULL DEFAULT '',
  `cour_name` char(15) DEFAULT NULL,
  `cour_credit` double(4,1) DEFAULT NULL,
  `cour_college` char(10) DEFAULT NULL,
  PRIMARY KEY (`cour_id`),
  KEY `cour_college` (`cour_college`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`cour_college`) REFERENCES `college` (`coll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "course"
#

INSERT INTO `course` VALUES ('0001','c++',3.5,'0001'),('0002','java',2.5,'0001');

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` char(10) NOT NULL,
  `stu_name` char(15) DEFAULT NULL,
  `stu_college` char(10) DEFAULT NULL,
  `stu_major` char(15) DEFAULT NULL,
  `stu_class` char(15) DEFAULT NULL,
  `stu_credit` double(4,1) DEFAULT '0.0',
  PRIMARY KEY (`stu_id`),
  KEY `stu_college` (`stu_college`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`stu_college`) REFERENCES `college` (`coll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "student"
#

INSERT INTO `student` VALUES ('030001','xiao ming','0001','CS','1701',0.0),('030002','xiao hong','0001','CS','1702',0.0);

#
# Structure for table "teacher"
#

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teac_id` char(10) NOT NULL DEFAULT '',
  `teac_name` char(15) DEFAULT NULL,
  `teac_college` char(10) DEFAULT NULL,
  PRIMARY KEY (`teac_id`),
  KEY `teac_college` (`teac_college`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`teac_college`) REFERENCES `college` (`coll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "teacher"
#

INSERT INTO `teacher` VALUES ('020001','mike','0001');

#
# Structure for table "begin_course"
#

DROP TABLE IF EXISTS `begin_course`;
CREATE TABLE `begin_course` (
  `bc_id` char(10) NOT NULL DEFAULT '',
  `bc_course` char(10) DEFAULT NULL,
  `bc_class` char(10) DEFAULT NULL,
  `bc_teacher` char(10) DEFAULT NULL,
  `bc_classroom` char(10) DEFAULT NULL,
  `bc_capacity` int(11) DEFAULT NULL,
  `bc_begin_time` char(25) DEFAULT NULL,
  `bc_end_time` char(20) DEFAULT NULL,
  `bc_time` char(50) DEFAULT NULL,
  PRIMARY KEY (`bc_id`),
  KEY `bc_classroom` (`bc_classroom`),
  KEY `bc_course` (`bc_course`),
  KEY `bc_teacher` (`bc_teacher`),
  CONSTRAINT `begin_course_ibfk_1` FOREIGN KEY (`bc_classroom`) REFERENCES `classroom` (`classroom_id`),
  CONSTRAINT `begin_course_ibfk_2` FOREIGN KEY (`bc_course`) REFERENCES `course` (`cour_id`),
  CONSTRAINT `begin_course_ibfk_3` FOREIGN KEY (`bc_teacher`) REFERENCES `teacher` (`teac_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "begin_course"
#

INSERT INTO `begin_course` VALUES ('0001','0001','0001','020001','0001',120,'第一周','第八周','周一1-2，周四3-4');

#
# Structure for table "select_course"
#

DROP TABLE IF EXISTS `select_course`;
CREATE TABLE `select_course` (
  `sc_id` char(10) NOT NULL DEFAULT '',
  `sc_course` char(10) DEFAULT NULL,
  `sc_class` char(10) DEFAULT NULL,
  `sc_student` char(10) DEFAULT NULL,
  `sc_term` char(30) DEFAULT NULL,
  `sc_grade` double(4,1) DEFAULT '-1.0',
  PRIMARY KEY (`sc_id`),
  KEY `sc_student` (`sc_student`),
  KEY `select_course_ibfk_1` (`sc_course`),
  CONSTRAINT `select_course_ibfk_1` FOREIGN KEY (`sc_course`) REFERENCES `begin_course` (`bc_id`),
  CONSTRAINT `select_course_ibfk_2` FOREIGN KEY (`sc_student`) REFERENCES `student` (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "select_course"
#

INSERT INTO `select_course` VALUES ('0001','0001','0001','030001','2019-2020-1',NULL);

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` char(10) NOT NULL DEFAULT '',
  `uer_name` char(15) DEFAULT NULL,
  `user_password` char(10) DEFAULT NULL,
  `user_role` char(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "user"
#

INSERT INTO `user` VALUES ('010001','bob','456','administrator'),('020001','mike','123','teacher'),('020002','mary','654321','teacher'),('030001','tom','123','student'),('030002','lucy','456789','student');

#
# Structure for table "administrator"
#

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `adm_id` char(10) NOT NULL DEFAULT '',
  `adm_name` char(15) DEFAULT NULL,
  PRIMARY KEY (`adm_id`),
  CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`adm_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "administrator"
#

INSERT INTO `administrator` VALUES ('010001','bob');
