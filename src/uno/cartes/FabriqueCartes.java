package uno.cartes;

import uno.jeu.Uno;

/**
 * Cette classe est une fabrique de paquet de cartes pour faire des tests ou même un jeu d'uno
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public class FabriqueCartes {

    private static final FabriqueCartes instance = new FabriqueCartes();
    private PaquetDeCartes paquet;

    public static FabriqueCartes getInstance() {
        return instance;
    }

    /**
     * constructeur de la fabrique
     */
    private FabriqueCartes() {
        this.paquet = new PaquetDeCartes();
    }

    /**
     * création d'un paquet de cartes d'uno
     *
     * @return le paquet de Cartes d'uno
     */
    public PaquetDeCartes getPaquetUno(Uno u) {
        this.paquet = new PaquetDeCartes(108);
        Carte c;
        for (Couleur couleur : Couleur.values()) {
            if (!couleur.equals(Couleur.NOIR)) {
                c = new Chiffre(u, couleur, 0);//ajout des chiffres
                paquet.ajouter(c);
                c = new Joker(u);//ajout d'une carte joker
                paquet.ajouter(c);
                c = new Plus4(u);//ajout d'une carte plus4
                paquet.ajouter(c);
                for (int k = 0; k < 2; k++) {
                    for (int i = 0; i < 9; i++) {
                        c = new Chiffre(u, couleur, i + 1);
                        paquet.ajouter(c);// ajout d'une carte chiffre
                    }
                    c = new PasseTonTour(u, couleur);
                    paquet.ajouter(c);//ajout de passeTonTour
                    c = new ChangementDeSens(u, couleur);
                    paquet.ajouter(c);//ajout de ChangementDeSens
                    c = new Plus2(u, couleur);
                    paquet.ajouter(c);//ajout de Plus2
                }
            }
        }
        return paquet;
    }

    /**
     * constructeur vide
     *
     * @return un paquet de Carte vide
     */
    public PaquetDeCartes getPaquetVide() {
        paquet = new PaquetDeCartes(108);
        return paquet;
    }

    /**
     * paquet de carte avec un chiffre vert
     *
     * @param u le jeu de Uno
     * @return un paquet d'une carte chiffre Verte
     */
    public PaquetDeCartes getPaquet1VertChiffre(Uno u) {
        paquet = new PaquetDeCartes();
        Carte carte = new Chiffre(u, Couleur.VERT, 2);
        paquet.ajouter(carte);
        return paquet;
    }

    /**
     * paquet de cartes avec un changement de sens vert
     *
     * @param u le jeu de Uno
     * @return le paquet de carte
     */
    public PaquetDeCartes getPaquet1VertChangementDeSens(Uno u) {
        paquet = new PaquetDeCartes();
        Carte carte = new ChangementDeSens(u, Couleur.VERT);
        paquet.ajouter(carte);
        return paquet;
    }

    /**
     * paquet de cartes avec un plus2
     *
     * @param u le jeu de Uno
     * @return le paquet de carte
     */
    public PaquetDeCartes getPaquet1VertPlus2(Uno u) {
        paquet = new PaquetDeCartes();
        Carte carte = new Plus2(u, Couleur.VERT);
        paquet.ajouter(carte);
        return paquet;
    }

    /**
     * paquet de cartes avec un plus4
     *
     * @param u le jeu de Uno
     * @return le paquet de carte
     */
    public PaquetDeCartes getPaquet1Plus4(Uno u) {
        paquet = new PaquetDeCartes();
        Carte carte = new Plus4(u);
        paquet.ajouter(carte);
        return paquet;
    }

    /**
     * paquet de cartes avec un joker
     *
     * @param u le jeu de Uno
     * @return le paquet de carte
     */
    public PaquetDeCartes getPaquet1Joker(Uno u) {
        paquet = new PaquetDeCartes();
        Carte carte = new Joker(u);
        paquet.ajouter(carte);
        return paquet;
    }

    /**
     * paquet de cartes avec un passe ton tour
     *
     * @param u le jeu de Uno
     * @return le paquet de carte
     */
    public PaquetDeCartes getPaquet1VertPasseTonTour(Uno u) {
        paquet = new PaquetDeCartes();
        Carte carte = new PasseTonTour(u, Couleur.VERT);
        paquet.ajouter(carte);
        return paquet;
    }

    /**
     * création d'un paquet de 5 chiffres
     *
     * @param u le jeu de Uno
     * @return le paquet de carte
     */
    public PaquetDeCartes getPaquet5Chiffres(Uno u) {
        paquet = new PaquetDeCartes();
        Carte carte1 = new Chiffre(u, Couleur.BLEU, 2);
        Carte carte2 = new Chiffre(u, Couleur.VERT, 3);
        Carte carte3 = new Chiffre(u, Couleur.BLEU, 2);
        Carte carte4 = new Chiffre(u, Couleur.BLEU, 3);
        Carte carte5 = new Chiffre(u, Couleur.VERT, 2);
        paquet.ajouter(carte1, carte2, carte3, carte4, carte5);
        return paquet;
    }

    /**
     * création d'un paquet de 5 changements de sens
     *
     * @param u le jeu de Uno
     * @return le paquet de carte
     */
    public PaquetDeCartes getPaquet5ChangementDeSens(Uno u) {
        paquet = new PaquetDeCartes();
        Carte carte1 = new ChangementDeSens(u, Couleur.BLEU);
        Carte carte2 = new ChangementDeSens(u, Couleur.VERT);
        Carte carte3 = new ChangementDeSens(u, Couleur.BLEU);
        Carte carte4 = new ChangementDeSens(u, Couleur.BLEU);
        Carte carte5 = new ChangementDeSens(u, Couleur.VERT);
        paquet.ajouter(carte1, carte2, carte3, carte4, carte5);
        return paquet;
    }

    /**
     * création d'un paquet de 5 plus2
     *
     * @param u le jeu de Uno
     * @return le paquet de carte
     */
    public PaquetDeCartes getPaquet5Plus2(Uno u) {
        paquet = new PaquetDeCartes();
        Carte carte1 = new Plus2(u, Couleur.BLEU);
        Carte carte2 = new Plus2(u, Couleur.VERT);
        Carte carte3 = new Plus2(u, Couleur.VERT);
        Carte carte4 = new Plus2(u, Couleur.BLEU);
        Carte carte5 = new Plus2(u, Couleur.VERT);
        paquet.ajouter(carte1, carte2, carte3, carte4, carte5);
        return paquet;
    }

    /**
     * création d'un paquet de 5 passe ton tour
     *
     * @param u le jeu de Uno
     * @return le paquet de carte
     */
    public PaquetDeCartes getPaquet5PasseTonTour(Uno u) {
        paquet = new PaquetDeCartes();
        Carte carte1 = new PasseTonTour(u, Couleur.BLEU);
        Carte carte2 = new PasseTonTour(u, Couleur.VERT);
        Carte carte3 = new PasseTonTour(u, Couleur.VERT);
        Carte carte4 = new PasseTonTour(u, Couleur.BLEU);
        Carte carte5 = new PasseTonTour(u, Couleur.VERT);
        paquet.ajouter(carte1, carte2, carte3, carte4, carte5);
        return paquet;
    }
}
