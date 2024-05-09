-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 09, 2024 at 08:05 AM
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
-- Table structure for table `cthoadon`
--

CREATE TABLE `cthoadon` (
  `id_hd` varchar(6) NOT NULL,
  `id_sp` varchar(6) NOT NULL,
  `ten_sp` varchar(50) NOT NULL,
  `serial_sp` varchar(13) NOT NULL,
  `so_luong` int(11) NOT NULL,
  `don_gia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `cthoadon`
--

INSERT INTO `cthoadon` (`id_hd`, `id_sp`, `ten_sp`, `serial_sp`, `so_luong`, `don_gia`) VALUES
('HD001', 'SP001', 'Acer Aspire 7', 'AAA', 1, 15000000),
('HD002', 'SP010', 'MacBook Pro M2', 'AAA', 1, 39999000),
('HD003', 'SP001', 'Acer Aspire 7', 'AAA', 1, 15000000),
('HD003', 'SP002', 'MSI modern 15', 'AAA', 1, 12000000),
('HD003', 'SP003', 'Acer Nitro 5', 'AAA', 1, 20000000),
('HD004', 'SP006', 'Dell Inspiron 15', 'AAA', 1, 13000000),
('HD004', 'SP008', 'LG Gram 2023', 'AAA', 2, 27000000),
('HD005', 'SP004', 'ASUS Zenbook 14 OLED', 'AAA', 1, 20000000),
('HD006', 'SP001', 'Acer Aspire 7', 'AAA', 5, 15000000),
('HD007', 'SP008', 'LG Gram 2023', 'AAA', 4, 27000000),
('HD007', 'SP009', 'MacBook Air M1', 'AAA', 1, 30999000),
('HD008', 'SP002', 'MSI modern 15', 'AAA', 2, 12000000);

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
('PN001', 'SP007', 'Dell Vostro 3530', 3, 14000000),
('PN002', 'SP001', 'Acer Aspire 7', 1, 9000000),
('PN002', 'SP002', 'MSI modern 15', 1, 7200000),
('PN003', 'SP008', 'LG Gram 2023', 10, 0);

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
('HD001', 'KH003', '', '2024-05-01', 15000000),
('HD002', 'KH002', '', '2024-05-02', 39999000),
('HD003', 'KH001', '', '2024-05-03', 47000000),
('HD004', 'KH003', '', '2024-05-03', 67000000),
('HD005', '', '', '2024-05-05', 20000000),
('HD006', 'KH003', '', '2024-05-05', 75000000),
('HD007', '', '', '2024-05-08', 138999000),
('HD008', '', '', '2024-05-08', 24000000);

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
('KH001', 'Võ Kim Bằng', 'abc, 123, xyz', '09221101923', 1),
('KH002', 'Donald Trump', 'USA', '0666999', 1),
('KH003', 'Vangogh', 'Italy', '09111', 1);

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
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `id` varchar(6) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `dia_chi` varchar(60) NOT NULL,
  `sdt` varchar(13) DEFAULT NULL,
  `gioi_tinh` varchar(5) NOT NULL,
  `img` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`id`, `ten`, `dia_chi`, `sdt`, `gioi_tinh`, `img`) VALUES
('NV001', 'abc', 'qweqwe', '011111', 'Nam', 'NV001.png');

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
('PN001', 'CC005', '', '2024-05-08', 42000000),
('PN002', '', '', '2024-05-09', 16200000),
('PN003', '', '', '2024-05-09', 0);

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
('SP001', 'Acer Aspire 7', 21, 15000, 'Acer', 'SP001.png', 1),
('SP002', 'MSI modern 15', 11, 12000, 'MSI', 'SP002.png', 1),
('SP003', 'Acer Nitro 5', 5, 20000, 'Acer', 'SP003.png', 1),
('SP004', 'ASUS Zenbook 14 OLED', 15, 20000, 'Asus', 'SP004.png', 1),
('SP005', 'ASUS ROG Zephyrus G14', 17, 50000, 'Asus', 'SP005.png', 1),
('SP006', 'Dell Inspiron 15', 12, 13000, 'Dell', 'SP006.png', 1),
('SP007', 'Dell Vostro 3530', 10, 14000, 'Dell', 'SP007.png', 1),
('SP008', 'LG Gram 2023', 10, 27000, 'LG', 'SP008.png', 1),
('SP009', 'MacBook Air M1', 24, 30990, 'Mac', 'SP009.png', 1),
('SP010', 'MacBook Pro M2', 20, 39999, 'Mac', 'SP010.png', 1);

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
  `role` varchar(50) NOT NULL,
  `img` varchar(50) DEFAULT NULL,
  `enable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `ten`, `gioi_tinh`, `sdt`, `role`, `img`, `enable`) VALUES
('admin', 'admin', 'admin', '', '', 'admin', '', 1);

--
-- Indexes for dumped tables
--

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
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`id_pn`);

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
