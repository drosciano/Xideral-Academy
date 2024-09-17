drop database if exists `tkd_tracker`;
CREATE DATABASE  IF NOT EXISTS `tkd_tracker`;
USE `tkd_tracker`;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `school_name` varchar(45) DEFAULT NULL,
  `teacher` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `last_name_2` varchar(45) DEFAULT NULL,
  `birth_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `occupation` varchar(45) DEFAULT NULL,
  `belt` varchar(45) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

