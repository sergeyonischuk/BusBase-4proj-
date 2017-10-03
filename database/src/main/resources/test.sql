DROP TABLE IF EXISTS `applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applications` (
  `id` int(11) NOT NULL,
  `route_id` int(11) NOT NULL,
  `grade` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `app_grade_idx` (`grade`),
  KEY `app_status_idx` (`status`),
  CONSTRAINT `app_grade` FOREIGN KEY (`grade`) REFERENCES `grades` (`level`) ON UPDATE CASCADE,
  CONSTRAINT `app_status` FOREIGN KEY (`status`) REFERENCES `status_values` (`value`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `buses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buses` (
  `number` varchar(8) NOT NULL,
  `model` varchar(45) NOT NULL,
  `grade` varchar(45) NOT NULL,
  `condition` varchar(45) NOT NULL,
  PRIMARY KEY (`number`),
  UNIQUE KEY `number_UNIQUE` (`number`),
  KEY `bus-model_idx` (`model`),
  KEY `bus-grade_idx` (`grade`),
  KEY `bus-condition_idx` (`condition`),
  CONSTRAINT `bus-condition` FOREIGN KEY (`condition`) REFERENCES `conditions` (`condition`) ON UPDATE CASCADE,
  CONSTRAINT `bus-grade` FOREIGN KEY (`grade`) REFERENCES `grades` (`level`) ON UPDATE CASCADE,
  CONSTRAINT `bus-model` FOREIGN KEY (`model`) REFERENCES `model` (`name`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cities` (
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `conditions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conditions` (
  `condition` varchar(45) NOT NULL,
  PRIMARY KEY (`condition`),
  UNIQUE KEY `idconditions_UNIQUE` (`condition`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `confirmed_applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `confirmed_applications` (
  `application_id` int(11) NOT NULL,
  `driver_id` varchar(8) NOT NULL,
  PRIMARY KEY (`application_id`),
  UNIQUE KEY `application_id_UNIQUE` (`application_id`),
  KEY `confirmed_driver_idx` (`driver_id`),
  CONSTRAINT `confirmed_app` FOREIGN KEY (`application_id`) REFERENCES `applications` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `confirmed_driver` FOREIGN KEY (`driver_id`) REFERENCES `driver_bus` (`driver_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `driver_bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver_bus` (
  `driver_id` varchar(8) NOT NULL,
  `bus_id` varchar(8) NOT NULL,
  PRIMARY KEY (`driver_id`),
  UNIQUE KEY `bus_id_UNIQUE` (`bus_id`),
  UNIQUE KEY `driver_id_UNIQUE` (`driver_id`),
  CONSTRAINT `driver_bus-driver` FOREIGN KEY (`driver_id`) REFERENCES `drivers` (`id_pasport`) ON UPDATE CASCADE,
  CONSTRAINT `driver_bus_bus` FOREIGN KEY (`bus_id`) REFERENCES `buses` (`number`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `drivers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drivers` (
  `id_pasport` varchar(8) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  PRIMARY KEY (`id_pasport`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grades` (
  `level` varchar(45) NOT NULL,
  PRIMARY KEY (`level`),
  UNIQUE KEY `level_UNIQUE` (`level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `model` (
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `routes` (
  `id` int(11) NOT NULL,
  `city_dispatch` varchar(45) NOT NULL,
  `city_destination` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `asd_idx` (`city_dispatch`),
  KEY `dest_city_idx` (`city_destination`),
  CONSTRAINT `dest_city` FOREIGN KEY (`city_destination`) REFERENCES `cities` (`name`) ON UPDATE CASCADE,
  CONSTRAINT `disp_city` FOREIGN KEY (`city_dispatch`) REFERENCES `cities` (`name`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;\

DROP TABLE IF EXISTS `status_values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status_values` (
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`value`),
  UNIQUE KEY `value_UNIQUE` (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `user_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_types` (
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`type`),
  UNIQUE KEY `type_UNIQUE` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`login`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  KEY `users_users-type_idx` (`type`),
  CONSTRAINT `users_users-type` FOREIGN KEY (`type`) REFERENCES `user_types` (`type`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;