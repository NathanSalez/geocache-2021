-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema geocache
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `geocache` ;

-- -----------------------------------------------------
-- Schema geocache
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `geocache` ;
USE `geocache` ;

-- -----------------------------------------------------
-- Table `geocache`.`CACHE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geocache`.`CACHE` ;

CREATE TABLE IF NOT EXISTS `geocache`.`CACHE` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT NOT NULL,
  `latitude` DOUBLE NULL,
  `longitude` DOUBLE NULL,
  `url` VARCHAR(255) NULL,
  `etat` VARCHAR(45) NOT NULL DEFAULT 'fermée',
  `type` VARCHAR(45) NOT NULL DEFAULT 'traditionnelle',
  `nature` VARCHAR(45) NOT NULL DEFAULT 'physique',
  `idProprietaire` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `geocache`.`UTILISATEUR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geocache`.`UTILISATEUR` ;

CREATE TABLE IF NOT EXISTS `geocache`.`UTILISATEUR` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pseudo` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NOT NULL DEFAULT 'L\'utilisateur n\'a pas modifié sa description.',
  `urlPhoto` VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `pseudo_UNIQUE` (`pseudo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `geocache`.`VISITE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geocache`.`VISITE` ;

CREATE TABLE IF NOT EXISTS `geocache`.`VISITE` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idCache` INT NOT NULL,
  `idUtilisateur` INT NOT NULL,
  `dateHeure` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `urlPhoto` VARCHAR(255) NOT NULL DEFAULT '',
  `commentaire` TEXT NOT NULL,
  `reussi` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
