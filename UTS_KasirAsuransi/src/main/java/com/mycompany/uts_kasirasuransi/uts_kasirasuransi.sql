-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2025 at 10:17 AM
-- Server version: 10.4.32-MariaDB-log
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uts_kasirasuransi`
--

-- --------------------------------------------------------

--
-- Table structure for table `klaim`
--

CREATE TABLE `klaim` (
  `id` int(11) NOT NULL,
  `polis_id` int(11) DEFAULT NULL,
  `tanggal` date NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `klaim`
--

INSERT INTO `klaim` (`id`, `polis_id`, `tanggal`, `status`) VALUES
(1, 1, '2025-05-12', 'Berhasil'),
(2, 2, '2025-05-12', 'Berhasil'),
(3, 3, '2025-05-12', 'Berhasil'),
(4, 4, '2025-05-13', 'Berhasil'),
(5, 5, '2025-05-13', 'Berhasil'),
(6, 6, '2025-05-13', 'Berhasil'),
(7, 7, '2025-05-13', 'Berhasil'),
(8, 8, '2025-05-13', 'Berhasil'),
(9, 9, '2025-05-13', 'Berhasil'),
(10, 10, '2025-05-13', 'Berhasil'),
(11, 11, '2025-05-13', 'Berhasil');

-- --------------------------------------------------------

--
-- Table structure for table `nasabah`
--

CREATE TABLE `nasabah` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `umur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nasabah`
--

INSERT INTO `nasabah` (`id`, `nama`, `umur`) VALUES
(1, 'sheila', 19),
(2, 'salsa', 20),
(3, 'alphin', 19),
(4, 'sela', 20),
(5, 'fitria', 21),
(6, 'dian', 23),
(7, 'kevin', 22),
(8, 'fatih', 20),
(9, 'piranti', 20),
(10, 'fatir', 20),
(11, 'salis', 21);

-- --------------------------------------------------------

--
-- Table structure for table `polis`
--

CREATE TABLE `polis` (
  `id` int(11) NOT NULL,
  `nasabah_id` int(11) DEFAULT NULL,
  `jenis` varchar(50) NOT NULL,
  `premi` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `polis`
--

INSERT INTO `polis` (`id`, `nasabah_id`, `jenis`, `premi`) VALUES
(1, 1, 'mata', 150.00),
(2, 2, 'perumahan', 200.00),
(3, 3, 'motor', 250.00),
(4, 4, 'gigi', 150.00),
(5, 5, 'mata', 150.00),
(6, 6, 'Dwiguna', 200.00),
(7, 7, 'Kuliah', 250.00),
(8, 8, 'jantung', 150.00),
(9, 9, 'mata', 150.00),
(10, 10, 'Universitas', 200.00),
(11, 11, 'dwipurna', 250.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `klaim`
--
ALTER TABLE `klaim`
  ADD PRIMARY KEY (`id`),
  ADD KEY `polis_id` (`polis_id`);

--
-- Indexes for table `nasabah`
--
ALTER TABLE `nasabah`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `polis`
--
ALTER TABLE `polis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nasabah_id` (`nasabah_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `klaim`
--
ALTER TABLE `klaim`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `nasabah`
--
ALTER TABLE `nasabah`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `polis`
--
ALTER TABLE `polis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `klaim`
--
ALTER TABLE `klaim`
  ADD CONSTRAINT `klaim_ibfk_1` FOREIGN KEY (`polis_id`) REFERENCES `polis` (`id`);

--
-- Constraints for table `polis`
--
ALTER TABLE `polis`
  ADD CONSTRAINT `polis_ibfk_1` FOREIGN KEY (`nasabah_id`) REFERENCES `nasabah` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
