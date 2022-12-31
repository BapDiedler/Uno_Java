package uno.cartes;

/**
 * énumération des différentes couleurs de carte
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public enum Couleur {
    NOIR("Noir","\u001B[30m"),
    BLEU("Bleu","\u001B[34m") ,
    ROUGE("Rouge","\u001B[31m") ,
    VERT("Vert","\u001B[32m") ,
    JAUNE("Jaune","\u001B[33m");

    private final String nom ;
    private final String affichage;

    /**
     * constructeur de l'énumération Couleur
     *
     * @param nom de la couleur
     * @param affichage couleur sur la console
     */
    Couleur(String nom, String affichage) {
        assert(nom!=null):"les Strings doivent être initialisés";
        this.nom=nom;
        this.affichage = affichage;
    }

    /**
     * getter du nom de la couleur
     *
     * @return le nom de la couleur
     */
    public String getNom(){
        return nom;
    }

    /**
     * fonction qui donne la couleur en fonction de l'initiale
     *
     * @param init initiale de la couleur
     * @return la couleur choisit
     */
    public static Couleur estDeCouleur(char init){
        for(Couleur color: Couleur.values()){
            if(color.getNom().charAt(0) == init)
                return color;
        }
        return NOIR;//la couleur n'existe pas
    }

    /**
     * affichage de la couleur
     *
     * @return la couleur
     */
    public String toString(){
        return affichage+"\uD83C\uDCCF"+"\u001B[0m";
    }
}
