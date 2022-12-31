package uno.cartes;

import uno.jeu.Uno;

/**
 * Cette classe représente la carte de jeu Passer son tour
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public class PasseTonTour extends Carte {

    /**
     * constructeur de la classe PasseTonTour
     *
     * @param uno     le uno
     * @param couleur la couleur de la carte
     */
    public PasseTonTour(Uno uno, Couleur couleur) {
        super(uno, couleur);
    }

    @Override
    public int getValeur() {
        return 20;
    }

    /**
     * applique les effets d'une carte sur le jeu
     */
    @Override
    public void appliquerEffet() {
        uno.passerJoueur();
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
        return this.estDeCouleurCompatibleAvec(carte);
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
     * @param carte Plus2
     * @return vrai si les cartes peuvent être superposé
     */
    @Override
    public boolean peutEtrePoseeSur(Plus2 carte) {
        return this.estDeCouleurCompatibleAvec(carte);
    }

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte ChangementDeSens
     * @return vrai si les cartes peuvent être superposé
     */
    @Override
    public boolean peutEtrePoseeSur(ChangementDeSens carte) {
        return this.estDeCouleurCompatibleAvec(carte);
    }

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte Plus4
     * @return vrai si les cartes peuvent être superposé
     */
    @Override
    public boolean peutEtrePoseeSur(Plus4 carte) {
        return this.estDeCouleurCompatibleAvec(carte);
    }

    /**
     * fonction qui nous dit si this peut être posée sur carte
     *
     * @param carte Joker
     * @return vrai si les cartes peuvent être superposé
     */
    @Override
    public boolean peutEtrePoseeSur(Joker carte) {
        return this.estDeCouleurCompatibleAvec(carte);
    }

    /**
     * @return l'affichage de la carte
     */
    @Override
    public String toString() {
        return super.toString() + "Passe ";
    }
}
