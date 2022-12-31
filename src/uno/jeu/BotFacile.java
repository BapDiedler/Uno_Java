package uno.jeu;

import uno.cartes.Carte;
import uno.cartes.Couleur;
import java.util.Random;

/**
 * Cette classe représente le bot difficile. La couleur de la carte est choisie aléatoirement
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public class BotFacile extends Bot {

    /**
     * constructeur du bot
     *
     * @param nom nom du bot
     * @param u   partie du bot
     */
    public BotFacile(String nom, Uno u) {
        super(nom, u);
    }

    /**
     * fonction qui fait choisir la couleur au bot
     *
     * @param c carte qui change de couleur
     */
    protected void choixCouleur(Carte c) {
        if (c.estSansCouleur()) {//si la carte est un joker ou un plus4
            int col = new Random().nextInt(3);//choix de la couleur est aléatoire
            c.setCouleur(Couleur.values()[col]);
        }
    }
}
