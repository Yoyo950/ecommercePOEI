@REQ_POEI25P2G2-16
Feature: US05 -  Ré-initialiser mon mot de passe 
	#*En tant qu'* 
	#
	#    Utilisateur 
	#
	#*Je souhaite* 
	#
	#   Ré-initialiser mon mot de passe oublié 
	#
	#*Afin de* 
	#
	#    D’accéder à mon compte client 
	#
	#*Règles de gestion :* 
	#
	#RG1 : Dans la page d'authentification, un lien "Forgot your password?" redirige l'utilisation vers la page de réinitialisation du compte. Un champ permet de saisir l'email du compte, et un bouton "Retrieve Password" génére l'envoi d'un mail de réinitialisation 
	#
	#RG2 : Le mail contient un lien de réinitialisation permettant l'envoi d'un mail avec un nouveau mot de passe

	@POEI25P2G2-58 @TNR
	Scenario: US05 -  Génération d'un nouveau mot de passe via le lien reçu par email
		Given l'utilisateur a reçu un email de réinitialisation de mot de passe
		When il clique sur le lien contenu dans l’email
		Then un nouveau mot de passe lui est envoyé par email
		
	@POEI25P2G2-57 @TNR
	Scenario: US05 -  Demande de réinitialisation de mot de passe
		Given l'utilisateur est sur la page de réinitialisation du mot de passe
		When il saisit son adresse email dans le champ prévu
		And il clique sur le bouton "Retrieve Password"
		Then une demande de réinitialisation est envoyée à l'adresse saisie
		
	@POEI25P2G2-52 @TNR
	Scenario: US05 -  Accès à la page de réinitialisation de mot de passe
		Given l'utilisateur est sur la page d'authentification
		When il clique sur le lien "Forgot your password?"
		Then la page de réinitialisation du mot de passe s'affiche
		
