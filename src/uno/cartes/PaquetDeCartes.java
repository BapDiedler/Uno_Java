package uno.cartes;

import uno.jeu.Uno;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Cette classe représente un paquet de cartes
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public class PaquetDeCartes implements Iterable<Carte> {

    /**
     * structure du paquet de cartes
     */
    private ArrayList<Carte> paquet;

    /**
     * fabrique d'un paquet de carte vide
     */
    public PaquetDeCartes() {
        this.paquet = new ArrayList<>();
    }

    /**
     * constructeur d'un paquet de cartes avec une taille
     *
     * @param size taille du paquet de cartes
     */
    public PaquetDeCartes(int size) {
        this.paquet = new ArrayList<>(size);
    }

    /**
     * fonction qui ajoute un tableau de cartes dans le paquet
     *
     * @param cartes les cartes que l'on ajoute
     */
    public void ajouter(Carte... cartes) {
        for (Carte c : cartes) {
            assert (c != null) : "les uno.cartes doivent être initialisées";
            paquet.add(0, c);
        }
    }

    /**
     * fonction qui ajoute deux paquets de cartes
     *
     * @param pdc paquet que l'on ajoute
     */
    public void ajouter(PaquetDeCartes pdc) {
        assert (pdc != null) : "le paquet de carte doit être initialisé";
        paquet.addAll(pdc.paquet);
    }

    /**
     * getter sur le nombre de cartes d'un paquet
     *
     * @return la taille du paquet de carte
     */
    public int getNombreDeCartes() {
        return paquet.size();
    }

    /**
     * la fonction nous dit si le paquet est vide
     *
     * @return vrai si le paquet est vide
     */
    public boolean estVide() {
        return paquet.isEmpty();
    }

    /**
     * la fonction nous donne la valeur d'un paquet de cartes en fonction de ses cartes
     *
     * @return la valeur du paquet
     */
    public int getValeur() {
        int somme = 0;
        for (Carte c : paquet) {
            somme += c.getValeur();
        }
        return somme;
    }

    /**
     * fonction écrivant un paquet de cartes dans un fichier
     *
     * @param NomDeFichier fichier dans lequel on écrit
     * @throws ErreurFichier si le fichier existe déjà
     */
    public void ecrire(String NomDeFichier) throws ErreurFichier {
        try {
            FileWriter flot = new FileWriter(NomDeFichier);
            BufferedWriter flotFiltre = new BufferedWriter(flot);
            int nbLignes = getNombreDeCartes();//car il y a 108 cartes
            Carte c;
            for (int i = 0; i < nbLignes; i++) {
                c = this.paquet.get(i);
                flotFiltre.write(c.getClass().getSimpleName());
                if (c.getValeur() < 10)//la carte est un chiffre
                    flotFiltre.write(String.valueOf(c.getValeur()));
                if (c.estSansCouleur())//la carte est un joker ou un plus4
                    flotFiltre.write(' ' + c.getCouleur().toString());
                flotFiltre.newLine();
            }
            flotFiltre.close();
        } catch (IOException ex) {//si le fichier existe déjà
            throw new ErreurFichier(ex.getMessage());
        }
    }

    /**
     * la fonction nous donne la carte à un indice donné
     *
     * @param index indice de la carte de 1 à nbCartes
     * @return carte voulut
     */
    public Carte getCarte(int index) {
        return paquet.get(index - 1);
    }

    /**
     * fonction qui passe un string vers une carte
     *
     * @param u   uno comportant la carte
     * @param mot string représentant la carte
     * @return la carte voulut
     */
    public Carte stringToCarte(Uno u, String mot) {
        Carte c;
        Couleur color;//initialisation de color
        switch (mot.charAt(4)) {
            case '2'://plus2
                color = Couleur.estDeCouleur(mot.charAt(6));
                c = new Plus2(u, color);
                break;
            case '4'://plus4
                c = new Plus4(u);
                break;
            case 'r'://joker
                c = new Joker(u);
                break;
            case 'f'://chiffre
                color = Couleur.estDeCouleur(mot.charAt(9));
                int val = Integer.parseInt(String.valueOf(mot.charAt(7)));
                c = new Chiffre(u, color, val);
                break;
            default:
                if (mot.charAt(0) == 'C') {//changement de sens
                    color = Couleur.estDeCouleur(mot.charAt(17));
                    c = new ChangementDeSens(u, color);
                } else {//passe ton tour
                    color = Couleur.estDeCouleur(mot.charAt(13));
                    c = new PasseTonTour(u, color);
                }
                break;
        }
        return c;
    }

    /**
     * la fonction permet de lire dans un fichier afin créer un paquet de carte
     *
     * @param u            uno contenant le paquet
     * @param nomDeFichier fichier qui contient le paquet
     * @throws ErreurFichier si le fichier n'existe pas
     */
    public void lire(Uno u, String nomDeFichier) throws ErreurFichier {
        try {
            FileReader flot = new FileReader(nomDeFichier);
            BufferedReader flotFiltre = new BufferedReader(flot);
            String ligne = flotFiltre.readLine();
            while (ligne != null) {
                paquet.add(stringToCarte(u, ligne));
                ligne = flotFiltre.readLine();///passage à la ligne suivante
            }
            flotFiltre.close();
        } catch (IOException ex) {
            throw new ErreurFichier(ex.getMessage());
        }
    }

    /**
     * affichage d'un paquet de cartes
     *
     * @return le paquet sous forme de String
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (Carte carte : paquet) {
            builder.append(++i);
            builder.append(":  ");
            builder.append(carte);
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * la fonction mélange le paquet de cartes
     */
    public void melanger() {
        Random rand = new Random();
        int ind;
        ArrayList<Carte> newPaquet = new ArrayList<>();
        while (!paquet.isEmpty()) {
            ind = rand.nextInt(paquet.size());
            newPaquet.add(paquet.get(ind));
            paquet.remove(paquet.get(ind));
        }
        paquet = newPaquet;
    }

    /**
     * la fonction retourne le paquet de cartes
     */
    public void retourner() {
        ArrayList<Carte> newPaquet = new ArrayList<>();
        for (int i = paquet.size() - 1; i >= 0; i--) {
            newPaquet.add(paquet.get(i));
            paquet.remove(i);
        }
        paquet = newPaquet;
    }

    /**
     * la fonction retire la carte du paquet
     *
     * @param c carte à retirer
     */
    public void retirerCarte(Carte c) {
        paquet.remove(c);
    }

    /**
     * la fonction nous permet de voir le sommet du paquet
     *
     * @return la première carte du paquet
     */
    public Carte getSommet() {
        return paquet.get(0);
    }

    /**
     * la fonction rend itérable la classe
     *
     * @return un iterator su rle paquet de cartes
     */
    public Iterator<Carte> iterator() {
        return paquet.iterator();
    }

    /**
     * la fonction permet de tirer la première carte du paquet de cartes
     *
     * @return la carte du sommet
     */
    public Carte piocher() {
        assert (!paquet.isEmpty()) : "le paquet ne doit pas être vide";
        return paquet.remove(0);
    }
}
