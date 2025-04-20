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

	Background:
		#@POEI25P2G2-90
		When L'utilisateur se rend sur la page authentification
		And Il entre une adresse mail temporaire sur le champ de création
		And Il clique sur le bouton create an account
		Then L'utilisateur est sur la page create an account
		When Il remplit le formulaire avec des données pour l'email temporaire
		And Il clique sur le bouton REGISTER
		Then L'utilisateur est sur la page my account
		And Le message Your account has been created est visible
		When L'utilisateur clique sur Sign Out
		Then L'utilisateur est déconnecté

	@POEI25P2G2-57 @TNR
	Scenario: US05 -  Parcours complet de réinitialisation du mot de passe
		Given L'utilisateur se rend sur la page authentification
		And L'utilisateur se rend sur la page réinitialisation du mot de passe
		When Il saisit son adresse email dans le champ prévu
		And Il clique sur le bouton retrieve password
		Then Une demande de réinitialisation est envoyée à l'adresse saisie
		
