package uno.jeu;

/**
 * classe représente les coups impossibles à jouer
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public class CoupIncorrect extends RuntimeException{

    /**
     * constructeur de l'exception
     */
    public CoupIncorrect(String message){
        super(message);
    }
}
