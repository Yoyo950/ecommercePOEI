@REQ_POEI25P2G2-6
Feature: US12 - Récapitulatif du panier
	#En tant qu' utilisateur,  je souhaite accéder au récapitulatif de mon panier afin de de pouvoir vérifier mon panier.
	#
	# Règles de gestion : 
	#
	#* RG1 : Le panier est accessible depuis la liste déroulante "Cart" en cliquant sur le bouton "Check out", ou bien depuis la pop-up apparaissant juste après l'ajout d'un article toujours en cliquant sur un bouton Check out" 
	#* RG2 : La page "SHOPPING-CART SUMMARY" s'affiche avec le récapitulatif du panier

	Background:
		#@POEI25P2G2-55
		Given l'utilisateur est sur la page d'authentification
		When il entre son identifiant "utilisateur@test.com" et son mot de passe "correct123"
		And il clique sur le bouton "Sign in"
		Then l'utilisateur est connecté

	#En tant qu' utilisateur,  je souhaite accéder au récapitulatif de mon panier afin de de pouvoir vérifier mon panier.
	#
	#RG1 : Le panier est accessible depuis la liste déroulante "Cart" en cliquant sur le bouton "Check out", ou bien depuis la pop-up apparaissant juste après l'ajout d'un article toujours en cliquant sur un bouton “Check out"
	@POEI25P2G2-36 @EVOL
	Scenario: US12 - Accès au panier depuis le pop-up apparaissant juste après l'ajout d'un article  en cliquant sur un bouton "Check out" depuis la pop-up
		When L'utilisateur ajoute un article au panier
		Then la pop-up s'affiche après ajout d'un article au panier
		When l'utilisateur clique sur le bouton "Check Out" de la pop-up
		Then La page "SHOPPING-CART SUMMARY" s'affiche avec le récapitulatif du panier
		
	#En tant qu' utilisateur,  je souhaite accéder au récapitulatif de mon panier afin de de pouvoir vérifier mon panier.
	#
	#RG1 : Le panier est accessible depuis la liste déroulante "Cart" en cliquant sur le bouton "Check out", ou bien depuis la pop-up apparaissant juste après l'ajout d'un article toujours en cliquant sur un bouton "Check out"
	@POEI25P2G2-35 @EVOL
	Scenario: US12 - Accès au panier depuis la liste déroulante "Cart" en cliquant sur le bouton "Check out"
		When L'utilisateur clique sur le bouton "Check out" de la liste déroulante "Cart"
		Then La page "SHOPPING-CART SUMMARY" s'affiche avec le récapitulatif du panier
		
