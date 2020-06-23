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

CREATE TABLE `estoque_produto` (
  `id_produto` INT NOT NULL,
  `id_est` INT NOT NULL,
  INDEX `id_produto_idx` (`id_produto` ASC),
  INDEX `id_estoque_idx` (`id_est` ASC),
  CONSTRAINT `id_produto_fk`
    FOREIGN KEY (`id_produto`)
    REFERENCES `produto` (`id_produto`),
  CONSTRAINT `id_estoque_fk`
    FOREIGN KEY (`id_est`)
    REFERENCES `estoque` (`id_est`)
);

CREATE TABLE `livro` (
  `id_produto` INT NOT NULL,
  `liv_author` VARCHAR(255) NOT NULL,
  `liv_titulo` VARCHAR(255) NOT NULL,
  INDEX `id_produto_idx` (`id_produto` ASC),
  CONSTRAINT `id_produto`
    FOREIGN KEY (`id_produto`)
    REFERENCES `produto` (`id_produto`));
    
CREATE TABLE `funcionario` (
  `id_func` INT NOT NULL AUTO_INCREMENT,
  `name_func` VARCHAR(255) NOT NULL,
  `doc_func` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_func`));


select *
from produto p 
where p.produto_name = "shampoo"





  