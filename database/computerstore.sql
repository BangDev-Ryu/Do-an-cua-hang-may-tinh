-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 19, 2024 at 08:56 AM
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
-- Database: `computerstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `baohanh`
--

CREATE TABLE `baohanh` (
  `id_kh` varchar(6) DEFAULT NULL,
  `ten_sp` varchar(50) NOT NULL,
  `serial` varchar(10) NOT NULL,
  `ngay_mua` date NOT NULL,
  `ngay_het_han` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `baohanh`
--

INSERT INTO `baohanh` (`id_kh`, `ten_sp`, `serial`, `ngay_mua`, `ngay_het_han`) VALUES
('KH001', 'Acer Aspire 7', 'SP001001', '2024-01-10', '2025-01-10'),
('KH001', 'Acer Aspire 7', 'SP001002', '2024-01-10', '2025-01-10'),
('KH001', 'MSI modern 15', 'SP002001', '2024-01-10', '2025-01-10'),
('KH002', 'Acer Nitro 5', 'SP003001', '2024-01-30', '2025-01-30'),
('KH002', 'Acer Nitro 5', 'SP003002', '2024-01-30', '2025-01-30'),
('KH003', 'ASUS Zenbook 14 OLED', 'SP004001', '2024-02-22', '2025-02-22'),
('KH003', 'ASUS Zenbook 14 OLED', 'SP004002', '2024-02-22', '2025-02-22'),
('KH003', 'ASUS Zenbook 14 OLED', 'SP004003', '2024-02-22', '2025-02-22'),
('KH003', 'ASUS Zenbook 14 OLED', 'SP004004', '2024-02-22', '2025-02-22'),
('KH003', 'ASUS Zenbook 14 OLED', 'SP004005', '2024-02-22', '2025-02-22'),
('KH001', 'ASUS Zenbook 14 OLED', 'SP004006', '2024-05-15', '2025-05-15'),
('KH001', 'ASUS Zenbook 14 OLED', 'SP004007', '2024-05-15', '2025-05-15'),
('KH001', 'ASUS Zenbook 14 OLED', 'SP004008', '2024-05-15', '2025-05-15'),
('KH001', 'ASUS Zenbook 14 OLED', 'SP004009', '2024-05-15', '2025-05-15'),
('KH001', 'ASUS Zenbook 14 OLED', 'SP004010', '2024-05-15', '2025-05-15'),
('KH003', 'ASUS ROG Zephyrus G14', 'SP005001', '2024-05-09', '2025-05-09'),
('KH003', 'ASUS ROG Zephyrus G14', 'SP005002', '2024-05-09', '2025-05-09'),
('KH003', 'ASUS ROG Zephyrus G14', 'SP005003', '2024-05-15', '2025-05-15'),
('KH003', 'LG Gram 2023', 'SP008001', '2024-05-09', '2025-05-09'),
('KH003', 'LG Gram 2023', 'SP008002', '2024-05-09', '2025-05-09'),
('KH003', 'LG Gram 2023', 'SP008003', '2024-05-09', '2025-05-09'),
('KH002', 'LG Gram 2023', 'SP008004', '2024-05-15', '2025-05-15'),
('KH002', 'LG Gram 2023', 'SP008005', '2024-05-15', '2025-05-15'),
('KH002', 'LG Gram 2023', 'SP008006', '2024-05-15', '2025-05-15'),
('KH002', 'LG Gram 2023', 'SP008007', '2024-05-15', '2025-05-15'),
('KH002', 'LG Gram 2023', 'SP008008', '2024-05-15', '2025-05-15'),
('KH002', 'LG Gram 2023', 'SP008009', '2024-05-15', '2025-05-15'),
('KH002', 'LG Gram 2023', 'SP008010', '2024-05-15', '2025-05-15'),
('KH002', 'LG Gram 2023', 'SP008011', '2024-05-15', '2025-05-15'),
('KH002', 'LG Gram 2023', 'SP008012', '2024-05-15', '2025-05-15'),
('KH002', 'LG Gram 2023', 'SP008013', '2024-05-15', '2025-05-15'),
('KH002', 'MacBook Air M1', 'SP009001', '2024-03-01', '2025-03-01'),
('KH002', 'MacBook Air M1', 'SP009002', '2024-03-01', '2025-03-01'),
('KH002', 'MacBook Air M1', 'SP009003', '2024-03-01', '2025-03-01'),
('KH002', 'MacBook Air M1', 'SP009004', '2024-03-01', '2025-03-01'),
('KH001', 'MacBook Air M1', 'SP009005', '2024-05-15', '2025-05-15'),
('KH002', 'MacBook Pro M2', 'SP010001', '2024-04-17', '2025-04-17'),
('KH002', 'MacBook Pro M2', 'SP010002', '2024-04-17', '2025-04-17'),
('KH001', 'MacBook Pro M2', 'SP010003', '2024-05-15', '2025-05-15'),
('KH002', 'MacBook Pro M5', 'SP010004', '2024-05-16', '2025-05-16'),
('KH003', 'MacBook Pro M5', 'SP010005', '2024-05-16', '2025-05-16'),
('KH003', 'MacBook Pro M5', 'SP010006', '2024-05-16', '2025-05-16'),
('KH003', 'MacBook Pro M5', 'SP010007', '2024-05-16', '2025-05-16'),
('KH003', 'MacBook Pro M5', 'SP010008', '2024-05-16', '2025-05-16'),
('KH002', 'abc', 'SP011001', '2024-05-16', '2025-05-16');

-- --------------------------------------------------------

--
-- Table structure for table `cthoadon`
--

CREATE TABLE `cthoadon` (
  `id_hd` varchar(6) NOT NULL,
  `id_sp` varchar(6) NOT NULL,
  `ten_sp` varchar(50) NOT NULL,
  `so_luong` int(11) NOT NULL,
  `don_gia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `cthoadon`
