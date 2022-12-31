package uno.cartes.tests;

import uno.cartes.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * test de la carte PasseTonTour
 *
 * @author Diedler Baptiste
 * @version 2022
 */
class PasseTonTourTest extends CarteTest{


    /**
     * test les fonctions peutEtrePoseeSur
     */
    @Override
    public void testPeutEtrePoseeSur() {
        assertTrue(paquetPasserTonTour.getSommet().peutEtrePoseeSur((Plus2) paquetPlus2.getSommet()));
        assertTrue(paquetPasserTonTour.getSommet().peutEtrePoseeSur((Chiffre)paquetChiffre.getSommet()));
        paquetPlus4.getSommet().setCouleur(Couleur.VERT);
        assertTrue(paquetPasserTonTour.getSommet().peutEtrePoseeSur((Plus4) paquetPlus4.getSommet()));
        assertTrue(paquetPasserTonTour.getSommet().peutEtrePoseeSur((Chiffre) paquetChangementDeSens.getSommet()));
        paquetJoker.getSommet().setCouleur(Couleur.VERT);
        assertTrue(paquetPasserTonTour.getSommet().peutEtrePoseeSur((Joker) paquetJoker.getSommet()));
    }

    /**
     * test les fonctions peutEtreRecouvertePar
     */
    @Override
    public void testPeutEtreRecouvertePar() {
        assertTrue(paquetPasserTonTour.getSommet().peutEtreRecouvertePar(paquetPlus2.getSommet()));
        assertTrue(paquetPasserTonTour.getSommet().peutEtreRecouvertePar(paquetChiffre.getSommet()));
        assertTrue(paquetPasserTonTour.getSommet().peutEtreRecouvertePar(paquetPlus4.getSommet()));
        assertTrue(paquetPasserTonTour.getSommet().peutEtreRecouvertePar(paquetChangementDeSens.getSommet()));
        assertTrue(paquetPasserTonTour.getSommet().peutEtreRecouvertePar(paquetJoker.getSommet()));
    }
}