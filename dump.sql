/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50144
 Source Host           : localhost
 Source Database       : shoebox

 Target Server Type    : MySQL
 Target Server Version : 50144
 File Encoding         : UTF-8

 Date: 03/06/2011 22:34:48 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `CategorieCharge`
-- ----------------------------
DROP TABLE IF EXISTS `CategorieCharge`;
CREATE TABLE `CategorieCharge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Description` varchar(255) DEFAULT NULL,
  `nomCategorie` varchar(255) DEFAULT NULL,
  `cooperative_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ADA2AB5C9314D5` (`cooperative_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `CategorieCharge`
-- ----------------------------
BEGIN;
INSERT INTO `CategorieCharge` VALUES ('1', null, 'categ1', '1'), ('2', null, 'categ2', '1');
COMMIT;

-- ----------------------------
--  Table structure for `CharteCompte`
-- ----------------------------
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

-- ----------------------------
--  Records of `CharteCompte`
-- ----------------------------
BEGIN;
INSERT INTO `CharteCompte` VALUES ('1', '1 010,000000', 'Capital social', 'BILAN', 'CA', 'Fixe'), ('2', '1 020,000000', 'Capital par dotation', 'BILAN', 'CB', 'Variable'), ('3', '1 110,000000', 'Réserves légales', 'BILAN', 'CC', 'Fixe'), ('4', '1 120,000000', 'Réserves statutaires', 'BILAN', 'CC', 'Variable'), ('5', '1 180,000000', 'Autres reserves', 'BILAN', 'CC', 'Variable'), ('6', '1 200,000000', 'Report à nouveau', 'BILAN', 'CH', 'Fixe'), ('7', '1 300,000000', 'Resultat de l\'exercice', 'BILAN', 'CI', 'Fixe'), ('12', '1 400,000000', 'Subventions d\'investissement', 'BILAN', 'CL', 'NULL'), ('13', '1 600,000000', 'Emprunts et dettes assimilées', 'BILAN', 'DA', 'NULL'), ('14', '1 700,000000', 'Dettes de crédit-bail et contrats assimilés', 'BILAN', 'DB', 'NULL'), ('15', '1 640,000000', 'Dettes finanicères diverses', 'BILAN', 'DC', 'NULL'), ('16', '2 200,000000', 'Terrains (valeur résiduelle)', 'BILAN', 'AJ', 'NULL'), ('17', '2 310,000000', 'Batiments agricoles et intallations techniques (valeur résiduelle)', 'BILAN', 'AK', 'NULL'), ('18', '2 420,000000', 'Matériel et outillage agricole (valeur résiduelle)', 'BILAN', 'AM', 'NULL'), ('19', '2 440,000000', 'Matériel et mobilier de bureau  (valeur résiduelle)', 'BILAN', 'AL', 'NULL'), ('20', '2 450,000000', 'Matériel de transport  (valeur résiduelle)', 'BILAN', 'AN', 'NULL'), ('21', '2 610,000000', 'Titres de participation (placements)', 'BILAN', 'AR', 'NULL'), ('22', '2 750,000000', 'Dépôts et cautionnements', 'BILAN', 'AS', 'NULL'), ('23', '2 830,000000', 'Amortissements des.batiments et intallations techniques', 'BILAN', 'NULL', 'NULL'), ('24', '2 842,000000', 'Amortisements.matériel et outillage agricole', 'BILAN', 'NULL', 'NULL'), ('25', '2 844,000000', 'Amortisements.matériel et mobilier de bureau', 'BILAN', 'NULL', 'NULL'), ('26', '2 845,000000', 'Amortisements.matériel de transport', 'BILAN', 'NULL', 'NULL'), ('27', '3 110,000000', 'Stocks de produits agricoles', 'BILAN', 'BC', 'NULL'), ('28', '3 310,000000', 'Stocks intrants agricoles', 'BILAN', 'BD', 'NULL'), ('29', '3 600,000000', 'Stocks de produits à valeur ajoutée(produits finis)', 'BILAN', 'BF', 'NULL'), ('30', '4 011,000000', 'Comptes courants coopérateurs ', 'BILAN', 'BH', 'NULL'), ('31', '4 019,000000', 'Fournisseurs de transport', 'BILAN', 'BH', 'NULL'), ('32', '4 111,000000', 'Clients café cacao', 'BILAN', 'BI', 'NULL'), ('33', '4 160,000000', 'Créances douteuses', 'BILAN', 'BI', 'NULL'), ('34', '4 180,000000', 'Clients, produits à recevoir', 'BILAN', 'BI', 'NULL'), ('35', '4 210,000000', 'Personnel, avances, prêt et acompte', 'BILAN', 'BJ', 'NULL'), ('36', '4 220,000000', 'Personnel, remunérations dues', 'BILAN', 'DL', 'NULL'), ('37', '4 310,000000', 'Sécurité sociale', 'BILAN', 'DL', 'NULL'), ('38', '4 470,000000', 'Etat et collectivités publiques', 'BILAN', 'DK', 'NULL'), ('39', '4 621,000000', 'Coopérateurs, prêts et créances', 'BILAN', 'BJ', 'NULL'), ('40', '4 650,000000', 'Ristournes coopérateurs', 'BILAN', 'BJ', 'NULL'), ('41', '4 670,000000', 'Coopérateurs compte de souscription', 'BILAN', 'BJ', 'NULL'), ('42', '4 760,000000', 'Charges constatées d\'avance', 'BILAN', 'BJ', 'NULL'), ('43', '4 810,000000', 'Fournisseurs d\'investissement', 'BILAN', 'DH', 'NULL'), ('44', '4 900,000000', 'Dépréciations et risques provisonnés', 'BILAN', 'NULL', 'NULL'), ('45', '5 000,000000', 'Titres de placement', 'BILAN', 'BQ', 'NULL'), ('46', '5 210,000000', 'Banques', 'BILAN', 'BS', 'NULL'), ('47', '5 700,000000', 'Caisse', 'BILAN', 'BS', 'NULL'), ('48', '6 011,000000', 'Apports de produits agricoles café cacao (achats)', 'CHARGE', 'RA-1', 'NULL'), ('49', '6 012,000000', 'Apports de produits agricoles autres (achats)', 'CHARGE', 'RA-2', 'NULL'), ('50', '6 020,000000', 'Achats de matières premières et fournitures liées', 'CHARGE', 'RC', 'NULL'), ('51', '6 050,000000', 'Autres achats', 'CHARGE', 'RE', 'NULL'), ('52', '6 321,000000', 'Ristournes des projets versées coopérateurs', 'CHARGE', 'RJ', 'NULL'), ('53', '6 030,000000', 'Variation de stocks café-cacao', 'CHARGE', 'RB-1', 'NULL'), ('54', '6 032,000000', 'Variation de stocks produits agricoles', 'CHARGE', 'RB-2', 'NULL'), ('55', '7 360,000000', 'Variation de stocks produits à valeur ajoutée', 'CHARGE', 'TE', 'NULL'), ('56', '7 370,000000', 'Variation de stocks autres produits', 'CHARGE', 'TE', 'NULL'), ('57', '6 042,000000', 'Carburant et lubrifiant', 'CHARGE', 'RE', 'NULL'), ('58', '6 043,000000', 'Pneumatique', 'CHARGE', 'RE', 'NULL'), ('59', '6 044,000000', 'Pièces de rechanges', 'CHARGE', 'RE', 'NULL'), ('60', '6 045,000000', 'Produits d\'entretien', 'CHARGE', 'RE', 'NULL'), ('61', '6 046,000000', 'Sacherie', 'CHARGE', 'RE', 'NULL'), ('62', '6 047,000000', 'Fournitures de magasin', 'CHARGE', 'RE', 'NULL'), ('63', '6 048,000000', 'Fournitures de bureau', 'CHARGE', 'RE', 'NULL'), ('64', '6 051,000000', 'Eau', 'CHARGE', 'RE', 'NULL'), ('65', '6 052,000000', 'Electricité', 'CHARGE', 'RE', 'NULL'), ('66', '6 056,000000', 'Achats de petit matériel et outillage', 'CHARGE', 'RE', 'NULL'), ('67', '6 058,000000', 'Achats travaux, mat.et équipement', 'CHARGE', 'RE', 'NULL'), ('68', '6 110,000000', 'Transport sur apport (collecte)', 'CHARGE', 'RI', 'NULL'), ('69', '6 120,000000', 'Transport sur ventes (évacuation)', 'CHARGE', 'RI', 'NULL'), ('70', '6 180,000000', 'Autres frais de transport', 'CHARGE', 'RI', 'NULL'), ('71', '6 223,000000', 'Locations matériel & équipements', 'CHARGE', 'RJ', 'NULL'), ('72', '6 220,000000', 'Locations véhicule', 'CHARGE', 'RJ', 'NULL'), ('73', '6 241,000000', 'Entretien et reparation', 'CHARGE', 'RJ', 'NULL'), ('74', '6 243,000000', 'Maintenance', 'CHARGE', 'RJ', 'NULL'), ('75', '6 252,000000', 'Assurance auto / moto', 'CHARGE', 'RJ', 'NULL'), ('76', '6 258,000000', 'Assurances feu / vol / responsabilité civile', 'CHARGE', 'RJ', 'NULL'), ('77', '6 281,000000', 'Frais de téléphone', 'CHARGE', 'RJ', 'NULL'), ('78', '6 288,000000', 'Autres frais de télécommunication', 'CHARGE', 'RJ', 'NULL'), ('79', '6 282,000000', 'Frais de poste / messagerie / courrier', 'CHARGE', 'RJ', 'NULL'), ('80', '6 310,000000', 'Frais bancaires', 'CHARGE', 'RJ', 'NULL'), ('81', '6 310,000000', 'Intérêts / frais financiers / opérations de trésorerie', 'CHARGE', 'RJ', 'NULL'), ('82', '6 760,000000', 'Pertes de change', 'CHARGE', 'SC', 'NULL'), ('83', '6 322,000000', 'Subventions accordées', 'CHARGE', 'RJ', 'NULL'), ('84', '6 324,000000', 'Honoraires', 'CHARGE', 'RJ', 'NULL'), ('85', '6 328,000000', 'Frais divers', 'CHARGE', 'RJ', 'NULL'), ('86', '6 220,000000', 'Loyer', 'CHARGE', 'RJ', 'NULL'), ('87', '6 330,000000', 'Frais de formation', 'CHARGE', 'RJ', 'NULL'), ('88', '6 340,000000', 'Redevances bascules', 'CHARGE', 'RJ', 'NULL'), ('89', '6 350,000000', 'Cotisations', 'CHARGE', 'RJ', 'NULL'), ('90', '6 373,000000', 'Frais décharg.charg.produits agricoles (manutention)', 'CHARGE', 'RJ', 'NULL'), ('91', '6 370,000000', 'Remunérations et autres main d\'œuvres temporaires', 'CHARGE', 'RJ', 'NULL'), ('92', '6 383,000000', 'Réceptions', 'CHARGE', 'RJ', 'NULL'), ('93', '6 384,000000', 'Missions', 'CHARGE', 'RJ', 'NULL'), ('94', '6 400,000000', 'Impôts et taxes', 'CHARGE', 'RK', 'NULL'), ('95', '6 510,000000', 'Perte sur créances', 'CHARGE', 'RL', 'NULL'), ('96', '6 581,000000', 'Jetons de présence administrateurs', 'CHARGE', 'RL', 'NULL'), ('97', '6 582,000000', 'Dons et pourboires', 'CHARGE', 'RL', 'NULL'), ('98', '6 582,000000', 'Frais de route', 'CHARGE', 'RL', 'NULL'), ('99', '6 583,000000', 'Frais d\'AG et de CA', 'CHARGE', 'RL', 'NULL'), ('100', '6 584,000000', 'Frais de Comités', 'CHARGE', 'RL', 'NULL'), ('101', '6 585,000000', 'Pénalité et amendes', 'CHARGE', 'RL', 'NULL'), ('102', '6 590,000000', 'Charges provisionnées d\'exploitation ', 'CHARGE', 'RL', 'NULL'), ('103', '6 600,000000', 'Charges de personnel', 'CHARGE', 'RP', 'NULL'), ('104', '6 745,000000', 'Intérêt bancaires et opération de trésorerie', 'CHARGE', 'SA', 'NULL'), ('105', '6 800,000000', 'Dotation aux amortissements', 'CHARGE', 'RS', 'NULL'), ('106', '6 900,000000', 'Taxes & prélevés', 'PRODUIT', 'NULL', 'NULL'), ('107', '7 071,000000', 'Ventes de café-cacao', 'PRODUIT', 'TA-1', 'NULL'), ('108', '7 012,000000', 'Ventes produits agricoles', 'PRODUIT', 'TA-2', 'NULL'), ('109', '7 013,000000', 'Ventes d\'intrants', 'PRODUIT', 'TC', 'NULL'), ('110', '7 020,000000', 'Ventes de produits à valeur ajoutée', 'PRODUIT', 'TC', 'NULL'), ('111', '7 061,000000', 'Transports facturés', 'PRODUIT', 'TD', 'NULL'), ('112', '7 062,000000', 'Commissions sur produits agricoles', 'PRODUIT', 'TD', 'NULL'), ('113', '7 070,000000', 'Autres produits ', 'PRODUIT', 'TH', 'NULL'), ('114', '7 110,000000', 'Subventions d\'exploitation', 'PRODUIT', 'TK', 'NULL'), ('115', '7 183,000000', 'Autres subventions', 'PRODUIT', 'TK', 'NULL'), ('116', '8 400,000000', 'Revenus hors activités ordinaires', 'PRODUIT', 'UL', 'NULL'), ('117', '7 760,000000', 'Gains de change', 'PRODUIT', 'UC', 'NULL'), ('118', '7 780,000000', 'Intérêt /dépôts et placement', 'PRODUIT', 'UA', 'NULL'), ('119', '8 220,000000', 'Produits des cessions des immobilisations corporelles', 'PRODUIT', 'UK', 'NULL'), ('120', '8 650,000000', 'Reprises de subventions d\'investissement', 'PRODUIT', 'UM', 'NULL'), ('121', '1 630,000000', 'Remboursement fournisseur d\'intrant', 'CHARGE', 'DJ', ''), ('122', '1 620,000000', 'Remboursement fournisseur de produit ', 'CHARGE', 'DI', ''), ('123', '1 610,000000', 'Avance Client', 'CHARGE', 'DI', ''), ('124', '10000', 'Stock debut produit agricole', 'Solde de depart', 'RA-1-SD', ''), ('125', '10001', 'Stock debut produit agricole', 'Solde de depart', 'RA-2-SD', ''), ('126', '10002', 'Stock à la fin Produit principal', 'Solde de depart', 'RA-1-SF', ''), ('127', '10003', 'Stock à la fin Produit agricole', 'Solde de depart', 'RA-2-SF', ''), ('128', '10004', 'Stock debut matiere premiere', 'Solde de depart', 'RC-SD', ''), ('129', '10005', 'Stock à la fin matiere premiere', 'Solde de part', 'RC-SF', ''), ('130', '10006', 'Stock debut autre achat', 'Solde de depart', 'RE-SD', ''), ('131', '10007', 'Stock à la fin autre achat', 'Solde de depart', 'RE-SF', '');
COMMIT;

-- ----------------------------
--  Table structure for `CharteCompte_copy`
-- ----------------------------
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

-- ----------------------------
--  Records of `CharteCompte_copy`
-- ----------------------------
BEGIN;
INSERT INTO `CharteCompte_copy` VALUES ('1', '6011', 'Apports de produits agricoles café cacao (achats)', 'CHARGE', 'RA-1', null), ('2', '6012', 'Apports de produits agricoles autres (achats)', 'CHARGE', 'RA-2', null), ('3', '6020', 'Achats de matières premières et fournitures liées', 'CHARGE', 'RC', null), ('4', '6050', 'Autres achats', 'CHARGE', 'RE', null), ('5', '6321', 'Ristournes des projets versées coopérateurs', 'CHARGE', 'RJ', null), ('6', '6030', 'Variation de stocks café-cacao', 'CHARGE', 'RB-1', null), ('7', '6032', 'Variation de stocks produits agricoles', 'CHARGE', 'RB-2', null), ('8', '7360', 'Variation de stocks produits à valeur ajoutée', 'CHARGE', 'TE', null), ('9', '7370', 'Variation de stocks autres produits', 'CHARGE', 'TE', null), ('10', '6042', 'Carburant et lubrifiant', 'CHARGE', 'RE', null), ('11', '6043', 'Pneumatique', 'CHARGE', 'RE', null), ('12', '6044', 'Pièces de rechanges', 'CHARGE', 'RE', null), ('13', '6045', 'Produits d\'entretien', 'CHARGE', 'RE', null), ('14', '6046', 'Sacherie', 'CHARGE', 'RE', null), ('15', '6047', 'Fournitures de magasin', 'CHARGE', 'RE', null), ('16', '6048', 'Fournitures de bureau', 'CHARGE', 'RE', null), ('17', '6051', 'Eau', 'CHARGE', 'RE', null), ('18', '6052', 'Electricité', 'CHARGE', 'RE', null), ('19', '6056', 'Achats de petit matériel et outillage', 'CHARGE', 'RE', null), ('20', '6058', 'Achats travaux, mat.et équipement', 'CHARGE', 'RE', null), ('21', '6110', 'Transport sur apport (collecte)', 'CHARGE', 'RI', null), ('22', '6120', 'Transport sur ventes (évacuation)', 'CHARGE', 'RI', null), ('23', '6180', 'Autres frais de transport', 'CHARGE', 'RI', null), ('24', '6223', 'Locations matériel & équipements', 'CHARGE', 'RJ', null), ('25', '6220', 'Locations véhicule', 'CHARGE', 'RJ', null), ('26', '6241', 'Entretien et reparation', 'CHARGE', 'RJ', null), ('27', '6243', 'Maintenance', 'CHARGE', 'RJ', null), ('28', '6252', 'Assurance auto / moto', 'CHARGE', 'RJ', null), ('29', '6258', 'Assurances feu / vol / responsabilité civile', 'CHARGE', 'RJ', null), ('30', '6281', 'Frais de téléphone', 'CHARGE', 'RJ', null), ('31', '6288', 'Autres frais de télécommunication', 'CHARGE', 'RJ', null), ('32', '6282', 'Frais de poste / messagerie / courrier', 'CHARGE', 'RJ', null), ('33', '6310', 'Frais bancaires', 'CHARGE', 'RJ', null), ('34', '6310', 'Intérêts / frais financiers / opérations de trésorerie', 'CHARGE', 'RJ', null), ('35', '6760', 'Pertes de change', 'CHARGE', 'SC', null), ('36', '6322', 'Subventions accordées', 'CHARGE', 'RJ', null), ('37', '6324', 'Honoraires', 'CHARGE', 'RJ', null), ('38', '6328', 'Frais divers', 'CHARGE', 'RJ', null), ('39', '6220', 'Loyer', 'CHARGE', 'RJ', null), ('40', '6330', 'Frais de formation', 'CHARGE', 'RJ', null), ('41', '6340', 'Redevances bascules', 'CHARGE', 'RJ', null), ('42', '6350', 'Cotisations', 'CHARGE', 'RJ', null), ('43', '6373', 'Frais décharg.charg.produits agricoles (manutention)', 'CHARGE', 'RJ', null), ('44', '6370', 'Remunérations et autres main d\'œuvres temporaires', 'CHARGE', 'RJ', null), ('45', '6383', 'Réceptions', 'CHARGE', 'RJ', null), ('46', '6384', 'Missions', 'CHARGE', 'RJ', null), ('47', '6400', 'Impôts et taxes', 'CHARGE', 'RK', null), ('48', '6510', 'Perte sur créances', 'CHARGE', 'RL', null), ('49', '6581', 'Jetons de présence administrateurs', 'CHARGE', 'RL', null), ('50', '6582', 'Dons et pourboires', 'CHARGE', 'RL', null), ('51', '6582', 'Frais de route', 'CHARGE', 'RL', null), ('52', '6583', 'Frais d\'AG et de CA', 'CHARGE', 'RL', null), ('53', '6584', 'Frais de Comités', 'CHARGE', 'RL', null), ('54', '6585', 'Pénalité et amendes', 'CHARGE', 'RL', null), ('55', '6590', 'Charges provisionnées d\'exploitation ', 'CHARGE', 'RL', null), ('56', '6600', 'Charges de personnel', 'CHARGE', 'RP', null), ('57', '6745', 'Intérêt bancaires et opération de trésorerie', 'CHARGE', 'SA', null), ('58', '6800', 'Dotation aux amortissements', 'CHARGE', 'RS', null), ('59', '6900', 'Taxes & prélevés', 'CHARGE', 'RL', null), ('61', '10000', 'Stock debut produit  principal', 'solde depart', 'RA-1-SD', null), ('60', '10002', 'Stock debut produit agricole', 'solde depart', 'RA-2-SD', null), ('62', '10001', 'Stock à la fin Produit principal', 'solde depart', 'RA-1-SF', null), ('63', '10003', 'Stock à la fin Produit agricole', 'solde depart', 'RA-2-SF', null), ('64', '10004', 'Stock debut matiere premiere', 'solde depart', 'RC-SD', null), ('65', '10005', 'Stock à la fin matiere premiere', 'solde depart', 'RC-SF', null), ('66 ', '10006', 'Stock debut autre achat', 'solde depart', 'RE-SD', null), ('67', null, 'Stock à la fin autre achat', 'solde depart', 'RE-SF', null);
COMMIT;

-- ----------------------------
--  Table structure for `Commande`
-- ----------------------------
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
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `Commande`
-- ----------------------------
BEGIN;
INSERT INTO `Commande` VALUES ('1', b'0', '2011-03-27', 'bhujjj', 'EPP', '1', '1', '7', '12'), ('2', b'0', '2011-03-27', 'etrert', 'EPI', '1', '1', '7', '14'), ('3', b'0', '2011-03-20', 'ghjtyu', 'EPS', '1', '1', '7', '12'), ('4', b'0', '2011-03-25', 'wtrwuryiwye', 'EPP', '1', '1', '2', '12'), ('5', b'1', '2011-03-19', 'yuyuiwey', 'SP', '1', '1', '2', '13'), ('6', b'1', '2011-03-25', 'ty7876', 'SP', '1', '1', '2', '13');
COMMIT;

-- ----------------------------
--  Table structure for `Commande_TransactionCaisse`
-- ----------------------------
DROP TABLE IF EXISTS `Commande_TransactionCaisse`;
CREATE TABLE `Commande_TransactionCaisse` (
  `Commande_id` bigint(20) NOT NULL,
  `lsttransactionCaisse_id` bigint(20) NOT NULL,
  UNIQUE KEY `lsttransactionCaisse_id` (`lsttransactionCaisse_id`),
  KEY `FKB16AC535E4B965F` (`Commande_id`),
  KEY `FKB16AC53493980E2` (`lsttransactionCaisse_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `Commande_TransactionCaisse`
-- ----------------------------
BEGIN;
INSERT INTO `Commande_TransactionCaisse` VALUES ('1', '1'), ('2', '3'), ('2', '2'), ('2', '4'), ('5', '5'), ('5', '7'), ('6', '8');
COMMIT;

-- ----------------------------
--  Table structure for `Compte`
-- ----------------------------
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

-- ----------------------------
--  Records of `Compte`
-- ----------------------------
BEGIN;
INSERT INTO `Compte` VALUES ('1', null, '123', 'BMO', 'Banque', '1', '1'), ('2', null, '323', 'Caisse1', 'Caisse', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `Cooperative`
-- ----------------------------
DROP TABLE IF EXISTS `Cooperative`;
CREATE TABLE `Cooperative` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `Cooperative`
-- ----------------------------
BEGIN;
INSERT INTO `Cooperative` VALUES ('1', 'coop1', 'kldksl');
COMMIT;

-- ----------------------------
--  Table structure for `DefinitionPeriode`
-- ----------------------------
DROP TABLE IF EXISTS `DefinitionPeriode`;
CREATE TABLE `DefinitionPeriode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mois` varchar(255) DEFAULT NULL,
  `numMois` int(11) NOT NULL,
  `periode` varchar(255) DEFAULT NULL,
  `periodeActif` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `DefinitionPeriode`
-- ----------------------------
BEGIN;
INSERT INTO `DefinitionPeriode` VALUES ('1', 'Janvier', '1', 'P1', b'0'), ('2', 'Fevrier', '2', 'P2', b'0'), ('3', 'Mars', '3', 'P3', b'0'), ('4', 'Avril', '4', 'P4', b'0'), ('5', 'Mai', '0', 'P5', b'0'), ('6', 'Juin', '0', 'P6', b'0'), ('7', 'Juillet', '0', 'P7', b'1'), ('8', 'Aout', '0', 'P8', b'0'), ('9', 'Septembre', '0', 'P9', b'0'), ('10', 'Octobre', '0', 'P10', b'0'), ('11', 'Novembre', '0', 'P11', b'0'), ('12', 'Decembre', '0', 'P12', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `Entite`
-- ----------------------------
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

-- ----------------------------
--  Records of `Entite`
-- ----------------------------
BEGIN;
INSERT INTO `Entite` VALUES ('FournisseurProduit', '12', '789', 'sdafkjl', 'taktou', 'tunisie', 'Membre', '1', '1', '5'), ('Client', '13', null, 'ertert', 'rttttt', null, null, '1', '1', '6'), ('FournisseurIntrant', '14', null, 'qwe', 'qwe', null, null, '1', '1', '7'), ('FournisseurProduit', '15', '234', 'nayek', 'fadhel', 'tunisie', 'Membre', '1', '1', '8');
COMMIT;

-- ----------------------------
--  Table structure for `Magasin`
-- ----------------------------
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

-- ----------------------------
--  Records of `Magasin`
-- ----------------------------
BEGIN;
INSERT INTO `Magasin` VALUES ('1', '', '34890234', 'mag1 ', '1', '1', null), ('2', '', '13322', 'magasin2 ', '1', '1', null), ('3', 'qeqweqeqweqweqe', '12333', 'magasin3', '1', '1', null);
COMMIT;

-- ----------------------------
--  Table structure for `ParamTransaction`
-- ----------------------------
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
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `ParamTransaction`
-- ----------------------------
BEGIN;
INSERT INTO `ParamTransaction` VALUES ('1', 'SP', 'Sortie produit', '107', '1', '1'), ('2', 'EPP', 'Entree Produit Principale', '48', '1', '1'), ('4', 'SI', 'Sortie Intrant', '109', '1', '1'), ('5', 'rmbClient', 'Remboursement Client', '123', '1', '1'), ('6', 'rmbFP', 'Remboursement fournisseur e produit', '122', '1', '1'), ('7', 'rmbFI', 'Remboursement fournisseur d\'intrant', '121', '1', '1'), ('8', 'detteClient', 'Dette Client', '14', '1', '1'), ('9', 'detteFP', 'Dette fournisseur de produit', '115', '1', '1'), ('10', 'detteFI', 'Dette fournisseur d\'intrant', '45', '1', '1'), ('11', 'EPI', 'Entree Produit Intrant', '50', '1', '1'), ('12', 'EPS', 'Entree Produit Secondaire', '22', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `Permission`
-- ----------------------------
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

-- ----------------------------
--  Records of `Permission`
-- ----------------------------
BEGIN;
INSERT INTO `Permission` VALUES ('3', null, null, 'Caisse', 'menuCaisse', '1'), ('1', null, null, 'parametrage', 'menuParam', '1'), ('7', null, null, 'administration', 'paramSoco', '1'), ('2', null, null, 'Commandes', 'menuMagasin', '1'), ('6', null, null, 'Resultat', 'resultatCoop', '1'), ('4', null, null, 'Rapport', 'menuRapport', '1');
COMMIT;

-- ----------------------------
--  Table structure for `Produit`
-- ----------------------------
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

-- ----------------------------
--  Records of `Produit`
-- ----------------------------
BEGIN;
INSERT INTO `Produit` VALUES ('1', 'produitCoop', 'jdkojfkjfklsjklfsfsf', 'CACAO', 'Principal', '1', '1'), ('2', 'produitCoop', 'erwrwerjwjrlwer', 'CAFE', 'Principal', '1', '1'), ('3', 'produitCoop', 'sefdsdfsdfsdfqfqff', 'BANANE', 'Secondaire', '1', '1'), ('4', 'intrant', 'werwerwerwerwer', 'int 21 ', null, '1', '1'), ('5', 'intrant', 'ssdfsdfsdfsf', 'int 2 ', null, '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `SoldeDepart`
-- ----------------------------
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

-- ----------------------------
--  Records of `SoldeDepart`
-- ----------------------------
BEGIN;
INSERT INTO `SoldeDepart` VALUES ('5', null, '550', 'rmbFP', '1', '1', '4', '12'), ('6', null, '1235', 'detteClient', '1', '1', '4', '13'), ('7', null, '7896', 'detteFI', '1', '1', '4', '14'), ('8', null, '-5800', 'detteFP', '1', '1', '4', '15');
COMMIT;

-- ----------------------------
--  Table structure for `SoldeDepart_TransactionCaisse`
-- ----------------------------
DROP TABLE IF EXISTS `SoldeDepart_TransactionCaisse`;
CREATE TABLE `SoldeDepart_TransactionCaisse` (
  `SoldeDepart_id` bigint(20) NOT NULL,
  `lstTransactionSoldeDepart_id` bigint(20) NOT NULL,
  UNIQUE KEY `lstTransactionSoldeDepart_id` (`lstTransactionSoldeDepart_id`),
  KEY `FK640DFA3E9F3ADF19` (`lstTransactionSoldeDepart_id`),
  KEY `FK640DFA3E6F9F06B5` (`SoldeDepart_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `SoldeDepart_TransactionCaisse`
-- ----------------------------
BEGIN;
INSERT INTO `SoldeDepart_TransactionCaisse` VALUES ('5', '6'), ('6', '9'), ('7', '10');
COMMIT;

-- ----------------------------
--  Table structure for `StructureCharge`
-- ----------------------------
DROP TABLE IF EXISTS `StructureCharge`;
CREATE TABLE `StructureCharge` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `Reference` varchar(255) DEFAULT NULL,
  `refereaffichage` varchar(255) DEFAULT NULL,
  `activite` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `StructureCharge`
-- ----------------------------
BEGIN;
INSERT INTO `StructureCharge` VALUES ('2', 'ppp', null, 'ACTIVIT D\'EXPLOITATION'), ('3', 'RA-1', 'RA-1', 'Achats de caf-cacao'), ('4', 'RA-1-SD', null, 'Stock au début'), ('5', 'RA-1-SF', null, 'Stock à la fin'), ('6', 'RB-1', 'RB-1', 'Variation de stock'), ('7', 'RA-2', 'RA-2', 'Achats de produits agricoles'), ('8', 'RA-2-SD', null, 'Stock au début'), ('9', 'RA-2-SF', null, 'Stock à la fin'), ('10', 'RB-2', 'RB-2', 'Variation de stock'), ('11', 'RC', 'RC', 'Achats de matires premires et fournitures lies'), ('12', 'RC-SD', null, 'Stock au début'), ('13', 'RC-SF', null, 'Stock à la fin'), ('14', 'RD', 'RD', 'Variation de stock  '), ('15', 'RE', 'RE', 'Autres achats'), ('16', 'RE-SD', null, 'Stock de début'), ('17', 'RE-SF', null, 'Stock à la fin'), ('18', 'RH', 'RH', 'Variation de stock       '), ('19', 'RI', 'RI', 'Transport'), ('20', 'RJ', 'RJ', 'Services extrieurs'), ('21', 'RK', 'RK', 'Impts et taxes'), ('22', 'RL', 'RL', 'Autres charges'), ('23', 'RP', 'RP', 'Charge de personnel'), ('24', 'RS', 'RS', 'Dotations aux amortissements et aux provisions '), ('25', 'RW', 'RW', 'Total des charges d\'exploitation'), ('26', 'ppp', null, 'ACTIVITE FINANCIERE'), ('27', 'SA', 'SA', 'Frais financiers '), ('28', 'SC', 'SC', 'Perte de change'), ('29', 'SD', 'SD', 'Dotations aux amortissements et aux provisions '), ('30', 'SF', 'SF', 'Total des charges financires '), ('31', 'SH', 'SH', 'Total des charges des activits  ordinaires'), ('32', 'ppp', null, 'HORS ACTIVITES ORDINAIRES (H.A.O )'), ('33', 'SK', 'SK', 'Valeurs comptables des cessions d\'immobilisations'), ('34', 'SL', 'SL', 'Charges H.A.O'), ('35', 'SM', 'SM', 'Dotations H.A.O'), ('36', 'SO', 'SO', 'Total des charges H.A.O'), ('37', 'SQ', 'SQ', 'Participation des travailleurs    '), ('38', 'SR', 'SR', 'Impts sur le resultat'), ('39', 'SS', 'SS', 'Total participation et impts'), ('40', 'ST', 'ST', 'TOTAL GENERAL DES CHARGES ');
COMMIT;

-- ----------------------------
--  Table structure for `TransactionCaisse`
-- ----------------------------
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
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `TransactionCaisse`
-- ----------------------------
BEGIN;
INSERT INTO `TransactionCaisse` VALUES ('TransactionCaisse', '1', '2011-03-20', 'Entree Produit Principale', '44000', 'yuitty', 'D', '48', '2', '1', '1', '7', null), ('TransactionCaisse', '2', '2011-03-30', 'Entree Produit Secondaire', '958985', 'uio8', 'D', '50', '1', '1', '1', '7', null), ('TransactionCaisse', '3', '2011-03-18', 'Entree Produit Secondaire', '500', 'vbnnbv', 'D', '50', '1', '1', '1', '7', null), ('TransactionCaisse', '4', '2011-03-31', 'Entree Produit Secondaire', '500000', 'uio908', 'D', '50', '2', '1', '1', '7', null), ('TransactionCaisse', '5', '2011-03-13', 'Sortie produit', '12000', 'wererw', 'E', '107', '2', '1', '1', '2', null), ('TransactionCaisse', '6', '2011-03-17', 'Remboursement fournisseur e produit', '550', 'dfsdfsf', 'D', '122', '1', '1', '1', '2', null), ('TransactionCaisse', '7', '2011-03-20', 'Sortie produit', '500', '7899', 'E', '107', '1', '1', '1', '2', null), ('TransactionCaisse', '8', '2011-03-27', 'Sortie produit', '40000', 'ghjyy', 'E', '107', '1', '1', '1', '2', null), ('TransactionCaisse', '9', '2011-03-13', 'Dette Client', '1200', 'erttttee', 'E', '14', '1', '1', '1', '2', null), ('TransactionCaisse', '10', '2011-03-20', 'Dette fournisseur d\'intrant', '7000', 'bhuvgy', 'E', '45', '1', '1', '1', '2', null), ('TransactionCharge', '11', '2011-03-27', null, '6780', '6788', 'D', '58', '2', '1', '1', '2', '2'), ('TransactionCharge', '12', '2011-03-26', null, '12440', 'afe444', 'D', '63', '1', '1', '1', '7', '1');
COMMIT;

-- ----------------------------
--  Table structure for `TransactionMagasin`
-- ----------------------------
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
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `TransactionMagasin`
-- ----------------------------
BEGIN;
INSERT INTO `TransactionMagasin` VALUES ('1', '1', '12', '12', '560', '0', '1', '1', '7', '1', '2', '1'), ('2', '2', '11', '11', '450', '0', '1', '1', '7', '1', '3', '2'), ('3', '2', '1', '15', '2220', '0', '1', '1', '7', '1', '1', '3'), ('4', '0', '0', '3455', '567', '0', '1', '1', '7', '2', '2', '4'), ('5', '1', '1', '10', '5670', '0', '1', '1', '7', '3', '2', '3'), ('6', '2', '1', '11', '890', '0', '1', '1', '7', '3', '1', '3'), ('7', '1', '3', '11', '144', '0', '1', '1', '2', '4', '2', '2'), ('8', '122', '12', '120', '12', '0', '1', '1', '2', '4', '2', '2'), ('9', '1', '0', '50', '100', '0', '1', '1', '2', '5', '2', '2'), ('10', '2', '0', '20', '400', '0', '1', '1', '2', '5', '3', '2'), ('11', '1', '0', '10', '5000', '0', '1', '1', '2', '6', '2', '3');
COMMIT;

-- ----------------------------
--  Table structure for `Utilisateur`
-- ----------------------------
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

-- ----------------------------
--  Records of `Utilisateur`
-- ----------------------------
BEGIN;
INSERT INTO `Utilisateur` VALUES ('1', b'1', 'momo', 'momo', '1', null, null), ('4', b'0', 'soco', 'qweq', '1', 'qwe', null), ('5', b'1', null, 'momo', null, 'test de fonction', ''), ('6', b'1', null, 'momo', null, '', ''), ('7', b'0', null, 'qweq', null, 'qwe', ''), ('8', b'1', null, 'momo', null, '', '');
COMMIT;

-- ----------------------------
--  Table structure for `Utilisateur_Permission`
-- ----------------------------
DROP TABLE IF EXISTS `Utilisateur_Permission`;
CREATE TABLE `Utilisateur_Permission` (
  `Utilisateur_id` bigint(20) NOT NULL,
  `lstpermission_id` bigint(20) NOT NULL,
  UNIQUE KEY `lstpermission_id` (`lstpermission_id`),
  KEY `FK5522304B5A5BA41E` (`Utilisateur_id`),
  KEY `FK5522304B55CFDEE9` (`lstpermission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `Utilisateur_Permission`
-- ----------------------------
BEGIN;
INSERT INTO `Utilisateur_Permission` VALUES ('1', '1'), ('1', '2'), ('1', '3'), ('1', '4'), ('1', '6'), ('1', '7');
COMMIT;

-- ----------------------------
--  Table structure for `formatageEntier`
-- ----------------------------
DROP TABLE IF EXISTS `formatageEntier`;
CREATE TABLE `formatageEntier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apresVirgule` int(11) NOT NULL,
  `curremcy` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `formatageEntier`
-- ----------------------------
BEGIN;
INSERT INTO `formatageEntier` VALUES ('1', '3', '$', 'devise'), ('2', '2', 'Kg', 'unite');
COMMIT;

-- ----------------------------
--  Table structure for `structureProduit`
-- ----------------------------
DROP TABLE IF EXISTS `structureProduit`;
CREATE TABLE `structureProduit` (
  `id` varchar(255) NOT NULL,
  `reference` varchar(255) NOT NULL,
  `referenceAffichage` varchar(255) NOT NULL,
  `activite` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `structureProduit`
-- ----------------------------
BEGIN;
INSERT INTO `structureProduit` VALUES ('1', 'TA-1', 'TA-1', 'Ventes de caf-cacao'), ('3', 'TA-2', 'TA-2', 'Ventes de produits agricoles autres'), ('2', 'TC', 'TC', 'Ventes de produits fabriqués et intrants'), ('6', 'TD', 'TD', 'Travaux, services vendus'), ('7', 'TE', 'TE', 'Production stocke (ou dstockage)'), ('8', 'TF', 'TF', 'Production immobilise'), ('10', 'TK', 'TH', 'Produits accessoires'), ('11', 'TL', 'TK', 'Subventions d\'exploitation'), ('12', 'TN', 'TL', 'Autres produits'), ('16', 'TS', 'TS', 'Reprises de provisions'), ('17', 'TT', 'TT', 'Transfert de charges  (frais pays d\'avance)'), ('18', 'TW', 'TW', ' Total des produits d\'exploitation'), ('20', 'MM', '', 'ACTIVITE FINANCIERE'), ('21', 'UA', 'UA', 'Revenus financiers'), ('22', 'UC', 'UC', 'Gains de change'), ('23', 'UD', 'UD', 'Reprises de provisions'), ('24', 'UE', 'UE', 'Transfert de charges  (frais pays d\'avance)'), ('25', 'UF', 'UF', 'Total des produits financiers'), ('27', 'UH', 'UH', 'Total des produits des activits ordinaires'), ('30', 'MM', '', 'HORS ACTIVITES ORDINAIRES (H.A.O )'), ('31', 'UK', 'UK', 'Produits des cessions d\'immobilisations'), ('32', 'UL', 'UL', 'Produits H.A.O'), ('33', 'UM', 'UM', 'Reprises H.A.O'), ('34', 'UN', 'UN', 'Transfert de charges  (frais pays d\'avance)'), ('35', 'UO', 'UO', 'Total des produits H.A.O'), ('38', 'UT', 'UT', 'TOTAL GENERAL DES PRODUITS');
COMMIT;
