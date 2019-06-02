-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 24 mai 2019 à 21:53
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet_ecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `tab_anneescolaire_ann`
--

DROP TABLE IF EXISTS `tab_anneescolaire_ann`;
CREATE TABLE IF NOT EXISTS `tab_anneescolaire_ann` (
  `ann_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ann_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_bulletin_bul`
--

DROP TABLE IF EXISTS `tab_bulletin_bul`;
CREATE TABLE IF NOT EXISTS `tab_bulletin_bul` (
  `bul_id` int(11) NOT NULL AUTO_INCREMENT,
  `bul_id_trimestre` int(11) NOT NULL,
  `bul_id_inscription` int(11) NOT NULL,
  PRIMARY KEY (`bul_id`),
  KEY `bul_id_inscription` (`bul_id_inscription`),
  KEY `bul_id_trimestre` (`bul_id_trimestre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_classe_cla`
--

DROP TABLE IF EXISTS `tab_classe_cla`;
CREATE TABLE IF NOT EXISTS `tab_classe_cla` (
  `cla_id` int(11) NOT NULL AUTO_INCREMENT,
  `cla_nom` varchar(255) NOT NULL,
  `cla_id_ecole` int(11) NOT NULL,
  `cla_id_niveau` int(11) NOT NULL,
  `cla_id_anne` int(11) NOT NULL,
  PRIMARY KEY (`cla_id`),
  KEY `cla_id_anne` (`cla_id_anne`),
  KEY `cla_id_niveau` (`cla_id_niveau`),
  KEY `cla_id_ecole` (`cla_id_ecole`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_detailbulletin_det`
--

DROP TABLE IF EXISTS `tab_detailbulletin_det`;
CREATE TABLE IF NOT EXISTS `tab_detailbulletin_det` (
  `det_id` int(11) NOT NULL AUTO_INCREMENT,
  `det_id_bulletin` int(11) NOT NULL,
  `det_id_enseign` int(11) NOT NULL,
  `det_appreciation` text NOT NULL,
  PRIMARY KEY (`det_id`),
  KEY `det_id_bulletin` (`det_id_bulletin`),
  KEY `det_id_enseign` (`det_id_enseign`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_discipline_dis`
--

DROP TABLE IF EXISTS `tab_discipline_dis`;
CREATE TABLE IF NOT EXISTS `tab_discipline_dis` (
  `dis_id` int(11) NOT NULL AUTO_INCREMENT,
  `dis_nom` varchar(255) NOT NULL,
  PRIMARY KEY (`dis_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_ecole_eco`
--

DROP TABLE IF EXISTS `tab_ecole_eco`;
CREATE TABLE IF NOT EXISTS `tab_ecole_eco` (
  `eco_id` int(11) NOT NULL AUTO_INCREMENT,
  `eco_nom` varchar(255) NOT NULL,
  `eco_vile` varchar(255) NOT NULL,
  `eco_statut` int(11) NOT NULL,
  PRIMARY KEY (`eco_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_enseignement_ens`
--

DROP TABLE IF EXISTS `tab_enseignement_ens`;
CREATE TABLE IF NOT EXISTS `tab_enseignement_ens` (
  `ens_id` int(11) NOT NULL AUTO_INCREMENT,
  `ens_id_classe` int(11) NOT NULL,
  `ens_id_discipline` int(11) NOT NULL,
  `ens_id_personne` int(11) NOT NULL,
  PRIMARY KEY (`ens_id`),
  KEY `ens_id_classe` (`ens_id_classe`),
  KEY `ens_id_discipline` (`ens_id_discipline`),
  KEY `ens_id_personne` (`ens_id_personne`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_evaluation_eva`
--

DROP TABLE IF EXISTS `tab_evaluation_eva`;
CREATE TABLE IF NOT EXISTS `tab_evaluation_eva` (
  `eva_id` int(11) NOT NULL AUTO_INCREMENT,
  `eva_id_det` int(11) NOT NULL,
  `eva_note` float NOT NULL,
  `eva_appre` text NOT NULL,
  PRIMARY KEY (`eva_id`),
  KEY `eva_id_det` (`eva_id_det`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_inscription_ins`
--

DROP TABLE IF EXISTS `tab_inscription_ins`;
CREATE TABLE IF NOT EXISTS `tab_inscription_ins` (
  `ins_id` int(11) NOT NULL AUTO_INCREMENT,
  `ins_id_classe` int(11) NOT NULL,
  `ins_id_personne` int(11) NOT NULL,
  PRIMARY KEY (`ins_id`),
  KEY `ins_id_classe` (`ins_id_classe`),
  KEY `ins_id_personne` (`ins_id_personne`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_niveau_niv`
--

DROP TABLE IF EXISTS `tab_niveau_niv`;
CREATE TABLE IF NOT EXISTS `tab_niveau_niv` (
  `niv_id` int(11) NOT NULL AUTO_INCREMENT,
  `niv_nom` varchar(255) NOT NULL,
  PRIMARY KEY (`niv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_personne_per`
--

DROP TABLE IF EXISTS `tab_personne_per`;
CREATE TABLE IF NOT EXISTS `tab_personne_per` (
  `per_id` int(11) NOT NULL AUTO_INCREMENT,
  `per_nom` varchar(255) NOT NULL,
  `per_prenom` varchar(255) NOT NULL,
  `per_type` int(11) NOT NULL,
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_trimestre_tri`
--

DROP TABLE IF EXISTS `tab_trimestre_tri`;
CREATE TABLE IF NOT EXISTS `tab_trimestre_tri` (
  `tri_id` int(11) NOT NULL AUTO_INCREMENT,
  `tri_numero` int(11) NOT NULL,
  `tri_debut` date NOT NULL,
  `tri_fin` date NOT NULL,
  `tri_id_anne` int(11) NOT NULL,
  PRIMARY KEY (`tri_id`),
  KEY `tri_id_anne` (`tri_id_anne`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `tab_bulletin_bul`
--
ALTER TABLE `tab_bulletin_bul`
  ADD CONSTRAINT `tab_bulletin_bul_ibfk_1` FOREIGN KEY (`bul_id_inscription`) REFERENCES `tab_inscription_ins` (`ins_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tab_bulletin_bul_ibfk_2` FOREIGN KEY (`bul_id_trimestre`) REFERENCES `tab_trimestre_tri` (`tri_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tab_classe_cla`
--
ALTER TABLE `tab_classe_cla`
  ADD CONSTRAINT `tab_classe_cla_ibfk_1` FOREIGN KEY (`cla_id_anne`) REFERENCES `tab_anneescolaire_ann` (`ann_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tab_classe_cla_ibfk_2` FOREIGN KEY (`cla_id_niveau`) REFERENCES `tab_niveau_niv` (`niv_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tab_classe_cla_ibfk_3` FOREIGN KEY (`cla_id_ecole`) REFERENCES `tab_ecole_eco` (`eco_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tab_detailbulletin_det`
--
ALTER TABLE `tab_detailbulletin_det`
  ADD CONSTRAINT `tab_detailbulletin_det_ibfk_1` FOREIGN KEY (`det_id_bulletin`) REFERENCES `tab_bulletin_bul` (`bul_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tab_detailbulletin_det_ibfk_2` FOREIGN KEY (`det_id_enseign`) REFERENCES `tab_enseignement_ens` (`ens_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tab_enseignement_ens`
--
ALTER TABLE `tab_enseignement_ens`
  ADD CONSTRAINT `tab_enseignement_ens_ibfk_1` FOREIGN KEY (`ens_id_classe`) REFERENCES `tab_classe_cla` (`cla_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tab_enseignement_ens_ibfk_2` FOREIGN KEY (`ens_id_discipline`) REFERENCES `tab_discipline_dis` (`dis_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tab_enseignement_ens_ibfk_3` FOREIGN KEY (`ens_id_personne`) REFERENCES `tab_personne_per` (`per_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tab_evaluation_eva`
--
ALTER TABLE `tab_evaluation_eva`
  ADD CONSTRAINT `tab_evaluation_eva_ibfk_1` FOREIGN KEY (`eva_id_det`) REFERENCES `tab_detailbulletin_det` (`det_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tab_inscription_ins`
--
ALTER TABLE `tab_inscription_ins`
  ADD CONSTRAINT `tab_inscription_ins_ibfk_1` FOREIGN KEY (`ins_id_classe`) REFERENCES `tab_classe_cla` (`cla_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tab_inscription_ins_ibfk_2` FOREIGN KEY (`ins_id_personne`) REFERENCES `tab_personne_per` (`per_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `tab_trimestre_tri`
--
ALTER TABLE `tab_trimestre_tri`
  ADD CONSTRAINT `tab_trimestre_tri_ibfk_1` FOREIGN KEY (`tri_id_anne`) REFERENCES `tab_anneescolaire_ann` (`ann_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
