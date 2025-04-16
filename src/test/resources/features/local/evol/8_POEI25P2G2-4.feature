@REQ_POEI25P2G2-4
Feature: US11 - Ajout des articles dans le panier "Cart"
	#En tant qu’utilisateur, je souhaite ajouter des articles dans mon panier ("Cart") afin de de pouvoir passer des commandes. 
	#
	#Règles de gestion :
	#
	#*  RG1 : Dans les listes de résultats un bouton "Add to cart" apparaît en passant la souris sur chaque article, le bouton permet d'ajouter l'article dans le panier ("Cart").
	#*  RG2 : Dans le détail de chaque article un bouton "Add to cart" sur la droite permet d'ajouter l'article dans le panier ("Chart") de mettre à jour ses informations.
	#* RG3 : Les boutons "Add to cart" (dans les listes de résultats et le détail de chaque article) enclenche une pop up : "Product successfully added to your shopping cart". Dans la pop up un bouton "Continue shopping" ferme la popup.

	#En tant qu’utilisateur, je souhaite ajouter des articles dans mon panier ("Cart") afin de de pouvoir passer des commandes. 
	#
	#RG2 : Dans le détail de chaque article un bouton "Add to cart" sur la droite permet d'ajouter l'article dans le panier ("Chart") et de mettre à jour ses informations.
	@POEI25P2G2-21 @EVOL
	Scenario: US11 - Bouton "Add to cart" sur la page détail de chaque article
		Given L'utilisateur est sur la page de détail de l'article
		When L'utilisateur clique sur le bouton "Add to cart" de la page détail de l'article
		Then L'article est ajouté au panier à partir de la page détails de l'article
		And Un pop up "Product successfully added to your shopping cart" apparaît avec un bouton "Continue shopping"
		When L'utilisateur clique sur le bouton "Continue Shopping"
		Then La pop-up "Product successfully added to your shopping cart" disparait
		
	#En tant qu’utilisateur, je souhaite ajouter des articles dans mon panier ("Cart") afin de de pouvoir passer des commandes. 
	#
	#RG1 : Dans les listes de résultats un bouton "Add to cart" apparaît en passant la souris sur chaque article, le bouton permet d'ajouter l'article dans le panier ("Cart").
	@POEI25P2G2-18 @EVOL
	Scenario: US11 - Bouton "Add to cart" sur la liste des résultats permettant d'ajouter l'article au panier 
		Given L'utilisateur est sur la page de la liste des résultats
		When L'utilisateur passe la souris sur un article
		And L'utilisateur clique sur le bouton "Add to cart"
		Then L'article est ajouté au panier à partir de la liste de résultat
		And Un pop up "Product successfully added to your shopping cart" apparaît avec un bouton "Continue shopping"
		When L'utilisateur clique sur le bouton "Continue Shopping"
		Then La pop-up "Product successfully added to your shopping cart" disparait
		
