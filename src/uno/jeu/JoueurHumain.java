package uno.jeu;

import uno.cartes.Carte;
import uno.cartes.Couleur;

import static uno.cartes.Couleur.estDeCouleur;

/**
 * Cette classe représente un joueur humain de la partie de Uno
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public class JoueurHumain extends Joueur {

    /**
     * constructeur du joueur humain
     *
     * @param nom nom du joueur
     * @param u   partie dans laquelle il joue
     */
    public JoueurHumain(String nom, Uno u) {
        super(nom, u);
    }

    /**
     * passage d'un string vers une carte
     *
     * @param coup carte que le joueur veut
     * @return la carte choisit
     * @throws CoupIncorrect si la carte n'existe pas
     */
    private Carte stringToCarte(String coup) throws CoupIncorrect {
        Carte c;
        try {
            if (coup.charAt(coup.length() - 1) >= '0' && coup.charAt(coup.length() - 1) <= '9') {
                int carte = Integer.parseInt(coup);
                c = main.getCarte(carte);
            } else {
                StringBuilder build = new StringBuilder(coup);
                coup = build.deleteCharAt(coup.length() - 1).toString();
                int carte = Integer.parseInt(coup);
                c = main.getCarte(carte);
            }
        } catch (RuntimeException ex) {//le coup ne correspond pas à une carte
            throw new CoupIncorrect("la carte jouée n'existe pas");
        }
        return c;
    }

    /**
     * la fonction renvoie la carte choisit par le joueur
     *
     * @param coup coup joué par le joueur
     * @return la carte choisit par le joueur
     * @throws CoupIncorrect La carte n'existe pas. L'exception vient de stringToCarte()
     */
    private Carte carteChoisie(String coup) throws CoupIncorrect {
        Carte choix;
        try {
            choix = this.stringToCarte(coup);
        }catch (CoupIncorrect ex){
            throw new CoupIncorrect(ex.getMessage());
        }
        if (choix != null) {
            for (Carte carte : main) {//on regarde si la carte se trouve dans la main du joueur
                if (choix.equals(carte)) {
                    return choix;
                }
            }
        }
       return null;//la carte n'est pas dans la main
    }

    /**
     * la fonction nous dit si le joueur est humain
     *
     * @return vrai le joueur est humain
     */
    @Override
    public boolean estHumain() {
        return true;
    }

    /**
     * la fonction nous dit si la carte peut être posée
     *
     * @param c carte à poser
     * @return vrai si la carte est jouable
     */
    @Override
    protected boolean peutEtrePosee(Carte c) {
        return super.peutEtrePosee(c);
    }

    /**
     * fonction qui fait piocher le joueur
     */
    private void jouerPioche() throws CoupIncorrect{
        Carte pioche = uno.piocher();
        String couleur;
        if (peutEtrePosee(pioche)) {
            if (pioche.estSansCouleur()) {
                couleur = uno.choixCouleur();
                poseCouleur(pioche, couleur.charAt(0));
                if (pioche.estSansCouleur()) {
                    uno.ajouterPioche(pioche);
                    throw new CoupIncorrect("la couleur n'existe pas");
                }
            }
            uno.ajouterTalon(pioche);
        } else main.ajouter(pioche);
    }

    /**
     * fonction qui pose une couleur sur une carte
     *
     * @param pioche carte qui va changer de couleur
     * @param val    couleur que l'on donne à la carte
     */
    private void poseCouleur(Carte pioche, char val) {
        Couleur color = estDeCouleur(val);
        pioche.setCouleur(color);
    }

    /**
     * fonction qui fait joueur le joueur
     *
     * @param coup que le joueur joue
     * @throws CoupIncorrect si la carte n'existe pas
            ou que la couleur n'est pas la bonne
            ou la carte ne peut pas être posée
     */
    @Override
    public void jouer(String coup) throws CoupIncorrect {
        if ("P".equals(coup)) {//le joueur pioche une carte
            try {
                jouerPioche();
            }catch (CoupIncorrect ex){
                throw new CoupIncorrect(ex.getMessage());
            }
        } else {//le joueur choisit une carte
            Carte choix = carteChoisie(coup);
            if (choix != null && peutEtrePosee(choix)) {
                char color = coup.charAt(coup.length() - 1);
                if (choix.estSansCouleur()) {
                    int i = coup.charAt(coup.length() - 1) - '0';//on regarde si le dernier caractère un chiffre
                    if (i >= 0 && i <= 9) {
                        System.err.println("la carte doit être posé avec une couleur");
                        color = uno.choixCouleur().charAt(0);
                    }
                    poseCouleur(choix, color);
                    if (choix.estSansCouleur()) {//la couleur rentrée n'est pas valide
                        throw new CoupIncorrect("la couleur de la carte n'est pas valide");
                    }
                }
                main.retirerCarte(choix);
                uno.ajouterTalon(choix);
            } else {//la carte ne peut pas être posée ou la carte n'existe pas
                throw new CoupIncorrect("la carte ne peut pas être posée sur le talon");
            }
        }
    }
}