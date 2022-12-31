package uno.cartes.tests;

import org.junit.jupiter.api.Test;
import uno.cartes.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * test de la carte Plus4
 *
 * @author Diedler Baptiste
 * @version 2022
 */
class Plus4Test extends CarteTest{

    /**
     * test les fonctions peutEtrePoseeSur
     */
    @Test
    public void testPeutEtrePoseeSur(){
        assertTrue(paquetPlus4.getSommet().peutEtrePoseeSur((Plus2) paquetPlus2.getSommet()));
        assertTrue(paquetPlus4.getSommet().peutEtrePoseeSur((PasseTonTour)paquetPasserTonTour.getSommet()));
        assertTrue(paquetPlus4.getSommet().peutEtrePoseeSur((Joker) paquetJoker.getSommet()));
        assertTrue(paquetPlus4.getSommet().peutEtrePoseeSur((Chiffre) paquetChiffre.getSommet()));
        assertTrue(paquetPlus4.getSommet().peutEtrePoseeSur((ChangementDeSens) paquetChangementDeSens.getSommet()));
    }

    /**
     * test les fonctions peutEtrePoseeSur
     */
    @Test
    public void testPeutEtreRecouvertePar(){
        paquetPlus4.getSommet().setCouleur(Couleur.VERT);
        assertTrue(paquetPlus4.getSommet().peutEtreRecouvertePar(paquetPlus2.getSommet()));
        assertTrue(paquetPlus4.getSommet().peutEtreRecouvertePar(paquetPasserTonTour.getSommet()));
        assertTrue(paquetPlus4.getSommet().peutEtreRecouvertePar(paquetJoker.getSommet()));
        assertTrue(paquetPlus4.getSommet().peutEtreRecouvertePar(paquetChiffre.getSommet()));
        assertTrue(paquetPlus4.getSommet().peutEtreRecouvertePar(paquetChangementDeSens.getSommet()));
    }
}