--

INSERT INTO `cthoadon` (`id_hd`, `id_sp`, `ten_sp`, `so_luong`, `don_gia`) VALUES
('HD001', 'SP001', 'Acer Aspire 7', 2, 15000),
('HD001', 'SP002', 'MSI modern 15', 1, 12000),
('HD002', 'SP009', 'MacBook Air M1', 4, 30990),
('HD002', 'SP010', 'MacBook Pro M2', 2, 39999),
('HD003', 'SP004', 'ASUS Zenbook 14 OLED', 5, 20000),
('HD004', 'SP009', 'MacBook Air M1', 1, 30990),
('HD005', 'SP003', 'Acer Nitro 5', 2, 20000),
('HD006', 'SP005', 'ASUS ROG Zephyrus G14', 2, 50000),
('HD006', 'SP008', 'LG Gram 2023', 3, 27000),
('HD007', 'SP004', 'ASUS Zenbook 14 OLED', 5, 20000),
('HD008', 'SP008', 'LG Gram 2023', 10, 27000),
('HD009', 'SP010', 'MacBook Pro M2', 1, 39999),
('HD010', 'SP005', 'ASUS ROG Zephyrus G14', 1, 50000),
('HD011', 'SP010', 'MacBook Pro M5', 1, 39999),
('HD011', 'SP011', 'abc', 1, 1000),
('HD012', 'SP010', 'MacBook Pro M5', 4, 39999);

-- --------------------------------------------------------

