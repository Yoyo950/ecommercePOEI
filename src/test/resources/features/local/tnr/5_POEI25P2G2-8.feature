@REQ_POEI25P2G2-8
Feature: US09 - Accès au Cart depuis toutes les pages
	#*En tant qu'* Utilisateur 
	#
	#*Je souhaite* Avoir un accès depuis toutes les pages vers mon panier d'achat (Cart) 
	#
	#*Afin de* Pouvoir finaliser mes commandes 
	#
	#+Règles de gestion :+ 
	#
	#* RG1 : Le lien du panier doit rediriger le site sur la page "Shopping Cart Summary" 
	#* RG2 : Le lien du panier doit être ancré en entête (présent sur toutes les pages du site)

	@POEI25P2G2-48 @TNR
	Scenario Outline: US09 - Accès au cart depuis toutes les pages
		When L'utilisateur se rend sur la page "<page>"
		Then Le bouton du panier et son lien sont présents
		When L'utilisateur se rend sur la page cart
		Then L'utilisateur est sur la page shopping cart summary
		
		Examples:
		  | page             |
		  | homepage         |
		  | article          |
		  | search           |
		  | contact          |
		  | authentification |
		
