@REQ_POEI25P2G2-12
Feature: US14 - Accès aux réseaux Sociaux
	#En tant qu' utilisateur, je souhaite accéder à Facebook, Twitter afin de Consulter les informations de l'application sur les réseaux sociaux.
	#
	#Règles de gestion : 
	#
	#* RG1 : Des liens renvoyant aux pages de chaque réseau social sont présents au bas de chaque page de l'application dans le bandeau "Follow us"

	#Tests En tant qu' utilisateur, je souhaite accéder à Facebook, Twitter afin de Consulter les informations de l'application sur les réseaux sociaux.
	#
	#Règles de gestion : 
	#
	#* RG1 : Des liens renvoyant aux pages de chaque réseau social sont présents au bas de chaque page de l'application dans le bandeau "Follow us"
	@POEI25P2G2-72 @EVOL
	Scenario Outline: US14 - Accès aux réseaux sociaux via le bandeau "Follow us"
		Given l'utilisateur est sur une page quelconque de l'application
		When il clique sur le lien vers "<réseau>" dans le bandeau "Follow us"
		Then il est redirigé vers la page "<réseau>" de l'application
		
		Examples:
		  | réseau   |
		  | Facebook |
		  | Twitter  |
		
	#Tests En tant qu' utilisateur, je souhaite accéder à Facebook, Twitter afin de Consulter les informations de l'application sur les réseaux sociaux.
	#
	#Règles de gestion : 
	#
	#* RG1 : Des liens renvoyant aux pages de chaque réseau social sont présents au bas de chaque page de l'application dans le bandeau "Follow us"
	@POEI25P2G2-71 @EVOL
	Scenario Outline: US14 - Présence des liens vers les réseaux sociaux dans le bandeau "Follow us"
		Given l'utilisateur est sur une page "<page>"
		Then le lien vers Facebook est visible dans le bandeau "Follow us"
		And le lien vers Twitter est visible dans le bandeau "Follow us"
		
		Examples:
		  | page  |
		  | homepage |
		  | cart     |
		  | article  |
		
