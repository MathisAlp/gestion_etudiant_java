package dao;

import domaine.*;
import domaine.Module;

import java.util.ArrayList;

public class accesBd {
    private ArrayList<Enseignant> listEns = new ArrayList<>();
    private ArrayList<Module> listMod = new ArrayList<>();

    private ArrayList<Etudiant> listEtu= new ArrayList<Etudiant>();


    public ArrayList<Enseignant> getListEns() {
        return listEns;
    }

    public ArrayList<Module> getListMod() {
        return listMod;
    }

    public ArrayList<Etudiant> getListEtu() {
        return listEtu;
    }

    public void ajouterPermanent(Permanent p){
        listEns.add(p);
    }

    public void ajouterVacataire(Vacataire v){
        listEns.add(v);
    }

    public void listerVacataire(){
        if (listEns.isEmpty()) {
            System.out.println("Aucun Enseignant vacataire enrégistré");
        } else {
            for(Enseignant e: listEns){
                if(e instanceof Vacataire){
                    Vacataire v = (Vacataire) e;
                    System.out.println("------------------------------------------");
                    v.afficher();
                }
                System.out.println("------------------------------------------");
            }
        }
    }

    public void listerPermanent(){
        if (listEns.isEmpty()) {
            System.out.println("Aucun Enseignant permanent enrégistré");
        } else {
            for(Enseignant e: listEns){
                if(e instanceof Permanent){
                    Permanent p = (Permanent) e;
                    System.out.println("------------------------------------------");
                    p.afficher();
                }
                System.out.println("------------------------------------------");
            }
        }

    }

    public void listerEnseignant(){
        if (listEns.isEmpty()) {
            System.out.println("Aucun enseignant enrégistré");
        } else {
            for(Enseignant e: listEns){
                System.out.println("------------------------------------------");
                e.afficher();
            }
            System.out.println("------------------------------------------");
        }
    }
    public void creerModule(Module mod){
        listMod.add(mod);
    }

    public Enseignant rechercherEnseignant(int n){
        for(Enseignant e: listEns){
            if(e.getNumE()==n){
                return e;
            }
        }
        return null;
    }
    public void listerModule(){
        for(Module m: listMod){
            System.out.println("------------------------------------------");
            m.afficher();
        }
        System.out.println("------------------------------------------");
    }
    public void ajouterEtu(Etudiant e){
        this.listEtu.add(e);
    }
    public Module rechercherModule(int n){
        for(Module m : listMod){
            if (m.getNumModule()==n){
                return m;
            }
        }
        return null;
    }
    public Etudiant rechercherEtudiant(int n){
        for (Etudiant e: listEtu){
            if(e.getNumEtudiant()==n){
                return e;
            }
        }
        return null;
    }
    public void listerEtudiant(){
        if (listEtu.isEmpty()) {
            System.out.println("Aucun enseignant enrégistré");
        }else{
            for(Etudiant e :listEtu){
                System.out.println("------------------------------------------");
                e.afficher();
            }
            System.out.println("------------------------------------------");
        }

    }
}