--
-- Table structure for table `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `id_pn` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id_sp` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ten_sp` varchar(50) NOT NULL,
  `so_luong` int(5) NOT NULL,
  `don_gia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ctphieunhap`
--

INSERT INTO `ctphieunhap` (`id_pn`, `id_sp`, `ten_sp`, `so_luong`, `don_gia`) VALUES
('PN001', 'SP001', 'Acer Aspire 7', 5, 7500),
('PN001', 'SP007', 'Dell Vostro 3530', 5, 7000),
('PN001', 'SP008', 'LG Gram 2023', 5, 13500),
('PN002', 'SP002', 'MSI modern 15', 10, 6000),
('PN003', 'SP008', 'LG Gram 2023', 18, 16200),
('PN004', 'SP006', 'Dell Inspiron 15', 18, 6500),
('PN005', 'SP010', 'MacBook Pro M2', 7, 8000),
('PN006', 'SP004', 'ASUS Zenbook 14 OLED', 15, 8000),
('PN007', 'SP003', 'Acer Nitro 5', 10, 14000),
('PN008', 'SP001', 'Acer Aspire 7', 12, 9000),
('PN009', 'SP007', 'Dell Vostro 3530', 5, 7000),
('PN010', 'SP005', 'ASUS ROG Zephyrus G14', 2, 10000),
('PN011', 'SP009', 'MacBook Air M1', 1, 6198),
('PN012', 'SP010', 'MacBook Pro M2', 1, 8000),
('PN013', 'SP001', 'Acer Aspire 7', 1, 7500),
('PN013', 'SP002', 'MSI modern 15', 1, 6000),
('PN013', 'SP011', 'abc', 100, 500);

-- --------------------------------------------------------

--
-- Table structure for table `ctquyenchucnang`
--

CREATE TABLE `ctquyenchucnang` (
  `id_quyen` varchar(10) NOT NULL,
  `id_chuc_nang` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `ctquyenchucnang`
--

INSERT INTO `ctquyenchucnang` (`id_quyen`, `id_chuc_nang`) VALUES
('QU001', '00'),
('QU001', '01'),
('QU001', '02'),
('QU001', '03'),
('QU001', '04'),
('QU001', '05'),
('QU001', '06'),
('QU001', '07'),
('QU001', '08'),
('QU001', '09'),
('QU001', '10'),
('QU001', '11'),
('QU001', '12'),
('QU001', '13'),
('QU001', '14'),
('QU001', '15'),
('QU001', '16'),
('QU001', '20'),
('QU001', '21'),
('QU001', '22'),
('QU001', '23'),
('QU001', '24'),
('QU001', '30'),
('QU001', '31'),
('QU001', '32'),
('QU001', '33'),
('QU001', '34'),
('QU002', '01'),
('QU002', '03'),
('QU002', '05'),
('QU002', '07'),
('QU002', '11'),
('QU002', '21'),
('QU002', '33'),
('QU003', '00'),
('QU003', '02'),
('QU003', '03'),
('QU003', '06'),
('QU003', '08'),
('QU003', '10'),
('QU003', '12'),
('QU003', '13'),
('QU003', '16'),
('QU003', '20'),
('QU003', '22'),
('QU003', '23'),
('QU003', '30'),
('QU003', '32'),
('QU003', '33'),
('QU004', '00'),
('QU004', '04'),
('QU004', '10'),
('QU004', '14'),
('QU004', '20'),
('QU004', '24'),
('QU004', '30'),
('QU004', '34'),
('QU005', '00'),
('QU005', '04'),
('QU005', '10'),
('QU005', '14'),
('QU005', '20'),
('QU005', '24'),
('QU005', '34'),
('QU006', '00'),
('QU006', '01'),
('QU006', '02'),
('QU006', '03'),
('QU006', '13');

-- --------------------------------------------------------

--
-- Table structure for table `ctsanpham`
--

CREATE TABLE `ctsanpham` (
  `id_sp` varchar(6) NOT NULL,
  `serial` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `ctsanpham`
--

INSERT INTO `ctsanpham` (`id_sp`, `serial`) VALUES
('SP001', 'SP001001'),
('SP001', 'SP001002'),
('SP002', 'SP002001'),
('SP003', 'SP003001'),
('SP003', 'SP003002'),
('SP004', 'SP004001'),
('SP004', 'SP004002'),
('SP004', 'SP004003'),
('SP004', 'SP004004'),
('SP004', 'SP004005'),
('SP004', 'SP004006'),
('SP004', 'SP004007'),
('SP004', 'SP004008'),
('SP004', 'SP004009'),
('SP004', 'SP004010'),
('SP005', 'SP005001'),
('SP005', 'SP005002'),
('SP005', 'SP005003'),
('SP008', 'SP008001'),
('SP008', 'SP008002'),
('SP008', 'SP008003'),
('SP008', 'SP008004'),
('SP008', 'SP008005'),
('SP008', 'SP008006'),
('SP008', 'SP008007'),
('SP008', 'SP008008'),
('SP008', 'SP008009'),
('SP008', 'SP008010'),
('SP008', 'SP008011'),
('SP008', 'SP008012'),
('SP008', 'SP008013'),
('SP009', 'SP009001'),
('SP009', 'SP009002'),
('SP009', 'SP009003'),
('SP009', 'SP009004'),
('SP009', 'SP009005'),
('SP010', 'SP010001'),
('SP010', 'SP010002'),
('SP010', 'SP010003'),
('SP010', 'SP010004'),
('SP010', 'SP010005'),
('SP010', 'SP010006'),
('SP010', 'SP010007'),
('SP010', 'SP010008'),
('SP011', 'SP011001');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `id_hd` varchar(6) NOT NULL,
  `id_kh` varchar(6) DEFAULT NULL,
  `id_user` varchar(6) DEFAULT NULL,
  `ngay_xuat` date NOT NULL,
  `tong_tien` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`id_hd`, `id_kh`, `id_user`, `ngay_xuat`, `tong_tien`) VALUES
('HD001', 'KH001', 'US001', '2024-01-10', 42000),
('HD002', 'KH002', 'US001', '2024-01-30', 203958),
('HD003', 'KH003', 'US001', '2024-02-22', 100000),
('HD004', 'KH001', 'US001', '2024-03-01', 30990),
('HD005', 'KH002', 'US001', '2024-04-17', 40000),
('HD006', 'KH003', 'US001', '2024-05-09', 181000),
('HD007', 'KH001', 'US001', '2024-05-15', 100000),
('HD008', 'KH002', 'US001', '2024-05-15', 270000),
('HD009', 'KH001', 'US001', '2024-05-15', 39999),
('HD010', 'KH003', 'US001', '2024-05-15', 50000),
('HD011', 'KH002', 'US001', '2024-05-16', 40999),
('HD012', 'KH003', 'US001', '2024-05-16', 159996);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `id` varchar(6) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `dia_chi` varchar(50) NOT NULL,
  `sdt` varchar(15) DEFAULT NULL,
  `enable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`id`, `ten`, `dia_chi`, `sdt`, `enable`) VALUES
