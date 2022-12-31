package uno.cartes.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.cartes.*;
import uno.jeu.Uno;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test de la classe paquet de cartes
 */
public class TestPaquetDeCarte {

    private Uno uno;

    @BeforeEach
    void setUp() {
        uno = null;
    }

    @Test
    void testAjouter(){
        PaquetDeCartes paquet = FabriqueCartes.getInstance().getPaquetVide();
        PaquetDeCartes p = FabriqueCartes.getInstance().getPaquet5Plus2(uno);
        paquet.ajouter(p.piocher());
        System.out.println(paquet.getSommet());
        assertNotNull(paquet.getSommet());
        assertNotNull(paquet.getSommet());
    }

    @Test
    void TestPaquet(){
        PaquetDeCartes paquet = FabriqueCartes.getInstance().getPaquetUno(uno);
        assertEquals(1240, paquet.getValeur());
    }

    @Test
    void TestPaquetFichierEcrire(){
        PaquetDeCartes paquet = FabriqueCartes.getInstance().getPaquetUno(uno);
        paquet.ecrire("Paquet.txt");
    }

    @Test
    void TestFichierLire(){
        PaquetDeCartes paquet = FabriqueCartes.getInstance().getPaquetVide();
        paquet.lire(uno,"Paquet.txt");
        int size = paquet.getNombreDeCartes();
        for(int i=0; i< size; i++){
            System.out.println(paquet.piocher().toString());
        }
    }
}
