-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 22-Nov-2017 às 21:44
-- Versão do servidor: 5.6.15-log
-- PHP Version: 5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bd_dsc`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acesso`
--

CREATE TABLE IF NOT EXISTS `acesso` (
  `codAcesso` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `login` text NOT NULL,
  `senha` text NOT NULL,
  `tipoAcesso` int(11) NOT NULL,
  PRIMARY KEY (`codAcesso`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `acesso`
--

INSERT INTO `acesso` (`codAcesso`, `nome`, `login`, `senha`, `tipoAcesso`) VALUES
(1, 'Leonardo Faeda', 'faeda', '123', 1),
(2, 'Diego Noceli', 'noceli', '123', 2),
(3, 'admin', 'admin', '123', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `caixa`
--

CREATE TABLE IF NOT EXISTS `caixa` (
  `codOperacao` int(11) NOT NULL AUTO_INCREMENT,
  `codCliente` int(11) NOT NULL,
  `data` date NOT NULL,
  `quantidadeFicha` int(11) NOT NULL,
  `valorTotal` text NOT NULL,
  `tipoOperacao` text NOT NULL,
  PRIMARY KEY (`codOperacao`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `codCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCliente` text NOT NULL,
  `cpfCliente` text NOT NULL,
  `telefoneCliente` text NOT NULL,
  PRIMARY KEY (`codCliente`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`codCliente`, `nomeCliente`, `cpfCliente`, `telefoneCliente`) VALUES
(2, 'diego', '111.111.111-11', '(11)1111-1111'),
(3, 'Leo', '111.111.111-11', '(11)1111-1111'),
(4, 'Jose', '111.111.111-11', '(11)1111-1111'),
(5, 'Pedro', '111.111.111-11', '(11)1111-1111'),
(6, 'Italo', '111.111.111-11', '(11)1111-1111'),
(7, 'Caio', '111.111.111-11', '(11)1111-1111'),
(11, 'Teste', 'teste', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `ficha`
--

CREATE TABLE IF NOT EXISTS `ficha` (
  `codFicha` int(11) NOT NULL AUTO_INCREMENT,
  `precoFicha` text NOT NULL,
  PRIMARY KEY (`codFicha`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `ficha`
--

INSERT INTO `ficha` (`codFicha`, `precoFicha`) VALUES
(1, 'R$ 100,00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE IF NOT EXISTS `funcionarios` (
  `codFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `salarioFuncionaio` char(20) NOT NULL,
  `cpfFuncionario` text NOT NULL,
  `nomeFuncionario` text NOT NULL,
  `telefoneFuncionario` text NOT NULL,
  PRIMARY KEY (`codFuncionario`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Extraindo dados da tabela `funcionarios`
--

INSERT INTO `funcionarios` (`codFuncionario`, `salarioFuncionaio`, `cpfFuncionario`, `nomeFuncionario`, `telefoneFuncionario`) VALUES
(9, 'R$3333,33', '222.222.222-22', 'pablim', '(33)3333-3333'),
(10, 'R$3333,33', '111.111.111-11', 'woshton', '(33)3333-3333'),
(11, 'R$3333,33', '111.111.111-11', 'wallace', '(33)3333-3333'),
(12, 'R$4444,44', '222.222.222-22', 'rodolfo', '(33)3333-3333'),
(13, 'R$1111,11', '111.111.111-11', 'Ariel', '(11)1111-1111'),
(14, 'R$1111,11', '111.111.111-11', 'Jose', '(11)1111-1111'),
(16, 'R$2222,22', '213.213.333-33', 'diegoNunes', '(12)3123-3333');

-- --------------------------------------------------------

--
-- Estrutura da tabela `gerentes`
--

CREATE TABLE IF NOT EXISTS `gerentes` (
  `codGerente` int(11) NOT NULL AUTO_INCREMENT,
  `salarioGerente` text NOT NULL,
  `cpfGerente` text NOT NULL,
  `nomeGerente` text NOT NULL,
  `telefoneGerente` text NOT NULL,
  PRIMARY KEY (`codGerente`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `gerentes`
--

INSERT INTO `gerentes` (`codGerente`, `salarioGerente`, `cpfGerente`, `nomeGerente`, `telefoneGerente`) VALUES
(1, '1200', '111.111.111-11', 'Leo', '(11)1111-1111');

-- --------------------------------------------------------

--
-- Estrutura da tabela `maquinas`
--

CREATE TABLE IF NOT EXISTS `maquinas` (
  `codMaquina` int(11) NOT NULL AUTO_INCREMENT,
  `nomeMaquina` text NOT NULL,
  `statusMaquina` text NOT NULL,
  PRIMARY KEY (`codMaquina`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `maquinas`
--

INSERT INTO `maquinas` (`codMaquina`, `nomeMaquina`, `statusMaquina`) VALUES
(1, 'Maquina 1', '0');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
