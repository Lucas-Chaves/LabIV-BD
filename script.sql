create database avaliacao;
use avaliacao;

drop database avaliacao;

CREATE USER 'lucas'@'localhost' IDENTIFIED BY 'lucas';
GRANT ALL PRIVILEGES ON * . * TO 'lucas'@'localhost';

FLUSH PRIVILEGES;

CREATE TABLE `estoque` (
  `id_est` INT NOT NULL AUTO_INCREMENT,
  `estoque_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_est`)
  );
  
  CREATE TABLE `marca` (
  `id_marca` INT NOT NULL AUTO_INCREMENT,
  `marca_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_marca`)
  );
  
CREATE TABLE `produto` (
  `id_produto` INT NOT NULL AUTO_INCREMENT,
  `produto_name` VARCHAR(255) NOT NULL,
  `id_marca` INT NOT NULL,
  PRIMARY KEY (`id_produto`),
  INDEX `id_marca_idx` (`id_marca` ASC),
  CONSTRAINT `id_marca_fk`
    FOREIGN KEY (`id_marca`)
    REFERENCES `marca` (`id_marca`)
);

CREATE TABLE `avaliacao`.`estoque_produto` (
  `id_prod` INT NOT NULL,
  `id_estoq` INT NOT NULL,
  INDEX `id_produto_idx` (`id_prod` ASC),
  INDEX `id_estoque_idx` (`id_estoq` ASC),
  CONSTRAINT `id_produto_fk`
    FOREIGN KEY (`id_prod`)
    REFERENCES `avaliacao`.`produto` (`id_produto`),
  CONSTRAINT `id_estoque_fk`
    FOREIGN KEY (`id_estoq`)
    REFERENCES `avaliacao`.`estoque` (`id_est`)
);





  