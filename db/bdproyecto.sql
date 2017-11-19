CREATE DATABASE  IF NOT EXISTS `bdproyecto` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdproyecto`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdproyecto
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.25-MariaDB

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
-- Table structure for table `tbl_acudientes`
--

DROP TABLE IF EXISTS `tbl_acudientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_acudientes` (
  `id_acudiente` int(11) NOT NULL AUTO_INCREMENT,
  `parentesco` varchar(45) NOT NULL,
  `fk_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_acudiente`),
  KEY `fk_tbl_acudientes_tbl_usuarios1_idx` (`fk_id_usuario`),
  CONSTRAINT `fk_acudiente_usuario` FOREIGN KEY (`fk_id_usuario`) REFERENCES `tbl_usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_acudientes`
--

LOCK TABLES `tbl_acudientes` WRITE;
/*!40000 ALTER TABLE `tbl_acudientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_acudientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_asignaturas`
--

DROP TABLE IF EXISTS `tbl_asignaturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_asignaturas` (
  `idtbl_asignaturas` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idtbl_asignaturas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_asignaturas`
--

LOCK TABLES `tbl_asignaturas` WRITE;
/*!40000 ALTER TABLE `tbl_asignaturas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_asignaturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_calificaciones`
--

DROP TABLE IF EXISTS `tbl_calificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_calificaciones` (
  `id_calificaion` int(11) NOT NULL AUTO_INCREMENT,
  `nota` double DEFAULT NULL,
  `fk_estudiante_asignatura` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_calificaion`),
  KEY `fk_calificaciones_tbl_estudiantes_has_tbl_asignaturas1_idx` (`fk_estudiante_asignatura`),
  CONSTRAINT `fk_calificaciones_tbl_estudiantes_has_tbl_asignaturas1` FOREIGN KEY (`fk_estudiante_asignatura`) REFERENCES `tbl_estudiantes_has_tbl_asignaturas` (`id_estudiante_asignatura`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_calificaciones`
--

LOCK TABLES `tbl_calificaciones` WRITE;
/*!40000 ALTER TABLE `tbl_calificaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_calificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_constanciasacademicas`
--

DROP TABLE IF EXISTS `tbl_constanciasacademicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_constanciasacademicas` (
  `id_constancia_academica` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fk_id_secretaria` int(11) NOT NULL,
  PRIMARY KEY (`id_constancia_academica`),
  KEY `fk_tbl_constanciasAcademicas_tbl_secretaria1_idx` (`fk_id_secretaria`),
  CONSTRAINT `fk_tbl_constanciasAcademicas_tbl_secretaria1` FOREIGN KEY (`fk_id_secretaria`) REFERENCES `tbl_secretaria` (`id_secretaria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_constanciasacademicas`
--

LOCK TABLES `tbl_constanciasacademicas` WRITE;
/*!40000 ALTER TABLE `tbl_constanciasacademicas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_constanciasacademicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cursos`
--

DROP TABLE IF EXISTS `tbl_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cursos` (
  `id_curso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `grupo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_curso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cursos`
--

LOCK TABLES `tbl_cursos` WRITE;
/*!40000 ALTER TABLE `tbl_cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cursos_has_tbl_asignaturas`
--

DROP TABLE IF EXISTS `tbl_cursos_has_tbl_asignaturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_cursos_has_tbl_asignaturas` (
  `fk_id_curso` int(11) NOT NULL,
  `fk_id_asignatura` int(11) NOT NULL,
  PRIMARY KEY (`fk_id_curso`,`fk_id_asignatura`),
  KEY `fk_tbl_cursos_has_tbl_asignaturas_tbl_asignaturas1_idx` (`fk_id_asignatura`),
  KEY `fk_tbl_cursos_has_tbl_asignaturas_tbl_cursos_idx` (`fk_id_curso`),
  CONSTRAINT `fk_tbl_cursos_has_tbl_asignaturas_tbl_asignaturas1` FOREIGN KEY (`fk_id_asignatura`) REFERENCES `tbl_asignaturas` (`idtbl_asignaturas`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_cursos_has_tbl_asignaturas_tbl_cursos` FOREIGN KEY (`fk_id_curso`) REFERENCES `tbl_cursos` (`id_curso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cursos_has_tbl_asignaturas`
--

LOCK TABLES `tbl_cursos_has_tbl_asignaturas` WRITE;
/*!40000 ALTER TABLE `tbl_cursos_has_tbl_asignaturas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_cursos_has_tbl_asignaturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_docente`
--

DROP TABLE IF EXISTS `tbl_docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_docente` (
  `id_docente` int(11) NOT NULL AUTO_INCREMENT,
  `licenciatura` varchar(20) NOT NULL,
  `fk_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_docente`),
  KEY `fk_tbl_Docente_tbl_usuarios1_idx` (`fk_id_usuario`),
  CONSTRAINT `fk_docente_usuario` FOREIGN KEY (`fk_id_usuario`) REFERENCES `tbl_usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_docente`
--

LOCK TABLES `tbl_docente` WRITE;
/*!40000 ALTER TABLE `tbl_docente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_docente_has_tbl_cursos`
--

DROP TABLE IF EXISTS `tbl_docente_has_tbl_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_docente_has_tbl_cursos` (
  `fk_id_docente` int(11) NOT NULL,
  `fk_id_curso` int(11) NOT NULL,
  PRIMARY KEY (`fk_id_docente`,`fk_id_curso`),
  KEY `fk_tbl_Docente_has_tbl_cursos_tbl_cursos1_idx` (`fk_id_curso`),
  KEY `fk_tbl_Docente_has_tbl_cursos_tbl_Docente1_idx` (`fk_id_docente`),
  CONSTRAINT `fk_tbl_Docente_has_tbl_cursos_tbl_Docente1` FOREIGN KEY (`fk_id_docente`) REFERENCES `tbl_docente` (`id_docente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_Docente_has_tbl_cursos_tbl_cursos1` FOREIGN KEY (`fk_id_curso`) REFERENCES `tbl_cursos` (`id_curso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_docente_has_tbl_cursos`
--

LOCK TABLES `tbl_docente_has_tbl_cursos` WRITE;
/*!40000 ALTER TABLE `tbl_docente_has_tbl_cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_docente_has_tbl_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_estudiantes`
--

DROP TABLE IF EXISTS `tbl_estudiantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_estudiantes` (
  `id_estudiante` int(11) NOT NULL AUTO_INCREMENT,
  `observaciones` tinytext NOT NULL,
  `fk_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_estudiante`),
  KEY `fk_tbl_estudiantes_tbl_usuarios1_idx` (`fk_id_usuario`),
  CONSTRAINT `fk_tbl_estudiantes_tbl_usuarios1` FOREIGN KEY (`fk_id_usuario`) REFERENCES `tbl_usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_estudiantes`
--

LOCK TABLES `tbl_estudiantes` WRITE;
/*!40000 ALTER TABLE `tbl_estudiantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_estudiantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_estudiantes_has_tbl_asignaturas`
--

DROP TABLE IF EXISTS `tbl_estudiantes_has_tbl_asignaturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_estudiantes_has_tbl_asignaturas` (
  `id_estudiante_asignatura` int(11) NOT NULL AUTO_INCREMENT,
  `fk_id_estudiante` int(11) NOT NULL,
  `fk_id_asignatura` int(11) NOT NULL,
  PRIMARY KEY (`id_estudiante_asignatura`),
  KEY `fk_tbl_estudiantes_has_tbl_asignaturas_tbl_asignaturas1_idx` (`fk_id_asignatura`),
  KEY `fk_tbl_estudiantes_has_tbl_asignaturas_tbl_estudiantes1_idx` (`fk_id_estudiante`),
  CONSTRAINT `fk_tbl_estudiantes_has_tbl_asignaturas_tbl_asignaturas1` FOREIGN KEY (`fk_id_asignatura`) REFERENCES `tbl_asignaturas` (`idtbl_asignaturas`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_estudiantes_has_tbl_asignaturas_tbl_estudiantes1` FOREIGN KEY (`fk_id_estudiante`) REFERENCES `tbl_estudiantes` (`id_estudiante`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_estudiantes_has_tbl_asignaturas`
--

LOCK TABLES `tbl_estudiantes_has_tbl_asignaturas` WRITE;
/*!40000 ALTER TABLE `tbl_estudiantes_has_tbl_asignaturas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_estudiantes_has_tbl_asignaturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_secretaria`
--

DROP TABLE IF EXISTS `tbl_secretaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_secretaria` (
  `id_secretaria` int(11) NOT NULL AUTO_INCREMENT,
  `contrasena` varchar(45) NOT NULL,
  `fk_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_secretaria`),
  KEY `fk_tbl_secretaria_tbl_usuarios1_idx` (`fk_id_usuario`),
  CONSTRAINT `fk_secretaria` FOREIGN KEY (`fk_id_usuario`) REFERENCES `tbl_usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_secretaria`
--

LOCK TABLES `tbl_secretaria` WRITE;
/*!40000 ALTER TABLE `tbl_secretaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_secretaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuarios`
--

DROP TABLE IF EXISTS `tbl_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `identificacion` varchar(20) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `primerNombre` varchar(30) NOT NULL,
  `segundoNombre` varchar(30) DEFAULT NULL,
  `primerApellido` varchar(30) NOT NULL,
  `segundoApellido` varchar(30) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuarios`
--

LOCK TABLES `tbl_usuarios` WRITE;
/*!40000 ALTER TABLE `tbl_usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-19 14:44:17
