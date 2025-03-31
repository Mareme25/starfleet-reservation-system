package fr.starfleet.modele.mission;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import fr.starfleet.modele.personne.Personne;

public class Mission implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String destination;
    private Date dateDepart;
    private Date dateRetour;
    private List<Personne> passagers;
    private int capaciteMax;

    // Constructeur
    public Mission(String id, String destination, Date dateDepart, Date dateRetour, int capaciteMax) {
        this.id = id;
        this.destination = destination;
        this.dateDepart = dateDepart;
        this.dateRetour = dateRetour;
        this.passagers = new ArrayList<>();
        this.capaciteMax = capaciteMax;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public List<Personne> getPassagers() {
        return passagers;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    // Ajouter un passager
    public boolean ajouterPassager(Personne personne) {
        if (verifierDisponibilite()) {
            this.passagers.add(personne);
            return true;
        }
        return false;
    }

    // Supprimer un passager
    public void supprimerPassager(Personne personne) {
        this.passagers.remove(personne);
    }

    // Vérifier s'il reste des places disponibles
    public boolean verifierDisponibilite() {
        return passagers.size() < capaciteMax;
    }

    // Afficher les informations de la mission
    @Override
    public String toString() {
        return "Mission{" +
                "id='" + id + '\'' +
                ", destination='" + destination + '\'' +
                ", dateDepart=" + dateDepart +
                ", dateRetour=" + dateRetour +
                ", passagers=" + passagers.size() +
                ", capaciteMax=" + capaciteMax +
                '}';
    }
}
