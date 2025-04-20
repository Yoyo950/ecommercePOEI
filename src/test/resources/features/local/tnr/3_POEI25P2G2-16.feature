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

	@POEI25P2G2-52 @TNR
	Scenario: US05 -  Accès à la page de réinitialisation de mot de passe
		Given L'utilisateur se rend sur la page authentification
		When L'utilisateur se rend sur la page réinitialisation du mot de passe
		Then La page de réinitialisation du mot de passe s'affiche
		
