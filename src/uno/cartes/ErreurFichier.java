package uno.cartes;

/**
 * la classe représente les erreurs dans la manipulation de fichier
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public class ErreurFichier extends RuntimeException {

    /**
     * constructeur de la classe
     *
     * @param mes message à faire passer
     */
    public ErreurFichier(String mes) {
        super(mes);
    }
}
