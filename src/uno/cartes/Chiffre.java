package uno.cartes;

import uno.jeu.Uno;

/**
 * Cette classe représente la carte de jeu chiffre
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public class Chiffre extends Carte {
    private final int number;

    /**
     * consturcteur de la classe chiffre
     *
     * @param uno     uno de la carte
     * @param couleur couleur de la carte
     * @param valeur  valeur de la carte
     */
    public Chiffre(Uno uno, Couleur couleur, int valeur) {
        super(uno, couleur);
        this.number = valeur;
    }

    /**
     * getter de la valeur de la carte
     *
     * @return la valeur de la carte
     */
    public int getValeur() {
        return number;
    }

    /**
     * affichage de la carte
     *
     * @return l'affichage de la carte
     */
    public String toString() {
        String val = super.toString();
        return val + number;
    }

    /**
     * la fonction dit si une carte peut recouvrir this
     *
     * @param carte la carte qui veut recouvrir
     * @return true si la carte peut être recouverte
     */
    public boolean peutEtreRecouvertePar(Carte carte) {
        return carte.peutEtrePoseeSur(this);
    }

    /**
     * on regarde si la carte peut être posé
     *
     * @param carte carte sur laquelle on veut la poser
     * @return vrai s'il la carte est disposable
     */
    public boolean peutEtrePoseeSur(Chiffre carte) {
        return carte.number == this.number || this.estDeCouleurCompatibleAvec(carte);
    }

    /**
     * on regarde si la carte peut être posé
     *
     * @param carte carte sur laquelle on veut la poser
     * @return vrai s'il la carte est disposable
     */
    public boolean peutEtrePoseeSur(Plus2 carte) {
        return this.estDeCouleurCompatibleAvec(carte);
    }

    /**
     * on regarde si la carte peut être posé
     *
     * @param carte carte sur laquelle on veut la poser
     * @return vrai s'il la carte est disposable
     */
    public boolean peutEtrePoseeSur(Plus4 carte) {
        return this.estDeCouleurCompatibleAvec(carte);
    }

    /**
     * on regarde si la carte peut être posé
     *
     * @param carte carte sur laquelle on veut la poser
     * @return vrai s'il la carte est disposable
     */
    public boolean peutEtrePoseeSur(Joker carte) {
        return this.estDeCouleurCompatibleAvec(carte);
    }

    /**
     * on regarde si la carte peut être posé
     *
     * @param carte carte sur laquelle on veut la poser
     * @return vrai s'il la carte est disposable
     */
    public boolean peutEtrePoseeSur(ChangementDeSens carte) {
        return this.estDeCouleurCompatibleAvec(carte);
    }

    /**
     * on regarde si la carte peut être posé
     *
     * @param carte carte sur laquelle on veut la poser
     * @return vrai s'il la carte est disposable
     */
    public boolean peutEtrePoseeSur(PasseTonTour carte) {
        return this.estDeCouleurCompatibleAvec(carte);
    }


}
