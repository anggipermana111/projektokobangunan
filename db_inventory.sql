/*
SQLyog Community v12.5.0 (64 bit)
MySQL - 5.5.39 : Database - db_inventory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_inventory` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_inventory`;

/*Table structure for table `barang` */

DROP TABLE IF EXISTS `barang`;

CREATE TABLE `barang` (
  `kode_barang` CHAR(8) NOT NULL,
  `kode_jenis` CHAR(5) NOT NULL,
  `nama_barang` VARCHAR(30) NOT NULL,
  `satuan` VARCHAR(10) NOT NULL,
  `harga` DOUBLE NOT NULL,
  `stok` INT(5) NOT NULL,
  PRIMARY KEY (`kode_barang`),
  KEY `kode_jenis` (`kode_jenis`),
  CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`kode_jenis`) REFERENCES `jenis_barang` (`kode_jenis`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/*Data for the table `barang` */

INSERT  INTO `barang`(`kode_barang`,`kode_jenis`,`nama_barang`,`satuan`,`harga`,`stok`) VALUES 
('B1908001','JB001','Paku 7 cm','Kg',22780,100),
('B1908002','JB001','Paku 5 cm','Kg',22244,100),
('B1908003','JB001','Paku 4 cm','Kg',22244,100),
('B1908004','JB001','Paku 2 cm','Kg',26800,100),
('B1908005','JB001','Paku 15 cm','Kg',21440,62),
('B1908006','JB003','Semen Tiga Roda','Zak',119260,54),
('B1908007','JB003','Semen Tonasa 50 Kg','Zak',116580,30),
('B1908008','JB004','Keramik DN','Karton',87100,50),
('B1908009','JB007','Triplek 3 m','Lembar',72360,50),
('B1908010','JB007','Triplek 3 mm','Lembar',76380,72),
('B1908011','JB005','Pipa Air Minum Medium 1/2 Inch','Batang',140700,50),
('B1908012','JB005','Pipa Air Minum Medium 3 Inch','Batang',603000,38),
('B1908013','JB019','Seng Gelombang BJLS 20','Lembar',54940,34),
('B1908014','JB019','Seng Plat BJLS 30','Lembar',113900,48),
('B1908015','JB008','Besi Beton 1/2 Inch','Batang',154100,20),
('B1908016','JB008','Besi Siku 7x7','Batang',750400,23),
('B1908017','JB008','Besi 5 m','Batang',50000,50);

/*Table structure for table `barang_keluar` */

DROP TABLE IF EXISTS `barang_keluar`;

CREATE TABLE `barang_keluar` (
  `no_keluar` CHAR(12) NOT NULL,
  `tgl_keluar` DATE NOT NULL,
  `total_keluar` DOUBLE NOT NULL,
  `id_pengguna` CHAR(10) NOT NULL,
  PRIMARY KEY (`no_keluar`),
  KEY `id_pengguna` (`id_pengguna`),
  CONSTRAINT `barang_keluar_ibfk_1` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/*Data for the table `barang_keluar` */

INSERT  INTO `barang_keluar`(`no_keluar`,`tgl_keluar`,`total_keluar`,`id_pengguna`) VALUES 
('BK190818001','2019-08-18',129000,'USR1907001'),
('BK190818002','2019-08-18',79000,'USR1907001'),
('BK190819003','2019-08-19',1112200,'USR1907001'),
('BK190819004','2019-08-19',1334640,'USR1907001'),
('BK190922005','2019-09-22',3618000,'USR1907001');

/*Table structure for table `barang_masuk` */

DROP TABLE IF EXISTS `barang_masuk`;

CREATE TABLE `barang_masuk` (
  `no_masuk` CHAR(12) NOT NULL,
  `tgl_masuk` DATE NOT NULL,
  `total_masuk` DOUBLE NOT NULL,
  `id_distributor` CHAR(10) NOT NULL,
  `id_pengguna` CHAR(10) NOT NULL,
  PRIMARY KEY (`no_masuk`),
  KEY `id_pengguna` (`id_pengguna`),
  KEY `id_distributor` (`id_distributor`),
  CONSTRAINT `barang_masuk_ibfk_1` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`),
  CONSTRAINT `barang_masuk_ibfk_2` FOREIGN KEY (`id_distributor`) REFERENCES `distributor` (`id_distributor`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/*Data for the table `barang_masuk` */

INSERT  INTO `barang_masuk`(`no_masuk`,`tgl_masuk`,`total_masuk`,`id_distributor`,`id_pengguna`) VALUES 
('BM190819001','2019-08-19',100000,'DST1907001','USR1907001'),
('BM190819002','2019-09-26',200000,'DST1908003','USR1907002'),
('BM190926003','2019-09-26',1680360,'DST1908003','USR1907001');

/*Table structure for table `detail_barang_keluar` */

DROP TABLE IF EXISTS `detail_barang_keluar`;

CREATE TABLE `detail_barang_keluar` (
  `no_keluar` CHAR(12) NOT NULL,
  `kode_barang` CHAR(12) NOT NULL,
  `jml_keluar` INT(4) NOT NULL,
  `subtotal_keluar` DOUBLE NOT NULL,
  KEY `no_keluar` (`no_keluar`),
  KEY `detail_barang_keluar_ibfk_2` (`kode_barang`),
  CONSTRAINT `detail_barang_keluar_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detail_barang_keluar_ibfk_3` FOREIGN KEY (`no_keluar`) REFERENCES `barang_keluar` (`no_keluar`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/*Data for the table `detail_barang_keluar` */

INSERT  INTO `detail_barang_keluar`(`no_keluar`,`kode_barang`,`jml_keluar`,`subtotal_keluar`) VALUES 
('BK190818001','B1908001',2,4000),
('BK190818002','B1908001',2,4000),
('BK190819003','B1908002',50,1112200),
('BK190819004','B1908003',60,1334640),
('BK190922005','B1908001',100,2278000),
('BK190922005','B1908004',50,1340000);

/*Table structure for table `detail_barang_masuk` */

DROP TABLE IF EXISTS `detail_barang_masuk`;

CREATE TABLE `detail_barang_masuk` (
  `no_masuk` CHAR(12) NOT NULL,
  `kode_barang` CHAR(12) NOT NULL,
  `jml_masuk` INT(4) NOT NULL,
  `subtotal_masuk` DOUBLE NOT NULL,
  KEY `kode_barang` (`kode_barang`),
  KEY `no_masuk` (`no_masuk`),
  CONSTRAINT `detail_barang_masuk_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`),
  CONSTRAINT `detail_barang_masuk_ibfk_3` FOREIGN KEY (`no_masuk`) REFERENCES `barang_masuk` (`no_masuk`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/*Data for the table `detail_barang_masuk` */

INSERT  INTO `detail_barang_masuk`(`no_masuk`,`kode_barang`,`jml_masuk`,`subtotal_masuk`) VALUES 
('BM190819001','B1908001',4,47000),
('BM190819001','B1908005',7,53000),
('BM190819002','B1908005',5,60000),
('BM190819002','B1908006',4,140000),
('BM190926003','B1908010',22,1680360);

/*Table structure for table `distributor` */

DROP TABLE IF EXISTS `distributor`;

CREATE TABLE `distributor` (
  `id_distributor` CHAR(10) NOT NULL,
  `nama_distributor` VARCHAR(30) NOT NULL,
  `telp_distributor` VARCHAR(13) NOT NULL,
  `alamat_distributor` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_distributor`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/*Data for the table `distributor` */

INSERT  INTO `distributor`(`id_distributor`,`nama_distributor`,`telp_distributor`,`alamat_distributor`) VALUES 
('DST1907001','CV. Dua Putra Petir','082123423789','Jl. Bukit Palma C5/33 Citraland Utara Surabaya 60185, Surabaya, Jawa Timur, Indonesia'),
('DST1907002','CV. Aneka Steel Teknik','082142342424','Jl. Randegan Sari No. 22 Gresik Driyorejo, Jawa Timur, Indonesia'),
('DST1908003','PT Prima Perkasa','086763747234','Jl. Merbau No. 29 Medan, Sumatera Utara, Indonesia'),
('DST1908004','Sintech','081245458978','Jl. Raya Benovo Desa Kepatihan Gresik, Jawa Timur, Indonesia'),
('DST1908005','Indah Prasasti','081223543522','Jl. Raya Pasar Minggu No. 37 Lampu Merah Simpang Tiga Taman Makam Pahlawan, Jakarta, Indonesia'),
('DST1908006','PT Ratimo Utama','081254355464','Jl. Raya Medan-Binjai Km2.5 Dusun IV Deli Serdang, Sumatera Utara, Indonesia'),
('DST1908007','Berkat Sukses','085843565778','Jl. hayam Wuruk No. 127 Jakarta, Indonesia'),
('DST1908008','PT Reka Indo Perkasa','081254903455','Jl. Stadion Kemiri Nomor 22 Sidoarjo, Jawa Timur, Indonesia'),
('DST1908009','CV. Anugerah Raya','081238789345','Jl. Lingkungan Tanah Putih, Flores Timur, Nusa Tenggara Timur, Indonesia'),
('DST1908010','Mandiri Perkasa','081274389757','Jl. Taman Alfa Indah Joglo, Jakarta, Indonesia'),
('DST1908011','PT. Langgeng Trada Teknik','021455646698','Jl. Banceuy No. 98 Bandung, Jawa Barat, Indonesia'),
('DST1908012','CV. Herindoe Perkasa','081234728578','Jl. Tembaan No. 57H, Surabaya, Jawa Timur, Indonesia');

/*Table structure for table `jenis_barang` */

DROP TABLE IF EXISTS `jenis_barang`;

CREATE TABLE `jenis_barang` (
  `kode_jenis` CHAR(5) NOT NULL,
  `nama_jenis` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`kode_jenis`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/*Data for the table `jenis_barang` */

INSERT  INTO `jenis_barang`(`kode_jenis`,`nama_jenis`) VALUES 
('JB001','Paku'),
('JB002','Pasir'),
('JB003','Semen'),
('JB004','Keramik'),
('JB005','Pipa'),
('JB006','Cat'),
('JB007','Triplek'),
('JB008','Besi'),
('JB009','Kayu'),
('JB010','Thinner'),
('JB011','Selang'),
('JB012','Kran'),
('JB013','Batu Bata'),
('JB014','Asbes'),
('JB015','Pintu'),
('JB016','Jendela'),
('JB017','Baut'),
('JB018','Alat Tukang'),
('JB019','Seng'),
('JB020','Kawat'),
('JB021','Lem'),
('JB022','Bor'),
('JB023','Mata Bor'),
('JB024','Pompa Air'),
('JB025','Kawat');

/*Table structure for table `pengguna` */

DROP TABLE IF EXISTS `pengguna`;

CREATE TABLE `pengguna` (
  `id_pengguna` CHAR(10) NOT NULL,
  `nama_pengguna` VARCHAR(30) NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `telp_pengguna` VARCHAR(13) NOT NULL,
  `alamat_pengguna` VARCHAR(100) NOT NULL,
  `level` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id_pengguna`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/*Data for the table `pengguna` */

INSERT  INTO `pengguna`(`id_pengguna`,`nama_pengguna`,`username`,`password`,`telp_pengguna`,`alamat_pengguna`,`level`) VALUES 
('USR1907001','Administrator','admin','21232f297a57a5a743894a0e4a801fc3','089723432343','Jl. Raya Tegal No. 1 Tegal, Jawa Tengah, Indonesia','Owner'),
('USR1907002','Teguh Julianto','teguh','f5cd3a020bc94866049206a7cf14e266','089671337916','Jl. Raya Suradadi No. 44 Kec. Suradadi Kab. Tegal','Staff');

/*Table structure for table `sementara_barang_masuk` */

DROP TABLE IF EXISTS `sementara_barang_masuk`;

CREATE TABLE `sementara_barang_masuk` (
  `kode_barang` CHAR(8) NOT NULL,
  `nama_barang` VARCHAR(30) NOT NULL,
  `satuan` VARCHAR(30) NOT NULL,
  `harga` DOUBLE NOT NULL,
  `jml_masuk` INT(5) NOT NULL,
  `subtotal_masuk` DOUBLE NOT NULL,
  KEY `kode_barang` (`kode_barang`),
  CONSTRAINT `sementara_barang_masuk_ibfk_1` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/*Data for the table `sementara_barang_masuk` */

/*Table structure for table `sementara_keluar` */

DROP TABLE IF EXISTS `sementara_keluar`;

CREATE OR REPLACE TABLE `sementara_keluar` (
  `kode_barang` CHAR(8) NOT NULL,
  `nama_barang` VARCHAR(30) NOT NULL,
  `satuan` VARCHAR(30) NOT NULL,
  `harga` DOUBLE NOT NULL,
  `jml_keluar` INT(4) NOT NULL,
  `subtotal_keluar` DOUBLE NOT NULL,
  KEY (`kode_barang`),
  CONSTRAINT `sementara_keluar_ibfk_1` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/*Data for the table `sementara_keluar` */

INSERT  INTO `sementara_keluar`(`kode_barang`,`nama_barang`,`satuan`,`harga`,`jml_keluar`,`subtotal_keluar`) VALUES 
('B1908001','Paku 7 cm','KG',22780,100,2278000),
('B1908007','Semen Tonasa 50 Kg','KG',116580,30,3497400);

/* Trigger structure for table `detail_barang_keluar` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `barang_keluar` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `barang_keluar` AFTER INSERT ON `detail_barang_keluar` FOR EACH ROW BEGIN
	UPDATE barang SET stok = stok-NEW.jml_keluar
    WHERE kode_barang=NEW.kode_barang;
END */$$


DELIMITER ;

/* Trigger structure for table `detail_barang_masuk` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `barang_masuk` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `barang_masuk` AFTER INSERT ON `detail_barang_masuk` FOR EACH ROW BEGIN
	UPDATE barang SET stok = stok+NEW.jml_masuk
    WHERE kode_barang = NEW.kode_barang;
END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


DELIMITER || 
CREATE OR REPLACE TRIGGER hapus_pengguna 
BEFORE DELETE ON pengguna
FOR EACH ROW BEGIN 
	DELETE FROM barang_keluar WHERE id_pengguna = old.id_pengguna;
	DELETE FROM barang_masuk WHERE id_pengguna = old.id_pengguna;
END ||
DELIMITER;

DELIMITER || 
CREATE OR REPLACE TRIGGER hapus_barang_keluar 
BEFORE DELETE ON barang_keluar
FOR EACH ROW BEGIN 
	DELETE FROM detail_barang_keluar WHERE no_keluar = old.no_keluar;
END ||
DELIMITER;

DELIMITER || 
CREATE OR REPLACE TRIGGER hapus_barang_masuk
BEFORE DELETE ON barang_masuk
FOR EACH ROW BEGIN 
	DELETE FROM detail_barang_masuk WHERE no_masuk = old.no_masuk;
END ||
DELIMITER;

DELIMITER || 
CREATE OR REPLACE TRIGGER hapus_distributor 
BEFORE DELETE ON distributor
FOR EACH ROW BEGIN 
	DELETE FROM barang_masuk WHERE id_distributor = old.id_distributor;
END ||
DELIMITER;

DELIMITER || 
CREATE OR REPLACE TRIGGER hapus_jenis_barang 
BEFORE DELETE ON jenis_barang
FOR EACH ROW BEGIN 
	DELETE FROM barang WHERE kode_jenis = old.kode_jenis;
END ||
DELIMITER;


DELIMITER || 
CREATE OR REPLACE TRIGGER hapus_jenis_barang 
BEFORE DELETE ON jenis_barang
FOR EACH ROW BEGIN 
	DELETE FROM barang WHERE kode_jenis = old.kode_jenis;
END ||
DELIMITER;

DELIMITER || 
CREATE OR REPLACE TRIGGER hapus_barang 
BEFORE DELETE ON barang
FOR EACH ROW BEGIN 
	DELETE FROM sementara_barang_masuk WHERE kode_barang = old.kode_barang;
	DELETE FROM detail_barang_keluar WHERE kode_barang = old.kode_barang;
	DELETE FROM detail_barang_masuk WHERE kode_barang = old.kode_barang;
	DELETE FROM sementara_keluar WHERE kode_barang = old.kode_barang;
END ||
DELIMITER;


DELETE FROM pengguna  WHERE id_pengguna = 'USR1907002';