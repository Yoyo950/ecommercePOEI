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
		#@POEI25P2G2-56
		* L'utilisateur accède au panier
		* La page "SHOPPING-CART SUMMARY" s'affiche avec le récapitulatif du panier

	#En tant qu'utilisateur, je souhaite procéder au paiement de la commande afin de finaliser ma commande.
	#
	#RG2 : Le bouton "Proceed to checkout" redirige vers la page "Your addresses" permettant de sauvegarder son adresse si aucune adresse n'avait déjà été enregistrée auparavant. Sinon la page "Addresses" s'affiche permettant de mettre à jour son adresse si nécessaire.
	@POEI25P2G2-51 @EVOL
	Scenario Outline: US13 - Redirection de la page "Proceed to checkout" de la page "SHOPPING-CART SUMMARY"
		When L'utilisateur clique sur le bouton "Proceed to checkout"
		And Une adresse a été renseigné ou non
		Then L'utilisateur est redirigé sur "<pages>"
		
		Examples: 
		 | pages |
		 | Your adresses|
		 | Adresses|
		
	#En tant qu'utilisateur, je souhaite procéder au paiement de la commande afin de finaliser ma commande.
	#
	#Règles de gestion : 
	#
	#RG1 : Dans la "SHOPPING-CART SUMMARY", la "Delivery address" et la "Invoice Address" apparaissent uniquement si une adresse a été renseignée dans l'espace "My addresses".
	@POEI25P2G2-43 @EVOL
	Scenario: US13 - Affichage de la "Delivery address" et la "Invoice Address" dans la page "SHOPPING-CART SUMMARY"
		When Une adresse a été renseignée dans l'espace "My addresses"
		Then La "Delivery address" et la "Invoice Address" apparaissent
		
