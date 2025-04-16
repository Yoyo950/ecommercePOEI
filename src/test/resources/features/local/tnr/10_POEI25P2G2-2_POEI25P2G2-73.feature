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

	Background:
		#@POEI25P2G2-73
		Given l'utilisateur accède à l'URL de l'application
		Then la page d'accueil s'affiche
		And la barre de navigation principale est visible

	@POEI25P2G2-29 @TNR
	Scenario Outline: US01 - Accès à une catégorie d'articles via le menu
		When il clique sur l'onglet "<catégorie>"
		Then la page des articles de la catégorie "<catégorie>" s'affiche
		
		Examples:
		  | catégorie |
		  | Women     |
		  | Dresses   |
		  | T-Shirts  |
		
	@POEI25P2G2-28 @TNR
	Scenario: US01 - Accès à la page d'authentification via le menu
		When il clique sur le lien "Sign in"
		Then la page d'authentification s'affiche
		
	@POEI25P2G2-27 @TNR
	Scenario: US01 - Accès à la page de contact via le menu
		Given l'utilisateur est sur la page d'accueil
		When il clique sur le lien "Contact us"
		Then la page de contact s'affiche
		
	@POEI25P2G2-25 @TNR
	Scenario: US01 - Présence des publicités à la une et redirection vers site prestataire
		Then des publicités à la une sont visibles dans la section principale
		When il clique sur une publicité à la une
		Then il est redirigé vers le site partenaire PrestaShop
		
	@POEI25P2G2-23 @TNR
	Scenario Outline: US01 - Les éléments de navigation sont visibles sur la page d'accueil
		Then l'élément "<élément>" est visible dans la barre de navigation
		
		Examples:
		  | élément      |
		  | Contact us   |
		  | Sign in      |
		  | Women        |
		  | Dresses      |
		  | T-Shirts     |
		  | BLOG         |
		
