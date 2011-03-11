/*
SQLyog Enterprise - MySQL GUI v8.12 
MySQL - 5.1.41-3ubuntu12.9 : Database - shoebox
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`shoebox` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `shoebox`;

/*Table structure for table `CategorieCharge` */

DROP TABLE IF EXISTS `CategorieCharge`;

CREATE TABLE `CategorieCharge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Description` varchar(255) DEFAULT NULL,
  `nomCategorie` varchar(255) DEFAULT NULL,
  `cooperative_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ADA2AB5C9314D5` (`cooperative_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `CategorieCharge` */

insert  into `CategorieCharge`(`id`,`Description`,`nomCategorie`,`cooperative_id`) values (1,NULL,'categ1',1),(2,NULL,'categ2',1);

/*Table structure for table `CharteCompte` */

DROP TABLE IF EXISTS `CharteCompte`;

CREATE TABLE `CharteCompte` (
  `id` varchar(255) NOT NULL,
  `numero` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `reference` varchar(255) NOT NULL,
  `nature` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `CharteCompte` */

insert  into `CharteCompte`(`id`,`numero`,`nom`,`type`,`reference`,`nature`) values ('1','1 010,000000','Capital social','BILAN','CA','Fixe'),('2','1 020,000000','Capital par dotation','BILAN','CB','Variable'),('3','1 110,000000','Réserves légales','BILAN','CC','Fixe'),('4','1 120,000000','Réserves statutaires','BILAN','CC','Variable'),('5','1 180,000000','Autres reserves','BILAN','CC','Variable'),('6','1 200,000000','Report à nouveau','BILAN','CH','Fixe'),('7','1 300,000000','Resultat de l\'exercice','BILAN','CI','Fixe'),('12','1 400,000000','Subventions d\'investissement','BILAN','CL','NULL'),('13','1 600,000000','Emprunts et dettes assimilées','BILAN','DA','NULL'),('14','1 700,000000','Dettes de crédit-bail et contrats assimilés','BILAN','DB','NULL'),('15','1 640,000000','Dettes finanicères diverses','BILAN','DC','NULL'),('16','2 200,000000','Terrains (valeur résiduelle)','BILAN','AJ','NULL'),('17','2 310,000000','Batiments agricoles et intallations techniques (valeur résiduelle)','BILAN','AK','NULL'),('18','2 420,000000','Matériel et outillage agricole (valeur résiduelle)','BILAN','AM','NULL'),('19','2 440,000000','Matériel et mobilier de bureau  (valeur résiduelle)','BILAN','AL','NULL'),('20','2 450,000000','Matériel de transport  (valeur résiduelle)','BILAN','AN','NULL'),('21','2 610,000000','Titres de participation (placements)','BILAN','AR','NULL'),('22','2 750,000000','Dépôts et cautionnements','BILAN','AS','NULL'),('23','2 830,000000','Amortissements des.batiments et intallations techniques','BILAN','NULL','NULL'),('24','2 842,000000','Amortisements.matériel et outillage agricole','BILAN','NULL','NULL'),('25','2 844,000000','Amortisements.matériel et mobilier de bureau','BILAN','NULL','NULL'),('26','2 845,000000','Amortisements.matériel de transport','BILAN','NULL','NULL'),('27','3 110,000000','Stocks de produits agricoles','BILAN','BC','NULL'),('28','3 310,000000','Stocks intrants agricoles','BILAN','BD','NULL'),('29','3 600,000000','Stocks de produits à valeur ajoutée(produits finis)','BILAN','BF','NULL'),('30','4 011,000000','Comptes courants coopérateurs ','BILAN','BH','NULL'),('31','4 019,000000','Fournisseurs de transport','BILAN','BH','NULL'),('32','4 111,000000','Clients café cacao','BILAN','BI','NULL'),('33','4 160,000000','Créances douteuses','BILAN','BI','NULL'),('34','4 180,000000','Clients, produits à recevoir','BILAN','BI','NULL'),('35','4 210,000000','Personnel, avances, prêt et acompte','BILAN','BJ','NULL'),('36','4 220,000000','Personnel, remunérations dues','BILAN','DL','NULL'),('37','4 310,000000','Sécurité sociale','BILAN','DL','NULL'),('38','4 470,000000','Etat et collectivités publiques','BILAN','DK','NULL'),('39','4 621,000000','Coopérateurs, prêts et créances','BILAN','BJ','NULL'),('40','4 650,000000','Ristournes coopérateurs','BILAN','BJ','NULL'),('41','4 670,000000','Coopérateurs compte de souscription','BILAN','BJ','NULL'),('42','4 760,000000','Charges constatées d\'avance','BILAN','BJ','NULL'),('43','4 810,000000','Fournisseurs d\'investissement','BILAN','DH','NULL'),('44','4 900,000000','Dépréciations et risques provisonnés','BILAN','NULL','NULL'),('45','5 000,000000','Titres de placement','BILAN','BQ','NULL'),('46','5 210,000000','Banques','BILAN','BS','NULL'),('47','5 700,000000','Caisse','BILAN','BS','NULL'),('48','6 011,000000','Apports de produits agricoles café cacao (achats)','CHARGE','RA-1','NULL'),('49','6 012,000000','Apports de produits agricoles autres (achats)','CHARGE','RA-2','NULL'),('50','6 020,000000','Achats de matières premières et fournitures liées','CHARGE','RC','NULL'),('51','6 050,000000','Autres achats','CHARGE','RE','NULL'),('52','6 321,000000','Ristournes des projets versées coopérateurs','CHARGE','RJ','NULL'),('53','6 030,000000','Variation de stocks café-cacao','CHARGE','RB-1','NULL'),('54','6 032,000000','Variation de stocks produits agricoles','CHARGE','RB-2','NULL'),('55','7 360,000000','Variation de stocks produits à valeur ajoutée','CHARGE','TE','NULL'),('56','7 370,000000','Variation de stocks autres produits','CHARGE','TE','NULL'),('57','6 042,000000','Carburant et lubrifiant','CHARGE','RE','NULL'),('58','6 043,000000','Pneumatique','CHARGE','RE','NULL'),('59','6 044,000000','Pièces de rechanges','CHARGE','RE','NULL'),('60','6 045,000000','Produits d\'entretien','CHARGE','RE','NULL'),('61','6 046,000000','Sacherie','CHARGE','RE','NULL'),('62','6 047,000000','Fournitures de magasin','CHARGE','RE','NULL'),('63','6 048,000000','Fournitures de bureau','CHARGE','RE','NULL'),('64','6 051,000000','Eau','CHARGE','RE','NULL'),('65','6 052,000000','Electricité','CHARGE','RE','NULL'),('66','6 056,000000','Achats de petit matériel et outillage','CHARGE','RE','NULL'),('67','6 058,000000','Achats travaux, mat.et équipement','CHARGE','RE','NULL'),('68','6 110,000000','Transport sur apport (collecte)','CHARGE','RI','NULL'),('69','6 120,000000','Transport sur ventes (évacuation)','CHARGE','RI','NULL'),('70','6 180,000000','Autres frais de transport','CHARGE','RI','NULL'),('71','6 223,000000','Locations matériel & équipements','CHARGE','RJ','NULL'),('72','6 220,000000','Locations véhicule','CHARGE','RJ','NULL'),('73','6 241,000000','Entretien et reparation','CHARGE','RJ','NULL'),('74','6 243,000000','Maintenance','CHARGE','RJ','NULL'),('75','6 252,000000','Assurance auto / moto','CHARGE','RJ','NULL'),('76','6 258,000000','Assurances feu / vol / responsabilité civile','CHARGE','RJ','NULL'),('77','6 281,000000','Frais de téléphone','CHARGE','RJ','NULL'),('78','6 288,000000','Autres frais de télécommunication','CHARGE','RJ','NULL'),('79','6 282,000000','Frais de poste / messagerie / courrier','CHARGE','RJ','NULL'),('80','6 310,000000','Frais bancaires','CHARGE','RJ','NULL'),('81','6 310,000000','Intérêts / frais financiers / opérations de trésorerie','CHARGE','RJ','NULL'),('82','6 760,000000','Pertes de change','CHARGE','SC','NULL'),('83','6 322,000000','Subventions accordées','CHARGE','RJ','NULL'),('84','6 324,000000','Honoraires','CHARGE','RJ','NULL'),('85','6 328,000000','Frais divers','CHARGE','RJ','NULL'),('86','6 220,000000','Loyer','CHARGE','RJ','NULL'),('87','6 330,000000','Frais de formation','CHARGE','RJ','NULL'),('88','6 340,000000','Redevances bascules','CHARGE','RJ','NULL'),('89','6 350,000000','Cotisations','CHARGE','RJ','NULL'),('90','6 373,000000','Frais décharg.charg.produits agricoles (manutention)','CHARGE','RJ','NULL'),('91','6 370,000000','Remunérations et autres main d\'œuvres temporaires','CHARGE','RJ','NULL'),('92','6 383,000000','Réceptions','CHARGE','RJ','NULL'),('93','6 384,000000','Missions','CHARGE','RJ','NULL'),('94','6 400,000000','Impôts et taxes','CHARGE','RK','NULL'),('95','6 510,000000','Perte sur créances','CHARGE','RL','NULL'),('96','6 581,000000','Jetons de présence administrateurs','CHARGE','RL','NULL'),('97','6 582,000000','Dons et pourboires','CHARGE','RL','NULL'),('98','6 582,000000','Frais de route','CHARGE','RL','NULL'),('99','6 583,000000','Frais d\'AG et de CA','CHARGE','RL','NULL'),('100','6 584,000000','Frais de Comités','CHARGE','RL','NULL'),('101','6 585,000000','Pénalité et amendes','CHARGE','RL','NULL'),('102','6 590,000000','Charges provisionnées d\'exploitation ','CHARGE','RL','NULL'),('103','6 600,000000','Charges de personnel','CHARGE','RP','NULL'),('104','6 745,000000','Intérêt bancaires et opération de trésorerie','CHARGE','SA','NULL'),('105','6 800,000000','Dotation aux amortissements','CHARGE','RS','NULL'),('106','6 900,000000','Taxes & prélevés','PRODUIT','NULL','NULL'),('107','7 071,000000','Ventes de café-cacao','PRODUIT','TA-1','NULL'),('108','7 012,000000','Ventes produits agricoles','PRODUIT','TA-2','NULL'),('109','7 013,000000','Ventes d\'intrants','PRODUIT','TC','NULL'),('110','7 020,000000','Ventes de produits à valeur ajoutée','PRODUIT','TC','NULL'),('111','7 061,000000','Transports facturés','PRODUIT','TD','NULL'),('112','7 062,000000','Commissions sur produits agricoles','PRODUIT','TD','NULL'),('113','7 070,000000','Autres produits ','PRODUIT','TH','NULL'),('114','7 110,000000','Subventions d\'exploitation','PRODUIT','TK','NULL'),('115','7 183,000000','Autres subventions','PRODUIT','TK','NULL'),('116','8 400,000000','Revenus hors activités ordinaires','PRODUIT','UL','NULL'),('117','7 760,000000','Gains de change','PRODUIT','UC','NULL'),('118','7 780,000000','Intérêt /dépôts et placement','PRODUIT','UA','NULL'),('119','8 220,000000','Produits des cessions des immobilisations corporelles','PRODUIT','UK','NULL'),('120','8 650,000000','Reprises de subventions d\'investissement','PRODUIT','UM','NULL'),('121','1 630,000000','Remboursement fournisseur d\'intrant','CHARGE','DJ',''),('122','1 620,000000','Remboursement fournisseur de produit ','CHARGE','DI',''),('123','1 610,000000','Avance Client','CHARGE','DI',''),('124','10000','Stock debut produit agricole','Solde de depart','RA-1-SD',''),('125','10001','Stock debut produit agricole','Solde de depart','RA-2-SD',''),('126','10002','Stock à la fin Produit principal','Solde de depart','RA-1-SF',''),('127','10003','Stock à la fin Produit agricole','Solde de depart','RA-2-SF',''),('128','10004','Stock debut matiere premiere','Solde de depart','RC-SD',''),('129','10005','Stock à la fin matiere premiere','Solde de part','RC-SF',''),('130','10006','Stock debut autre achat','Solde de depart','RE-SD',''),('131','10007','Stock à la fin autre achat','Solde de depart','RE-SF','');

/*Table structure for table `CharteCompte_copy` */

DROP TABLE IF EXISTS `CharteCompte_copy`;

CREATE TABLE `CharteCompte_copy` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `numero` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `currentuser_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8036090775047F3D` (`currentuser_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `CharteCompte_copy` */

insert  into `CharteCompte_copy`(`id`,`numero`,`nom`,`type`,`reference`,`currentuser_id`) values ('1','6011','Apports de produits agricoles café cacao (achats)','CHARGE','RA-1',NULL),('2','6012','Apports de produits agricoles autres (achats)','CHARGE','RA-2',NULL),('3','6020','Achats de matières premières et fournitures liées','CHARGE','RC',NULL),('4','6050','Autres achats','CHARGE','RE',NULL),('5','6321','Ristournes des projets versées coopérateurs','CHARGE','RJ',NULL),('6','6030','Variation de stocks café-cacao','CHARGE','RB-1',NULL),('7','6032','Variation de stocks produits agricoles','CHARGE','RB-2',NULL),('8','7360','Variation de stocks produits à valeur ajoutée','CHARGE','TE',NULL),('9','7370','Variation de stocks autres produits','CHARGE','TE',NULL),('10','6042','Carburant et lubrifiant','CHARGE','RE',NULL),('11','6043','Pneumatique','CHARGE','RE',NULL),('12','6044','Pièces de rechanges','CHARGE','RE',NULL),('13','6045','Produits d\'entretien','CHARGE','RE',NULL),('14','6046','Sacherie','CHARGE','RE',NULL),('15','6047','Fournitures de magasin','CHARGE','RE',NULL),('16','6048','Fournitures de bureau','CHARGE','RE',NULL),('17','6051','Eau','CHARGE','RE',NULL),('18','6052','Electricité','CHARGE','RE',NULL),('19','6056','Achats de petit matériel et outillage','CHARGE','RE',NULL),('20','6058','Achats travaux, mat.et équipement','CHARGE','RE',NULL),('21','6110','Transport sur apport (collecte)','CHARGE','RI',NULL),('22','6120','Transport sur ventes (évacuation)','CHARGE','RI',NULL),('23','6180','Autres frais de transport','CHARGE','RI',NULL),('24','6223','Locations matériel & équipements','CHARGE','RJ',NULL),('25','6220','Locations véhicule','CHARGE','RJ',NULL),('26','6241','Entretien et reparation','CHARGE','RJ',NULL),('27','6243','Maintenance','CHARGE','RJ',NULL),('28','6252','Assurance auto / moto','CHARGE','RJ',NULL),('29','6258','Assurances feu / vol / responsabilité civile','CHARGE','RJ',NULL),('30','6281','Frais de téléphone','CHARGE','RJ',NULL),('31','6288','Autres frais de télécommunication','CHARGE','RJ',NULL),('32','6282','Frais de poste / messagerie / courrier','CHARGE','RJ',NULL),('33','6310','Frais bancaires','CHARGE','RJ',NULL),('34','6310','Intérêts / frais financiers / opérations de trésorerie','CHARGE','RJ',NULL),('35','6760','Pertes de change','CHARGE','SC',NULL),('36','6322','Subventions accordées','CHARGE','RJ',NULL),('37','6324','Honoraires','CHARGE','RJ',NULL),('38','6328','Frais divers','CHARGE','RJ',NULL),('39','6220','Loyer','CHARGE','RJ',NULL),('40','6330','Frais de formation','CHARGE','RJ',NULL),('41','6340','Redevances bascules','CHARGE','RJ',NULL),('42','6350','Cotisations','CHARGE','RJ',NULL),('43','6373','Frais décharg.charg.produits agricoles (manutention)','CHARGE','RJ',NULL),('44','6370','Remunérations et autres main d\'œuvres temporaires','CHARGE','RJ',NULL),('45','6383','Réceptions','CHARGE','RJ',NULL),('46','6384','Missions','CHARGE','RJ',NULL),('47','6400','Impôts et taxes','CHARGE','RK',NULL),('48','6510','Perte sur créances','CHARGE','RL',NULL),('49','6581','Jetons de présence administrateurs','CHARGE','RL',NULL),('50','6582','Dons et pourboires','CHARGE','RL',NULL),('51','6582','Frais de route','CHARGE','RL',NULL),('52','6583','Frais d\'AG et de CA','CHARGE','RL',NULL),('53','6584','Frais de Comités','CHARGE','RL',NULL),('54','6585','Pénalité et amendes','CHARGE','RL',NULL),('55','6590','Charges provisionnées d\'exploitation ','CHARGE','RL',NULL),('56','6600','Charges de personnel','CHARGE','RP',NULL),('57','6745','Intérêt bancaires et opération de trésorerie','CHARGE','SA',NULL),('58','6800','Dotation aux amortissements','CHARGE','RS',NULL),('59','6900','Taxes & prélevés','CHARGE','RL',NULL),('61','10000','Stock debut produit  principal','solde depart','RA-1-SD',NULL),('60','10002','Stock debut produit agricole','solde depart','RA-2-SD',NULL),('62','10001','Stock à la fin Produit principal','solde depart','RA-1-SF',NULL),('63','10003','Stock à la fin Produit agricole','solde depart','RA-2-SF',NULL),('64','10004','Stock debut matiere premiere','solde depart','RC-SD',NULL),('65','10005','Stock à la fin matiere premiere','solde depart','RC-SF',NULL),('66 ','10006','Stock debut autre achat','solde depart','RE-SD',NULL),('67',NULL,'Stock à la fin autre achat','solde depart','RE-SF',NULL);

/*Table structure for table `Commande` */

DROP TABLE IF EXISTS `Commande`;

CREATE TABLE `Commande` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `confirmation` bit(1) NOT NULL,
  `dateCommande` date DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `coop_id` bigint(20) DEFAULT NULL,
  `currentuser_id` bigint(20) DEFAULT NULL,
  `defPeriode_id` bigint(20) DEFAULT NULL,
  `m_entite_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKDFF06E9AE1B9D193` (`coop_id`),
  KEY `FKDFF06E9A75047F3D` (`currentuser_id`),
  KEY `FKDFF06E9A12A1262D` (`m_entite_id`),
  KEY `FKDFF06E9A131A1E70` (`defPeriode_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `Commande` */

insert  into `Commande`(`id`,`confirmation`,`dateCommande`,`reference`,`type`,`coop_id`,`currentuser_id`,`defPeriode_id`,`m_entite_id`) values (1,'\0','2011-03-27','bhujjj','EPP',1,1,7,12),(2,'\0','2011-03-27','etrert','EPI',1,1,7,14),(3,'\0','2011-03-20','ghjtyu','EPS',1,1,7,12),(4,'\0','2011-03-25','wtrwuryiwye','EPP',1,1,2,12),(5,'','2011-03-19','yuyuiwey','SPP',1,1,2,13),(6,'','2011-03-25','ty7876','SPP',1,1,2,13),(7,'','2011-03-24','adfsdfsf','SI',1,1,7,12),(8,'','2011-03-25','wer','SPS',1,1,7,13),(9,'','2011-03-26','123','SPS',1,1,7,13),(10,'','2011-03-25','qwreer','SI',1,1,7,12),(11,'\0','2011-07-15','defrgthy','EPP',1,1,7,15),(12,'','2011-07-07','werer','SI',1,1,7,12);

/*Table structure for table `Commande_TransactionCaisse` */

DROP TABLE IF EXISTS `Commande_TransactionCaisse`;

CREATE TABLE `Commande_TransactionCaisse` (
  `Commande_id` bigint(20) NOT NULL,
  `lsttransactionCaisse_id` bigint(20) NOT NULL,
  UNIQUE KEY `lsttransactionCaisse_id` (`lsttransactionCaisse_id`),
  KEY `FKB16AC535E4B965F` (`Commande_id`),
  KEY `FKB16AC53493980E2` (`lsttransactionCaisse_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `Commande_TransactionCaisse` */

insert  into `Commande_TransactionCaisse`(`Commande_id`,`lsttransactionCaisse_id`) values (1,1),(2,3),(2,2),(2,4),(5,5),(5,7),(6,8),(7,20),(8,14),(9,15),(10,16),(3,17),(9,18),(8,19),(7,13),(7,21),(11,23),(11,22),(11,24),(3,25);

/*Table structure for table `Compte` */

DROP TABLE IF EXISTS `Compte`;

CREATE TABLE `Compte` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Description` varchar(255) DEFAULT NULL,
  `folio` varchar(255) DEFAULT NULL,
  `nomCompte` varchar(255) DEFAULT NULL,
  `typeCompte` varchar(255) DEFAULT NULL,
  `currentuser_id` bigint(20) DEFAULT NULL,
  `coop_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK78A421E075047F3D` (`currentuser_id`),
  KEY `FK78A421E0E1B9D193` (`coop_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `Compte` */

insert  into `Compte`(`id`,`Description`,`folio`,`nomCompte`,`typeCompte`,`currentuser_id`,`coop_id`) values (1,NULL,'123','BMO','Banque',1,1),(2,NULL,'323','Caisse1','Caisse',1,1);

/*Table structure for table `Cooperative` */

DROP TABLE IF EXISTS `Cooperative`;

CREATE TABLE `Cooperative` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `Cooperative` */

insert  into `Cooperative`(`id`,`name`,`reference`) values (1,'coop1','kldksl');

/*Table structure for table `DefinitionPeriode` */

DROP TABLE IF EXISTS `DefinitionPeriode`;

CREATE TABLE `DefinitionPeriode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mois` varchar(255) DEFAULT NULL,
  `numMois` int(11) NOT NULL,
  `periode` varchar(255) DEFAULT NULL,
  `periodeActif` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `DefinitionPeriode` */

insert  into `DefinitionPeriode`(`id`,`mois`,`numMois`,`periode`,`periodeActif`) values (1,'Janvier',1,'P1','\0'),(2,'Fevrier',2,'P2','\0'),(3,'Mars',3,'P3','\0'),(4,'Avril',4,'P4','\0'),(5,'Mai',5,'P5','\0'),(6,'Juin',6,'P6','\0'),(7,'Juillet',7,'P7',''),(8,'Aout',8,'P8','\0'),(9,'Septembre',9,'P9','\0'),(10,'Octobre',10,'P10','\0'),(11,'Novembre',11,'P11','\0'),(12,'Decembre',12,'P12','\0');

/*Table structure for table `Entite` */

DROP TABLE IF EXISTS `Entite`;

CREATE TABLE `Entite` (
  `DTYPE` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `distance` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `pointCollecte` varchar(255) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `coop_id` bigint(20) DEFAULT NULL,
  `currentuser_id` bigint(20) DEFAULT NULL,
  `soldeDepart_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7C02CFEFE1B9D193` (`coop_id`),
  KEY `FK7C02CFEF75047F3D` (`currentuser_id`),
  KEY `FK7C02CFEF6F9F06B5` (`soldeDepart_id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `Entite` */

insert  into `Entite`(`DTYPE`,`id`,`distance`,`name`,`reference`,`pointCollecte`,`statut`,`coop_id`,`currentuser_id`,`soldeDepart_id`) values ('FournisseurProduit',12,'789','sdafkjl','taktou','tunisie','Membre',1,1,5),('Client',13,NULL,'ertert','rttttt',NULL,NULL,1,1,6),('FournisseurIntrant',14,NULL,'qwe','qwe',NULL,NULL,1,1,7),('FournisseurProduit',15,'234','nayek','fadhel','tunisie','Membre',1,1,8);

/*Table structure for table `Magasin` */

DROP TABLE IF EXISTS `Magasin`;

CREATE TABLE `Magasin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `distance` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `currentuser_id` bigint(20) DEFAULT NULL,
  `coop_id` bigint(20) DEFAULT NULL,
  `commande_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK949F308A75047F3D` (`currentuser_id`),
  KEY `FK949F308AE1B9D193` (`coop_id`),
  KEY `FK949F308A5E4B965F` (`commande_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `Magasin` */

insert  into `Magasin`(`id`,`description`,`distance`,`name`,`currentuser_id`,`coop_id`,`commande_id`) values (1,'',34890234,'mag1 ',1,1,NULL),(2,'',13322,'magasin2 ',1,1,NULL),(3,'qeqweqeqweqweqe',12333,'magasin3',1,1,NULL);

/*Table structure for table `ParamTransaction` */

DROP TABLE IF EXISTS `ParamTransaction`;

CREATE TABLE `ParamTransaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `abrev` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `charteCompte_id` varchar(255) DEFAULT NULL,
  `currentuser_id` bigint(20) DEFAULT NULL,
  `cooperative_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA7CFBC313746C8DF` (`charteCompte_id`),
  KEY `FKA7CFBC3175047F3D` (`currentuser_id`),
  KEY `FKA7CFBC315C9314D5` (`cooperative_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `ParamTransaction` */

insert  into `ParamTransaction`(`id`,`abrev`,`type`,`charteCompte_id`,`currentuser_id`,`cooperative_id`) values (1,'SPP','Sortie produit','107',1,1),(2,'EPP','Entree Produit Principale','48',1,1),(4,'SI','Sortie Intrant','109',1,1),(5,'rmbClient','Remboursement Client','123',1,1),(6,'rmbFP','Remboursement fournisseur e produit','122',1,1),(7,'rmbFI','Remboursement fournisseur d\'intrant','121',1,1),(8,'detteClient','Dette Client','14',1,1),(9,'detteFP','Dette fournisseur de produit','115',1,1),(10,'detteFI','Dette fournisseur d\'intrant','45',1,1),(11,'EPI','Entree Produit Intrant','50',1,1),(12,'EPS','Entree Produit Secondaire','22',NULL,NULL),(14,'SPS','Sortis produit secondaire','108',1,1);

/*Table structure for table `Permission` */

DROP TABLE IF EXISTS `Permission`;

CREATE TABLE `Permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Description` varchar(255) DEFAULT NULL,
  `emplacement` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `redirect` varchar(255) DEFAULT NULL,
  `currentuser_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK57F7A1EF75047F3D` (`currentuser_id`)
) ENGINE=MyISAM AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;

/*Data for the table `Permission` */

insert  into `Permission`(`id`,`Description`,`emplacement`,`name`,`redirect`,`currentuser_id`) values (3,NULL,NULL,'Caisse','menuCaisse',1),(1,NULL,NULL,'parametrage','menuParam',1),(7,NULL,NULL,'administration','paramSoco',1),(2,NULL,NULL,'Commandes','menuMagasin',1),(6,NULL,NULL,'Resultat','resultatCoop',1),(4,NULL,NULL,'Rapport','menuRapport',1);

/*Table structure for table `Produit` */

DROP TABLE IF EXISTS `Produit`;

CREATE TABLE `Produit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `currentuser_id` bigint(20) DEFAULT NULL,
  `coop_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK50C6658975047F3D` (`currentuser_id`),
  KEY `FK50C66589E1B9D193` (`coop_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `Produit` */

insert  into `Produit`(`id`,`categorie`,`description`,`name`,`type`,`currentuser_id`,`coop_id`) values (1,'produitCoop','jdkojfkjfklsjklfsfsf','CACAO','Principal',1,1),(2,'produitCoop','erwrwerjwjrlwer','CAFE','Principal',1,1),(3,'produitCoop','sefdsdfsdfsdfqfqff','BANANE','Secondaire',1,1),(4,'intrant','werwerwerwerwer','int 21 ',NULL,1,1),(5,'intrant','ssdfsdfsdfsf','int 2 ',NULL,1,1);

/*Table structure for table `SoldeDepart` */

DROP TABLE IF EXISTS `SoldeDepart`;

CREATE TABLE `SoldeDepart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `montant` float NOT NULL,
  `typeSolde` varchar(255) DEFAULT NULL,
  `coop_id` bigint(20) DEFAULT NULL,
  `currentuser_id` bigint(20) DEFAULT NULL,
  `defPeriode_id` bigint(20) DEFAULT NULL,
  `entite_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAB74F145E1B9D193` (`coop_id`),
  KEY `FKAB74F14575047F3D` (`currentuser_id`),
  KEY `FKAB74F145131A1E70` (`defPeriode_id`),
  KEY `FKAB74F1456000F7F` (`entite_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `SoldeDepart` */

insert  into `SoldeDepart`(`id`,`date`,`montant`,`typeSolde`,`coop_id`,`currentuser_id`,`defPeriode_id`,`entite_id`) values (5,NULL,550,'rmbFP',1,1,4,12),(6,NULL,1235,'detteClient',1,1,4,13),(7,NULL,7896,'detteFI',1,1,4,14),(8,NULL,-5800,'detteFP',1,1,4,15);

/*Table structure for table `SoldeDepart_TransactionCaisse` */

DROP TABLE IF EXISTS `SoldeDepart_TransactionCaisse`;

CREATE TABLE `SoldeDepart_TransactionCaisse` (
  `SoldeDepart_id` bigint(20) NOT NULL,
  `lstTransactionSoldeDepart_id` bigint(20) NOT NULL,
  UNIQUE KEY `lstTransactionSoldeDepart_id` (`lstTransactionSoldeDepart_id`),
  KEY `FK640DFA3E9F3ADF19` (`lstTransactionSoldeDepart_id`),
  KEY `FK640DFA3E6F9F06B5` (`SoldeDepart_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `SoldeDepart_TransactionCaisse` */

insert  into `SoldeDepart_TransactionCaisse`(`SoldeDepart_id`,`lstTransactionSoldeDepart_id`) values (5,6),(6,9),(7,10);

/*Table structure for table `StructureCharge` */

DROP TABLE IF EXISTS `StructureCharge`;

CREATE TABLE `StructureCharge` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `Reference` varchar(255) DEFAULT NULL,
  `refereaffichage` varchar(255) DEFAULT NULL,
  `activite` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `StructureCharge` */

insert  into `StructureCharge`(`id`,`Reference`,`refereaffichage`,`activite`) values ('2','ppp',NULL,'ACTIVIT D\'EXPLOITATION'),('3','RA-1','RA-1','Achats de caf-cacao'),('4','RA-1-SD',NULL,'Stock au début'),('5','RA-1-SF',NULL,'Stock à la fin'),('6','RB-1','RB-1','Variation de stock'),('7','RA-2','RA-2','Achats de produits agricoles'),('8','RA-2-SD',NULL,'Stock au début'),('9','RA-2-SF',NULL,'Stock à la fin'),('10','RB-2','RB-2','Variation de stock'),('11','RC','RC','Achats de matires premires et fournitures lies'),('12','RC-SD',NULL,'Stock au début'),('13','RC-SF',NULL,'Stock à la fin'),('14','RD','RD','Variation de stock  '),('15','RE','RE','Autres achats'),('16','RE-SD',NULL,'Stock de début'),('17','RE-SF',NULL,'Stock à la fin'),('18','RH','RH','Variation de stock       '),('19','RI','RI','Transport'),('20','RJ','RJ','Services extrieurs'),('21','RK','RK','Impts et taxes'),('22','RL','RL','Autres charges'),('23','RP','RP','Charge de personnel'),('24','RS','RS','Dotations aux amortissements et aux provisions '),('25','RW','RW','Total des charges d\'exploitation'),('26','ppp',NULL,'ACTIVITE FINANCIERE'),('27','SA','SA','Frais financiers '),('28','SC','SC','Perte de change'),('29','SD','SD','Dotations aux amortissements et aux provisions '),('30','SF','SF','Total des charges financires '),('31','SH','SH','Total des charges des activits  ordinaires'),('32','ppp',NULL,'HORS ACTIVITES ORDINAIRES (H.A.O )'),('33','SK','SK','Valeurs comptables des cessions d\'immobilisations'),('34','SL','SL','Charges H.A.O'),('35','SM','SM','Dotations H.A.O'),('36','SO','SO','Total des charges H.A.O'),('37','SQ','SQ','Participation des travailleurs    '),('38','SR','SR','Impts sur le resultat'),('39','SS','SS','Total participation et impts'),('40','ST','ST','TOTAL GENERAL DES CHARGES ');

/*Table structure for table `TransactionCaisse` */

DROP TABLE IF EXISTS `TransactionCaisse`;

CREATE TABLE `TransactionCaisse` (
  `DTYPE` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `montant` float NOT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `typeTransaction` varchar(255) DEFAULT NULL,
  `charteCompte_id` varchar(255) DEFAULT NULL,
  `compteEncaisse_id` bigint(20) DEFAULT NULL,
  `coop_id` bigint(20) DEFAULT NULL,
  `currentuser_id` bigint(20) DEFAULT NULL,
  `defPeriode_id` bigint(20) DEFAULT NULL,
  `categorieCharge_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK668406B8E1B9D193` (`coop_id`),
  KEY `FK668406B875047F3D` (`currentuser_id`),
  KEY `FK668406B84469E2BC` (`compteEncaisse_id`),
  KEY `FK668406B89529CF75` (`categorieCharge_id`),
  KEY `FK668406B8131A1E70` (`defPeriode_id`),
  KEY `FK668406B83746C8DF` (`charteCompte_id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Data for the table `TransactionCaisse` */

insert  into `TransactionCaisse`(`DTYPE`,`id`,`date`,`description`,`montant`,`reference`,`typeTransaction`,`charteCompte_id`,`compteEncaisse_id`,`coop_id`,`currentuser_id`,`defPeriode_id`,`categorieCharge_id`) values ('TransactionCaisse',1,'2011-03-20','Entree Produit Principale',44000,'yuitty','D','48',2,1,1,7,NULL),('TransactionCaisse',2,'2011-03-30','Entree Produit Secondaire',958985,'uio8','D','50',1,1,1,7,NULL),('TransactionCaisse',3,'2011-03-18','Entree Produit Secondaire',500,'vbnnbv','D','50',1,1,1,7,NULL),('TransactionCaisse',4,'2011-03-31','Entree Produit Secondaire',500000,'uio908','D','50',2,1,1,7,NULL),('TransactionCaisse',5,'2011-03-13','Sortie produit',12000,'wererw','E','107',2,1,1,2,NULL),('TransactionCaisse',6,'2011-03-17','Remboursement fournisseur e produit',550,'dfsdfsf','D','122',1,1,1,2,NULL),('TransactionCaisse',7,'2011-03-20','Sortie produit',500,'7899','E','107',1,1,1,2,NULL),('TransactionCaisse',8,'2011-03-27','Sortie produit',40000,'ghjyy','E','107',1,1,1,2,NULL),('TransactionCaisse',9,'2011-03-13','Dette Client',1200,'erttttee','E','14',1,1,1,2,NULL),('TransactionCaisse',10,'2011-03-20','Dette fournisseur d\'intrant',7000,'bhuvgy','E','45',1,1,1,2,NULL),('TransactionCharge',11,'2011-03-27',NULL,6780,'6788','D','58',2,1,1,2,2),('TransactionCharge',12,'2011-03-26',NULL,12440,'afe444','D','63',1,1,1,7,1),('TransactionCaisse',13,'2011-03-19','Sortie Intrant',4000,'rer','E','109',2,1,1,7,NULL),('TransactionCaisse',14,'2011-03-25','Sortie produit secondaire',10,'234411','E','107',1,1,1,7,NULL),('TransactionCaisse',15,'2011-03-20','Sortis produit secondaire',12200,'qewe','E','108',2,1,1,7,NULL),('TransactionCaisse',16,'2011-03-31','Sortie Intrant',600,'erttt','E','109',2,1,1,7,NULL),('TransactionCaisse',17,'2011-07-22','Entree Produit Secondaire',60000,'qweeee','E','49',1,1,1,8,NULL),('TransactionCaisse',18,'2011-07-31','Sortis produit secondaire',37000,'defr','E','108',2,1,1,7,NULL),('TransactionCaisse',19,'2011-07-31','Sortis produit secondaire',5000,'vfgnh','E','108',2,1,1,7,NULL),('TransactionCaisse',20,'2011-07-31','Sortie Intrant',500,'decvvf','E','109',1,1,1,7,NULL),('TransactionCaisse',21,'2011-07-31','Sortie Intrant',500,'cdvfbg','E','109',2,1,1,7,NULL),('TransactionCaisse',22,'2011-07-21','Entree Produit Principale',60000,'cdvfbg','D','48',2,1,1,7,NULL),('TransactionCaisse',23,'2011-07-31','Entree Produit Principale',800,'cdvfxs','D','48',2,1,1,7,NULL),('TransactionCaisse',24,'2011-07-16','Entree Produit Principale',2000,'xszadss','D','48',1,1,1,7,NULL),('TransactionCaisse',25,'2011-07-31','Entree Produit Secondaire',2000,'cdvfaa','E','49',1,1,1,7,NULL);

/*Table structure for table `TransactionMagasin` */

DROP TABLE IF EXISTS `TransactionMagasin`;

CREATE TABLE `TransactionMagasin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grade` int(11) NOT NULL,
  `humidite` int(11) NOT NULL,
  `prixUnitaire` float NOT NULL,
  `quantite` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `coop_id` bigint(20) DEFAULT NULL,
  `currentuser_id` bigint(20) DEFAULT NULL,
  `defPeriode_id` bigint(20) DEFAULT NULL,
  `m_commande_id` bigint(20) DEFAULT NULL,
  `magasin_id` bigint(20) DEFAULT NULL,
  `produit_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7AD6C40CC8BC4595` (`produit_id`),
  KEY `FK7AD6C40CE1B9D193` (`coop_id`),
  KEY `FK7AD6C40C75047F3D` (`currentuser_id`),
  KEY `FK7AD6C40C7604D9F5` (`magasin_id`),
  KEY `FK7AD6C40C131A1E70` (`defPeriode_id`),
  KEY `FK7AD6C40CC701B98D` (`m_commande_id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `TransactionMagasin` */

insert  into `TransactionMagasin`(`id`,`grade`,`humidite`,`prixUnitaire`,`quantite`,`type`,`coop_id`,`currentuser_id`,`defPeriode_id`,`m_commande_id`,`magasin_id`,`produit_id`) values (1,1,12,12,560,0,1,1,7,1,2,1),(2,2,11,11,450,0,1,1,7,1,3,2),(3,2,1,15,2220,0,1,1,7,1,1,3),(4,0,0,3455,567,0,1,1,7,2,2,4),(5,1,1,10,5670,0,1,1,7,3,2,3),(6,2,1,11,890,0,1,1,7,3,1,3),(7,1,3,11,144,0,1,1,2,4,2,2),(8,122,12,120,12,0,1,1,2,4,2,2),(9,1,0,50,100,0,1,1,2,5,2,2),(10,2,0,20,400,0,1,1,2,5,3,2),(11,1,0,10,5000,0,1,1,2,6,2,3),(12,0,0,10,500,0,1,1,7,7,2,4),(13,1,0,10,600,0,1,1,7,8,2,3),(14,1,0,10,5000,0,1,1,7,9,2,3),(15,0,0,10,60,0,1,1,7,10,2,4),(16,1,1,20,3240,0,1,1,7,11,3,1),(17,0,0,10,6,0,1,1,7,12,2,4);

/*Table structure for table `Utilisateur` */

DROP TABLE IF EXISTS `Utilisateur`;

CREATE TABLE `Utilisateur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `etat` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `cooperative_id` bigint(20) DEFAULT NULL,
  `fonction` varchar(255) DEFAULT NULL,
  `langue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK407FDB635C9314D5` (`cooperative_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `Utilisateur` */

insert  into `Utilisateur`(`id`,`etat`,`password`,`username`,`cooperative_id`,`fonction`,`langue`) values (1,'','momo','momo',1,NULL,NULL),(4,'\0','soco','qweq',1,'qwe',NULL),(5,'',NULL,'momo',NULL,'test de fonction',''),(6,'',NULL,'momo',NULL,'',''),(7,'\0',NULL,'qweq',NULL,'qwe',''),(8,'',NULL,'momo',NULL,'','');

/*Table structure for table `Utilisateur_Permission` */

DROP TABLE IF EXISTS `Utilisateur_Permission`;

CREATE TABLE `Utilisateur_Permission` (
  `Utilisateur_id` bigint(20) NOT NULL,
  `lstpermission_id` bigint(20) NOT NULL,
  UNIQUE KEY `lstpermission_id` (`lstpermission_id`),
  KEY `FK5522304B5A5BA41E` (`Utilisateur_id`),
  KEY `FK5522304B55CFDEE9` (`lstpermission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `Utilisateur_Permission` */

insert  into `Utilisateur_Permission`(`Utilisateur_id`,`lstpermission_id`) values (1,1),(1,2),(1,3),(1,4),(1,6),(1,7);

/*Table structure for table `formatageEntier` */

DROP TABLE IF EXISTS `formatageEntier`;

CREATE TABLE `formatageEntier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apresVirgule` int(11) NOT NULL,
  `curremcy` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `formatageEntier` */

insert  into `formatageEntier`(`id`,`apresVirgule`,`curremcy`,`type`) values (1,3,'$','devise'),(2,2,'Kg','unite');

/*Table structure for table `structureProduit` */

DROP TABLE IF EXISTS `structureProduit`;

CREATE TABLE `structureProduit` (
  `id` varchar(255) NOT NULL,
  `reference` varchar(255) NOT NULL,
  `referenceAffichage` varchar(255) NOT NULL,
  `activite` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `structureProduit` */

insert  into `structureProduit`(`id`,`reference`,`referenceAffichage`,`activite`) values ('1','TA-1','TA-1','Ventes de caf-cacao'),('3','TA-2','TA-2','Ventes de produits agricoles autres'),('2','TC','TC','Ventes de produits fabriqués et intrants'),('6','TD','TD','Travaux, services vendus'),('7','TE','TE','Production stocke (ou dstockage)'),('8','TF','TF','Production immobilise'),('10','TK','TH','Produits accessoires'),('11','TL','TK','Subventions d\'exploitation'),('12','TN','TL','Autres produits'),('16','TS','TS','Reprises de provisions'),('17','TT','TT','Transfert de charges  (frais pays d\'avance)'),('18','TW','TW',' Total des produits d\'exploitation'),('20','MM','','ACTIVITE FINANCIERE'),('21','UA','UA','Revenus financiers'),('22','UC','UC','Gains de change'),('23','UD','UD','Reprises de provisions'),('24','UE','UE','Transfert de charges  (frais pays d\'avance)'),('25','UF','UF','Total des produits financiers'),('27','UH','UH','Total des produits des activits ordinaires'),('30','MM','','HORS ACTIVITES ORDINAIRES (H.A.O )'),('31','UK','UK','Produits des cessions d\'immobilisations'),('32','UL','UL','Produits H.A.O'),('33','UM','UM','Reprises H.A.O'),('34','UN','UN','Transfert de charges  (frais pays d\'avance)'),('35','UO','UO','Total des produits H.A.O'),('38','UT','UT','TOTAL GENERAL DES PRODUITS');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
