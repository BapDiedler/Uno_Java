package uno.cartes;

import uno.jeu.Uno;

/**
 * Cette classe représente de façon abstraite une carte de jeu d'uno
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public abstract class Carte {
    /**
     * couleur de la carte
     */
    protected Couleur couleur;
    /**
     * uno dans lequel se trouve la carte
     */
    protected final Uno uno;

    /**
     * constructeur de la classe carte
     *
     * @param uno     uno dans lequel se trouve la carte
     * @param couleur couleur de la carte
     */
    public Carte(Uno uno, Couleur couleur) {
        this.uno = uno;
        this.couleur = couleur;
    }

    /**
     * constructeur pour les cartes sans couleur la couleur de la carte par défaut est noir
     *
     * @param uno uno dans lequel se trouve la carte
     */
    public Carte(Uno uno) {
        this(uno, Couleur.NOIR);
    }

    /**
     * @return la valeur de la carte
     */
    public abstract int getValeur();


    /**
     * @return la couleur de la carte
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * fonction qui change la couleur de la carte
     *
     * @param couleur couleur que va prendre la carte
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * applique les effets d'une carte sur le jeu
     */
    public void appliquerEffet() {}

    /**
     * @return l'affichage de la carte
     */
    public String toString() {
        return couleur + " ";
    }

    /**
     * fonction qui nous dit si la carte possède une couleur
     *
     * @return vrai si la carte est sans couleur
     */
    public boolean estSansCouleur() {
        return couleur.getNom().equals("Noir");
    }

    /**
     * fonction qui nous dit si les cartes ont les mêmes couleurs
     *
     * @param carte carte que l'on compare avec this
     * @return vrai si la couleur est la même
     */
    public boolean estDeCouleurCompatibleAvec(Carte carte) {
        return couleur == carte.couleur;
    }

    /**
     * fonction qui nous dit si this peut être recouverte par carte
     *
     * @param carte carte que l'on veut poser
     * @return vrai si les cartes peuvent être superposé
     */
    public abstract boolean peutEtreRecouvertePar(Carte carte);

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte Chiffre
     * @return vrai si les cartes peuvent être superposé
     */
    public abstract boolean peutEtrePoseeSur(Chiffre carte);

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte Plus2
     * @return vrai si les cartes peuvent être superposé
     */
    public abstract boolean peutEtrePoseeSur(Plus2 carte);

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte Plus4
     * @return vrai si les cartes peuvent être superposé
     */
    public abstract boolean peutEtrePoseeSur(Plus4 carte);

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte Joker
     * @return vrai si les cartes peuvent être superposé
     */
    public abstract boolean peutEtrePoseeSur(Joker carte);

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte ChangementDeSens
     * @return vrai si les cartes peuvent être superposé
     */
    public abstract boolean peutEtrePoseeSur(ChangementDeSens carte);

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte PasseTonTour
     * @return vrai si les cartes peuvent être superposé
     */
    public abstract boolean peutEtrePoseeSur(PasseTonTour carte);
}