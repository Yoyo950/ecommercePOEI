@REQ_POEI25P2G2-3
Feature: US07 - Affichage du Logo
	#*En tant qu'* Utilisateur 
	#
	#*Je souhaite* Voir le logo du Site "Your Logo What a new experience" en gris 
	#
	#+Règles de gestion :+ 
	#
	#* RG1 : Le logo contient un lien qui doit rediriger le site sur la page accueil 
	#* RG2 : Le logo doit être présent sur toutes les pages du site

	@POEI25P2G2-22 @TNR
	Scenario Outline: US07 - Affichage du logo sur toutes les pages, renvoie page d'accueil
		When L'utilisateur se rend sur la page "<page>"
		Then Le logo 'Your Logo What a new experience' est présent
		When L'utilisateur clique sur le logo
		Then L'utilisateur est sur la page accueil
		
		Examples: 
		  | page              |
		  | authentification  |
		  | article           |
		  | search            |
		  | contact           |
		
