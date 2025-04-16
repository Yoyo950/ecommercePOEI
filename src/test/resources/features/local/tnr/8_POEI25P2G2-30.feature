Feature: Test plan TNR

	Background:
		#@POEI25P2G2-73
		Given l'utilisateur accède à l'URL de l'application
		Then la page d'accueil s'affiche
		And la barre de navigation principale est visible

	@POEI25P2G2-30 @TNR
	Scenario: US01 - Interaction avec une publicité à la une
		When il clique sur une publicité à la une
		Then il est redirigé vers le site partenaire PrestaShop
		
