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

	@POEI25P2G2-20 @TNR
	Scenario: US01 - L'utilisateur accède à la page d'accueil
		Given l'utilisateur accède à l'URL de l'application
		Then la page d'accueil s'affiche
		And la barre de navigation principale est visible
		
