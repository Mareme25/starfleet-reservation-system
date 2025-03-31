package fr.starfleet.interfaceconsole;

import fr.starfleet.modele.reservation.SystemeReservation;
import fr.starfleet.modele.vaisseau.Vaisseau;
import fr.starfleet.modele.personne.Personne;
import fr.starfleet.modele.mission.Mission;
import fr.starfleet.modele.reservation.Reservation;

import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InterfaceConsole {
    private SystemeReservation systeme;
    private Scanner scanner;

    // Constructeur
    public InterfaceConsole() {
        this.systeme = new SystemeReservation();
        this.scanner = new Scanner(System.in);
    }

    // Lancer le menu principal
    public void demarrer() {
        while (true) {
            System.out.println("\n--- Système de Réservation Starfleet ---");
            System.out.println("1. Gérer les vaisseaux");
            System.out.println("2. Gérer les personnes");
            System.out.println("3. Gérer les missions");
            System.out.println("4. Gérer les réservations");
            System.out.println("5. Rechercher");
            System.out.println("6. Sauvegarder/Charger les données");
            System.out.println("7. Quitter");
            System.out.print("Choisissez une option : ");
            
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne
            
            switch (choix) {
                case 1:
                    gererVaisseaux();
                    break;
                case 2:
                    gererPersonnes();
                    break;
                case 3:
                    gererMissions();
                    break;
                case 4:
                    gererReservations();
                    break;
                case 5:
                    rechercher();
                    break;
                case 6:
                    sauvegardeChargement();
                    break;
                case 7:
                    System.out.println("Fermeture du programme.");
                    return;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }

    private void gererReservations() {
        while (true) {
            System.out.println("\n--- Gestion des Réservations ---");
            System.out.println("1. Créer une réservation");
            System.out.println("2. Confirmer une réservation");
            System.out.println("3. Annuler une réservation");
            System.out.println("4. Afficher les réservations d'une personne");
            System.out.println("5. Afficher les réservations d'une mission");
            System.out.println("6. Retour");
            System.out.print("Choisissez une option : ");
            
            int choix = scanner.nextInt();
            scanner.nextLine();
            
            switch (choix) {
                case 1:
                    System.out.print("ID de la réservation : ");
                    String idRes = scanner.nextLine();
                    System.out.print("ID de la mission : ");
                    String idMission = scanner.nextLine();
                    System.out.print("ID de la personne : ");
                    String idPersonne = scanner.nextLine();
                    Mission mission = systeme.getMissions().stream()
                            .filter(m -> m.getId().equals(idMission))
                            .findFirst()
                            .orElse(null);
                    Personne personne = systeme.getPersonnes().stream()
                            .filter(p -> p.getId().equals(idPersonne))
                            .findFirst()
                            .orElse(null);
                    if (mission != null && personne != null) {
                        systeme.effectuerReservation(new Reservation(idRes, mission, personne));
                        System.out.println("Réservation créée avec succès.");
                    } else {
                        System.out.println("Mission ou personne introuvable.");
                    }
                    break;
                case 2:
                    System.out.print("ID de la réservation à confirmer : ");
                    String idConf = scanner.nextLine();
                    systeme.confirmerReservation(idConf);
                    System.out.println("Réservation confirmée.");
                    break;
                case 3:
                    System.out.print("ID de la réservation à annuler : ");
                    String idAnnul = scanner.nextLine();
                    systeme.annulerReservation(idAnnul);
                    System.out.println("Réservation annulée.");
                    break;
                case 4:
                    System.out.print("ID de la personne : ");
                    String idPers = scanner.nextLine();
                    List<Reservation> reservationsPers = systeme.getReservationsParPersonne(idPers);
                    reservationsPers.forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("ID de la mission : ");
                    String idMiss = scanner.nextLine();
                    List<Reservation> reservationsMiss = systeme.getReservationsParMission(idMiss);
                    reservationsMiss.forEach(System.out::println);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }
}
