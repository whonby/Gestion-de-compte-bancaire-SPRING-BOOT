-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Mer 19 Juin 2019 à 16:56
-- Version du serveur :  5.7.26-0ubuntu0.18.04.1
-- Version de PHP :  7.2.19-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `minibanque`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `code` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`code`, `email`, `nom`, `telephone`) VALUES
(1, 'gueiroland1@gmail.com', 'Guei Roland', '+22554761743'),
(2, 'martineol@gmail.com', 'Martine Olio', '+22574001201'),
(3, 'klf@gmail.com', 'Kolinoy fabrice', '+22568764363'),
(4, 'amique451@gmail.com', 'Amique Valione', '+22507789001'),
(5, 'celine_fabiano@gmail.com', 'Fabiano celine', '+22565784110'),
(6, 'walysebatien@gmail.com', 'Waly Sebatien', '+22501023345'),
(7, 'lKoua@gmail.com', 'Luiaz Kouadio', '+2257801002'),
(8, 'jDiona@gmail.com', 'Julien Diona', '+6854888');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `type_cpte` varchar(2) NOT NULL,
  `num_compte` varchar(255) NOT NULL,
  `date_create` datetime DEFAULT NULL,
  `solde` double NOT NULL,
  `taux` double DEFAULT NULL,
  `decouvert` double DEFAULT NULL,
  `code_cli` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`type_cpte`, `num_compte`, `date_create`, `solde`, `taux`, `decouvert`, `code_cli`) VALUES
('CE', '4545AB', '2019-06-17 00:00:00', 5470000, 4.6, NULL, 3),
('CE', '548200PM', '2019-06-17 17:00:00', 300000, 4.2, NULL, 3),
('CC', 'C54', '2019-06-18 00:00:00', 254112, NULL, 6000, 1);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(20),
(20);

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `type_op` varchar(1) NOT NULL,
  `numero` bigint(20) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `code_cpte` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `operation`
--

INSERT INTO `operation` (`type_op`, `numero`, `date_creation`, `montant`, `code_cpte`) VALUES
('V', 1, '2019-06-17 12:00:00', 54200, '4545AB'),
('V', 2, '2019-06-17 09:19:00', 500000, '548200PM'),
('V', 3, '2019-06-17 00:00:00', 60000, '548200PM'),
('V', 4, '2019-06-18 00:00:00', 850000, 'C54'),
('V', 9, '2019-06-18 15:42:54', 100, '548200PM'),
('R', 10, '2019-06-18 15:43:05', 100, '548200PM'),
('R', 11, '2019-06-18 15:43:12', 100, '548200PM'),
('R', 12, '2019-06-18 15:44:08', 100000, '548200PM'),
('V', 13, '2019-06-18 15:44:08', 100000, 'C54'),
('R', 14, '2019-06-18 15:45:19', 50000, 'C54'),
('R', 15, '2019-06-18 15:53:36', 100000, 'C54'),
('R', 16, '2019-06-18 16:43:29', 547888, 'c54'),
('V', 17, '2019-06-18 16:43:29', 547888, 'C54'),
('R', 18, '2019-06-18 16:51:52', 2000, '548200PM'),
('V', 19, '2019-06-18 16:51:52', 2000, 'c54');

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE `roles` (
  `role` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `roles`
--

INSERT INTO `roles` (`role`) VALUES
('ADMIN'),
('USER');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(55) NOT NULL,
  `password` text NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `active`) VALUES
(4, 'whonby', '23580e2a459f7ea40f9efa148b63cafb', 1),
(5, 'guei217', '23580e2a459f7ea40f9efa148b63cafb', 1),
(6, 'th321', '23580e2a459f7ea40f9efa148b63cafb', 1);

-- --------------------------------------------------------

--
-- Structure de la table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` int(1) NOT NULL,
  `role_id` varchar(15) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`, `id`) VALUES
(4, 'ADMIN', 1),
(4, 'USER', 2),
(5, 'USER', 3),
(6, 'USER', 4);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`num_compte`),
  ADD KEY `FK2hw4shqsxc782lychpkr52lmv` (`code_cli`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `FKkr9nfjf0ipqrw5xwcf9jqq6gv` (`code_cpte`);

--
-- Index pour la table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users_roles`
--
ALTER TABLE `users_roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `operation`
--
ALTER TABLE `operation`
  MODIFY `numero` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `users_roles`
--
ALTER TABLE `users_roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `users_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `users_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
