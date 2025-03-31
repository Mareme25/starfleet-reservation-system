package fr.starfleet.modele.reservation;

import java.util.ArrayList;
import java.util.List;
import fr.starfleet.modele.mission.Mission;
import fr.starfleet.modele.personne.Personne;
import fr.starfleet.modele.vaisseau.Vaisseau;
import java.io.*;

public class SystemeReservation {
    private List<Vaisseau> vaisseaux;
    private List<Personne> personnes;
    private List<Mission> missions;
    private List<Reservation> reservations;

    // Constructeur
    public SystemeReservation() {
        this.vaisseaux = new ArrayList<>();
        this.personnes = new ArrayList<>();
        this.missions = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    // Ajouter un vaisseau
    public void ajouterVaisseau(Vaisseau vaisseau) {
        vaisseaux.add(vaisseau);
    }

    // Ajouter une personne
    public void ajouterPersonne(Personne personne) {
        personnes.add(personne);
    }

    // Créer une mission
    public void creerMission(Mission mission) {
        missions.add(mission);
    }

    // Effectuer une réservation
    public Reservation effectuerReservation(String id, Mission mission, Personne passager) {
        if (mission.verifierDisponibilite()) {
            Reservation reservation = new Reservation(id, mission, passager);
            reservation.confirmer();
            reservations.add(reservation);
            return reservation;
        }
        return null; // Capacité maximale atteinte
    }

    // Rechercher des missions par destination
    public List<Mission> rechercherMissions(String destination) {
        List<Mission> resultats = new ArrayList<>();
        for (Mission mission : missions) {
            if (mission.getDestination().equalsIgnoreCase(destination)) {
                resultats.add(mission);
            }
        }
        return resultats;
    }

    // Sauvegarder les données dans un fichier
    public void sauvegarderDonnees(String fichier) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichier))) {
            out.writeObject(vaisseaux);
            out.writeObject(personnes);
            out.writeObject(missions);
            out.writeObject(reservations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Charger les données depuis un fichier
    public void chargerDonnees(String fichier) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichier))) {
            vaisseaux = (List<Vaisseau>) in.readObject();
            personnes = (List<Personne>) in.readObject();
            missions = (List<Mission>) in.readObject();
            reservations = (List<Reservation>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}