Feature: Test plan EVOL

	#En tant qu’utilisateur, je souhaite ajouter des articles dans mon panier ("Cart") afin de de pouvoir passer des commandes.
	#
	#Règles de gestion :
	#
	#RG3 : Les boutons "Add to cart" de la page de listes de résultats enclenche une pop up : "Product successfully added to your shopping cart". Dans la pop up un bouton "Continue shopping" ferme la popup.
	@POEI25P2G2-32 @EVOL
	Scenario: US11 - Apparition du pop-up après avoir cliquer le bouton "Add to cart" de la page liste de résultat
		Given L'utilisateur L'utilisateur est sur la page de liste des résultats
		When L'utilisateur clique sur le bouton "Add to cart" de la page de liste des résultats
		Then Un pop up "Product successfully added to your shopping cart" apparaît avec un bouton "Continue shopping"
		
	#En tant qu’utilisateur, je souhaite ajouter des articles dans mon panier ("Cart") afin de de pouvoir passer des commandes. 
	#
	#RG3 : Le bouton "Add to cart" sur la page détail de chaque article enclenche une pop up : "Product successfully added to your shopping cart". Dans la pop up un bouton "Continue shopping" ferme la popup.
	@POEI25P2G2-26 @EVOL
	Scenario: US11 - Apparition du pop-up après avoir cliquer le bouton "Add to cart" des pages détails des articles
		Given L'utilisateur L'utilisateur est sur la page de détail de l'article
		When L'utilisateur clique sur le bouton "Add to cart" de la page détail de l'article
		Then Un pop up "Product successfully added to your shopping cart" apparaît avec un bouton "Continue shopping"
		
