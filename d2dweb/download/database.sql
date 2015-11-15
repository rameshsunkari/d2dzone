CREATE TABLE `userinfo` (
  `emailId` varchar(255) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emailId`,`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
