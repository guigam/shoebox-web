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
  `id` varchar(255) NOT NULL DEFAULT '',
  `numero` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `currentuser_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8036090775047F3D` (`currentuser_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `CharteCompte` */

insert  into `CharteCompte`(`id`,`numero`,`nom`,`type`,`reference`,`currentuser_id`) values ('1','6011','Apports de produits agricoles café cacao (achats)','CHARGE','RA-1',NULL),('2','6012','Apports de produits agricoles autres (achats)','CHARGE','RA-2',NULL),('3','6020','Achats de matières premières et fournitures liées','CHARGE','RC',NULL),('4','6050','Autres achats','CHARGE','RE',NULL),('5','6321','Ristournes des projets versées coopérateurs','CHARGE','RJ',NULL),('6','6030','Variation de stocks café-cacao','CHARGE','RB-1',NULL),('7','6032','Variation de stocks produits agricoles','CHARGE','RB-2',NULL),('8','7360','Variation de stocks produits à valeur ajoutée','CHARGE','TE',NULL),('9','7370','Variation de stocks autres produits','CHARGE','TE',NULL),('10','6042','Carburant et lubrifiant','CHARGE','RE',NULL),('11','6043','Pneumatique','CHARGE','RE',NULL),('12','6044','Pièces de rechanges','CHARGE','RE',NULL),('13','6045','Produits d\'entretien','CHARGE','RE',NULL),('14','6046','Sacherie','CHARGE','RE',NULL),('15','6047','Fournitures de magasin','CHARGE','RE',NULL),('16','6048','Fournitures de bureau','CHARGE','RE',NULL),('17','6051','Eau','CHARGE','RE',NULL),('18','6052','Electricité','CHARGE','RE',NULL),('19','6056','Achats de petit matériel et outillage','CHARGE','RE',NULL),('20','6058','Achats travaux, mat.et équipement','CHARGE','RE',NULL),('21','6110','Transport sur apport (collecte)','CHARGE','RI',NULL),('22','6120','Transport sur ventes (évacuation)','CHARGE','RI',NULL),('23','6180','Autres frais de transport','CHARGE','RI',NULL),('24','6223','Locations matériel & équipements','CHARGE','RJ',NULL),('25','6220','Locations véhicule','CHARGE','RJ',NULL),('26','6241','Entretien et reparation','CHARGE','RJ',NULL),('27','6243','Maintenance','CHARGE','RJ',NULL),('28','6252','Assurance auto / moto','CHARGE','RJ',NULL),('29','6258','Assurances feu / vol / responsabilité civile','CHARGE','RJ',NULL),('30','6281','Frais de téléphone','CHARGE','RJ',NULL),('31','6288','Autres frais de télécommunication','CHARGE','RJ',NULL),('32','6282','Frais de poste / messagerie / courrier','CHARGE','RJ',NULL),('33','6310','Frais bancaires','CHARGE','RJ',NULL),('34','6310','Intérêts / frais financiers / opérations de trésorerie','CHARGE','RJ',NULL),('35','6760','Pertes de change','CHARGE','SC',NULL),('36','6322','Subventions accordées','CHARGE','RJ',NULL),('37','6324','Honoraires','CHARGE','RJ',NULL),('38','6328','Frais divers','CHARGE','RJ',NULL),('39','6220','Loyer','CHARGE','RJ',NULL),('40','6330','Frais de formation','CHARGE','RJ',NULL),('41','6340','Redevances bascules','CHARGE','RJ',NULL),('42','6350','Cotisations','CHARGE','RJ',NULL),('43','6373','Frais décharg.charg.produits agricoles (manutention)','CHARGE','RJ',NULL),('44','6370','Remunérations et autres main d\'œuvres temporaires','CHARGE','RJ',NULL),('45','6383','Réceptions','CHARGE','RJ',NULL),('46','6384','Missions','CHARGE','RJ',NULL),('47','6400','Impôts et taxes','CHARGE','RK',NULL),('48','6510','Perte sur créances','CHARGE','RL',NULL),('49','6581','Jetons de présence administrateurs','CHARGE','RL',NULL),('50','6582','Dons et pourboires','CHARGE','RL',NULL),('51','6582','Frais de route','CHARGE','RL',NULL),('52','6583','Frais d\'AG et de CA','CHARGE','RL',NULL),('53','6584','Frais de Comités','CHARGE','RL',NULL),('54','6585','Pénalité et amendes','CHARGE','RL',NULL),('55','6590','Charges provisionnées d\'exploitation ','CHARGE','RL',NULL),('56','6600','Charges de personnel','CHARGE','RP',NULL),('57','6745','Intérêt bancaires et opération de trésorerie','CHARGE','SA',NULL),('58','6800','Dotation aux amortissements','CHARGE','RS',NULL),('59','6900','Taxes & prélevés','CHARGE','RL',NULL),('61','10000','Stock debut produit  principal','solde depart','RA-1-SD',NULL),('60','10002','Stock debut produit agricole','solde depart','RA-2-SD',NULL),('62','10001','Stock à la fin Produit principal','solde depart','RA-1-SF',NULL),('63','10003','Stock à la fin Produit agricole','solde depart','RA-2-SF',NULL),('64','10004','Stock debut matiere premiere','solde depart','RC-SD',NULL),('65','10005','Stock à la fin matiere premiere','solde depart','RC-SF',NULL),('66 ','10006','Stock debut autre achat','solde depart','RE-SD',NULL),('67',NULL,'Stock à la fin autre achat','solde depart','RE-SF',NULL);

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
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `Commande` */

insert  into `Commande`(`id`,`confirmation`,`dateCommande`,`reference`,`type`,`coop_id`,`currentuser_id`,`defPeriode_id`,`m_entite_id`) values (1,'\0','2011-02-23','werfds','EP',1,1,4,12),(2,'','2011-02-25','awsde','SP',1,1,4,13),(3,'\0','2011-02-27','ghjaj','EI',1,1,4,14),(4,'\0','2011-02-24','entreeproduit2','EP',1,1,4,15),(5,'','2011-02-26','sortisprod','SP',1,1,4,13),(6,'',NULL,'magasin1','EMI',1,1,7,NULL),(7,'',NULL,'magasin2','EMI',1,1,7,NULL),(8,'\0','2011-03-25','WWWWW','SP',1,1,7,13);

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

insert  into `Commande_TransactionCaisse`(`Commande_id`,`lsttransactionCaisse_id`) values (2,1),(1,4),(5,5),(6,20),(6,11),(7,18),(7,13),(7,17),(6,10),(6,22),(7,23);

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

insert  into `DefinitionPeriode`(`id`,`mois`,`numMois`,`periode`,`periodeActif`) values (1,'Janvier',1,'P1',''),(2,'Fevrier',2,'P2','\0'),(3,'Mars',3,'P3','\0'),(4,'Avril',4,'P4','\0'),(5,'Mai',0,'P5','\0'),(6,'Juin',0,'P6','\0'),(7,'Juillet',0,'P7','\0'),(8,'Aout',0,'P8','\0'),(9,'Septembre',0,'P9','\0'),(10,'Octobre',0,'P10','\0'),(11,'Novembre',0,'P11','\0'),(12,'Decembre',0,'P12','\0');

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

insert  into `Magasin`(`id`,`description`,`distance`,`name`,`currentuser_id`,`coop_id`,`commande_id`) values (1,'',34890234,'mag1 ',1,1,6),(2,'',13322,'magasin2 ',1,1,7),(3,'qeqweqeqweqweqe',12333,'magasin3',1,1,NULL);

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
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `ParamTransaction` */

insert  into `ParamTransaction`(`id`,`abrev`,`type`,`charteCompte_id`,`currentuser_id`,`cooperative_id`) values (1,'SP','Sortie produit','3',1,1),(2,'EP','Entree Produit','4',1,1),(3,'EI','Entree Intrant','6',1,1),(4,'SI','Sortie Intrant','11',1,1),(5,'rmbClient','Remboursement Client','5',1,1),(6,'rmbFP','Remboursement fournisseur e produit','15',1,1),(7,'rmbFI','Remboursement fournisseur d\'intrant','12',1,1),(8,'detteClient','Dette Client','19',1,1),(9,'detteFP','Dette fournisseur de produit','21',1,1),(10,'detteFI','Dette fournisseur d\'intrant','25',1,1);

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
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `Permission` */

insert  into `Permission`(`id`,`Description`,`emplacement`,`name`,`redirect`,`currentuser_id`) values (1,NULL,NULL,'Caisse','menuCaisse',1),(2,NULL,NULL,'parametrage','menuParam',1),(3,NULL,NULL,'administration','paramSoco',1),(4,NULL,NULL,'Commandes','menuMagasin',1),(6,NULL,NULL,'Resultat','menuResultat',1);

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

insert  into `SoldeDepart_TransactionCaisse`(`SoldeDepart_id`,`lstTransactionSoldeDepart_id`) values (6,2),(7,3),(8,6),(6,12);

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
  `montant` int(11) NOT NULL,
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
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `TransactionCaisse` */

insert  into `TransactionCaisse`(`DTYPE`,`id`,`date`,`description`,`montant`,`reference`,`typeTransaction`,`charteCompte_id`,`compteEncaisse_id`,`coop_id`,`currentuser_id`,`defPeriode_id`,`categorieCharge_id`) values ('TransactionCaisse',1,'2011-02-24','Sortie produit',3000,'werrr','E','3',1,1,1,4,1),('TransactionCaisse',2,'2011-02-23','Dette Client',1200,'asd','E','19',1,1,1,2,1),('TransactionCaisse',3,'2011-03-16','Dette fournisseur d\'intrant',7000,'asd','E','25',1,1,1,4,1),('TransactionCaisse',4,'2011-02-24','Entree Produit',12000,'qweyui','D','4',2,1,1,4,1),('TransactionCaisse',5,'2011-02-25','Sortie produit',200000,'ffffff','E','3',1,1,1,7,1),('TransactionCaisse',6,'2011-02-24','Dette fournisseur de produit',5800,'foufou','E','21',2,1,1,4,1),('TransactionCharge',7,'2011-03-31',NULL,10250,'charge1','D','16',2,1,1,3,1),('TransactionCharge',8,'2011-03-31',NULL,1200,'charge1','D','56',1,1,1,4,2),('TransactionCharge',9,'2011-03-30',NULL,5300,'errrrrr','D','56',1,1,1,7,2),('TransactionCaisse',10,NULL,'entree magasin',1111,'magasin','E','61',1,1,1,7,2),('TransactionCaisse',11,NULL,'entree magasin',435465,NULL,'E','61',1,1,1,7,1),('TransactionCaisse',12,'2011-03-25','Dette Client',35,'foufou','E','19',1,1,1,7,1),('TransactionCaisse',13,'2011-03-22','entree magasin',15000,'magasin2','E','61',2,1,1,7,1),('TransactionCaisse',17,'2011-03-04','Entree Magasin',4444,'magasin2','E','60',1,1,1,7,NULL),('TransactionCaisse',18,'2011-03-04','Entree Magasin',56222,'magasin2','E','61',2,1,1,7,NULL),('TransactionCaisse',20,'2011-03-04','Entree Magasin',111222,'magasin1','E','60',1,1,1,7,NULL),('TransactionCharge',21,'2011-04-09',NULL,5622,'refcharge2','D','57',2,1,1,7,2),('TransactionCaisse',22,'2011-03-04','Entree Magasin',2,'magasin1','E','61',1,1,1,7,NULL),('TransactionCaisse',23,'2011-03-04','Entree Magasin',444,'magasin2','E','60',2,1,1,7,NULL);

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
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `TransactionMagasin` */

insert  into `TransactionMagasin`(`id`,`grade`,`humidite`,`prixUnitaire`,`quantite`,`type`,`coop_id`,`currentuser_id`,`defPeriode_id`,`m_commande_id`,`magasin_id`,`produit_id`) values (1,1,1,10,1235,0,1,1,4,1,1,1),(2,1,0,13,235,0,1,1,4,2,1,1),(3,0,0,10,123,0,1,1,4,3,1,4),(4,0,0,20,253,0,1,1,4,3,2,4),(5,3,1,12,12333,0,1,1,4,4,1,1),(6,3,0,20,12000,0,1,1,4,5,1,1),(7,1,0,10,450,0,1,1,4,5,1,1),(8,1,0,0,1233,0,1,1,7,6,1,1),(9,2,0,0,11334,0,1,1,7,6,1,1),(10,1,0,0,900,0,1,1,7,6,1,1),(19,1,0,0,3123,0,1,1,7,6,2,1),(18,1,0,12,123123,0,1,1,7,8,2,3),(17,1,0,0,312312,0,1,1,7,6,2,3),(20,1,0,0,2111,0,1,1,7,7,2,3);

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

insert  into `Utilisateur_Permission`(`Utilisateur_id`,`lstpermission_id`) values (1,1),(1,2),(1,3),(1,4),(1,6);

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
