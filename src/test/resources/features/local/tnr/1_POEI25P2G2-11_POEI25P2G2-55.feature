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
		Given L'utilisateur se rend sur la page authentification
		When Il entre ses identifiants
		And Il clique sur le bouton Sign In
		Then l'utilisateur est connecté

	@POEI25P2G2-60 @TNR
	Scenario: US10 - Création d'adresse
		When L'utilisateur se rend sur la page my account
		And L'utilisateur clique sur créer une adresse
		Then L'utilisateur est sur la page création adresse
		When L'utilisateur rentre les informations "prenom", "nom", "telephone", "adresse", "ville", "code_postal", "pays" et valide
		Then L'utilisateur est sur la page my account
		And L'adresse a été créée avec les informations "prenom", "nom", "telephone", "adresse", "ville", "code_postal", "pays"
		
	@POEI25P2G2-59 @TNR
	Scenario: US10 - Modification d'adresse
		When L'utilisateur est sur la page my account
		And L'utilisateur clique sur modifier une adresse
		Then L'utilisateur clique sur modifier une adresse
		When L'utilisateur rentre les informations "<prenom>", "<nom>", "<telephone>", "<adresse>", "<ville>", "<code_postal>", "<pays>" et valide
		Then L'utilisateur est sur la page my account
		And L'adresse a été modifiée avec les informations "<prenom>", "<nom>", "<telephone>", "<adresse>", "<ville>", "<code_postal>", "<pays>"
		
	@POEI25P2G2-53 @TNR
	Scenario: US10 - Vérification présence de 'My Address' dans 'My Account'
		When L'utilisateur se rend sur la page my account
		Then Un espace my address est affiché sur la page
		And Les informations "prenom", "nom", "telephone", "adresse" sont présents
		
