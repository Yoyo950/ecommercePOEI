Feature: Test plan TNR

	@POEI25P2G2-24 @TNR
	Scenario: US07 - Lien du logo renvoie à la page d'accueil
		Given L'utilisateur n'est pas sur la page d'accueil
		When L'utilisateur clique sur le logo
		Then L'utilisateur est sur la page d'accueil
		
	@POEI25P2G2-19 @TNR
	Scenario: US06 - Déconnexion quand clic sur 'Sign Out'
		Given L'utilisateur est connecté
		
