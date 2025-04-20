Feature: Test plan TNR

	@POEI25P2G2-30 @TNR
	Scenario: US01 - Interaction avec une publicité à la une
		Given L'utilisateur est sur la page accueil
		When L'utilisateur clique sur une publicité à la une
		Then L'utilisateur est sur la page du site partenaire PrestaShop
		
	@POEI25P2G2-24 @TNR
	Scenario: US07 - Lien du logo renvoie à la page d'accueil
		Given L'utilisateur se rend sur la page authentification
		When L'utilisateur clique sur le logo
		Then L'utilisateur est sur la page accueil
		
