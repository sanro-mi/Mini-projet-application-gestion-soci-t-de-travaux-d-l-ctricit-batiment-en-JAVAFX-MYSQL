-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 21 déc. 2021 à 14:45
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `électricien`
--

-- --------------------------------------------------------

--
-- Structure de la table `détails`
--

CREATE TABLE `détails` (
  `id` int(11) NOT NULL,
  `nom_projet` varchar(100) NOT NULL,
  `versement` double NOT NULL,
  `reste` double NOT NULL,
  `total` double NOT NULL,
  `date_v` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `employé`
--

CREATE TABLE `employé` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `num_tlf` int(11) NOT NULL,
  `photo` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `employé`
--

INSERT INTO `employé` (`id`, `nom`, `prenom`, `adresse`, `num_tlf`, `photo`) VALUES
(2, 'zaza', 'zaza', 'zaza', 45287, 'C:\\Users\\sa\\Desktop\\prejet\\client.PNG');

-- --------------------------------------------------------

--
-- Structure de la table `entrepreneur`
--

CREATE TABLE `entrepreneur` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `num_tlf` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `photo` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `entrepreneur`
--

INSERT INTO `entrepreneur` (`id`, `nom`, `prenom`, `adresse`, `num_tlf`, `email`, `photo`) VALUES
(2, 'Zaza', 'Zaza', 'Zaza', 4406, 'Zaza', NULL),
(3, 'walid', 'dadi', 'foulani', 779648520, 'sad@gmail.com', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `pojet`
--

CREATE TABLE `pojet` (
  `id` int(11) NOT NULL,
  `nom` varchar(1000) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `entrepreneur` varchar(100) NOT NULL,
  `cout` double NOT NULL,
  `photo` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `pojet`
--

INSERT INTO `pojet` (`id`, `nom`, `adresse`, `entrepreneur`, `cout`, `photo`) VALUES
(9, 'Les belles couleurs de l\'éco-quartier de Cronenbourg', 'ville ', 'A A', 1500050, 'C:\\Users\\sa\\Desktop\\steb\\projet\\projet-charles-auderghem-.jpg'),
(10, 'couleurs de l\'éco-quartier de Cronenbourg', 'plf', 'A A', 100004, 'C:\\Users\\sa\\Desktop\\steb\\projet\\001311114_620x393_c.jpg'),
(11, 'cite 200/750 tiaret', 'ville ', 'Z Z', 1568769, 'C:\\Users\\sa\\Desktop\\steb\\projet\\magnifique-appartement-3-ch-toison-dor.jpg'),
(13, 'une architecture à saveur post-industrielle | Portail Constructo', 'ville', 'A A', 156920, 'C:\\Users\\sa\\Desktop\\steb\\projet\\projet-edwin2_prj.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `num_tlf` int(11) NOT NULL,
  `user` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `photo` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `détails`
--
ALTER TABLE `détails`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `employé`
--
ALTER TABLE `employé`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `entrepreneur`
--
ALTER TABLE `entrepreneur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pojet`
--
ALTER TABLE `pojet`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `détails`
--
ALTER TABLE `détails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `employé`
--
ALTER TABLE `employé`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `entrepreneur`
--
ALTER TABLE `entrepreneur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `pojet`
--
ALTER TABLE `pojet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
