# starfleet-reservation-system
Système de réservation pour vaisseaux StarFleet - Projet Java

Description

Ce projet est une application Java permettant la gestion des réservations de missions spatiales pour la flotte Starfleet. Il inclut la gestion des vaisseaux, des membres d'équipage et passagers, des missions et des réservations.

Fonctionnalités

Gestion des vaisseaux : Ajouter, modifier, supprimer, afficher les vaisseaux.

Gestion des personnes : Ajouter, modifier, supprimer, afficher les membres d'équipage et les passagers.

Gestion des missions : Créer, modifier, annuler, afficher les missions et les associer à un vaisseau.

Gestion des réservations : Créer, confirmer, annuler et afficher les réservations.

Recherche : Recherche de missions, personnes et vaisseaux selon plusieurs critères.

Persistance des données : Sauvegarde et chargement des données dans un fichier.

Installation et Exécution

Cloner le dépôt :

git clone <URL-du-repository>

Compiler le projet :

javac -d bin -sourcepath src src/fr/starfleet/interfaceconsole/InterfaceConsole.java

Exécuter l'application :

java -cp bin fr.starfleet.interfaceconsole.InterfaceConsole

Dépendances

Aucune dépendance externe requise. Le projet utilise uniquement les bibliothèques standard de Java.


Auteur
Nom : Mareme NGONDI

Email : ***********


Organisation : Starfleet Development Team

Rapport de Conception

1. Introduction

Le projet Système de Réservation Starfleet est une application Java permettant d'organiser des missions spatiales et d'en gérer les réservations. Il repose sur une architecture orientée objet et suit les bonnes pratiques de programmation.

2. Architecture du Projet

Le projet est organisé en plusieurs packages :

fr.starfleet.modele.vaisseau : Gestion des vaisseaux.

fr.starfleet.modele.personne : Gestion des personnes (pilotes, équipage, passagers).

fr.starfleet.modele.mission : Gestion des missions spatiales.

fr.starfleet.modele.reservation : Gestion des réservations.

fr.starfleet.interfaceconsole : Interface utilisateur via la console.

3. Choix Techniques

Collections :

ArrayList pour stocker les listes de vaisseaux, missions, passagers, etc.

HashMap pourrait être utilisé pour accélérer la recherche par identifiant.

Gestion des Exceptions :

Vérification des entrées utilisateur avec try-catch.

Gestion des erreurs de format et des cas où une réservation est impossible.

Persistance des Données :

Utilisation de la sérialisation (ObjectOutputStream et ObjectInputStream) pour sauvegarder et charger les données.

4. Améliorations Possibles

Développement d'une interface graphique (Swing, JavaFX).

Ajout d'une base de données pour une gestion persistante avancée.

Intégration d'une API REST pour interagir avec d'autres systèmes.

5. Conclusion

Ce projet offre une gestion efficace des missions Starfleet et applique les concepts fondamentaux de la programmation orientée objet, des structures de données et de la gestion des exceptions.

Fait par : Mareme NGONDI

Date : 31 Mars 2025


