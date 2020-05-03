-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Lun 20 Mai 2019 à 16:50
-- Version du serveur :  5.7.26-0ubuntu0.18.04.1
-- Version de PHP :  7.2.17-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gest`
--

-- --------------------------------------------------------

--
-- Structure de la table `Article`
--

CREATE TABLE `Article` (
  `barcode` varchar(13) NOT NULL,
  `name` varchar(32) NOT NULL,
  `category` varchar(32) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Article`
--

INSERT INTO `Article` (`barcode`, `name`, `category`, `price`) VALUES
('0123456789123', 'Yaourt', 'Alimentaire', 1.5),
('1234567890125', 'CafÃ©', 'Alimentaire', 1.5);

-- --------------------------------------------------------

--
-- Structure de la table `Command`
--

CREATE TABLE `Command` (
  `iddb` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `barcode` varchar(13) NOT NULL,
  `quantity` int(11) NOT NULL,
  `date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Command`
--

INSERT INTO `Command` (`iddb`, `id`, `barcode`, `quantity`, `date`) VALUES
(8, -289059322, '7895123012344', 7, 'Fri May 17 18:03:25 CEST 2019'),
(9, 1558342010, '7895123012344', 123, 'Fri May 17 18:05:05 CEST 2019'),
(10, 1996752550, '7895123012344', 4, 'Fri May 17 18:15:59 CEST 2019'),
(11, 1876892062, '7895123012344', 7, 'Fri May 17 18:29:54 CEST 2019'),
(12, 1876892062, '7819160291129', 2, 'Fri May 17 18:29:54 CEST 2019'),
(13, 1876892062, '7814140291129', 3, 'Fri May 17 18:29:54 CEST 2019'),
(14, 1666580346, '7895123012344', 3, 'Fri May 17 18:32:54 CEST 2019'),
(15, 1666580346, '7814140291129', 3, 'Fri May 17 18:32:54 CEST 2019'),
(16, 1366133237, '0123456789123', 4, 'Mon May 20 15:08:03 CEST 2019'),
(17, 1366133237, '1234567890125', 2, 'Mon May 20 15:08:03 CEST 2019'),
(18, 43569965, '0123456789123', 1, 'Mon May 20 15:08:34 CEST 2019'),
(19, 43569965, '1234567890125', 1, 'Mon May 20 15:08:34 CEST 2019'),
(20, 2077970066, '0123456789123', 1, 'Mon May 20 15:09:45 CEST 2019'),
(21, 2077970066, '1234567890125', 1, 'Mon May 20 15:09:45 CEST 2019'),
(22, 1741152219, '0123456789123', 2, 'Mon May 20 15:12:13 CEST 2019'),
(23, 1741152219, '1234567890125', 5, 'Mon May 20 15:12:13 CEST 2019'),
(24, 1199762858, '0123456789123', 1, 'Mon May 20 15:12:30 CEST 2019'),
(25, 1199762858, '8715342018238', 1, 'Mon May 20 15:12:30 CEST 2019'),
(26, 1991508545, '0123456789123', 9, 'Mon May 20 16:44:48 CEST 2019'),
(27, 1991508545, '1234567890125', 1, 'Mon May 20 16:44:48 CEST 2019');

-- --------------------------------------------------------

--
-- Structure de la table `Stock`
--

CREATE TABLE `Stock` (
  `barcode` varchar(13) NOT NULL,
  `quantity` int(11) NOT NULL,
  `treshold` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Stock`
--

INSERT INTO `Stock` (`barcode`, `quantity`, `treshold`) VALUES
('0123456789123', 1000, 0),
('1234567890125', 10000, 100);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Article`
--
ALTER TABLE `Article`
  ADD PRIMARY KEY (`barcode`);

--
-- Index pour la table `Command`
--
ALTER TABLE `Command`
  ADD PRIMARY KEY (`iddb`);

--
-- Index pour la table `Stock`
--
ALTER TABLE `Stock`
  ADD PRIMARY KEY (`barcode`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Command`
--
ALTER TABLE `Command`
  MODIFY `iddb` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
