package fr.starfleet.modele.vaisseau;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import fr.starfleet.modele.mission.Mission;

public class Vaisseau implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nom;
    private String immatriculation;
    private int capaciteMaximale;
    private List<Mission> missions;

    // Constructeur
    public Vaisseau(String nom, String immatriculation, int capaciteMaximale) {
        this.nom = nom;
        this.immatriculation = immatriculation;
        this.capaciteMaximale = capaciteMaximale;
        this.missions = new ArrayList<>();
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }

    public void setCapaciteMaximale(int capaciteMaximale) {
        this.capaciteMaximale = capaciteMaximale;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    // Méthode pour ajouter une mission
    public void ajouterMission(Mission mission) {
        this.missions.add(mission);
    }

    // Méthode pour supprimer une mission
    public void supprimerMission(Mission mission) {
        this.missions.remove(mission);
    }

    // Vérifier si la capacité est suffisante
    public boolean verifierCapacite(int nombrePassagers) {
        return nombrePassagers <= capaciteMaximale;
    }

    // Méthode pour afficher les informations du vaisseau
    @Override
    public String toString() {
        return "Vaisseau{" +
                "nom='" + nom + '\'' +
                ", immatriculation='" + immatriculation + '\'' +
                ", capaciteMaximale=" + capaciteMaximale +
                ", missions=" + missions.size() +
                '}';
    }
}
