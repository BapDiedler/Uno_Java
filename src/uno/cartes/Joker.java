package uno.cartes;

import uno.jeu.Uno;

/**
 * Cette classe représente la carte de jeu Joker
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public class Joker extends Carte {


    /**
     * constructeur de la classe Joker
     *
     * @param uno le uno
     */
    public Joker(Uno uno) {
        super(uno);
    }

    /**
     * @return int
     */
    @Override
    public int getValeur() {
        return 50;
    }

    /**
     * @return l'affichage de la carte
     */
    @Override
    public String toString() {
        String val = super.toString();
        return val + "joker ";
    }

    /**
     * fonction qui nous dit si this peut être recouverte par carte
     *
     * @param carte carte qui va être posée
     * @return vrai si les cartes peuvent être superposé
     */
    @Override
    public boolean peutEtreRecouvertePar(Carte carte) {
        return carte.peutEtrePoseeSur(this);
    }

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte Chiffre
     * @return vrai si les cartes peuvent être superposé
     */
    @Override
    public boolean peutEtrePoseeSur(Chiffre carte) {
        return true;
    }

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte Plus2
     * @return vrai si les cartes peuvent être superposé
     */
    @Override
    public boolean peutEtrePoseeSur(Plus2 carte) {
        return true;
    }

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte ChangementDeSens
     * @return vrai si les cartes peuvent être superposé
     */
    @Override
    public boolean peutEtrePoseeSur(ChangementDeSens carte) {
        return true;
    }

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte PasseTonTour
     * @return vrai si les cartes peuvent être superposé
     */
    @Override
    public boolean peutEtrePoseeSur(PasseTonTour carte) {
        return true;
    }

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte Joker
     * @return vrai si les cartes peuvent être superposé
     */
    @Override
    public boolean peutEtrePoseeSur(Joker carte) {
        return true;
    }

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte Plus4
     * @return vrai si les cartes peuvent être superposé
     */
    @Override
    public boolean peutEtrePoseeSur(Plus4 carte) {
        return true;
    }
}
