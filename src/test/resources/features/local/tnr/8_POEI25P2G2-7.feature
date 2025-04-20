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
		Given L'utilisateur se rend sur la page authentification
		When Il entre l'adresse mail "<email>" sur le champ de création
		And Il clique sur le bouton create an account
		Then L'utilisateur est sur la page create an account
		When Il remplit le formulaire avec "<genre>", "<prénom>", "<nom>", "<motDePasse>", "<dateNaissance>", "<newsletter>"
		And Il clique sur le bouton REGISTER
		Then Le message d'erreur "<message>" s'affiche
		
		Examples:
		  | genre | prénom | nom     | motDePasse | dateNaissance | newsletter | email         | message                |
		  | Mr    |        | fat     | abcdef     | 01/01/1990    | coché      | random        | firstname is required. |
		  | Mrs   | fatima |         | abcdef     | 01/01/1990    | non coché  | random        | lastname is required.  |
		  | Mr    | william| fat     |            | 01/01/1990    | coché      | random        | passwd is required.    |
		  | Mrs   | Alice  | fat     | 123        | 05/07/1985    | non coché  | random        | passwd is invalid.     |
		
	@POEI25P2G2-39 @TNR
	Scenario Outline: US02 - Création de compte avec informations valides
		Given L'utilisateur se rend sur la page authentification 
		When Il entre l'adresse mail "<email>" sur le champ de création
		And Il clique sur le bouton create an account
		Then L'utilisateur est sur la page create an account
		When Il remplit le formulaire avec "<genre>", "<prénom>", "<nom>", "<motDePasse>", "<dateNaissance>", "<newsletter>"
		And Il clique sur le bouton REGISTER
		Then L'utilisateur est sur la page my account
		And Le message Your account has been created est visible
		
		Examples:
					| genre | prénom | nom     | email            | motDePasse | dateNaissance | newsletter |
					| Mrs   | fatima | fatima  | random           |  abcdef    | 01/01/1990    | coché      |
		
	@POEI25P2G2-38 @TNR
	Scenario Outline: US02 - Saisie d'un email invalide sur la page d'authentification
		Given L'utilisateur se rend sur la page authentification
		When Il entre l'adresse mail "<email>" sur le champ de création
		And Il clique sur le bouton create an account
		Then Le message "Invalid email address." s'affiche
		
		Examples:
		  | email         | 
		  | test          | 
		  | test@         |
		
	@POEI25P2G2-37 @TNR
	Scenario: US02 - Accès à la page de création de compte
		Given L'utilisateur se rend sur la page authentification
		When Il entre l'adresse mail "adressevalide@validedefou.com" sur le champ de création
		And Il clique sur le bouton create an account
		Then L'utilisateur est sur la page create an account
		
