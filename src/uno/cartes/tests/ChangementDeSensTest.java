package uno.cartes.tests;

import org.junit.jupiter.api.Test;
import uno.cartes.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * test de la carte ChangementDeSens
 *
 * @author Diedler Baptiste
 * @version 2022
 */
class ChangementDeSensTest extends CarteTest{

    /**
     * test les fonctions peutEtrePoseeSur
     */
    @Test
    @Override
    public void testPeutEtrePoseeSur() {
        assertTrue(paquetChangementDeSens.getSommet().peutEtrePoseeSur((Plus2) paquetPlus2.getSommet()));
        assertTrue(paquetChangementDeSens.getSommet().peutEtrePoseeSur((PasseTonTour)paquetPasserTonTour.getSommet()));
        paquetPlus4.getSommet().setCouleur(Couleur.VERT);
        assertTrue(paquetChangementDeSens.getSommet().peutEtrePoseeSur((Plus4) paquetPlus4.getSommet()));
        assertTrue(paquetChangementDeSens.getSommet().peutEtrePoseeSur((Chiffre) paquetChiffre.getSommet()));
        paquetJoker.getSommet().setCouleur(Couleur.VERT);
        assertTrue(paquetChangementDeSens.getSommet().peutEtrePoseeSur((Joker) paquetJoker.getSommet()));
    }

    /**
     * test les fonctions peutEtreRecouvertePar
     */
    @Test
    @Override
    public void testPeutEtreRecouvertePar() {
        assertTrue(paquetChangementDeSens.getSommet().peutEtreRecouvertePar(paquetPlus2.getSommet()));
        assertTrue(paquetChangementDeSens.getSommet().peutEtreRecouvertePar(paquetPasserTonTour.getSommet()));
        assertTrue(paquetChangementDeSens.getSommet().peutEtreRecouvertePar(paquetPlus4.getSommet()));
        assertTrue(paquetChangementDeSens.getSommet().peutEtreRecouvertePar(paquetChiffre.getSommet()));
        assertTrue(paquetChangementDeSens.getSommet().peutEtreRecouvertePar(paquetJoker.getSommet()));
    }
}