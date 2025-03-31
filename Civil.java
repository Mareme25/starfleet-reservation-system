package fr.starfleet.modele.personne;

public class Civil extends Personne {
    private String planeteOrigine;
    private String motifVoyage;

    // Constructeur
    public Civil(String nom, String prenom, String identifiant, String planeteOrigine, String motifVoyage) {
        super(nom, prenom, identifiant);
        this.planeteOrigine = planeteOrigine;
        this.motifVoyage = motifVoyage;
    }

    // Getters et Setters
    public String getPlaneteOrigine() { return planeteOrigine; }
    public void setPlaneteOrigine(String planeteOrigine) { this.planeteOrigine = planeteOrigine; }

    public String getMotifVoyage() { return motifVoyage; }
    public void setMotifVoyage(String motifVoyage) { this.motifVoyage = motifVoyage; }

    // Implémentation de la méthode abstraite
    @Override
    public String getDescription() {
        return "Civil de " + planeteOrigine + ", voyage pour " + motifVoyage;
    }
}