('KH001', 'Võ Kim Bằng', 'abc, 123, xyz', '911', 1),
('KH002', 'Donald Trump', 'Korean', '0666999', 1),
('KH003', 'Vangogh', 'India', '113 ', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `id` varchar(6) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `dia_chi` varchar(60) NOT NULL,
  `sdt` varchar(15) NOT NULL,
  `enable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`id`, `ten`, `dia_chi`, `sdt`, `enable`) VALUES
('CC001', 'Công Ty TNHH Điều Khiển Tự Động An Phát', '86/21 Phan Tây Hồ, P. 7, Q. Phú Nhuận TP. Hồ Chí Minh', '02835109735', 1),
('CC002', 'Công Ty TNHH Thương Mại Dịch Vụ Hoàng Cố Đô', '622/16/5 Cộng Hòa, Phường 13, Quận Tân Bình, TP HCM', '02838115345', 1),
('CC003', 'Công Ty Cổ Phần Bán Lẻ Kỹ Thuật Số FPT', '261 - 263 Khánh Hội, P2, Q4, TP. Hồ Chí Minh', '02873023456', 1),
('CC004', 'Công ty Cổ phần đầu tư công nghệ HACOM', 'Số 129-131, phố Lê Thanh Nghị, Phường Đồng Tâm, Quận Hai Bà ', '1900 1903', 1),
('CC005', 'Công Ty TNHH Thương Mại Hoàng Phát Hải Phòng', 'Số 4, Lô 2A Lê Hồng Phong, Ngô Quyền, Tp. Hải Phòng', '02253250888', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `id_pn` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id_ncc` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id_user` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngay_nhap` date NOT NULL,
  `tong_tien` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`id_pn`, `id_ncc`, `id_user`, `ngay_nhap`, `tong_tien`) VALUES
('PN001', 'CC001', 'US001', '2024-01-09', 140000),
('PN002', 'CC001', 'US001', '2024-01-31', 60000),
('PN003', 'CC002', 'US001', '2024-02-08', 291600),
('PN004', 'CC003', 'US001', '2024-02-28', 117000),
('PN005', 'CC005', 'US001', '2024-03-05', 56000),
('PN006', 'CC005', 'US001', '2024-04-02', 120000),
('PN007', 'CC004', 'US001', '2024-04-16', 140000),
('PN008', 'CC005', 'US001', '2024-04-28', 108000),
('PN009', 'CC001', 'US001', '2024-05-03', 35000),
('PN010', 'CC005', 'US001', '2024-05-16', 20000),
('PN011', 'CC004', 'US001', '2024-05-16', 6198),
('PN012', 'CC001', 'US001', '2024-05-16', 8000),
('PN013', 'CC003', 'US001', '2024-05-16', 63500);

