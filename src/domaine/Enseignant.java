package domaine;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import static Others.ServiceUtils.createCode;
import static java.lang.Integer.parseInt;

public abstract class Enseignant implements Serializable {
    protected int numE;
    protected String nomE;
    protected String prenomE;
    protected String grade;
    protected String spec;
    protected ArrayList<Module> listMod = new ArrayList<>();

    public Enseignant() {
        this.numE = parseInt(createCode());
    }

    public Enseignant(String nomE, String prenomE, String grade, String spec) {
        this.numE = parseInt(createCode());
        this.nomE = nomE;
        this.prenomE = prenomE;
        this.grade = grade;
        this.spec = spec;
    }

    public int getNumE() {
        return numE;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenom(String prenomE) {
        this.prenomE = prenomE;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
    public abstract void afficher();

    public ArrayList<Module> getListMod() {
        return listMod;
    }

    public void ajouterModuleEnseignant(Module m){
        this.listMod.add(m);
    }
}
