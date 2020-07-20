-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 24, 2020 at 03:16 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `collegemanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin1', 'admin123'),
('admin2', 'admin234');

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
CREATE TABLE IF NOT EXISTS `marks` (
  `rollno` int(10) NOT NULL,
  `marks1` float DEFAULT '0',
  `marks2` float DEFAULT '0',
  `marks3` float DEFAULT '0',
  `marks4` float DEFAULT '0',
  `marks5` float DEFAULT '0',
  PRIMARY KEY (`rollno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`rollno`, `marks1`, `marks2`, `marks3`, `marks4`, `marks5`) VALUES
(22002, 80, 90, 75, 90, 80),
(22001, 70, 80, 80, 90, 80),
(22005, 70, 80, 80, 90, 90),
(22003, 70, 80, 80, 85, 75);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `name` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `empid` int(10) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `address` text NOT NULL,
  `contactno` bigint(12) NOT NULL,
  `email` varchar(20) NOT NULL,
  `designation` varchar(20) NOT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`name`, `username`, `empid`, `dob`, `address`, `contactno`, `email`, `designation`) VALUES
('Gopal Das', 'gopaldas', 44001, '04/03/1980', 'Silchar', 9978664533, 'gd@gmail.com', 'Lab Assistant');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `name` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `rollno` int(10) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `address` text NOT NULL,
  `contactno` bigint(12) NOT NULL,
  `email` varchar(20) NOT NULL,
  `stream` varchar(10) NOT NULL,
  `standard` int(2) NOT NULL DEFAULT '11',
  PRIMARY KEY (`rollno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`name`, `username`, `rollno`, `dob`, `address`, `contactno`, `email`, `stream`, `standard`) VALUES
('Abhishek Sengupta', 'abhisheksg', 22003, '04/04/1996', 'Guwahati', 9989776755, 'asg@gmail.com', 'Commerce', 11),
('Jay Debnath', 'jaydeb', 22002, '05/03/1996', 'Tezpur', 9987665431, 'jd@gmail.com', 'Science', 12),
('Abhishek Das', 'abhidas', 22005, '05/06/1996', 'Tezpur', 8978675645, 'ad@gmail.com', 'Science', 12);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
CREATE TABLE IF NOT EXISTS `subject` (
  `rollno` int(10) NOT NULL,
  `subject1` varchar(20) NOT NULL,
  `subject2` varchar(20) NOT NULL,
  `subject3` varchar(20) NOT NULL,
  `subject4` varchar(20) NOT NULL,
  `subject5` varchar(20) NOT NULL,
  PRIMARY KEY (`rollno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`rollno`, `subject1`, `subject2`, `subject3`, `subject4`, `subject5`) VALUES
(22002, 'Physics', 'Chemistry', 'Mathematics', 'Biology', 'English'),
(22001, 'Accountancy', 'Economics', 'Business Studies', 'Management', 'Banking'),
(22005, 'Physics', 'Chemistry', 'Maths', 'English', 'Biology'),
(22003, 'Accountancy', 'Business Studies', 'Banking', 'Economics', 'Statistics');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `name` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `empid` int(10) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `address` text NOT NULL,
  `contactno` bigint(12) NOT NULL,
  `email` varchar(20) NOT NULL,
  `department` varchar(20) NOT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`name`, `username`, `empid`, `dob`, `address`, `contactno`, `email`, `department`) VALUES
('Rosy Sharma', 'rosysh', 33001, '03/03/1985', 'Tezpur', 9887766554, 'rs@gmail.com', 'Computer Science');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
