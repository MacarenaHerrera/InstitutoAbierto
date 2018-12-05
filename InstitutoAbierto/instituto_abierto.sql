-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-12-2018 a las 18:02:07
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

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
(1, 'matematica', 'pepito', 200, 20, 1),
(2, 'hhh', 'gg', 20, 15, 2),
(3, 'matematica', 'esta bueno', 150, 20, 1);

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
(1, 'Macarena Herrera', 38750019, 154749854),
(2, 'Macarena Herrera', 38750019, 154749854),
(3, 'Macarena Herreka', 38750019, 154749854);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id_curso`);

--
-- Indices de la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`id_matricula`);

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
  MODIFY `id_curso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `matricula`
--
ALTER TABLE `matricula`
  MODIFY `id_matricula` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id_persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
