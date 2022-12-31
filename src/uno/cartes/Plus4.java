package uno.cartes;

import uno.jeu.Uno;

/**
 * Cette classe représente la carte de jeu Plus4
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public class Plus4 extends Carte {

    /**
     * constructeur de la classe Plus4
     *
     * @param uno le uno
     */
    public Plus4(Uno uno) {
        super(uno);
    }

    /**
     * fonction qui nous donne la valeur de la carte
     *
     * @return int
     */
    @Override
    public int getValeur() {
        return 50;
    }

    /**
     * applique les effets d'une carte sur le jeu
     */
    @Override
    public void appliquerEffet() {
        uno.passerJoueur();
        uno.piocherCarte(4);
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
     * @param carte Plus4
     * @return vrai si les cartes peuvent être superposé
     */
    @Override
    public boolean peutEtrePoseeSur(Plus4 carte) {
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
     * @return l'affichage de la carte
     */
    @Override
    public String toString() {
        String val = super.toString();
        return val + "+4 ";
    }
}
