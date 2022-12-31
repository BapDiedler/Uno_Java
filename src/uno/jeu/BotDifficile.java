package uno.jeu;

import uno.cartes.Carte;
import uno.cartes.Couleur;
import java.util.HashMap;
import java.util.Map;

/**
 * Cette classe représente le bot difficile. Il choisit la couleur de la carte quand il doit le faire
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public class BotDifficile extends Bot{

    public BotDifficile(String nom, Uno u) {
        super(nom, u);
    }

    /**
     * @brief fonction qui permet au bot de choisir sa couleur en fonction du nombre de cartes qu'il a dans la main
     * @param c est la carte dont la couleur va être choisi
     */
    protected void choixCouleur(Carte c){
        if(c.estSansCouleur()) {
            Map<Couleur, Integer> map = new HashMap<>();
            for (Couleur color : Couleur.values()) {//initialisation de la map
                map.put(color, 0);
            }
            for (Carte carte : main) {//on compte les cartes en fonction de couleurs
                map.computeIfPresent(carte.getCouleur(), (k, v) -> v + 1);
            }
            Couleur maxColor = null;
            for (Couleur color : map.keySet()) {//on regarde la valeur max
                if (maxColor == null || map.get(color) > map.get(maxColor)) {
                    maxColor = color;
                }
            }
            assert maxColor != null;
            if(maxColor.equals(Couleur.NOIR))
                c.setCouleur(Couleur.ROUGE);//on pose la couleur
            else
                c.setCouleur(maxColor);
        }
    }
}
