package uno.cartes.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;
import uno.jeu.Uno;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test des cartes du jeu de Uno
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public abstract class CarteTest {

    Uno uno;
    PaquetDeCartes paquetJoker;
    PaquetDeCartes paquetPasserTonTour;
    PaquetDeCartes paquetPlus2;
    PaquetDeCartes paquetPlus4;
    PaquetDeCartes paquetChangementDeSens;
    PaquetDeCartes paquetChiffre;

    @BeforeEach
    void setUp() {
        uno = Uno.initialisation(2, "", 1);
        paquetPasserTonTour = FabriqueCartes.getInstance().getPaquet1VertPasseTonTour(uno);
        paquetJoker = FabriqueCartes.getInstance().getPaquet1Joker(uno);
        paquetPlus4 = FabriqueCartes.getInstance().getPaquet1Plus4(uno);
        paquetPlus2 = FabriqueCartes.getInstance().getPaquet1VertPlus2(uno);
        paquetChangementDeSens = FabriqueCartes.getInstance().getPaquet1VertChangementDeSens(uno);
        paquetChiffre = FabriqueCartes.getInstance().getPaquet1VertChiffre(uno);
    }

    /**
     * test les fonctions peutEtrePoseeSur
     */
    @Test
    public abstract void testPeutEtrePoseeSur();

    /**
     * test les fonctions peutEtreRecouvertePar
     */
    @Test
    public abstract void testPeutEtreRecouvertePar();

    /**
     * test de la fonction est sans couleur
     */
    @Test
    public void testEstSansCouleur() {
        assertTrue(paquetJoker.getSommet().estSansCouleur());
        assertTrue(paquetPlus4.getSommet().estSansCouleur());
        assertFalse(paquetChiffre.getSommet().estSansCouleur());
        assertFalse(paquetChangementDeSens.getSommet().estSansCouleur());
        assertFalse(paquetPlus2.getSommet().estSansCouleur());
        assertFalse(paquetPasserTonTour.getSommet().estSansCouleur());
    }

    /**
     * test de la fonction est de couleur compatible
     */
    @Test
    public void testEstDeCouleurCompatible(){
        assertTrue(paquetPasserTonTour.getSommet().estDeCouleurCompatibleAvec(paquetPlus2.getSommet()));
        assertFalse(paquetChiffre.getSommet().estDeCouleurCompatibleAvec(paquetPlus4.getSommet()));
    }
}