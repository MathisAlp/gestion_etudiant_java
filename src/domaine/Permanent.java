package domaine;

import java.io.Serializable;

public class Permanent extends Enseignant implements Serializable {
    private int primePermanent;

    public Permanent(int primePermanent) {
        this.primePermanent = primePermanent;
    }

    public Permanent(String nomE, String prenomE, String grade, String spec, int primePermanent) {
        super(nomE, prenomE, grade, spec);
        this.primePermanent = primePermanent;
    }

    public int getPrimePermanent() {
        return primePermanent;
    }

    public void setPrimePermanent(int primePermanent) {
        this.primePermanent = primePermanent;
    }

    @Override
    public void afficher() {
        System.out.println("Numero Enseignant: " + numE);
        System.out.println("Nom: "+ nomE);
        System.out.println("Prenom: "+prenomE);
        System.out.println("Grade: "+grade);
        System.out.println("Specialite: "+spec);
        System.out.println("Prime: "+primePermanent);
    }
}
