package uno.jeu;

import java.util.Scanner;

/**
 * Cette classe permet de faire un lien entre le jeu et l'Homme. C'est par cette classe que l'utilisateur
        rentre les données utiles pour le fonctionnement du jeu. De plus c'est ici que se trouve tout
        l'affichage de la console.
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public class DialogueLigneDeCommande {

    /**
     * uno dans lequel on joue
     */
    private Uno uno;
    /**
     * scanner qui fait le lien entre l'Homme machine
     */
    private final Scanner scan;

    /**
     * constructeur de la classe
     */
    public DialogueLigneDeCommande() {
        scan = new Scanner(System.in);
        initialisation();
    }

    /**
     * initialisation de la classe avec le nombre de joueurs dans la partie, le nom du joueur humain
            et le niveau de difficulté
     */
    private void initialisation() {
        int nbJoueurs = 0;
        String nomJoueur;
        int niveau;
        do {
            System.out.println("Entrez le nombre de joueur dans la partie :");
            try {
                String val = scan.nextLine();
                nbJoueurs = Integer.parseInt(val);
            } catch (RuntimeException ex) {//si la valeur rentrée n'est pas un chiffre
                System.err.println("la valeur rentrée n'est pas un chiffre");
            }
        } while (nbJoueurs < 2 || nbJoueurs >= 10);//le nombre de joueurs est compris entre 2 et 10
        nomJoueur = choixNom();
        niveau = choixNiveau();
        uno = Uno.initialisation(nbJoueurs, nomJoueur, niveau);
        uno.setDialogue(this);
    }

    /**
     * fonction qui fait réagir le bot ou le joueur
     */
    public void reagir() {
        System.out.println("\nle sommet du talon est : " + uno.sommetTalon());
        if (uno.estFinie()) {
            if (!uno.estHumain()) {//si le joueur est un bot
                reagirBot();
            } else {//si le joueur est un humain
                reagirHumain();
            }
        } else affichageFin();
    }

    /**
     * affichage de ce que joue le bot
     */
    private void reagirBot() {
        System.out.println("\n\uD83D\uDC7E " + uno.getNom() + "  NB_CARTES: \u001B[35m" + uno.getNbCartes() + "\u001B[0m");
        try {//temps d'attente pour créer une interaction avec le joueur
            for (int i = 0; i < 10; ++i) {
                System.out.print("_ ");
                Thread.sleep(200);
            }
        } catch (InterruptedException ie) {
            System.exit(1);
        }
        uno.jouer("");//le bot jou
    }

    /**
     * affichage de ce que joue le joueur
     */
    private void reagirHumain() {
        try {
            System.out.println("\nVotre main est :️");
            System.out.print(uno.getMainJoueur());
            System.out.println("\nChoisissez une carte :");
            String coup = scan.nextLine().toUpperCase();
            uno.jouer(coup);
        } catch (CoupIncorrect ex) {//la carte choisit ne peut pas être jouée
            System.err.println(ex.getMessage());
            reagir();//on fait rejouer le joueur
        }
    }

    /**
     * choix du nom du personnage
     *
     * @return le nom du personnage
     */
    private String choixNom() {
        System.out.println("Donnez un nom à votre joueur:");
        return scan.nextLine();
    }

    /**
     * donne la difficulté du niveau
     *
     * @return le niveau choisit
     */
    private int choixNiveau(){
        int niveau = 0;
        String ligne;
        do {
            System.out.println("Donnez la difficulté du niveau (1/2):");
            try {
                ligne = scan.nextLine();
                if (ligne.charAt(0) - '0' == 1 || ligne.charAt(0) - '0' == 2)//le niveau est 1 / 2
                    niveau = Integer.parseInt(ligne);
                else
                    System.err.println("la valeur rentrée n'est pas valide");
            } catch (RuntimeException ex) {
                System.err.println("la valeur rentrée n'est pas valide");
                return choixNiveau();
            }
        } while (niveau != 1 && niveau != 2);//on oblige le joueur à choisir un numéro valide
        return niveau;
    }

    /**
     * demande au joueur la couleur de la carte
     *
     * @return La couleur de la carte
     */
    public String choisirCouleur() {
        System.out.println("qu'elle est la couleur de la carte à poser:");
        return scan.nextLine().toUpperCase();
    }

    /**
     * affichage de UNO quand le joueur n'a plus qu'une carte
     */
    public void afficherUno() {
        if (uno.getNbCartes() == 1) System.out.println("\n\033[0;36mUNO\u001B[0m");
    }

    /**
     * affiche le nom du gagnant
     */
    private void affichageFin() {
        System.out.println("\n\033[0;36m" + uno.getNomGagnant() + " a gagné\u001B[0m");
    }
}
