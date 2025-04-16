@REQ_POEI25P2G2-10
Feature: US03 - Gestion du compte client : commnades et informations personnelles
	#*En tant qu'* 
	#
	#    Utilisateur 
	#
	#*Je souhaite* 
	#
	#    Gérer mon compte client 
	#
	#*Afin de* 
	#
	#    Gérer mes commandes et mes informations personnelles 
	#
	#*Règles de gestion :* 
	#
	#RG1 : Dans l'espace "My Account", l'utilisateur doit pouvoir gérer : . Son historique de commande . Ses avoirs . Ses adresses de livraison . Ses informations personnelles 
	#
	#RG2 : Si aucune adresse n'a encore été sauvegardée, un bouton "Add my first Address" est disponible" nous redirigeant vers la page de saisie d'adresse 
	#
	#RG3 : Un bouton "Home" redirige le site sur la page d'accueil

	Background:
		#@POEI25P2G2-55
		Given l'utilisateur est sur la page d'authentification
		When il entre son identifiant "utilisateur@test.com" et son mot de passe "correct123"
		And il clique sur le bouton "Sign in"
		Then l'utilisateur est connecté

	@POEI25P2G2-46 @TNR
	Scenario: US03 - Retour à la page d'accueil depuis l'espace "My Account"
		When l'utilisateur est sur la page "My Account"
		And il clique sur le bouton "Home"
		Then il est redirigé vers la page d'accueil
		
	@POEI25P2G2-45 @TNR
	Scenario: US03 - Redirection vers la page de saisie d’adresse
		When l'utilisateur est sur la page "My Account"
		And il clique sur le bouton "Add my first address"
		Then la page de saisie d’adresse s’affiche
		
	@POEI25P2G2-44 @TNR
	Scenario: US03 - Présence du bouton 'Add my first Address' pour ajouter une première adresse
		When il accède à la page "My Account"
		And Il n'a enregistré aucune adresse
		Then le bouton "Add my first address" est affiché
		
	@POEI25P2G2-42 @TNR
	Scenario Outline: US03 - Présence des différentes sections sur 'My Account'
		When il accède à la page "My Account"
		Then la section "<section>" est visible
		
		Examples:
		  | section                 |
		  | Historique de commandes |
		  | Avoirs                  |
		  | Adresses de livraison   |
		  | Informations personnelles |
		
