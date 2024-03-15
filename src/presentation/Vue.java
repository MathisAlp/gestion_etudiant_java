package presentation;

import dao.accesBd;
import domaine.*;
import domaine.Module;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Vue {
    private static final accesBd bd = new accesBd();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String nomE, prenomE, grade, spec, nomMod;
        int prime, volume;
        Vacataire v;
        Permanent p;
        Module mod;
        Etudiant etu;
        Enseignant ens;
        int choix = 0;
        do {
            System.out.println("___________Menu_______________");
            System.out.println("1- Créer un permanent");
            System.out.println("2- Creer un vacataire");
            System.out.println("3- Lister les permanents");
            System.out.println("4- Lister les vacataires");
            System.out.println("5- Lister tous les enseignants");
            System.out.println("6- Créer un étudiant");
            System.out.println("7- Lister les étudiants");
            System.out.println("8- Gestion des modules");
            System.out.println("9- Lister tous les modules suivis d'un étudiant donné");
            System.out.println("10- Lister tous les étudiants inscrits à un module donné");
            System.out.println("11- Lister tous les module d'un professeur");
            System.out.println("12- Quitter");
            System.out.println("Faites votre choix !");
            choix = getIntegerInput(sc);
            sc.nextLine();

            switch (choix){
                case 1:
                    System.out.println("Nom du permanent ?");
                    nomE = sc.nextLine();
                    System.out.println("Prenom du permanent");
                    prenomE = sc.nextLine();
                    System.out.println(("Grade du permanent ?"));
                    grade= sc.nextLine();
                    System.out.println("Specialité ?");
                    spec=sc.nextLine();
                    System.out.println("Prime Permanent ?");
                    prime=getIntegerInput(sc);
                    p= new Permanent(nomE,prenomE,grade,spec,prime);
                    bd.ajouterPermanent(p);
                    break;
                case 2:
                    System.out.println("Nom du vacataire ?");
                    nomE = sc.nextLine();
                    System.out.println("Prenom du vacataire");
                    prenomE = sc.nextLine();
                    System.out.println(("Grade du vacataire ?"));
                    grade= sc.nextLine();
                    System.out.println("Specialité ?");
                    spec=sc.nextLine();
                    System.out.println("Prime Permanent ?");
                    prime=getIntegerInput(sc);
                    v= new Vacataire(nomE,prenomE,grade,spec,prime);
                    bd.ajouterVacataire(v);
                    break;
                case 3:
                    bd.listerPermanent();
                    break;
                case 4:
                    bd.listerVacataire();
                    break;
                case 5:
                    bd.listerEnseignant();
                    break;
                case 6:
                    System.out.println("Nom etudiant");
                    String nomEtu = sc.nextLine();
                    System.out.println("Prenom Etu");
                    String prenomEtu= sc.nextLine();
                    etu= new Etudiant(nomEtu,prenomEtu);
                    bd.ajouterEtu(etu);
                    break;
                case 7:
                    bd.listerEtudiant();
                    break;
                case 8:
                    choix = 0;
                    do{
                        System.out.println("1- Créer un module");
                        System.out.println("2- Lister les modules");
                        System.out.println("3- Associer un module a un professeur");
                        System.out.println("4- Associer un module a un etudiant");
                        System.out.println("5- Quitter");
                        System.out.println("Faites votre choix");
                        choix = getIntegerInput(sc);
                        sc.nextLine();

                        switch (choix){
                            case 1:
                                System.out.println("Nom du module ?");
                                nomMod = sc.nextLine();
                                System.out.println("Volume du module ?");
                                volume= getIntegerInput(sc);
                                mod= new Module(nomMod,volume);
                                bd.creerModule(mod);
                                break;
                            case 2:
                                bd.listerModule();
                                break;
                            case 3:
                                System.out.println("_________Choix du module__________");
                                bd.listerModule();
                                System.out.println("Entrer le numéro du module ");
                                int num= getIntegerInput(sc);
                                mod = bd.rechercherModule(num);

                                System.out.println("_________Choix du professeur__________");
                                if(bd.getListEns().isEmpty()){
                                    System.out.println("Aucun professeur enrégistré, veuillez créer un professeur");
                                }else{
                                    bd.listerEnseignant();
                                    System.out.println("Entrer le numéro du professesur ");
                                    num= getIntegerInput(sc);
                                    ens = bd.rechercherEnseignant(num);
                                    while (ens==null) {
                                        System.out.println("Professeur inexistant !!");
                                        System.out.println("Entrer le numéro du professesur ");
                                        num = getIntegerInput(sc);
                                        ens = bd.rechercherEnseignant(num);
                                    }
                                    mod.setEns(ens);
                                    ens.ajouterModuleEnseignant(mod);
                                }
                                break;
                            case 4:
                                System.out.println("_________Choix du module__________");
                                bd.listerModule();
                                System.out.println("Entrer le numéro du module ");
                                num= getIntegerInput(sc);
                                mod = bd.rechercherModule(num);
                                System.out.println(mod.getVolume());

                                System.out.println("__________Choix Etudiant____________");
                                if(bd.getListEtu().isEmpty()){
                                    System.out.println("Aucun étudiant enrégistré, veuillez créer un étudiant");
                                }else{
                                    bd.listerEtudiant();
                                    System.out.println("Entrer le numéro de l'étudiant choisi");
                                    int numE= getIntegerInput(sc);
                                    etu = bd.rechercherEtudiant(numE);
                                    etu.getListModEtu().add(mod);
                                    mod.getListEtuMod().add(etu);
                                    while (etu==null) {
                                        System.out.println("Etudiant inexistant !!");
                                        System.out.println("Entrer le numéro de l'etudiant ");
                                        num = getIntegerInput(sc);
                                        etu = bd.rechercherEtudiant(num);
                                        etu.getListModEtu().add(mod);
                                        mod.getListEtuMod().add(etu);
                                    }
                                }
                        }
                    }while(choix!=5);
                    break;
                /*
                case 7:
                    System.out.println("Nom etudiant");
                    String nomEtu = sc.nextLine();
                    System.out.println("Prenom Etu");
                    String prenomEtu= sc.nextLine();
                    Etudiant etu= new Etudiant(nomEtu,prenomEtu);

                    System.out.println(("________________Choix des modules________________"));
                    bd.listerModule();
                    System.out.println("___________________________________________________");

                    System.out.println("Entrer le numéro du module choisi");
                    int numM= getIntegerInput(sc);
                    mod = bd.rechercherModule(numM);
                    etu.getListModEtu().add(mod);
                    mod.getListEtuMod().add(etu);
                    String ch="o";
                    while(ch.equals("o")){
                        sc.nextLine();
                        System.out.println("Voulez vous ajouter un module ?(o/n)");
                        ch= sc.nextLine();
                        if(ch.equals("o")){
                            System.out.println(("________________Choix des modules________________"));
                            bd.listerModule();

                            System.out.println("Entrer le numéro du module choisi");
                            numM= getIntegerInput(sc);
                            mod = bd.rechercherModule(numM);
                            etu.getListModEtu().add(mod);
                            mod.getListEtuMod().add(etu);
                        }
                    }
                    bd.ajouterEtu(etu);
                    break;
                case 9:
                    bd.listerEtudiant();
                    break;
                    */
                case 9:
                    String ch="o";
                    etu=null;
                    while(ch.equals("o")){
                        System.out.println("____________________Liste Etudiant______________________");
                        bd.listerEtudiant();
                        System.out.println("Entrer le numéro de l'étudiant choisi");
                        int numE= getIntegerInput(sc);
                        etu = bd.rechercherEtudiant(numE);
                        System.out.println("_________Liste des modules de l'etudiant_______");
                        for(Module module: etu.getListModEtu()){
                            System.out.println("_____________________________________________________________________");
                            module.afficher();
                        }
                        System.out.println("_____________________________________________________________________");
                        sc.nextLine();
                        System.out.println("Voulez vous voir les modules d'un autre etudiant ?(o/n)");
                        ch=sc.nextLine();
                    }
                    break;
                case 10:
                    ch="o";
                    while(ch.equals("o")){
                        System.out.println("____________________Liste Module______________________");
                        bd.listerModule();
                        System.out.println("Entrer le numéro du module choisi");
                        int numM= getIntegerInput(sc);
                        mod = bd.rechercherModule(numM);
                        System.out.println("_________Liste des étudiants du module_______");
                        for(Etudiant etudiant : mod.getListEtuMod()){
                            System.out.println("_____________________________________________________________________");
                            etudiant.afficher();
                        }
                        System.out.println("_____________________________________________________________________");
                        sc.nextLine();
                        System.out.println("Voulez vous voir les étudiants d'un autre module ?(o/n)");
                        ch=sc.nextLine();
                    }
                    break;
                case 11:
                    ch="o";
                    etu=null;
                    while(ch.equals("o")){
                        System.out.println("____________________Liste Enseignant______________________");
                        bd.listerEnseignant();
                        System.out.println("Entrer le numéro de l'enseignant choisi");
                        int numE= getIntegerInput(sc);
                        ens = bd.rechercherEnseignant(numE);
                        System.out.println("_________Liste des modules de l'enseignant_______");
                        for(Module module: ens.getListMod()){
                            System.out.println("___________________________________________________");
                            module.afficher();
                        }
                        System.out.println("_____________________________________________________________________");
                        sc.nextLine();
                        System.out.println("Voulez vous voir les modules d'un autre enseignant ?(o/n)");
                        ch=sc.nextLine();
                    }
                    break;
            }
        }while(choix!=12);
        System.out.println("Fin de l'application");
    }

    public static int getIntegerInput(Scanner sc) {
        while(true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Saisie invalide. Veuillez entrer un entier.");
                sc.nextLine();
            }
        }
    }
}
