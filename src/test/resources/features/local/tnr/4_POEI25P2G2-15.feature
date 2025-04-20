@REQ_POEI25P2G2-15
Feature: US04 - Gestion du compte client authentification
	#*En tant qu'* 
	#
	#     Utilisateur 
	#
	#*Je souhaite* 
	#
	#     Me connecter à mon compte 
	#
	#*Afin de* 
	#
	#     Gérer mon compte client 
	#
	#*Règles de gestion :* 
	#
	#RG1 : La page d'authentification est accessible depuis la page "Authentification" 
	#
	#RG2 : En se connectant à son compte l'écran "My Account" doit s'afficher 
	#
	#RG3 : les nom, prénom de l'utilisateur apparaît dans la barre menu 
	#
	#RG4 : En cas de connexion avec un mot de passe erroné, un message "Invalid password" s'affich

	@POEI25P2G2-50 @TNR
	Scenario Outline: US04 - Connexion échouée avec des identifiants incorrects
		Given l'utilisateur est sur la page d'authentification
		When il entre son identifiant "<email>" et son mot de passe "<motDePasse>"
		And il clique sur le bouton "Sign in"
		Then le message "<message>" s'affiche
		
		Examples:
		  | email               | motDePasse | message            |
		  | mauvais@test.com    | correct123 | Invalid password   |
		  | utilisateur@test.com| fauxpass   | Invalid password   |
		  | ""                  | correct123 | Invalid password   |
		
	#Tests *En tant qu'* 
	#
	#     Utilisateur 
	#
	#*Je souhaite* 
	#
	#     Me connecter à mon compte 
	#
	#*Afin de* 
	#
	#     Gérer mon compte client 
	#
	#*Règles de gestion :* 
	#
	#RG1 : La page d'authentification est accessible s'effectue depuis la page "Authentification" 
	#
	#RG2 : En se connectant à son compte l'écran "My Account" doit s'afficher 
	#
	#RG3 : les nom, prénom de l'utilisateur apparaît dans la barre menu 
	#
	#RG4 : En cas de connexion avec un mot de passe erroné, un message "Invalid password" s'affiche
	@POEI25P2G2-49 @TNR
	Scenario: US04 - Connexion avec des identifiants valides
		Given L'utilisateur se rend sur la page authentification
		When Il entre ses identifiants
		And Il clique sur le bouton Sign In
		Then L'utilisateur est sur la page my account
		And Son nom et prénom apparaissent dans la barre de menu
		
	@POEI25P2G2-47 @TNR
	Scenario: US04 - Accès à la page d'authentification depuis la page d’accueil
		Given L'utilisateur est sur la page accueil
		When L'utilisateur se rend sur la page authentification
		Then L'utilisateur est sur la page authentification
		
