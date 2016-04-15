-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 15-04-2016 a las 14:23:34
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `personal`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `categoria_area`
-- 

CREATE TABLE `categoria_area` (
  `id_catArea` int(12) NOT NULL auto_increment,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY  (`id_catArea`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

-- 
-- Volcar la base de datos para la tabla `categoria_area`
-- 

INSERT INTO `categoria_area` VALUES (1, 'Servicios');
INSERT INTO `categoria_area` VALUES (2, 'Desarrollo');
INSERT INTO `categoria_area` VALUES (3, 'Zarpeo');
INSERT INTO `categoria_area` VALUES (4, 'MttoZarpeo');
INSERT INTO `categoria_area` VALUES (5, 'MttoEquipoPesado');
INSERT INTO `categoria_area` VALUES (6, 'MttoEquipoLigero');
INSERT INTO `categoria_area` VALUES (7, 'Administrativo');
INSERT INTO `categoria_area` VALUES (8, 'Vigilancia');
INSERT INTO `categoria_area` VALUES (9, 'Limpieza');
INSERT INTO `categoria_area` VALUES (10, 'Salud Ocupacional');
INSERT INTO `categoria_area` VALUES (11, 'Gerencia');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `categoria_parentesco`
-- 

CREATE TABLE `categoria_parentesco` (
  `id_catParentesco` int(12) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY  (`id_catParentesco`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `categoria_parentesco`
-- 

INSERT INTO `categoria_parentesco` VALUES (1, 'Padre');
INSERT INTO `categoria_parentesco` VALUES (2, 'Abuelo');
INSERT INTO `categoria_parentesco` VALUES (3, 'Cuñada');
INSERT INTO `categoria_parentesco` VALUES (4, 'Cuñado');
INSERT INTO `categoria_parentesco` VALUES (5, 'Esposo');
INSERT INTO `categoria_parentesco` VALUES (6, 'Esposa');
INSERT INTO `categoria_parentesco` VALUES (7, 'Hermana');
INSERT INTO `categoria_parentesco` VALUES (8, 'Hermano');
INSERT INTO `categoria_parentesco` VALUES (9, 'Hija');
INSERT INTO `categoria_parentesco` VALUES (10, 'Hijo');
INSERT INTO `categoria_parentesco` VALUES (11, 'Madre');
INSERT INTO `categoria_parentesco` VALUES (12, 'Novia');
INSERT INTO `categoria_parentesco` VALUES (13, 'Suegra');
INSERT INTO `categoria_parentesco` VALUES (14, 'Tia');
INSERT INTO `categoria_parentesco` VALUES (15, 'Vecino');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `categoria_sexo`
-- 

CREATE TABLE `categoria_sexo` (
  `id_catSexo` int(12) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY  (`id_catSexo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `categoria_sexo`
-- 

INSERT INTO `categoria_sexo` VALUES (1, 'Femenino');
INSERT INTO `categoria_sexo` VALUES (2, 'Masculino');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `categoria_tiposangre`
-- 

CREATE TABLE `categoria_tiposangre` (
  `id_catTipoSangre` int(12) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY  (`id_catTipoSangre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `categoria_tiposangre`
-- 

INSERT INTO `categoria_tiposangre` VALUES (1, 'A RH -');
INSERT INTO `categoria_tiposangre` VALUES (2, 'A RH +');
INSERT INTO `categoria_tiposangre` VALUES (3, 'AB RH +');
INSERT INTO `categoria_tiposangre` VALUES (4, 'B RH -');
INSERT INTO `categoria_tiposangre` VALUES (5, 'B RH +');
INSERT INTO `categoria_tiposangre` VALUES (6, 'NO SABE');
INSERT INTO `categoria_tiposangre` VALUES (7, 'O RH -');
INSERT INTO `categoria_tiposangre` VALUES (8, 'O RH +');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `empleados`
-- 

CREATE TABLE `empleados` (
  `id_empleado` bigint(35) NOT NULL auto_increment,
  `num_empleado` bigint(30) NOT NULL,
  `clave_minera` bigint(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido_paterno` varchar(30) default NULL,
  `apellido_materno` varchar(30) default NULL,
  `area_id_area` int(12) NOT NULL,
  `puesto` varchar(30) NOT NULL,
  `telefono` bigint(30) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `edad` int(12) default NULL,
  `escolaridad` varchar(30) default NULL,
  `no_imss` varchar(45) default NULL,
  `rfc` varchar(45) default NULL,
  `curp` varchar(45) default NULL,
  `sexo_id_sexo` int(12) NOT NULL,
  `calle` varchar(45) default NULL,
  `colonia` varchar(30) NOT NULL,
  `ciudad` varchar(30) NOT NULL,
  `estado` varchar(30) NOT NULL,
  `estado_civil` varchar(30) default NULL,
  `dependientes_economicos` int(12) NOT NULL,
  `sangre_id_sangre` int(12) default NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_termino` date NOT NULL,
  `nombre_emergencia` varchar(30) default NULL,
  `parentesco_id_parentesco` int(12) default NULL,
  `telefono_parentesco` bigint(30) default NULL,
  `foto` varchar(100) default NULL,
  PRIMARY KEY  (`id_empleado`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- 
-- Volcar la base de datos para la tabla `empleados`
-- 

INSERT INTO `empleados` VALUES (2, 123, 321, 'jairo', 'jara', 'castrop', 3, 'sistemas', 123, '2016-03-18', 25, 'licenciatura', '12345', '54321', '12345', 2, 'gonzalez', 'esparza', 'fresnillo', 'zacatecas', 'soltero', 1, 2, '2016-03-10', '2016-03-04', 'vero', 11, 49312344, 'C:\\Users\\JAIRO\\Documents\\lona\\Documento1_archivos\\image009.png');
INSERT INTO `empleados` VALUES (3, 456, 987, 'Jose', 'garcia', 'amaro', 2, 'Topografo', 4931234455, '2016-04-02', 30, 'Ingenieria', '12314552644', '4RCVD1222245', '44FGVR12344565', 0, 'Gonzalez', 'Ortega', '215', 'zacatecas', 'Casado', 3, 0, '2016-04-04', '2016-04-08', 'Alejandra', 6, 4931201444, 'C:\\Users\\JAIRO\\Documents\\lona\\Documento1_archivos\\image003.jpg');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `faltas`
-- 

CREATE TABLE `faltas` (
  `id_faltas` int(11) NOT NULL auto_increment,
  `folio` int(20) default NULL,
  `num_empleado` int(12) NOT NULL,
  `nombre` varchar(45) default NULL,
  `apellido_paterno` varchar(45) default NULL,
  `apellido_materno` varchar(45) default NULL,
  `total_faltas` int(15) default NULL,
  PRIMARY KEY  (`id_faltas`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `faltas`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `faltas_has_empleados`
-- 

CREATE TABLE `faltas_has_empleados` (
  `folio` bigint(45) NOT NULL,
  `num_empleado` bigint(16) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido_paterno` varchar(45) default NULL,
  `apellido_materno` varchar(20) default NULL,
  `fecha` date default NULL,
  `faltas` int(13) default NULL,
  `id` int(10) NOT NULL auto_increment,
  `tipo_falta` int(32) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=471 ;

-- 
-- Volcar la base de datos para la tabla `faltas_has_empleados`
-- 

INSERT INTO `faltas_has_empleados` VALUES (3, 456, 'Jose', 'garcia', 'amaro', '2016-03-30', 1, 469, 3);
INSERT INTO `faltas_has_empleados` VALUES (1, 456, 'Jose', 'garcia', 'amaro', '2016-03-14', 1, 467, 1);
INSERT INTO `faltas_has_empleados` VALUES (2, 456, 'Jose', 'garcia', 'amaro', '2016-03-24', 1, 468, 2);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `perfil`
-- 

CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL auto_increment,
  `descripcion` varchar(15) NOT NULL,
  PRIMARY KEY  (`id_perfil`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `perfil`
-- 

INSERT INTO `perfil` VALUES (1, 'Administrador');
INSERT INTO `perfil` VALUES (2, 'Auxiliar');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `usuarios`
-- 

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL auto_increment,
  `nombre` varchar(13) NOT NULL,
  `apellido_paterno` varchar(13) NOT NULL,
  `apellido_materno` varchar(13) default NULL,
  `password` varchar(45) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `perfil_id_perfil` int(11) NOT NULL,
  PRIMARY KEY  (`id_usuario`,`perfil_id_perfil`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- 
-- Volcar la base de datos para la tabla `usuarios`
-- 

INSERT INTO `usuarios` VALUES (1, 'jairo', 'jara', 'castro', '905f0a2a11eef8797c1dcd15f9fa6506', 'jairo', 1);
INSERT INTO `usuarios` VALUES (2, 'administrador', 'admin1', 'admin1234', 'c93ccd78b2076528346216b3b2f701e6', 'admin', 1);
INSERT INTO `usuarios` VALUES (3, 'Nancy', 'Muñoz', 'Espinoza', '7b0f81bdd2b24ba32cb27f6c16e6b900', 'Nancy', 2);
