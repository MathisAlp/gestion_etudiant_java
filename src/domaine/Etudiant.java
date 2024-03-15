package domaine;

import java.io.Serializable;
import java.util.ArrayList;

import static Others.ServiceUtils.createCode;
import static java.lang.Integer.parseInt;

public class Etudiant implements Serializable {
    private int numEtudiant;
    private String nom;
    private String prenom;
    private ArrayList<Module> listModEtu = new ArrayList<>();

    public Etudiant() {
        this.numEtudiant=parseInt(createCode());
    }
    public Etudiant(String nom, String prenom) {
        this.numEtudiant = parseInt(createCode());
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getNumEtudiant() {
        return numEtudiant;
    }

    public void setNumEtudiant(int numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void afficher(){
        System.out.println("Numéro Etudiant: "+this.numEtudiant);
        System.out.println("Nom etudiant: "+this.nom) ;
        System.out.println("Prenom etudiant: "+this.prenom);
    }

    public ArrayList<Module> getListModEtu() {
        return listModEtu;
    }

    public void setListModEtu(ArrayList<Module> listModEtu) {
        this.listModEtu = listModEtu;
    }
}
