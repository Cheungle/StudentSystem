-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: studentsystem
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `idadmin` int(11) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idadmin`),
  UNIQUE KEY `admincol_UNIQUE` (`idadmin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (11000,'admin'),(11001,'admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `choosesc`
--

DROP TABLE IF EXISTS `choosesc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `choosesc` (
  `idstudent` int(11) NOT NULL,
  `idcourse` int(11) NOT NULL,
  `kindcourse` varchar(45) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `GPA` double DEFAULT NULL,
  `term` varchar(45) DEFAULT NULL,
  `testtime` varchar(45) DEFAULT NULL,
  `testplace` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idstudent`,`idcourse`),
  KEY `idco` (`idcourse`),
  CONSTRAINT `idco` FOREIGN KEY (`idcourse`) REFERENCES `course` (`idcourse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idstu` FOREIGN KEY (`idstudent`) REFERENCES `student` (`idstudent`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `choosesc`
--

LOCK TABLES `choosesc` WRITE;
/*!40000 ALTER TABLE `choosesc` DISABLE KEYS */;
INSERT INTO `choosesc` VALUES (2017110501,565,'professional',90,4,'18-19 1','2019-12-30 9:00-11:00','third classroom 702'),(2017110501,566,'personalized',84,3.3,'17-18 2','2018-6-9 14:00-16:00','third classroom 401'),(2017110501,567,'general elective',NULL,NULL,'19-20 1','2020-1-2 8:00-10:00','third classroom 107'),(2017110501,569,'general required',NULL,NULL,'19-20 1',NULL,NULL),(2017110501,572,'general required',84,3.3,'18-19 1','2019-1-10 16:00-18:00','second classroom 405'),(2017110501,573,'subject common',85,3.7,'17-18 1','2018-1-9 14:00-16:00','first classroom 203'),(2017110502,569,'general required',80,3.3,'19-20 1','2020-1-6 9:00-11:00','computer room 8'),(2017110504,566,'personalized',NULL,NULL,'18-19 2',NULL,NULL),(2017110505,565,'general elective',NULL,NULL,'18-19 1',NULL,NULL);
/*!40000 ALTER TABLE `choosesc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `idcourse` int(11) NOT NULL,
  `namecourse` varchar(45) NOT NULL,
  `classroom` varchar(45) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `idteacher` int(11) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `starttime` varchar(45) DEFAULT NULL,
  `sumclass` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcourse`),
  UNIQUE KEY `idcourse_UNIQUE` (`idcourse`),
  KEY `idtea` (`idteacher`),
  CONSTRAINT `idtea` FOREIGN KEY (`idteacher`) REFERENCES `teacher` (`idteacher`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (565,'Java','third classroom 101',2,1,'Monday','8:00','2'),(566,'Web','computer room 2',2,7,'Monday','13:20','3'),(567,'Movie','lecture theater 5',2,3,'Thursday','18:00','2'),(568,'Music','lecture theater 2',2,2,'Friday','10:05','2'),(569,'Math','second classroom 404',4,3,'Tuesday','8:00','2'),(570,'Economy','third classroom 107',3,1,'Wednesday','19:50','2'),(571,'Movies\'music','lecture theater 8',2,8,'Wednesday','10:05','2'),(572,'English','first classroom 203',2,5,'Tuesday','8:00','2'),(573,'Probability','second classroom 204',2,4,'Friday','8:00','2');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `courseinfor_view`
--

DROP TABLE IF EXISTS `courseinfor_view`;
/*!50001 DROP VIEW IF EXISTS `courseinfor_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `courseinfor_view` AS SELECT 
 1 AS `nameteacher`,
 1 AS `namecourse`,
 1 AS `credit`,
 1 AS `classroom`,
 1 AS `starttime`,
 1 AS `sumclass`,
 1 AS `date`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `gradewithmore_view`
--

DROP TABLE IF EXISTS `gradewithmore_view`;
/*!50001 DROP VIEW IF EXISTS `gradewithmore_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `gradewithmore_view` AS SELECT 
 1 AS `namecourse`,
 1 AS `grade`,
 1 AS `GPA`,
 1 AS `credit`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `idnotice` int(11) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `pubdate` date DEFAULT NULL,
  `pubperson` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idnotice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (1,'Notice of Shanghai Opera House modern dance drama,Early Spring February, entering the special performance of Shanghai University of Finance and Economics','    The modern dance drama ,Early Spring February, of Shanghai Opera House entered the special performance of Shanghai University of Finance and Economics on December 17, 2019 at 18:45 in the student art center of Shanghai University of Finance and economics. Welcome to watch.    How to ask for tickets: On December 10 at 11:30-13:00 to collect tickets from the gainng tickets position of the green leaf pedestrian street. Each person is limited to 2 tickets, first come first served, until they are all collected. From now on, the Department and staff can also book by phone (6590472113167219180) or wechat (the same number as the mobile phone), and collect tickets from Ren bin, teacher 312 in the administrative building, at 14:00-16:00 p.m. on December 10 and 9:30-11:00 a.m. on December 11.','2019-12-24','Lu'),(2,'abc','    sdasdasdsadcdvdsvsdvsdv','2018-01-01','Chen'),(3,'dsdasd','dsadadasdad','2018-12-11','Kate'),(4,'fdfdfs','dfsdfsdfs','2019-08-01','Zhang'),(5,'dfdfdfsdvdfvdfvfdvsdvs','dvdsvsdvsdvsdv','2019-10-10','Li'),(6,'vsdvsdvsdvsdvdsv','sdvsdvsdvsdvsvs','2019-08-01','Li');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `idstudent` int(11) NOT NULL,
  `namestudent` varchar(45) NOT NULL,
  `class` varchar(45) DEFAULT NULL,
  `major` varchar(45) DEFAULT NULL,
  `academy` varchar(45) DEFAULT NULL,
  `photo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idstudent`),
  UNIQUE KEY `idstudent_UNIQUE` (`idstudent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (424,'fsdf','big data','big data','information engineering',''),(5245,'hgfhf','bid data','big data','information engineering',''),(5646,'klm','big data','big data','information engineering','fs'),(2017110501,'Max','computer','computer','information engineering','img/avatar-3.jpg'),(2017110502,'Jane','information system 2','information system','information engineering','img/avatar-2.jpg'),(2017110503,'Jim','information system 1','information system','information engineering','img/avatar-3.jpg'),(2017110504,'Tom','computer','computer','information engineering','img/avatar-2.jpg'),(2017110505,'Je','law3','law','law','img/avatar-3.jpg'),(2017110506,'ABH',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `idteacher` int(11) NOT NULL,
  `nameteacher` varchar(45) NOT NULL,
  `office` varchar(45) DEFAULT NULL,
  `academy` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idteacher`),
  UNIQUE KEY `idteacher_UNIQUE` (`idteacher`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Chen','209','information engineering'),(2,'Lu','203','information engineering'),(3,'Kate','302','law'),(4,'Wang','605','law'),(5,'Tang','405','information engineering'),(6,'Li','610','information engineering'),(7,'Nick','511','information engineering'),(8,'Zhang','205','law'),(9,'Nack','555','information engineering'),(11,'da','111','information engineering');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `testinfor_view`
--

DROP TABLE IF EXISTS `testinfor_view`;
/*!50001 DROP VIEW IF EXISTS `testinfor_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `testinfor_view` AS SELECT 
 1 AS `namecourse`,
 1 AS `testtime`,
 1 AS `testplace`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `courseinfor_view`
--

/*!50001 DROP VIEW IF EXISTS `courseinfor_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `courseinfor_view` AS select `teacher`.`nameteacher` AS `nameteacher`,`course`.`namecourse` AS `namecourse`,`course`.`credit` AS `credit`,`course`.`classroom` AS `classroom`,`course`.`starttime` AS `starttime`,`course`.`sumclass` AS `sumclass`,`course`.`date` AS `date` from ((`teacher` join `course`) join `choosesc`) where ((`course`.`idcourse` = `choosesc`.`idcourse`) and (`teacher`.`idteacher` = `course`.`idteacher`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `gradewithmore_view`
--

/*!50001 DROP VIEW IF EXISTS `gradewithmore_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `gradewithmore_view` AS select `course`.`namecourse` AS `namecourse`,`choosesc`.`grade` AS `grade`,`choosesc`.`GPA` AS `GPA`,`course`.`credit` AS `credit` from (`course` join `choosesc`) where (`course`.`idcourse` = `choosesc`.`idcourse`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `testinfor_view`
--

/*!50001 DROP VIEW IF EXISTS `testinfor_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `testinfor_view` AS select `course`.`namecourse` AS `namecourse`,`choosesc`.`testtime` AS `testtime`,`choosesc`.`testplace` AS `testplace` from (`choosesc` join `course`) where (`choosesc`.`idcourse` = `course`.`idcourse`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-09 17:59:56
