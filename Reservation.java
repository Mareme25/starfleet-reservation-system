package fr.starfleet.modele.reservation;

import java.io.Serializable;
import fr.starfleet.modele.mission.Mission;
import fr.starfleet.modele.personne.Personne;

public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public enum Statut {
        CONFIRMEE, EN_ATTENTE, ANNULEE
    }
    
    private String id;
    private Mission mission;
    private Personne passager;
    private Statut statut;

    // Constructeur
    public Reservation(String id, Mission mission, Personne passager) {
        this.id = id;
        this.mission = mission;
        this.passager = passager;
        this.statut = Statut.EN_ATTENTE;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Personne getPassager() {
        return passager;
    }

    public void setPassager(Personne passager) {
        this.passager = passager;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    // Méthode pour confirmer la réservation
    public void confirmer() {
        if (mission.verifierDisponibilite()) {
            mission.ajouterPassager(passager);
            this.statut = Statut.CONFIRMEE;
        }
    }

    // Méthode pour annuler la réservation
    public void annuler() {
        mission.supprimerPassager(passager);
        this.statut = Statut.ANNULEE;
    }

    // Méthode pour modifier la réservation
    public void modifier(Mission nouvelleMission) {
        if (this.statut == Statut.CONFIRMEE) {
            this.annuler();
        }
        this.mission = nouvelleMission;
        this.statut = Statut.EN_ATTENTE;
    }

    // Afficher les informations de la réservation
    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", mission=" + mission.getId() +
                ", passager=" + passager.getNom() +
                ", statut=" + statut +
                '}';
    }
}