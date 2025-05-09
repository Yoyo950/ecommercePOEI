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
		Given L'utilisateur se rend sur la page authentification
		When Il entre ses identifiants
		And Il clique sur le bouton Sign In
		Then l'utilisateur est connecté

	@POEI25P2G2-46 @TNR
	Scenario: US03 - Retour à la page d'accueil depuis l'espace "My Account"
		When L'utilisateur se rend sur la page my account
		And L'utilisateur se rend sur la page accueil
		Then L'utilisateur est sur la page accueil
		
	@POEI25P2G2-42 @TNR
	Scenario Outline: US03 - Présence des différentes sections sur 'My Account'
		When L'utilisateur se rend sur la page my account
		Then La section "<section>" est visible
		
		Examples:
		  | section                 |
		  | Historique de commandes |
		  | Avoirs                  |
		  | Adresses de livraison   |
		  | Informations personnelles |
		
