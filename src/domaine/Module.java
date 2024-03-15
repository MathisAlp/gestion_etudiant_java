package domaine;

import java.util.ArrayList;

import static Others.ServiceUtils.createCode;
import static java.lang.Integer.parseInt;

public class Module {
    private int numModule;
    private String nomModule;
    private int volume;
    private Enseignant ens;
    private ArrayList<Etudiant> listEtuMod = new ArrayList<>();

    public Module(){
        this.numModule= parseInt(createCode()) ;
    }

    public Module(String nomModule, int volume) {
        this.numModule = parseInt(createCode());
        this.nomModule = nomModule;
        this.volume = volume;
    }

    public int getNumModule() {
        return numModule;
    }

    public void setNumModule(int numModule) {
        this.numModule = numModule;
    }

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Enseignant getEns() {
        return ens;
    }

    public void setEns(Enseignant ens) {
        this.ens = ens;
    }

    public void afficher() {
        System.out.println("Numero Module: " + numModule);
        System.out.println("Nom : "+ nomModule);
        System.out.println("Volume: "+volume+" Heures");
        if(this.getEns()!=null){
            System.out.println("Nom du professeur: "+this.getEns().nomE+ " " +this.getEns().prenomE);
        }
    }

    public ArrayList<Etudiant> getListEtuMod() {
        return listEtuMod;
    }

    public void setListEtuMod(ArrayList<Etudiant> listEtuMod) {
        this.listEtuMod = listEtuMod;
    }
}
