-- phpMyAdmin SQL Dump
-- version 4.2.7
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Jun 17, 2016 at 10:11 PM
-- Server version: 5.6.17-debug-log
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `kindergarten`
--

-- --------------------------------------------------------

--
-- Table structure for table `classroom`
--

CREATE TABLE IF NOT EXISTS `classroom` (
  `classroomID` varchar(2) NOT NULL,
  `classroomName` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classroom`
--

INSERT INTO `classroom` (`classroomID`, `classroomName`) VALUES
('C1', 'class A'),
('C2', 'class B'),
('C3', 'class C');

-- --------------------------------------------------------

--
-- Table structure for table `ranking`
--

CREATE TABLE IF NOT EXISTS `ranking` (
  `studentID` int(5) NOT NULL,
  `ranking` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE IF NOT EXISTS `result` (
  `resultID` varchar(4) NOT NULL,
  `studentID` varchar(4) NOT NULL,
  `markBm` int(3) NOT NULL,
  `markMath` int(3) NOT NULL,
  `mathArt` int(3) NOT NULL,
  `markBi` int(3) NOT NULL,
  `totalMark` int(11) NOT NULL,
  `percentage` double NOT NULL,
  `comment` varchar(150) NOT NULL,
  `grade` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`resultID`, `studentID`, `markBm`, `markMath`, `mathArt`, `markBi`, `totalMark`, `percentage`, `comment`, `grade`) VALUES
('R1', 'S101', 100, 100, 100, 100, 400, 100, 'GOOD', 'A+'),
('R2', 'S102', 80, 80, 80, 80, 360, 80, 'Great', 'ni');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `studentID` varchar(4) NOT NULL,
  `classroomID` varchar(2) NOT NULL,
  `studentName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentID`, `classroomID`, `studentName`) VALUES
('S101', 'C1', 'MUHAMMAD HAZIQ BIN HAKIMI'),
('S102', 'C1', 'SITI NUR ZAHIRAH BINTI AHMAD ZAINI'),
('S103', 'C1', 'MUHAMMAD DANIEL BIN AHMAD ADAM'),
('S104', 'C1', 'NUR ARIFF RAYYAN BIN MOHD UMAR'),
('S105', 'C1', 'NUR QALISYA BINTI MUHD ZAKI'),
('S201', 'C2', 'IRIS KEISHA BINTI AHMAD AIMAN'),
('S202', 'C2', 'NUR ALYA HUMAIRAH BINTI HARRIS'),
('S203', 'C2', 'MUHAMMAD ARRYAN BIN MUHAMMAD '),
('S204', 'C2', 'WAN ASHRAF BI WAN AIMAN'),
('S205', 'C2', 'AQIL AMSYAR BIN SAIFUL ANWAR'),
('S301', 'C3', 'DANISH HAIKAL BIN OMAR NAUFAL'),
('S302', 'C3', 'AHMAD ARYAN BIN AHMAD IHSAN'),
('S303', 'C3', 'ZUL ARYAN AQIF BIN ZUL LATIF'),
('S304', 'C3', 'DHIA MARISSA BIN MUHAMMAD SALLEH'),
('S305', 'C3', 'SITI IRDINA HUSNA BINTI MUHAMMAD ZARIFF');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `classroom`
--
ALTER TABLE `classroom`
 ADD PRIMARY KEY (`classroomID`);

--
-- Indexes for table `result`
--
ALTER TABLE `result`
 ADD PRIMARY KEY (`resultID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`studentID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
