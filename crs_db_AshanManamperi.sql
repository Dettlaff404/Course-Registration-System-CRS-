-- MySQL dump 10.13  Distrib 8.0.39, for Win64 (x86_64)
--
-- Host: localhost    Database: crs_db
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` varchar(4) NOT NULL,
  `title` varchar(5) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `contact` varchar(10) NOT NULL,
  `email` varchar(65) NOT NULL,
  `password` varchar(20) NOT NULL,
  `post` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `contact` (`contact`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('A001','Mr.','John Smith','1980-05-15','9000000001','john.smith@example.com','Pass@123','Faculty'),('A002','Ms.','Emily Davis','1985-08-22','9000000002','emily.davis@example.com','EmiD@456','Administration'),('A003','Dr.','Robert Johnson','1972-11-30','9000000003','robert.johnson@example.com','RobJ@789','Lecturer'),('A004','Mrs.','Sophia Brown','1988-03-25','9000000004','sophia.brown@example.com','SophB@234','Faculty'),('A005','Mr.','James Wilson','1975-07-14','9000000005','james.wilson@example.com','JamW@567','Staff'),('A006','Ms.','Olivia Martinez','1990-09-10','9000000006','olivia.martinez@example.com','OlivM@890','Administration'),('A007','Dr.','William Anderson','1983-01-05','9000000007','william.anderson@example.com','WillA@123','Lecturer'),('A008','Mr.','David Thomas','1978-12-18','9000000008','david.thomas@example.com','DavT@456','Faculty'),('A009','Mrs.','Emma White','1986-04-29','9000000009','emma.white@example.com','EmmW@789','Staff'),('A010','Ms.','Charlotte Harris','1992-06-17','9000000010','charlotte.harris@example.com','CharH@234','Administration'),('A011','Dr.','Benjamin Clark','1981-08-03','9000000011','benjamin.clark@example.com','BenC@567','Lecturer'),('A012','Mr.','Lucas Lewis','1977-10-21','9000000012','lucas.lewis@example.com','LucL@890','Faculty'),('A013','Ms.','Amelia Walker','1989-11-07','9000000013','amelia.walker@example.com','AmeW@123','Administration'),('A014','Dr.','Henry Allen','1974-02-14','9000000014','henry.allen@example.com','HenA@456','Lecturer'),('A015','Mrs.','Isabella Young','1987-07-19','9000000015','isabella.young@example.com','IsaY@789','Faculty'),('A016','Mr.','Michael King','1982-09-23','9000000016','michael.king@example.com','MicK@234','Staff'),('A017','Ms.','Mia Scott','1991-05-30','9000000017','mia.scott@example.com','MiaS@567','Administration'),('A018','Dr.','Daniel Green','1976-12-11','9000000018','daniel.green@example.com','DanG@890','Lecturer'),('A019','Mrs.','Evelyn Baker','1984-03-08','9000000019','evelyn.baker@example.com','EveB@123','Staff'),('A020','Mr.','Alexander Hall','1973-06-25','9000000020','alexander.hall@example.com','AlexH@456','Faculty');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` varchar(7) NOT NULL,
  `title` varchar(50) NOT NULL,
  `cred_hrs` int NOT NULL,
  `max_enrollcap` int NOT NULL,
  `department_id` varchar(4) NOT NULL,
  PRIMARY KEY (`course_id`),
  KEY `fk_coursePr` (`department_id`),
  CONSTRAINT `fk_coursePr` FOREIGN KEY (`department_id`) REFERENCES `program` (`program_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('ART101','Art History',15,82,'ART'),('ART202','Modern Art',17,61,'ART'),('BIO101','Cell Biology',15,96,'BIO'),('BIO202','Genetics',17,79,'BIO'),('BUS101','Principles of Management',12,117,'BUS'),('BUS202','Marketing Strategies',18,90,'BUS'),('CE101','Structural Analysis',13,84,'CE'),('CE202','Geotechnical Engineering',18,60,'CE'),('CHEM101','Organic Chemistry',15,83,'CHEM'),('CHEM202','Inorganic Chemistry',12,60,'CHEM'),('CS101','Introduction to Computer Science',15,100,'CS'),('CS201','Data Structures',16,80,'CS'),('CS301','Operating Systems',14,75,'CS'),('ECON101','Microeconomics',14,100,'ECON'),('ECON202','Macroeconomics',16,80,'ECON'),('EE101','Circuit Analysis',13,90,'EE'),('EE202','Microprocessors',17,70,'EE'),('ENG101','Literary Analysis',12,100,'ENG'),('ENG202','Creative Writing',18,80,'ENG'),('HIST101','World History',15,90,'HIST'),('HIST202','Modern History',16,70,'HIST'),('IT101','Fundamentals of IT',12,100,'IT'),('IT202','Network Security',18,60,'IT'),('MATH101','Calculus I',14,99,'MATH'),('MATH202','Linear Algebra',16,80,'MATH'),('ME101','Thermodynamics',14,85,'ME'),('ME202','Fluid Mechanics',16,60,'ME'),('PHYS101','General Physics I',13,90,'PHYS'),('PHYS202','Quantum Mechanics',17,70,'PHYS'),('PSY101','Introduction to Psychology',14,100,'PSY'),('PSY202','Cognitive Psychology',17,80,'PSY');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollments`
--

DROP TABLE IF EXISTS `enrollments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrollments` (
  `student_id` varchar(4) NOT NULL,
  `course_id` varchar(7) NOT NULL,
  `semester` varchar(10) NOT NULL,
  `grade` varchar(1) DEFAULT NULL,
  `enrolled_date` date DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `enrollments_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `enrollments_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollments`
--

LOCK TABLES `enrollments` WRITE;
/*!40000 ALTER TABLE `enrollments` DISABLE KEYS */;
INSERT INTO `enrollments` VALUES ('S001','CS101','Fall2021','A','2021-06-01',1),('S001','MATH101','Fall2021','F','2021-06-01',2),('S002','IT101','Spring2020','A','2020-01-01',3),('S002','EE101','Spring2020','C','2020-01-01',4),('S003','EE202','Fall2022','A','2022-06-01',5),('S003','CS201','Fall2022','P','2022-06-01',6),('S004','ME101','Spring2019','B','2019-01-01',7),('S004','PHYS101','Spring2019','F','2019-01-01',8),('S005','BIO101','Fall2021','A','2021-06-01',9),('S005','CHEM101','Fall2021','B','2021-06-01',10),('S006','BUS101','Spring2020','C','2020-01-01',11),('S006','ECON101','Spring2020','P','2020-01-01',12),('S007','MATH202','Fall2022','A','2022-06-01',13),('S007','PHYS202','Fall2022','B','2022-06-01',14),('S008','PHYS101','Spring2019','C','2019-01-01',15),('S008','CHEM202','Spring2019','F','2019-01-01',16),('S009','CHEM101','Fall2021','A','2021-06-01',17),('S009','BIO202','Fall2021','P','2021-06-01',18),('S010','ECON202','Fall2022','B','2022-06-01',19),('S010','BUS202','Fall2022','C','2022-06-01',20),('S011','ART101','Spring2020','A','2020-01-01',21),('S011','ENG101','Spring2020','B','2020-01-01',22),('S012','ENG202','Fall2022','P','2022-06-01',23),('S012','HIST101','Fall2022','F','2022-06-01',24),('S013','HIST202','Fall2022','A','2022-06-01',25),('S013','PSY101','Fall2022','C','2022-06-01',26),('S014','PSY202','Spring2019','B','2019-01-01',27),('S014','CE101','Spring2019','P','2019-01-01',28),('S015','CE202','Fall2022','A','2022-06-01',29),('S015','ME202','Fall2022','F','2022-06-01',30),('S016','CS201','Fall2021','B','2021-06-01',31),('S016','IT202','Fall2021','C','2021-06-01',32),('S017','IT101','Fall2022','P','2022-06-01',33),('S017','EE101','Fall2022','A','2022-06-01',34),('S018','EE202','Spring2019','B','2019-01-01',35),('S018','ME101','Spring2019','F','2019-01-01',36),('S019','ME202','Fall2022','C','2022-06-01',37),('S019','PHYS202','Fall2022','P','2022-06-01',38),('S020','BIO101','Fall2021','A','2021-06-01',39),('S020','CHEM202','Fall2021','B','2021-06-01',40),('S001','ART101','Fall2022','B','2022-02-25',41),('S001','MATH101','Fall2025','','2025-02-02',47),('S001','CE101','Fall2025','','2025-02-02',48),('S001','ART202','Fall2025','B','2025-02-24',64),('S003','ART101','Fall2025','P','2025-02-24',65),('S004','ART101','Fall2025','A','2025-02-24',66),('S002','ART101','Fall2025','A','2025-02-24',67),('S007','ART101','Fall2025','A','2025-02-24',68),('S020','ART101','Fall2025','P','2025-02-25',70),('S020','BIO202','Fall2025','','2025-02-25',71),('S021','ART101','Fall2025','B','2025-02-25',72),('S021','BIO101','Fall2025','A','2025-02-25',73),('S003','ART202','Fall2025','F','2025-02-25',74);
/*!40000 ALTER TABLE `enrollments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prerequisites`
--

DROP TABLE IF EXISTS `prerequisites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prerequisites` (
  `course_id` varchar(7) NOT NULL,
  `prereq_course_id` varchar(7) NOT NULL,
  PRIMARY KEY (`course_id`,`prereq_course_id`),
  KEY `prereq_course_id` (`prereq_course_id`),
  CONSTRAINT `prerequisites_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `prerequisites_ibfk_2` FOREIGN KEY (`prereq_course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prerequisites`
--

LOCK TABLES `prerequisites` WRITE;
/*!40000 ALTER TABLE `prerequisites` DISABLE KEYS */;
INSERT INTO `prerequisites` VALUES ('ART202','ART101'),('BIO202','BIO101'),('BUS202','BUS101'),('CE202','CE101'),('CHEM202','CHEM101'),('CS201','CS101'),('CS301','CS201'),('ECON202','ECON101'),('EE202','EE101'),('ENG202','ENG101'),('HIST202','HIST101'),('IT202','IT101'),('MATH202','MATH101'),('ME202','ME101'),('PHYS202','PHYS101'),('PSY202','PSY101');
/*!40000 ALTER TABLE `prerequisites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program` (
  `program_id` varchar(4) NOT NULL,
  `description` varchar(30) NOT NULL,
  PRIMARY KEY (`program_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES ('ART','Fine Arts'),('BIO','Biology'),('BUS','Business Administration'),('CE','Civil Engineering'),('CHEM','Chemistry'),('CS','Computer Science'),('ECON','Economics'),('EE','Electrical Engineering'),('ENG','English Literature'),('HIST','History'),('IT','Information Technology'),('MATH','Mathematics'),('ME','Mechanical Engineering'),('PHYS','Physics'),('PSY','Psychology');
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` varchar(4) NOT NULL,
  `name` varchar(30) NOT NULL,
  `dob` date NOT NULL,
  `year` year NOT NULL,
  `contact` varchar(10) NOT NULL,
  `password` varchar(12) NOT NULL,
  `program_id` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `contact` (`contact`),
  KEY `fk_program` (`program_id`),
  CONSTRAINT `fk_program` FOREIGN KEY (`program_id`) REFERENCES `program` (`program_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('S001','Alice Johnson','2002-05-14',2021,'0912345678','pass1234','CS'),('S002','Bob Smith','2001-08-22',2020,'0923456789','pass2345','IT'),('S003','Charlie Brown','2003-02-10',2022,'0934567890','pass1234','EE'),('S004','David Wilson','2000-11-25',2019,'0945678901','pass4567','ME'),('S005','Emma Davis','2002-07-19',2021,'0956789012','pass5678','BIO'),('S006','Frank Thomas','2001-04-30',2020,'0967890123','pass6789','BUS'),('S007','Grace Lee','2003-06-15',2022,'0978901234','pass7890','MATH'),('S008','Henry Walker','2000-09-08',2019,'0989012345','pass8901','PHYS'),('S009','Isabella White','2002-01-17',2021,'0990123456','pass9012','CHEM'),('S010','Jack Martin','2003-03-23',2022,'0901234567','pass0123','ECON'),('S011','Kate Lewis','2001-12-12',2020,'0912345670','pass1230','ART'),('S012','Leo Harris','2002-10-05',2021,'0923456701','pass2340','ENG'),('S013','Mia Clark','2003-07-30',2022,'0934567012','pass3450','HIST'),('S014','Noah Young','2000-05-21',2019,'0945670123','pass4560','PSY'),('S015','Olivia Hall','2001-08-09',2020,'0956780234','pass5670','CE'),('S016','Paul Allen','2002-02-28',2021,'0967890345','pass6780','CS'),('S017','Quinn Wright','2003-11-11',2022,'0978900456','pass7891','IT'),('S018','Rachel King','2000-09-19',2019,'0989010567','pass8902','EE'),('S019','Samuel Scott','2001-06-17',2020,'0990120678','pass9013','ME'),('S020','Tina Green','2002-12-22',2021,'0901230789','pass0124','BIO'),('S021','Umar Baker','2003-04-05',2022,'0912340890','pass1235','BUS'),('S022','Victoria Adams','2000-07-30',2019,'0923450912','pass2346','MATH'),('S023','William Carter','2001-01-14',2020,'0934561023','pass3457','PHYS'),('S024','Xander Phillips','2002-08-18',2021,'0945671134','pass4568','CHEM'),('S025','Yvonne Evans','2003-05-27',2022,'0956781245','pass5679','ECON'),('S026','Zane Murphy','2000-11-15',2019,'0967891356','pass6781','ART'),('S027','Anna Parker','2001-10-08',2020,'0978901467','pass7892','ENG'),('S028','Brandon Reed','2002-03-29',2021,'0989011578','pass8903','HIST'),('S029','Catherine Foster','2003-07-12',2022,'0990121689','pass9014','PSY'),('S030','Daniel Mitchell','2000-06-09',2019,'0901231790','pass0125','CE'),('S031','Ella Howard','2001-02-26',2020,'0912341901','pass1236','CS'),('S032','Felix Ramirez','2002-09-14',2021,'0923452012','pass2347','IT'),('S034','Harrison Bennett','2000-10-11',2019,'0945672234','pass4569','ME'),('S035','Ivy Gomez','2001-07-07',2020,'0956782345','pass5670','BIO'),('S036','James Torres','2002-04-01',2021,'0967892456','pass6781','BUS'),('S037','Kara Hughes','2003-02-19',2022,'0978902567','pass7893','MATH'),('S038','Liam Peterson','2000-12-30',2019,'0989012678','pass8904','PHYS'),('S039','Monica Simmons','2001-05-06',2020,'0990122789','pass9015','CHEM'),('S040','Nathan Diaz','2002-11-23',2021,'0901232890','pass5678','ECON');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-25 21:18:02
