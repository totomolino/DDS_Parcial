-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-08-2021 a las 16:35:58
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `juegos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegosimple`
--

CREATE TABLE `juegosimple` (
  `id_juegoSimple` int(11) NOT NULL,
  `estado` enum('STOCK','PRESTADO','RETRASADO') NOT NULL DEFAULT 'STOCK',
  `condicion` enum('Gastado','Nuevo') NOT NULL DEFAULT 'Nuevo',
  `titulo` varchar(100) NOT NULL,
  `cantUsos` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `juegosimple`
--

INSERT INTO `juegosimple` (`id_juegoSimple`, `estado`, `condicion`, `titulo`, `cantUsos`) VALUES
(1, 'STOCK', 'Nuevo', 'MARVELSAVENGERS', 0),
(2, 'STOCK', 'Nuevo', 'LEGO: Marvel Avengers', 0),
(3, 'STOCK', 'Nuevo', 'Star Wars Pinball VR', 0),
(4, 'STOCK', 'Nuevo', 'FIFA 22', 0),
(5, 'STOCK', 'Nuevo', 'FIFA 21', 0),
(6, 'STOCK', 'Nuevo', 'NBA2K21', 0),
(7, 'STOCK', 'Nuevo', 'NBA2K22', 0),
(8, 'STOCK', 'Nuevo', 'LEGOBATMAN', 0),
(9, 'STOCK', 'Nuevo', 'LEGOBATMAN2', 0),
(10, 'STOCK', 'Nuevo', 'LEGOBATMANTRILOGY', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `juegosimple`
--
ALTER TABLE `juegosimple`
  ADD PRIMARY KEY (`id_juegoSimple`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `juegosimple`
--
ALTER TABLE `juegosimple`
  MODIFY `id_juegoSimple` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
