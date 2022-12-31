package uno.jeu;

import uno.cartes.Carte;
import java.util.Iterator;

/**
 * Cette classe représente les bots du jeu
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public abstract class Bot extends Joueur {

    /**
     * constructeur de la classe abstraite Bot
     *
     * @param nom nom du bot dans le jeu
     * @param u   partie dans laquelle se trouve le bot
     */
    public Bot(String nom, Uno u) {
        super(nom, u);
    }

    /**
     * la fonction nous permet de savoir si le joueur est humain
     *
     * @return faux le bot n'est pas humain
     */
    public boolean estHumain() {
        return false;
    }

    /**
     * fonction abstraite qui permet au bot de choisir sa couleur de carte
     *
     * @param carte carte qui change de couleur
     */
    protected abstract void choixCouleur(Carte carte);

    /**
     * fonction qui fait joueur le joueur
     *
     * @param coup que le joueur joue
     */
    @Override
    public void jouer(String coup) {
        Iterator<Carte> iterator = main.iterator();
        Carte carte;
        boolean peutPoser = false;
        while (!peutPoser && iterator.hasNext()) {//la carte n'est pas posée tant que le joueur n'a pas de carte à poser
            carte = iterator.next();
            if (peutEtrePosee(carte)) {
                peutPoser = true;
                main.retirerCarte(carte);
                choixCouleur(carte);
                uno.ajouterTalon(carte);//on retire la carte de la main du joueur
            }
        }
        if (!peutPoser) {//le bot pioche une carte
            Carte piocher = uno.piocher();
            if (peutEtrePosee(piocher)) {
                choixCouleur(piocher);//la carte piochée peut être posée
                uno.ajouterTalon(piocher);
            } else {
                main.ajouter(piocher);
            }
        }
    }
}
