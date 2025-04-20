@REQ_POEI25P2G2-2
Feature: US01 - Accès à la page d'accueil
	#*En tant qu'* 
	#    Utilisateur 
	#
	#*Je souhaite* 
	#
	#     Accéder à la page accueil 
	#
	#*Afin de* 
	#
	#     Gérer mes commandes et mes informations personnelles 
	#
	#*Règles de gestion :* 
	#
	#RG1 : Une barre menu en noir contient les liens « Contact us » qui redirige vers la page de contact et « Sign in » vers la page d’authentification (barre menu présent sur toutes les pages du site) 
	#
	#RG2 : Des onglets "Women", "Dresses", "T-Shirts" redirige vers des articles en filtrés en fonction de la catégorie de l'onglet. Un onglet "BLOG" redirige vers le site prestashop (onglets présents sur toutes les pages du site) 
	#
	#RG3 : Des publicités à la une redirige vers le site partenaire prestashop

	@POEI25P2G2-29 @TNR
	Scenario Outline: US01 - Accès à une catégorie d'articles via le menu
		Given L'utilisateur est sur la page accueil
		When Il clique sur l'onglet "<catégorie>"
		Then La page des articles de la catégorie "<catégorie>" s'affiche
		
		Examples:
		  | catégorie |
		  | Women     |
		  | Dresses   |
		  | T-Shirts  |
		
	@POEI25P2G2-28 @TNR
	Scenario: US01 - Accès à la page d'authentification via le menu
		Given L'utilisateur est sur la page accueil
		When L'utilisateur se rend sur la page authentification
		Then L'utilisateur est sur la page authentification
		
	@POEI25P2G2-27 @TNR
	Scenario: US01 - Accès à la page de contact via le menu
		Given L'utilisateur est sur la page accueil
		When Il clique sur le lien Contact Us
		Then L'utilisateur est sur la page contact
		
	@POEI25P2G2-23 @TNR
	Scenario Outline: US01 - Les éléments de navigation sont visibles sur la page d'accueil
		Given L'utilisateur est sur la page accueil
		Then L'élément "<élément>" est visible 
		
		Examples:
		  | élément      |
		  | Contact us   |
		  | Sign in      |
		  | Women        |
		  | Dresses      |
		  | T-Shirts     |
		  | BLOG         |
		
