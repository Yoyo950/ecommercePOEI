@REQ_POEI25P2G2-11
Feature: US10 - Gestion des coordonnées de l'utilisateur
	#*En tant qu'* Utilisateur 
	#
	#*Je souhaite* Gérer mes coordonnées 
	#
	#*Afin de* Pouvoir gérer mes informations de livraison pour les commandes 
	#
	#+Règles de gestion :+ 
	#
	#* RG1 : Dans la page "My Account", le site doit afficher un espace "My Address" avec les coordonnées du client (nom prénom, addresse, téléphone) 
	#* RG2 : Dans l'espace page "My Address" l'utilisateur doit avoir la possibilité de mettre à jour ses informations
	#* RG3 : Dans l'espace page "My Address" l'utilisateur doit avoir la possibilité de créer d'autres addresses

	Background:
		#@POEI25P2G2-55
		Given l'utilisateur est sur la page d'authentification
		When il entre son identifiant "utilisateur@test.com" et son mot de passe "correct123"
		And il clique sur le bouton "Sign in"
		Then l'utilisateur est connecté

	@POEI25P2G2-60 @TNR
	Scenario: US10 - Création d'addresse
		When L'utilisateur va dans la page 'My Account'
		And L'utilisateur clique sur 'Créer une addresse'
		Then L'utilisateur est sur la page 'Création d'Addresse'
		When L'utilisateur rentre les informations "prenom", "nom", "telephone", "addresse", "ville", "code_postal", "pays" et valide
		Then L'utilisateur est sur la page 'My Account'
		And L'adresse a été créée avec les informations "prenom", "nom", "telephone", "addresse", "ville", "code_postal", "pays"
		
	@POEI25P2G2-59 @TNR
	Scenario: US10 - Modification d'addresse
		When L'utilisateur se rend sur la page 'My Account'
		And L'utilisateur clique sur 'Modifier une Adresse'
		Then L'utilisateur est sur la page 'Modification d'Addresse'
		When L'utilisateur rentre les informations "prenom", "nom", "telephone", "addresse", "ville", "code_postal", "pays" et valide
		Then L'utilisateur est sur la page 'My Account'
		And L'adresse a été modifiée avec les informations "prenom", "nom", "telephone", "addresse", "ville", "code_postal", "pays"
		
	@POEI25P2G2-53 @TNR
	Scenario: US10 - Vérification présence de 'My Address' dans 'My Account'
		When L'utilisateur va dans la page 'My Account'
		Then Un espace 'My Address' est affiché sur la page
		And Les informations "prenom", "nom", "telephone", "addresse" sont présents
		
