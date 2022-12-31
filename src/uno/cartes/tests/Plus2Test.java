package uno.cartes.tests;

import org.junit.jupiter.api.Test;
import uno.cartes.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * test de la carte Plus2
 *
 * @author Diedler Baptiste
 * @version 2022
 */
class Plus2Test extends CarteTest{


    /**
     * test les fonctions peutEtrePoseeSur
     */
    @Test
    @Override
    public void testPeutEtrePoseeSur() {
        assertTrue(paquetPlus2.getSommet().peutEtrePoseeSur((Chiffre) paquetChiffre.getSommet()));
        assertTrue(paquetPlus2.getSommet().peutEtrePoseeSur((PasseTonTour)paquetPasserTonTour.getSommet()));
        paquetPlus4.getSommet().setCouleur(Couleur.VERT);
        assertTrue(paquetPlus2.getSommet().peutEtrePoseeSur((Plus4) paquetPlus4.getSommet()));
        assertTrue(paquetPlus2.getSommet().peutEtrePoseeSur((ChangementDeSens) paquetChangementDeSens.getSommet()));
        paquetJoker.getSommet().setCouleur(Couleur.VERT);
        assertTrue(paquetPlus2.getSommet().peutEtrePoseeSur((Joker) paquetJoker.getSommet()));
    }

    /**
     * test les fonctions peutEtreRecouvertePar
     */
    @Test
    @Override
    public void testPeutEtreRecouvertePar() {
        assertTrue(paquetPlus2.getSommet().peutEtreRecouvertePar(paquetChiffre.getSommet()));
        assertTrue(paquetPlus2.getSommet().peutEtreRecouvertePar(paquetPasserTonTour.getSommet()));
        assertTrue(paquetPlus2.getSommet().peutEtreRecouvertePar(paquetPlus4.getSommet()));
        assertTrue(paquetPlus2.getSommet().peutEtreRecouvertePar(paquetChangementDeSens.getSommet()));
        assertTrue(paquetPlus2.getSommet().peutEtreRecouvertePar(paquetJoker.getSommet()));
    }
}