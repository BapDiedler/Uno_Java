package uno.jeu.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;
import uno.jeu.*;

import static org.junit.jupiter.api.Assertions.*;

public class JoueurTest {
    protected Uno uno;
    protected Joueur playerHumain;
    protected Joueur playerBotFacile;
    protected Joueur playerBotDifficile;


    @BeforeEach
    void setUp() {
        playerHumain = new JoueurHumain("humanPlayer", uno);
        playerBotFacile = new BotFacile("botFacilePlayer", uno);
        playerBotDifficile = new BotDifficile("botDifficilePlayer", uno);
    }

    /**
     * test de la fonction estHumain
     */
    @Test
    public void testEstHumain(){
        assertTrue(playerHumain.estHumain());
        assertFalse(playerBotDifficile.estHumain());
        assertFalse(playerBotFacile.estHumain());
    }

    /**
     * test de la fonction getNbCartes
     */
    @Test
    public void testGetNbCartes(){
        PaquetDeCartes paquetJoueur = FabriqueCartes.getInstance().getPaquet5Plus2(uno);
        playerHumain.getMain().ajouter(paquetJoueur);
        playerBotFacile.getMain().ajouter(paquetJoueur);
        playerBotDifficile.getMain().ajouter(paquetJoueur);
        assertEquals(playerBotDifficile.nbCartes(),5);
        assertEquals(playerBotFacile.nbCartes(),5);
        assertEquals(playerHumain.nbCartes(),5);
    }
}
