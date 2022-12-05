-- Creamos la base de datos DiscografiaPF --
CREATE DATABASE IF NOT EXISTS DiscografiaPF CHARSET utf8mb4 COLLATE utf8mb4_spanish_ci;

-- Ponemos en uso la base de datos DiscografiaPF --
USE DiscografiaPF;

-- Creamos la tabla Banda con las columnas ID_Banda INT PK, Nom_Banda VARCHAR, Album_Debut VARCHAR y Album_Ultimo VARCHAR --
CREATE TABLE IF NOT EXISTS Banda (ID_Banda INT PRIMARY KEY AUTO_INCREMENT,
								  Nom_Banda VARCHAR(50) NOT NULL,
								  Album_Debut VARCHAR(100) NOT NULL,
                                  Album_ultimo VARCHAR(100));
 
-- Insertamos datos de prueba en la tabla Banda --
INSERT INTO Banda (ID_Banda, Nom_Banda, Album_Debut, Album_Ultimo)
	VALUES (DEFAULT, 'Exodus', 'Bounded By Blood', 'Persona Non Grata'),
		   (DEFAULT, 'Megadeth', 'Killing is My Businees... And Busines is Good', 'The Sick, The Dying... And The Dead'),
           (DEFAULT, 'Metallica', 'Kill ´em All', 'Hardwired... To Selft-Destruct'),
           (DEFAULT, 'Slayer', 'Show No Mercy', 'Repentless'),
           (DEFAULT, 'Arch Enemy', 'Black Earth', 'Deceivers');
           
-- Consultamos dichos datos --
SELECT * FROM Banda;
                                  
