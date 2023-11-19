-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Jugadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Jugadores` (
  `idJugador` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `edadLimite` TINYINT NOT NULL,
  `pazGuerra` TINYINT NOT NULL,
  PRIMARY KEY (`idJugador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Personas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Personas` (
  `idpersonas` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(10) NOT NULL,
  `genero` VARCHAR(1) NOT NULL,
  `consumo` INT NOT NULL,
  `moral` INT NOT NULL,
  `tiempoColonia` INT NOT NULL,
  `fuerza` INT NULL,
  `alimentaXdia` INT NOT NULL,
  `profesion` VARCHAR(45) NULL,
  `produce` VARCHAR(45) NULL,
  `personaColonia` VARCHAR(45) NULL,
  `idJugador` INT NOT NULL,
  `muereVivo` TINYINT NOT NULL,
  PRIMARY KEY (`idpersonas`),
  INDEX `fk_personas_jugador_idx` (`idJugador` ASC) VISIBLE,
  CONSTRAINT `fk_personas_jugador`
    FOREIGN KEY (`idJugador`)
    REFERENCES `mydb`.`Jugadores` (`idJugador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`historialGuerra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`historialGuerra` (
  `idHistorialGuerras` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL,
  `resultado` VARCHAR(45) NULL,
  `contrincante` VARCHAR(45) NULL,
  `idJugador` INT NOT NULL,
  PRIMARY KEY (`idHistorialGuerras`),
  INDEX `fk_historialGuerra_Jugadores1_idx` (`idJugador` ASC) VISIBLE,
  CONSTRAINT `fk_historialGuerra_Jugadores1`
    FOREIGN KEY (`idJugador`)
    REFERENCES `mydb`.`Jugadores` (`idJugador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`jugadorCredentials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`jugadorCredentials` (
  `idJugador` INT NOT NULL,
  `passwordHashed` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idJugador`),
  CONSTRAINT `fk_jugadorCredentials_jugadores1`
    FOREIGN KEY (`idJugador`)
    REFERENCES `mydb`.`Jugadores` (`idJugador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
