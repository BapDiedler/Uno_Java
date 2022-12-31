package uno.cartes.tests;

import uno.cartes.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * test de la carte Chiffre
 *
 * @author Diedler Baptiste
 * @version 2022
 */
class ChiffreTest extends CarteTest{


    /**
     * test les fonctions peutEtrePoseeSur
     */
    @Override
    public void testPeutEtrePoseeSur() {
        assertTrue(paquetChiffre.getSommet().peutEtrePoseeSur((Plus2) paquetPlus2.getSommet()));
        assertTrue(paquetChiffre.getSommet().peutEtrePoseeSur((PasseTonTour)paquetPasserTonTour.getSommet()));
        paquetPlus4.getSommet().setCouleur(Couleur.VERT);
        assertTrue(paquetChiffre.getSommet().peutEtrePoseeSur((Plus4) paquetPlus4.getSommet()));
        assertTrue(paquetChiffre.getSommet().peutEtrePoseeSur((ChangementDeSens) paquetChangementDeSens.getSommet()));
        paquetJoker.getSommet().setCouleur(Couleur.VERT);
        assertTrue(paquetChiffre.getSommet().peutEtrePoseeSur((Joker) paquetJoker.getSommet()));
    }

    /**
     * test les fonctions peutEtreRecouvertePar
     */
    @Override
    public void testPeutEtreRecouvertePar() {
        assertTrue(paquetChiffre.getSommet().peutEtreRecouvertePar(paquetPlus2.getSommet()));
        assertTrue(paquetChiffre.getSommet().peutEtreRecouvertePar(paquetPasserTonTour.getSommet()));
        assertTrue(paquetChiffre.getSommet().peutEtreRecouvertePar(paquetPlus4.getSommet()));
        assertTrue(paquetChiffre.getSommet().peutEtreRecouvertePar(paquetChangementDeSens.getSommet()));
        assertTrue(paquetChiffre.getSommet().peutEtreRecouvertePar(paquetJoker.getSommet()));
    }
}