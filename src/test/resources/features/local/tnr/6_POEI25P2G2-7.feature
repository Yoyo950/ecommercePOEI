@REQ_POEI25P2G2-7
Feature: US02 - Création d'un compte client
	#*En tant qu'* 
	#
	#     Utilisateur 
	#
	#*Je souhaite* 
	#
	#    Créer un compte client 
	#
	#*Afin de* 
	#
	#    Gérer mes commandes et mes informations personnelles 
	#
	#*Règles de gestion :* 
	#
	#RG1 : La page de création de compte est accessible s'effectue depuis la page "Authentification" 
	#
	#RG2 : Dans le champ "Email adress", il est nécessaire de renseigner une adresse mail valide (au format XXX@YYY.zz) et de cliquer sur le bouton "Create an account". Un message "Invalid email address" apparaît si le format n'est pas respecté, sinon la page "Create an account" s'affiche 
	#
	#RG3 : Dans la page "Create an account", l'utilisateur doit pouvoir créer un compte dans le pavé "Register" : 
	#
	#- En sélectionnant le genre - En saisissant son nom et prénom - En vérifiant/modifiant l'adresse mail, si l'email est modifié avec un format non conforme, le message "Email is invalid" s'affiche et la création du compte est bloquée) 
	#
	#- En saisissant un mot de passe (minimum 5 caractères, sinon le message "password is invalid" s'affiche et la création du compte ne s'effectue pas) 
	#
	#- Saisissant sa date de naissance (non obligatoire) 
	#
	#- En cochant "Sign up for our newsletter!" (non obligatoire) 
	#
	#- En validant avec un bouton "REGISTER" : la page "My account s'affiche avec un message "Your account has been created."

	@POEI25P2G2-40 @TNR
	Scenario Outline: US02 - Création de compte : des données invalides
		Given l'utilisateur est sur la page "Create an account"
		When il remplit le formulaire avec :
		    | genre         | <genre>         |
		    | prénom        | <prénom>        |
		    | nom           | <nom>           |
		    | email         | <email>         |
		    | motDePasse    | <motDePasse>    |
		    | dateNaissance | <dateNaissance> |
		    | newsletter    | <newsletter>    |
		And il clique sur le bouton "REGISTER"
		Then le message d'erreur "<message>" s'affiche
		
		Examples:
		  | genre | prénom | nom     | email         | motDePasse | dateNaissance | newsletter | message                         |
		  |       | fatima | fatima  | test@mail.com | abcdef     | 01/01/1990    | coché      | Le champ genre est obligatoire |
		  | Mme   |        | fatima  | test@mail.com | abcdef     |               | non coché  | Le prénom est obligatoire      |
		  | Mme   | fatima |         | test@mail.com | abcdef     |               | coché      | Le nom est obligatoire         |
		  | Mme   | fatima | fatima  | test@mail     | abcdef     |               | non coché  | Email is invalid               |
		  | Mme   | fatima | fatima  | test@mail.com | 123        | 05/07/1985    | coché      | Password is invalid            |
		
	@POEI25P2G2-39 @TNR
	Scenario: US02 - Création de compte avec informations valides
		Given l'utilisateur est sur la page "Create an account"
		When il renseigne toutes les informations valides du formulaire "Register"
		And il clique sur le bouton "REGISTER"
		Then la page "My account" s'affiche
		And le message "Your account has been created." est visible
		
	@POEI25P2G2-38 @TNR
	Scenario Outline: US02 - Saisie d'un email invalide sur la page d'authentification
		Given l'utilisateur est sur la page d'authentification
		When il saisit "<email>" dans le champ "Email address"
		And il clique sur le bouton "Create an account"
		Then le message "Invalid email address" s'affiche
		
		Examples:
		  | email         | 
		  | test          | 
		  | test@         |
		  | "test.zz"     |
		
	@POEI25P2G2-37 @TNR
	Scenario: US02 - Accès à la page de création de compte
		Given l'utilisateur est sur la page d'authentification
		When il saisit une adresse email valide dans le champ "Email address"
		And il clique sur le bouton "Create an account"
		Then la page "Create an account" s'affiche
		
