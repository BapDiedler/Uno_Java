package uno.jeu;

import uno.cartes.Carte;
import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;

/**
 * Cette classe représente un joueur de la partie de Uno
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public abstract class Joueur {

    protected final Uno uno;
    protected final String nom;
    protected final PaquetDeCartes main;

    /**
     * constructeur de la classe joueur
     *
     * @param nom du joueur
     * @param u   uno dans lequel le joueur joue
     */
    public Joueur(String nom, Uno u) {
        uno = u;
        this.nom = nom;
        this.main = FabriqueCartes.getInstance().getPaquetVide();
    }

    /**
     * on regarde si la carte peut-être posée
     *
     * @param c carte à poser
     * @return vrai si la carte peut-être posée
     */
    protected boolean peutEtrePosee(Carte c) {
        Carte sommetTalon = uno.sommetTalon();//on pose la carte sur le sommet talon
        return sommetTalon.peutEtreRecouvertePar(c);
    }

    /**
     * fonction qui fait joueur le joueur
     *
     * @param coup que le joueur joue
     */
    public abstract void jouer(String coup);

    /**
     * ajoute une carte dans la main du joueur
     *
     * @param c carte ajoutée
     */
    public void ajouter(Carte c) {
        main.ajouter(c);
    }

    /**
     * dit si le joueur est humain
     *
     * @return vrai si le joueur est humain
     */
    public abstract boolean estHumain();

    /**
     * getter du nom du joueur
     *
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * getter du nombre de cartes du joueur
     *
     * @return le nombre de cartes
     */
    public int nbCartes() {
        return main.getNombreDeCartes();
    }

    /**
     * getter de la main du joueur
     *
     * @return la main du joueur
     */
    public PaquetDeCartes getMain() {
        return main;
    }
}
