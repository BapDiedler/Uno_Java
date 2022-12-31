package uno.jeu.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.jeu.Uno;

import static org.junit.jupiter.api.Assertions.*;

class UnoTest{

    private Uno uno;

    @BeforeEach
    void setUp() {
        uno = Uno.initialisation(2,"",1);
    }

    @Test
    void changementDeSens() {
        assertTrue(uno.getSens());
        uno.changementDeSens();
        assertFalse(uno.getSens());
    }

    @Test
    void passerJoueur() {
        int tmp = uno.getIndexJoueurCourant();
        uno.passerJoueur();
        assertTrue(tmp != uno.getIndexJoueurCourant());
    }

    @Test
    void piocherCarte() {
        uno.piocherCarte(2);
        assertEquals(9, uno.getNbCartes((uno.getIndexJoueurCourant() + 1) % uno.nbJoueurs()));
    }
}