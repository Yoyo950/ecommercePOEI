@REQ_POEI25P2G2-1
Feature: US06 - Déconnexion de l'utilisateur
	#*En tant qu'* Utilisateur 
	#
	#*Je souhaite* Me déconnecter 
	#
	#*Afin de* Ne plus pouvoir accéder à mon espace client 
	#
	#+Règles de gestion :+ 
	#
	#* RG1 : Dans l'espace la barre menu, un lien "Sign out" déclenche la déconnexion 
	#* RG2 : La page d'authentification s'affiche et le lien "Sign in" remplace le lien "Sign out" dans la barre menu

	Background:
		#@POEI25P2G2-55
		Given L'utilisateur se rend sur la page authentification
		When Il entre ses identifiants
		And Il clique sur le bouton Sign In
		Then l'utilisateur est connecté

	@POEI25P2G2-17 @TNR
	Scenario Outline: US06 - Test Déconnexion Utilisateur sur plusieurs pages
		When L'utilisateur se rend sur la page "<page>"
		Then Le bouton Sign Out avec le lien correspondant doit être présent
		When L'utilisateur clique sur Sign Out
		Then L'utilisateur est déconnecté
		And L'utilisateur est sur la page authentification
		
		Examples:
		  | page      |
		  | homepage  |
		  | article   |
		  | search    |
		  | contact   |
		  | myaccount |
		
