@REQ_POEI25P2G2-9
Feature: US13 - Paiement de la commande
	#En tant qu'utilisateur, je souhaite procéder au paiement de la commande afin de finaliser ma commande.
	#
	#
	#
	# Règles de gestion : 
	#
	#* RG1 : Dans la "SHOPPING-CART SUMMARY", la "Delivery address" et la "Invoice Address" apparaissent uniquement si les une adresse a été renseignée dans l'espace "My addresses" 
	#* RG2 : Le bouton "Proceed to checkout" redirige vers la page "Your addresses" permettant de sauvegarder son adresse si aucune addresse n'avait déjà été enregistrée auaparavant. Sinon la page "Addresses" s'affiche permettant de mettre à jour son adresse si nécessaire. 
	#* RG3 : Le bouton "Proceed to check out" de la page "Addresses" redirige vers la page "Shipping", une case à cocher pour valider les termes du service doit être cochée pour passer à l'étape de paiement. Sinon le message "You must agree to the terms of service before continuing" apparaît 
	#* RG4 : Le bouton "Proceed to check out" de la page "Shipping" redirige vers la page "Payment". L'espace "Payment" doit afficher le récapitulatif de la commande avec le montant total à régler. 3 options de paiement sont proposées : virement, chéque ou paypal 
	#* RG5 : En choisissant un mode paiement, on peut directement confirmer l'ordre en cliquant sur le bouton "I confirm my order". Le message "Your order on My Shop is complete." s'affiche

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
	#RG3 : Le bouton "Proceed to check out" de la page "Addresses" redirige vers la page "Shipping", une case à cocher pour valider les termes du service doit être cochée pour passer à l'étape de paiement. Sinon le message "You must agree to the terms of service before continuing" apparaît
	@POEI25P2G2-74 @EVOL
	Scenario: US13 - Redirection de la page "Proceed to checkout" de la page "Addresses" avec la case de validation non cochée
		Given L'utilisateur est sur la page "Addresses"
		When L'utilisateur clique sur le bouton "Proceed to checkout" de la page "Adresses"
		And La case de validation des termes du service n'est pas cochée
		Then Un message "You must agree to the terms of service before continuing" apparaît
		
	#Tests En tant qu'utilisateur, je souhaite procéder au paiement de la commande afin de finaliser ma commande.
	#
	#RG4 : Le bouton "Proceed to check out" de la page "Shipping" redirige vers la page "Payment". L'espace "Payment" doit afficher le récapitulatif de la commande avec le montant total à régler. 3 options de paiement sont proposées : virement, chéque ou paypal.
	@POEI25P2G2-68 @EVOL
	Scenario Outline: US13 - Redirection du bouton "Proceed to check out" de la page "Shipping"
		Given L'utilisateur est sur la page "Shipping"
		When L'utilisateur clique sur le bouton "Proceed to checkout" de la page "Adresses"
		And La case de validation des termes du service est cochée
		Then L'utilisateur est redirigé vers la page "Payment"
		When Le récapitulatif de la commande avec le montant total à régler est affiché
		Then L'utilisateur peut finaliser sa commande en "<mode_paiement>"
		When L'utilisateur clique sur le bouton "I confirm my order"
		Then Un message de confirmation "Your order on My Shop is complete" s'affiche
		
		Examples:
		  | mode_paiement |
		  | virement      |
		  | cheque        |
		  | paypal        |
		
	#En tant qu'utilisateur, je souhaite procéder au paiement de la commande afin de finaliser ma commande.
	#
	#RG3 : Le bouton "Proceed to check out" de la page "Addresses" redirige vers la page "Shipping", une case à cocher pour valider les termes du service doit être cochée pour passer à l'étape de paiement. Sinon le message "You must agree to the terms of service before continuing" apparaît.
	@POEI25P2G2-64 @EVOL
	Scenario: US13 - Redirection de la page "Proceed to checkout" de la page "Addresses" avec la case de validation cochée
		Given L'utilisateur est sur la page "Addresses"
		When L'utilisateur clique sur le bouton "Proceed to checkout" de la page "Adresses"
		And La case de validation des termes du service est cochée
		Then L'utilisateur est redirigé vers la page "Shipping"
		
