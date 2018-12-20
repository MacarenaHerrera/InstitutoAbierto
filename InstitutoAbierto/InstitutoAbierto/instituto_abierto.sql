-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-12-2018 a las 15:46:19
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `instituto_abierto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL,
  `nombreCurso` varchar(50) NOT NULL,
  `descripcion` text NOT NULL,
  `costo` double NOT NULL,
  `cupoMax` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`id_curso`, `nombreCurso`, `descripcion`, `costo`, `cupoMax`, `id_persona`) VALUES
(14, 'Lengua', '', 1250, 30, 9),
(15, 'Filosofía', '', 1500, 15, 6),
(16, 'Psicologia', '', 1400, 9, 6),
(17, 'Inglés', '', 1600, 15, 6),
(18, 'Francés', '', 4000, 20, 6),
(19, 'Geografía', '', 3200, 25, 6),
(20, 'Minería de datos', '', 8000, 20, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matricula` (
  `id_matricula` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `costo` double NOT NULL,
  `id_curso` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matricula` (`id_matricula`, `fecha`, `costo`, `id_curso`, `id_persona`) VALUES
(44, '2018-12-19', 1250, 14, 9),
(45, '2018-12-20', 1600, 17, 11),
(46, '2018-12-20', 1600, 17, 9),
(47, '2018-12-20', 1600, 17, 10),
(48, '2018-12-20', 1600, 17, 6),
(49, '2018-12-20', 1600, 17, 8),
(50, '2018-12-20', 1600, 17, 7),
(51, '2018-12-20', 1600, 17, 10),
(52, '2018-12-20', 1600, 17, 9),
(53, '2018-12-20', 1600, 17, 11),
(54, '2018-12-20', 4000, 18, 11),
(55, '2018-12-20', 4000, 18, 6),
(56, '2018-12-20', 4000, 18, 8),
(57, '2018-12-20', 4000, 18, 7),
(58, '2018-12-20', 1250, 14, 7),
(59, '2018-12-20', 1250, 14, 11),
(60, '2018-12-20', 1250, 14, 8),
(61, '2018-12-20', 1500, 15, 6),
(62, '2018-12-20', 1500, 15, 7),
(63, '2018-12-20', 1500, 15, 8),
(64, '2018-12-20', 1400, 16, 10),
(65, '2018-12-20', 1400, 16, 9),
(66, '2018-12-20', 1400, 16, 11),
(67, '2018-12-20', 1600, 17, 6),
(68, '2018-12-20', 1600, 17, 8),
(69, '2018-12-20', 1600, 17, 7),
(70, '2018-12-20', 4000, 18, 10),
(71, '2018-12-20', 4000, 18, 9),
(72, '2018-12-20', 4000, 18, 11),
(73, '2018-12-20', 3200, 19, 6),
(74, '2018-12-20', 3200, 19, 8),
(75, '2018-12-20', 3200, 19, 7),
(76, '2018-12-20', 8000, 20, 10),
(77, '2018-12-20', 8000, 20, 8),
(78, '2018-12-20', 8000, 20, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL,
  `nombrePersona` varchar(50) NOT NULL,
  `dni` int(11) NOT NULL,
  `celular` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id_persona`, `nombrePersona`, `dni`, `celular`) VALUES
(6, 'Martina Deicas', 147, 15478963),
(7, 'María José', 369, 12354678),
(8, 'Ezequiel Gomez', 258, 15789654),
(9, 'Macarena Herrera', 456, 123546),
(10, 'Roberto Lopez', 123, 489651278),
(11, 'Alicia Maravilla', 789, 15247896);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id_curso`),
  ADD KEY `id_persona` (`id_persona`);

--
-- Indices de la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`id_matricula`),
  ADD KEY `matricula_persona` (`id_persona`),
  ADD KEY `matricula_curso` (`id_curso`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id_persona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `curso`
--
ALTER TABLE `curso`
  MODIFY `id_curso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `matricula`
--
ALTER TABLE `matricula`
  MODIFY `id_matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id_persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `curso_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD CONSTRAINT `matricula_curso` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `matricula_persona` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
