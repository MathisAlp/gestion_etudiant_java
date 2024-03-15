package domaine;

import java.io.Serializable;

public class Vacataire extends Enseignant implements Serializable {
    private int primeVacataire;

    public Vacataire() {
    }

    public Vacataire(int primeVacataire) {
        this.primeVacataire = primeVacataire;
    }
    public Vacataire(String nomE, String prenom, String grade, String spec, int primeVacataire) {
        super(nomE, prenom, grade, spec);
        this.primeVacataire = primeVacataire;
    }

    public int getPrimeVacataire() {
        return primeVacataire;
    }

    public void setPrimeVacataire(int primeVacataire) {
        this.primeVacataire = primeVacataire;
    }

    @Override
    public void afficher() {
        System.out.println("Numero Enseignant: " + numE);
        System.out.println("Nom: "+ nomE);
        System.out.println("Prenom: "+prenomE);
        System.out.println("Grade: "+grade);
        System.out.println("Specialite: "+spec);
        System.out.println("Prime: "+primeVacataire);
    }
}