-- --------------------------------------------------------

--
-- Table structure for table `quyen`
--

CREATE TABLE `quyen` (
  `id` varchar(10) NOT NULL,
  `ten` varchar(50) DEFAULT NULL,
  `enable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `quyen`
--

INSERT INTO `quyen` (`id`, `ten`, `enable`) VALUES
('QU001', 'Admin', 1),
('QU002', 'Nhân viên bán hàng', 1),
('QU003', 'Nhân viên nhập hàng', 1),
('QU004', 'Quản lý nhân viên', 1),
('QU005', 'abc', 1),
('QU006', '123', 0);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id` varchar(5) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `gia_ban` int(11) DEFAULT NULL,
  `hang` varchar(50) NOT NULL,
  `img` varchar(50) DEFAULT NULL,
  `enable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `ten`, `so_luong`, `gia_ban`, `hang`, `img`, `enable`) VALUES
('SP001', 'Acer Aspire 7', 31, 15000, 'Acer', 'SP001.png', 1),
('SP002', 'MSI modern 15', 21, 12000, 'MSI', 'SP002.png', 1),
('SP003', 'Acer Nitro 5', 20, 20000, 'Acer', 'SP003.png', 1),
('SP004', 'ASUS Zenbook 14 OLED', 20, 20000, 'Asus', 'SP004.png', 1),
('SP005', 'ASUS ROG Zephyrus G14', 16, 50000, 'Asus', 'SP005.png', 1),
('SP006', 'Dell Inspiron 15', 30, 13000, 'Dell', 'SP006.png', 1),
('SP007', 'Dell Vostro 3530', 20, 14000, 'Dell', 'SP007.png', 1),
('SP008', 'LG Gram 2023', 20, 27000, 'LG', 'SP008.png', 1),
('SP009', 'MacBook Air M1', 20, 30990, 'Mac', 'SP009.png', 1),
('SP010', 'MacBook Pro M5', 20, 39999, 'Mac', 'SP010.png', 1),
('SP011', 'abc', 99, 1000, 'Mac', 'SP011.png', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(6) NOT NULL,
  `password` varchar(50) NOT NULL,
  `ten` varchar(50) DEFAULT NULL,
  `gioi_tinh` varchar(5) DEFAULT NULL,
  `sdt` varchar(15) DEFAULT NULL,
  `quyen` varchar(50) NOT NULL,
  `img` varchar(50) DEFAULT NULL,
  `enable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `ten`, `gioi_tinh`, `sdt`, `quyen`, `img`, `enable`) VALUES
('US001', 'admin', 'Admin', 'Nam', '911', 'QU001', 'US001.png', 1),
('US002', '123', 'nhan vien 1', 'Nữ', '6666', 'QU005', 'US002.png', 1),
('US003', '123', 'nv2', 'Nam', '12345', 'QU004', 'US003.png', 1),
('US004', '123', 'abc', 'Nữ', '11', 'QU002', 'US004.png', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `baohanh`
--
ALTER TABLE `baohanh`
  ADD PRIMARY KEY (`serial`);

--
-- Indexes for table `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD PRIMARY KEY (`id_hd`,`id_sp`),
  ADD KEY `id_hd` (`id_hd`,`id_sp`);

--
-- Indexes for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD PRIMARY KEY (`id_pn`,`id_sp`),
  ADD KEY `id_pn` (`id_pn`,`id_sp`);

--
-- Indexes for table `ctquyenchucnang`
--
ALTER TABLE `ctquyenchucnang`
  ADD PRIMARY KEY (`id_quyen`,`id_chuc_nang`);

--
-- Indexes for table `ctsanpham`
--
ALTER TABLE `ctsanpham`
  ADD PRIMARY KEY (`id_sp`,`serial`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id_hd`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`id_pn`);

--
-- Indexes for table `quyen`
--
ALTER TABLE `quyen`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
