Feature: Test plan EVOL

	Background:
		#@POEI25P2G2-55
		Given l'utilisateur est sur la page d'authentification
		When il entre son identifiant "utilisateur@test.com" et son mot de passe "correct123"
		And il clique sur le bouton "Sign in"
		Then l'utilisateur est connecté

	#En tant qu' utilisateur,  je souhaite accéder au récapitulatif de mon panier afin de de pouvoir vérifier mon panier.
	#
	# RG2 : La page "SHOPPING-CART SUMMARY" s'affiche avec le récapitulatif du panier
	@POEI25P2G2-41 @EVOL
	Scenario: US12 - Affichage de la page "SHOPPING-CART SUMMARY" avec le récapitulatif du panier
		When L'utilisateur accède au panier
		Then La page "SHOPPING-CART SUMMARY" s'affiche avec le récapitulatif du panier
		
