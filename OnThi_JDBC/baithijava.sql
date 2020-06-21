CREATE DATABASE IF NOT EXISTS `baithijava` DEFAULT CHARACTER SET utf8 COLLATE utf8_czech_ci;
USE `baithijava`;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";



CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `balance` int(11) NOT NULL,
  `createDate` date NOT NULL,
  `status` tinyint(1) NOT NULL,
  `idcus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;


INSERT INTO `account` (`id`, `balance`, `createDate`, `status`, `idcus`) VALUES
(1, 300000, '2020-01-01', 1, 1),
(2, 200000, '2020-03-02', 1, 2),
(4, 200000, '2020-03-02', 1, 2),
(5, 400000, '2019-04-03', 1, 6),
(6, 200000, '2020-04-02', 0, 2),
(7, 100000, '2019-02-04', 1, 3),
(8, 100000, '2019-02-01', 0, 1),
(9, 400000, '2018-03-02', 0, 1);


CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  `age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;


INSERT INTO `customer` (`id`, `name`, `age`) VALUES
(1, 'Hồ Đình Khả', 50),
(2, 'Lương An Vinh', 26),
(3, 'Lê Triệu Ngọc Đức', 40),
(6, 'Trần Văn Thắng', 52),
(8, 'Lê Thị Chu My', 34);


ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idcus` (`idcus`);

ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`idcus`) REFERENCES `customer` (`id`) ON UPDATE CASCADE;

