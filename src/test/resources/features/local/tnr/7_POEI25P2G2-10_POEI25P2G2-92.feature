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
		#@POEI25P2G2-92
		Given L'utilisateur se rend sur la page authentification 
		    When Il entre l'adresse mail "random" sur le champ de création
		    And Il clique sur le bouton create an account
		    Then L'utilisateur est sur la page create an account
		    When Il remplit le formulaire avec "Mrs", "fatima", "fatima", "abcdef", "01/01/1990", "coché"
		    And Il clique sur le bouton REGISTER
		    Then L'utilisateur est sur la page my account
		    And Le message Your account has been created est visible

	@POEI25P2G2-44 @TNR
	Scenario: US03 - Présence du bouton 'Add my first Address' pour ajouter une première adresse
		When L'utilisateur se rend sur la page my account
		And Le bouton add my first address est affiché
		And Il clique sur le bouton add my first address
		Then L'utilisateur est sur la page création adresse
		
