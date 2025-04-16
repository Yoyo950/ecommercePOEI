Feature: Test plan EVOL

	Background:
		#@POEI25P2G2-55
		Given l'utilisateur est sur la page d'authentification
		When il entre son identifiant "utilisateur@test.com" et son mot de passe "correct123"
		And il clique sur le bouton "Sign in"
		Then l'utilisateur est connecté
		#@POEI25P2G2-61
		* L'article est ajouté au panier à partir de la page détails de l'article

	#En tant qu'utilisateur, je souhaite procéder au paiement de la commande afin de finaliser ma commande.
	#
	#RG5 : En choisissant un mode paiement, on peut directement confirmer l'ordre en cliquant sur le bouton "I confirm my order". Le message "Your order on My Shop is complete." s'affiche
	@POEI25P2G2-70 @EVOL
	Scenario: US13 - Confirmation de paiement
		Given L'utilisateur est sur la page de confirmation de paiement
		When L'utilisateur clique sur le bouton "I confirm my order"
		Then Un message de confirmation "Your order on My Shop is complete" s'affiche
		
	#En tant qu'utilisateur, je souhaite procéder au paiement de la commande afin de finaliser ma commande.
	#
	#
	#* RG4 : Le bouton "Proceed to check out" de la page "Shipping" redirige vers la page "Payment". L'espace "Payment" doit afficher le récapitulatif de la commande avec le montant total à régler. 3 options de paiement sont proposées : virement, chéque ou paypal.
	@POEI25P2G2-69 @EVOL
	Scenario Outline: US13 - Vérification des modes de paiement
		Given L'utilisateur est sur la page "Payment"
		When Le récapitulatif de la commande avec le montant total à régler est affiché
		Then L'utilisateur peut finaliser sa commande selon son "<mode_de_paiement>"
		
		Examples:
		  |mode_de_paiement|
		  | virement|
		  | cheque|
		  | paypal|
		
