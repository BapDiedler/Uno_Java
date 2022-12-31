package uno.cartes.tests;

import org.junit.jupiter.api.Test;
import uno.cartes.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * test de la carte joker
 *
 * @author Diedler Baptiste
 * @version 2022
 */
class JokerTest extends CarteTest{

    /**
     * test les fonctions peutEtrePoseeSur
     */
    @Test
    public void testPeutEtrePoseeSur(){
        assertTrue(paquetJoker.getSommet().peutEtrePoseeSur((Plus2) paquetPlus2.getSommet()));
        assertTrue(paquetJoker.getSommet().peutEtrePoseeSur((PasseTonTour)paquetPasserTonTour.getSommet()));
        assertTrue(paquetJoker.getSommet().peutEtrePoseeSur((Plus4) paquetPlus4.getSommet()));
        assertTrue(paquetJoker.getSommet().peutEtrePoseeSur((Chiffre) paquetChiffre.getSommet()));
        assertTrue(paquetJoker.getSommet().peutEtrePoseeSur((ChangementDeSens) paquetChangementDeSens.getSommet()));
    }

    /**
     * test les fonctions peutEtrePoseeSur
     */
    @Test
    public void testPeutEtreRecouvertePar(){
        paquetJoker.getSommet().setCouleur(Couleur.VERT);
        assertTrue(paquetJoker.getSommet().peutEtreRecouvertePar(paquetPlus2.getSommet()));
        assertTrue(paquetJoker.getSommet().peutEtreRecouvertePar(paquetPasserTonTour.getSommet()));
        assertTrue(paquetJoker.getSommet().peutEtreRecouvertePar(paquetPlus4.getSommet()));
        assertTrue(paquetJoker.getSommet().peutEtreRecouvertePar(paquetChiffre.getSommet()));
        assertTrue(paquetJoker.getSommet().peutEtreRecouvertePar(paquetChangementDeSens.getSommet()));
    }
}