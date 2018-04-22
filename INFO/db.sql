-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema trucking
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `trucking` ;

-- -----------------------------------------------------
-- Schema trucking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `trucking` DEFAULT CHARACTER SET utf8 ;
USE `trucking` ;

-- -----------------------------------------------------
-- Table `trucking`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trucking`.`cities` ;

CREATE TABLE IF NOT EXISTS `trucking`.`cities` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `latitude` DECIMAL(6,2) NOT NULL DEFAULT 0,
  `longitude` DECIMAL(6,2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cityName_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trucking`.`vehicle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trucking`.`vehicles` ;

CREATE TABLE IF NOT EXISTS `trucking`.`vehicles` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(45) NOT NULL,
  `capacity` INT UNSIGNED NOT NULL,
  `status` ENUM ('OK', 'BROKEN') NOT NULL DEFAULT 'OK',
  `cities_id` INT UNSIGNED NOT NULL,
  `count_drivers` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `vehicleNumber_UNIQUE` (`number` ASC),
  INDEX `vehicleCity_idx` (`cities_id` ASC),
  CONSTRAINT `vehicleCity`
    FOREIGN KEY (`cities_id`)
    REFERENCES `trucking`.`cities` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trucking`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trucking`.`orders` ;

CREATE TABLE IF NOT EXISTS `trucking`.`orders` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` INT UNSIGNED NOT NULL,
  `vehicles_id` INT UNSIGNED NULL,
  `done_order` ENUM ('YES', 'NO') NOT NULL DEFAULT 'NO',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `orderNumber_UNIQUE` (`number` ASC),
  INDEX `orderVehicle_idx` (`vehicles_id` ASC),
  CONSTRAINT `orderVehicle`
    FOREIGN KEY (`vehicles_id`)
    REFERENCES `trucking`.`vehicles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trucking`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trucking`.`users` ;

CREATE TABLE IF NOT EXISTS `trucking`.`users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `status` ENUM ('DRIVER', 'ADMIN') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userLogin_UNIQUE` (`login` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trucking`.`driver`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trucking`.`drivers` ;

CREATE TABLE IF NOT EXISTS `trucking`.`drivers` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `vehicles_id` INT UNSIGNED NULL,
  `cities_id` INT UNSIGNED NOT NULL,
  `users_id` INT UNSIGNED NOT NULL,
  `orders_id` INT UNSIGNED NULL,
  `last_update` DATETIME NOT NULL DEFAULT NOW(),
  `worked` INT UNSIGNED NOT NULL DEFAULT 0,
  `status` ENUM('REST', 'WORK') NOT NULL DEFAULT 'REST',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `driverNumber_UNIQUE` (`number` ASC),
  INDEX `driverVehicle_idx` (`vehicles_id` ASC),
  INDEX `driverCity_idx` (`cities_id` ASC),
  INDEX `driverUser_idx` (`users_id` ASC),
  INDEX `driverOrder_idx` (`orders_id` ASC),
  CONSTRAINT `driverVehicle`
    FOREIGN KEY (`vehicles_id`)
    REFERENCES `trucking`.`vehicles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `driverCity`
    FOREIGN KEY (`cities_id`)
    REFERENCES `trucking`.`cities` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `driverUser`
    FOREIGN KEY (`users_id`)
    REFERENCES `trucking`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `driverOrder`
    FOREIGN KEY (`orders_id`)
    REFERENCES `trucking`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trucking`.`cargo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trucking`.`cargoes` ;

CREATE TABLE IF NOT EXISTS `trucking`.`cargoes` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` INT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `weight` DECIMAL(15,3) UNSIGNED NOT NULL DEFAULT 0,
  `status` ENUM ('READY', 'SHIPPED', 'DELIVERED') NOT NULL DEFAULT 'READY',
  `cities_id` INT UNSIGNED NOT NULL,
  `vehicles_id` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cargoNumber_UNIQUE` (`number` ASC),
  INDEX `cargoCity_idx` (`cities_id` ASC),
  INDEX `cargoVehicle_idx` (`vehicles_id` ASC),
  CONSTRAINT `cargoCity`
    FOREIGN KEY (`cities_id`)
    REFERENCES `trucking`.`cities` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cargoVehicle`
    FOREIGN KEY (`vehicles_id`)
    REFERENCES `trucking`.`vehicles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trucking`.`checkpoints`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trucking`.`checkpoints` ;

CREATE TABLE IF NOT EXISTS `trucking`.`checkpoints` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `orders_id` INT UNSIGNED NOT NULL,
  `cities_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `checkpointOrder_idx` (`orders_id` ASC),
  INDEX `checkpointCity_idx` (`cities_id` ASC),
  CONSTRAINT `CheckpointOrder`
    FOREIGN KEY (`orders_id`)
    REFERENCES `trucking`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `CheckpointCity`
    FOREIGN KEY (`cities_id`)
    REFERENCES `trucking`.`cities` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trucking`.`subtask`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trucking`.`subtasks` ;

CREATE TABLE IF NOT EXISTS `trucking`.`subtasks` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `checkpoint_id` INT UNSIGNED NOT NULL,
  `cargo_id` INT UNSIGNED NOT NULL,
  `operation` ENUM ('LOADING', 'UNLOADING') NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `subtaskCheckpoint_idx` (`checkpoint_id` ASC),
  INDEX `subtaskCargo_idx` (`cargo_id` ASC),
  CONSTRAINT `SubtaskCheckpoint`
    FOREIGN KEY (`checkpoint_id`)
    REFERENCES `trucking`.`checkpoints` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `SubtaskCargo`
    FOREIGN KEY (`cargo_id`)
    REFERENCES `trucking`.`cargoes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

