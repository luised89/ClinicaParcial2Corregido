-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-07-2025 a las 01:41:12
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clinica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrativo`
--

CREATE TABLE `administrativo` (
  `Id` int(10) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Documento` int(20) NOT NULL,
  `Cuenta` varchar(30) NOT NULL,
  `Pass` varchar(10) NOT NULL,
  `Cargo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `administrativo`
--

INSERT INTO `administrativo` (`Id`, `Nombre`, `Documento`, `Cuenta`, `Pass`, `Cargo`) VALUES
(1, 'Luis Eduardo Peña', 1014203, 'Luis@admin', '1234', 'Gerente'),
(3, 'sara', 1120890, 'sara@admin', '789', 'gerente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `Id` int(10) NOT NULL,
  `Paciente` varchar(30) NOT NULL,
  `Cuenta` varchar(20) NOT NULL,
  `TipoCita` varchar(30) NOT NULL,
  `Medico` varchar(30) NOT NULL,
  `CuentaMedica` varchar(20) NOT NULL,
  `FechaHora` datetime NOT NULL,
  `Motivo` varchar(50) NOT NULL,
  `Estado` varchar(20) NOT NULL DEFAULT 'Pendiente',
  `Historia` varchar(400) NOT NULL DEFAULT '---'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`Id`, `Paciente`, `Cuenta`, `TipoCita`, `Medico`, `CuentaMedica`, `FechaHora`, `Motivo`, `Estado`, `Historia`) VALUES
(1, 'mayra', 'may@paciente', 'Fisioterapia', 'carlos', 'carlos@medic', '2025-07-03 09:00:00', 'control', 'Realizado', 'algo'),
(2, 'LauraX', 'laux@paciente', 'Fisioterapia', 'carlos', 'carlos@medic', '2025-07-01 10:30:00', 'control', 'Cancelado', 'ninguno'),
(3, 'Karla G', 'karla@paciente', 'General', 'Daniel Garzon', 'Dani@medic', '2025-07-02 09:00:00', 'consulta', 'Pendiente', '---');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `Id` int(10) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Documento` int(20) NOT NULL,
  `Cuenta` varchar(30) NOT NULL,
  `Pass` varchar(10) NOT NULL,
  `Especialidad` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`Id`, `Nombre`, `Documento`, `Cuenta`, `Pass`, `Especialidad`) VALUES
(1, 'carlos', 114112, 'carlos@medic', '456', 'Fisioterapia'),
(2, 'Daniel Garzon', 455522, 'Dani@medic', '456', 'General'),
(3, 'Juliana Ortiz', 1055698, 'juli@medic', '7556', 'Optometria'),
(4, 'Marcela Usme', 10143665, 'marce@medic', '6558', 'Odontologia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `Id` int(10) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Documento` int(20) NOT NULL,
  `Cuenta` varchar(30) NOT NULL,
  `Sangre` varchar(10) NOT NULL,
  `Fecha_Nacimiento` date NOT NULL,
  `Alergias` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`Id`, `Nombre`, `Documento`, `Cuenta`, `Sangre`, `Fecha_Nacimiento`, `Alergias`) VALUES
(1, 'mayra', 1014194, 'may@paciente', 'O+', '1987-12-21', 'ninguna'),
(2, 'Karla G', 1014456, 'karla@paciente', 'A+', '1992-07-04', 'ninguna'),
(3, 'LauraX', 101234, 'laux@paciente', 'A+', '1991-02-28', 'ninguna');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrativo`
--
ALTER TABLE `administrativo`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrativo`
--
ALTER TABLE `administrativo`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `medico`
--
ALTER TABLE `medico`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
