-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2023 at 05:05 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `retail_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(10) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `State` varchar(50) NOT NULL,
  `ZipCode` int(10) NOT NULL,
  `ContactNo` int(11) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `FirstName`, `LastName`, `Street`, `City`, `State`, `ZipCode`, `ContactNo`, `Username`, `Password`) VALUES
(1, 'dee', 'tee', 'n bacalso', 'cebu', 'phil', 6000, 232232, 'kapoy', '123'),
(2, 'Paulo', 'Carabuena', 'Purok', 'Naga', 'Abra', 6037, 2147483647, 'pawekz', '1234'),
(6, 'Donna', 'Topacio', 'Mambalin', 'Cebu', 'Cebu', 6000, 0, 'donnat1', '1234'),
(7, 'John', 'Demoral', 'asda', 'Cebu', 'region Voo', 6000, 999999, 'vanilogical', '1234'),
(8, 'Luke', 'Stanley', 'F Llamas', 'Cebu', 'Region VII', 6000, 2147483647, 'luke', '1234'),
(9, 'Almira', 'Legaspina', 'Purok Bungturan, Sitio Sto. Nino, Barangay Inayaga', 'Naga City, Central Visayas', 'Abra', 6037, 2147483647, 'mhira', 'mhira123');

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

CREATE TABLE `delivery` (
  `DeliveryReceiptID` int(10) NOT NULL,
  `DeliveryAddress` varchar(255) NOT NULL,
  `DeliveryDate` date NOT NULL,
  `DeliveryStatus` varchar(255) NOT NULL,
  `CustomerID` int(10) NOT NULL,
  `TransactionID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orderhistory`
--

CREATE TABLE `orderhistory` (
  `OrderID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `TransactionID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderhistory`
--

INSERT INTO `orderhistory` (`OrderID`, `ProductID`, `TransactionID`, `Quantity`) VALUES
(74, 0, 34, 4),
(75, 3, 34, 5),
(76, 3, 35, 8),
(77, 7, 36, 2),
(78, 3, 37, 2),
(79, 7, 37, 6),
(80, 0, 38, 1),
(81, 3, 38, 4),
(83, 0, 40, 6),
(84, 7, 40, 6);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ProductID` int(10) NOT NULL,
  `ProductName` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `NoOfRemainingStocks` int(255) NOT NULL,
  `Price` int(255) NOT NULL,
  `Quantity` int(255) NOT NULL,
  `SupplierID` int(10) NOT NULL,
  `loyaltyPoint` int(10) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductID`, `ProductName`, `Description`, `NoOfRemainingStocks`, `Price`, `Quantity`, `SupplierID`, `loyaltyPoint`) VALUES
(0, 'RTX A6000', 'A6000 Professional Video Card', 12, 123112, 23, 2, 60),
(1, 'RTX 3050', 'RTX 3050 6GB 128bit', 32, 23234, 55, 1, 12),
(3, 'KINGSTON 8GB RAM DDR4 SODIMM', 'KINGSTON 8GB DDR4 RAM FOR DESKTOP', 32, 2313, 23, 1, 3),
(7, 'RTX 6090 TITAN', 'HAIR GEL GPU 69GB RAM 9999 TENSOR CORES', 32, 567452, 0, 2, 100);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `SupplierID` int(10) NOT NULL,
  `SupplierName` varchar(255) NOT NULL,
  `Street` varchar(255) NOT NULL,
  `City` varchar(255) NOT NULL,
  `State` varchar(255) NOT NULL,
  `ZipCode` int(5) NOT NULL,
  `TelephoneNo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`SupplierID`, `SupplierName`, `Street`, `City`, `State`, `ZipCode`, `TelephoneNo`) VALUES
(1, 'NUTECH', 'COLON', 'Cebu', 'Region VII', 6000, 123123),
(2, 'VSTECH', 'Cebu', 'Cebu', 'Region VII', 6000, 123435678);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `TransactionID` int(10) NOT NULL,
  `PurchaseDate` datetime(6) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `TotalPrice` int(255) NOT NULL,
  `LoyaltyPoints` int(255) NOT NULL,
  `CustomerID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`TransactionID`, `PurchaseDate`, `Quantity`, `TotalPrice`, `LoyaltyPoints`, `CustomerID`) VALUES
(34, '2023-12-15 11:55:55.000000', 9, 504013, 255, 1),
(35, '2023-12-15 11:56:03.000000', 8, 18504, 24, 2),
(36, '2023-12-15 11:56:10.000000', 2, 1134904, 200, 1),
(37, '2023-12-15 11:56:24.000000', 8, 3409338, 606, 6),
(38, '2023-12-15 11:56:36.000000', 5, 132364, 72, 7),
(40, '2023-12-15 12:01:16.000000', 12, 4143384, 960, 9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`DeliveryReceiptID`),
  ADD KEY `delivery_idfk_1` (`CustomerID`),
  ADD KEY `delivery_idfk_2` (`TransactionID`);

--
-- Indexes for table `orderhistory`
--
ALTER TABLE `orderhistory`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `ProductID` (`ProductID`),
  ADD KEY `TransactionID` (`TransactionID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductID`),
  ADD KEY `product_ibfk_1` (`SupplierID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`SupplierID`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`TransactionID`),
  ADD KEY `transaction_idfk_1` (`CustomerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orderhistory`
--
ALTER TABLE `orderhistory`
  MODIFY `OrderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `SupplierID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `TransactionID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `delivery_idfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`),
  ADD CONSTRAINT `delivery_idfk_2` FOREIGN KEY (`TransactionID`) REFERENCES `transaction` (`TransactionID`);

--
-- Constraints for table `orderhistory`
--
ALTER TABLE `orderhistory`
  ADD CONSTRAINT `orderhistory_ibfk_1` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  ADD CONSTRAINT `orderhistory_ibfk_2` FOREIGN KEY (`TransactionID`) REFERENCES `transaction` (`TransactionID`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`SupplierID`) REFERENCES `supplier` (`SupplierID`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_idfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
