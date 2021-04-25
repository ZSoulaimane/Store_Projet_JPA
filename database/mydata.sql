-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tp
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `articles`
--

DROP TABLE IF EXISTS `articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articles` (
  `CodeArticle` int NOT NULL AUTO_INCREMENT,
  `Designation` varchar(255) NOT NULL,
  `Prix` int NOT NULL,
  `Stock` varchar(255) NOT NULL,
  `Categorie` int NOT NULL,
  `Photo` varchar(255) NOT NULL,
  PRIMARY KEY (`CodeArticle`),
  UNIQUE KEY `CodeArticle` (`CodeArticle`),
  KEY `fk_categ_idx` (`Categorie`),
  CONSTRAINT `fk_categ` FOREIGN KEY (`Categorie`) REFERENCES `categories` (`RefCat`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articles`
--

LOCK TABLES `articles` WRITE;
/*!40000 ALTER TABLE `articles` DISABLE KEYS */;
INSERT INTO `articles` VALUES (1,'Moking Bird',10,'50',2,'https://images-na.ssl-images-amazon.com/images/I/51Bgn8ruwDL._SX425_.jpg'),(2,'Lose yourself',12,'30',2,'https://i.ytimg.com/vi/wUhE1f56CuU/movieposter.jpg'),(3,'Gods plan',9,'20',2,'https://www.jawharafm.net/fr/imageResize/resize/francais_image2_62779_1526301176.jpg/630/353'),(4,'Smooth criminal',6,'20',1,'https://www.mjvibe.com/wp-content/uploads/2021/01/8a6e91e5f0364d2f3ed129dc143f7185_2000x2000-1.jpg'),(5,'Billie Jean',9,'10',1,'https://m.media-amazon.com/images/I/51IJG7kIFdL._SX260_.jpg'),(6,'Bad',15,'3',1,'https://images-na.ssl-images-amazon.com/images/I/719gURl-EaL._SL1500_.jpg');
/*!40000 ALTER TABLE `articles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `RefCat` int NOT NULL AUTO_INCREMENT,
  `Cat` varchar(255) NOT NULL,
  PRIMARY KEY (`RefCat`),
  UNIQUE KEY `RefCat` (`RefCat`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Jazz'),(2,'Rap');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Email` varchar(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `Adresse` varchar(255) NOT NULL,
  `CodePostal` int NOT NULL,
  `Ville` varchar(255) NOT NULL,
  `tel` int NOT NULL,
  `MotPasse` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id` (`Id`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'mehdi@gmail.com','mehdi','mehdi','mehdi',12,'mehdi',12,'mehdi'),(2,'soule@gmail.com','soule','soule','soule',12,'soule',12,'soule'),(3,'salut@gmail.com','sqdm','heloo','mlkml',454,'dsqd',4654,'salut'),(4,'mez@gmail.com','HE','helo','lkjkl',454,'dcsfdzs',4554,'mez'),(5,'melkj@ds.com','lkjlk','helo','mklkm',454,'khjkjh',465464,'dsqkhkqsd');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commandes`
--

DROP TABLE IF EXISTS `commandes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commandes` (
  `NumCommande` int NOT NULL AUTO_INCREMENT,
  `CodeClient` int DEFAULT NULL,
  `DateCommande` date NOT NULL,
  PRIMARY KEY (`NumCommande`),
  UNIQUE KEY `NumCommande` (`NumCommande`),
  KEY `fk_client_id_idx` (`CodeClient`),
  CONSTRAINT `fk_client_id` FOREIGN KEY (`CodeClient`) REFERENCES `clients` (`Id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commandes`
--

LOCK TABLES `commandes` WRITE;
/*!40000 ALTER TABLE `commandes` DISABLE KEYS */;
INSERT INTO `commandes` VALUES (1,1,'2021-04-25'),(4,1,'2021-04-25'),(5,1,'2021-04-25'),(6,1,'2021-04-25'),(7,1,'2021-04-25'),(8,1,'2021-04-25'),(9,1,'2021-04-25'),(10,1,'2021-04-25'),(11,1,'2021-04-25'),(12,1,'2021-04-25'),(13,1,'2021-04-25'),(14,1,'2021-04-25');
/*!40000 ALTER TABLE `commandes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lignecommandes`
--

DROP TABLE IF EXISTS `lignecommandes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lignecommandes` (
  `NumCommande` int NOT NULL,
  `CodeArticle` int NOT NULL,
  `QteCde` int NOT NULL,
  KEY `fk_article_idx` (`CodeArticle`),
  KEY `fk_comande_idx` (`NumCommande`),
  CONSTRAINT `fk_article` FOREIGN KEY (`CodeArticle`) REFERENCES `articles` (`CodeArticle`),
  CONSTRAINT `fk_comande` FOREIGN KEY (`NumCommande`) REFERENCES `commandes` (`NumCommande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lignecommandes`
--

LOCK TABLES `lignecommandes` WRITE;
/*!40000 ALTER TABLE `lignecommandes` DISABLE KEYS */;
INSERT INTO `lignecommandes` VALUES (11,1,1),(12,1,1),(12,2,1),(12,3,1),(13,1,2),(14,1,4),(14,2,2);
/*!40000 ALTER TABLE `lignecommandes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-25 23:52:20
