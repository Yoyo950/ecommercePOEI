@REQ_POEI25P2G2-5
Feature: US08 - Recherche des articles sur le site
	#*En tant qu'* Utilisateur 
	#
	#*Je souhaite* Avoir un champ de recherche et sa loupe de confirmation
	#
	#*Afin d'* Effectuer des recherches d'articles sur tout le site 
	#
	#+Règles de gestion :+ 
	#
	#* RG1 : Le champ et la loupe doivent être ancrés en entête (présent sur toutes les pages du site) 
	#* RG2 : Le champ de recherche propose des suggestions d'articles à l'utilisateur au fur et à mesure de sa saisie, en cas de sélection d'une de ces proposition d'articles, la loupe renvoie directement vers l'article 
	#* RG3 : En cas de saisie "libre" (non seléction d'un article suggéré). La loupe de recherche renvoie vers la page "Search" avec des résultats d'articles pertinents en fonction de la saisie

	@POEI25P2G2-34 @TNR
	Scenario Outline: US08 - Recherche classique avec une liste de résultats
		When L'utilisateur entre "<input>" dans la barre de recherche
		And Clique sur la loupe
		Then L'utilisateur est sur la page search
		And L'article "<article>" est présent dans la liste de résultats
		
		Examples:
		  | input  | article                 |
		  | blou   | Blouse                  |
		  | summ   | Printed Summer Dress    |
		
	@POEI25P2G2-33 @TNR
	Scenario Outline: US08 - Proposition d'articles lors de la recherche
		When L'utilisateur entre "<input>" dans la barre de recherche
		Then L'article "<article>" doit être proposé
		When L'utilisateur clique sur un article "<article>" proposé
		Then L'utilisateur est sur la page article de "<article>"
		
		Examples:
		  | input  | article                 |
		  | blou   | Blouse                  |
		  | summ   | Printed Summer Dress    |
		
	@POEI25P2G2-31 @TNR
	Scenario Outline: US08 - Présence du champ et de la loupe dans toutes les pages
		When L'utilisateur se rend sur la page "<page>"
		Then Le champ de recherche et la loupe doivent être présents
		
		Examples:
		  | page             |
		  | homepage         |
		  | article          |
		  | search           |
		  | contact          |
		  | authentification |
		
