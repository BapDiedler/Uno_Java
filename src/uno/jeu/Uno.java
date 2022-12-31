package uno.jeu;

import uno.cartes.Carte;
import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;

import java.util.Random;

/**
 * Cette classe représente le jeu d'uno ainsi que son implémentation
 *
 * @author Diedler Baptiste
 * @version 2022
 */
public class Uno {

    /**
     * index de la personne qui distribue les cartes dans le jeu
     * utilisé pour déterminer la première personne qui joue
     */
    private int indexDonneur;
    /**
     * index du joueur courant nous permet de savoir le joueur qui est en train de jouer
     */
    private int indexJoueurCourant;
    /**
     * sens de la partie pour connaitre le joueur suivant au joueur courant
     * vrai passe au joueur plus 1
     * faux passe au joueur moins 1
     */
    private boolean sens;
    /**
     * dialogue permettant d'interagir avec le joueur humain
     */
    private DialogueLigneDeCommande dialogue;
    /**
     * tableau de joueurs contenant tous les joueurs de la partie
     */
    private Joueur[] joueurs;
    /**
     * pioche correspondant à la pioche du jeu de Uno
     */
    private PaquetDeCartes pioche;
    /**
     * talon correspondant au talon du jeu de Uno
     */
    private PaquetDeCartes talon;

    /**
     * constructeur de la classe Uno
     */
    private Uno() {
    }

    /**
     * fonction qui permet d'initialiser la liste de joueurs de la partie
     *
     * @param nbJoueurs dans la partie
     * @param nomJoueur est le nom du joueur humain
     * @param niveau    est le niveau de difficulté du jeu
     */
    private void creerJoueurs(int nbJoueurs, String nomJoueur, int niveau) {
        joueurs = new Joueur[nbJoueurs];
        joueurs[0] = new JoueurHumain(nomJoueur, this);
        for (int i = 1; i < nbJoueurs; i++) {
            if (niveau == 1) joueurs[i] = new BotFacile("Bot" + i, this);
            else {
                joueurs[i] = new BotDifficile("BotDifficile" + i, this);
            }
        }
    }

    /**
     * la fonction permet d'initialiser la pioche du jeu
     *
     * @param uno à partir duquel la pioche va être cré
     */
    private void initialiserPioche(Uno uno) {
        pioche = FabriqueCartes.getInstance().getPaquetUno(uno);
        pioche.melanger();
    }

    /**
     * la fonction permet d'initialiser le talon du jeu
     */
    private void initialiserTalon() {
        talon = new PaquetDeCartes();
    }

    /**
     * fonction qui choisit qui commence à distribuer de façon aléatoire
     */
    private void choisirQuiDistribue() {
        indexDonneur = new Random().nextInt(joueurs.length);
    }

    /**
     * fonction qui donne l'index du joueur courant en fonction du joueur qui distribue
     */
    private void choisirQuiJoue() {
        indexJoueurCourant = (indexDonneur + 1) % joueurs.length;
    }

    /**
     * fonction qui distribue les cartes d'un jeu d'uno
     */
    private void distribuerCartes() {
        Carte c;
        for (int i = 0; i < 7; i++) {//7 cartes par joueurs
            for (Joueur joueur : joueurs) {
                c = pioche.piocher();
                joueur.ajouter(c);
            }
        }
        do {
            c = pioche.piocher();
            talon.ajouter(c);
        } while (sommetTalon().estSansCouleur());//la première carte du paquet ne doit pas être un joker
    }

    /**
     * fonction qui initialise l'uno
     *
     * @param nbJoueurs nombre de joueurs dans la partie
     * @param nomJoueur nom du joueur humain
     * @param niveau    niveau de difficulté du jeu
     * @return l'uno initialisé
     */
    public static Uno initialisation(int nbJoueurs, String nomJoueur, int niveau) {
        assert (nbJoueurs <= 10 && nbJoueurs >= 2) : "le nombre de joueurs doit être compris entre 2 et 10";
        Uno uno = new Uno();
        uno.creerJoueurs(nbJoueurs, nomJoueur, niveau);
        uno.initialiserPioche(uno);
        uno.initialiserTalon();
        uno.choisirQuiDistribue();
        uno.choisirQuiJoue();
        uno.distribuerCartes();
        uno.sens = true;
        return uno;
    }

    /**
     * initialise l'attribut DialogueLigneDeCommande de la classe
     *
     * @param dialogue qui va devenir l'attribut de la classe
     */
    public void setDialogue(DialogueLigneDeCommande dialogue) {
        this.dialogue = dialogue;
    }

    /**
     * fonction qui met en place les règles du jeu ainsi qui le roulement des joueurs
     *
     * @param coup joué par le joueur courant
     * @throws CoupIncorrect en cas d'erreur dans les valeurs entrées
     */
    public void jouer(String coup) throws CoupIncorrect{
        if (pioche.estVide())//le talon redevient la pioche si la pioche n'a plus de carte
            talonToPioche();
        int talonTaille = talon.getNombreDeCartes();
        try {
            joueurs[indexJoueurCourant].jouer(coup);//le joueur courant joue la partie
        }catch (CoupIncorrect ex){
            throw new CoupIncorrect(ex.getMessage());
        }
        dialogue.afficherUno();
        if (estFinie()) {//la partie continue
            if (talonTaille < talon.getNombreDeCartes())//si une carte est posée on applique son effet
                sommetTalon().appliquerEffet();
            passerJoueur();//changement de joueur
        }
        dialogue.reagir();//on fait reagir le joueur courant
    }

    /**
     * passage du talon vers la pioche
     */
    private void talonToPioche() {
        Carte sommetTalon = talon.piocher();//on garde le sommet du talon
        pioche.ajouter(talon);
        for (Carte c : pioche) {//on remet les jokers à null
            if (c.getValeur() == 50) c.setCouleur(null);
        }
        talon = FabriqueCartes.getInstance().getPaquetVide();
        talon.ajouter(sommetTalon);
        pioche.retourner();
    }

    /**
     * permet de changer le sens du jeu
     */
    public void changementDeSens() {
        sens ^= true;
    }

    /**
     * permet de passer un joueur en fonction du sens
     */
    public void passerJoueur() {
        if (sens) indexJoueurCourant = (indexJoueurCourant + 1) % joueurs.length;
        else indexJoueurCourant = (nbJoueurs() + indexJoueurCourant - 1) % joueurs.length;
    }

    /**
     * fait piocher nbCartes au joueur courant
     *
     * @param nbCartes à piocher
     */
    public void piocherCarte(int nbCartes) {
        for (int i = 0; i < nbCartes; i++) {
            joueurs[(indexJoueurCourant) % nbJoueurs()].ajouter(pioche.piocher());
        }
    }

    /**
     * demande la couleur à un utilisateur
     *
     * @return la valeur en String de la couleur
     */
    public String choixCouleur() {
        return dialogue.choisirCouleur();
    }

    /**
     * la fonction nous permet de savoir si le jeu est fini
     *
     * @return vrai si le jeu est fini
     */
    public boolean estFinie() {
        for (Joueur j : joueurs) {
            if (j.nbCartes() == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * fonction qui renvoie la pioche de l'uno
     *
     * @return la pioche de l'uno
     */
    public Carte piocher() {
        return pioche.piocher();
    }

    /**
     * fonction qui ajoute au talon
     *
     * @param carte à ajouter
     */
    public void ajouterTalon(Carte carte) {
        talon.ajouter(carte);
    }

    /**
     * fonction qui ajoute dans la pioche
     *
     * @param carte à ajouter
     */
    public void ajouterPioche(Carte carte){
        pioche.ajouter(carte);
    }

    /**
     * fonction qui renvoie le sommet du talon
     *
     * @return le sommet du talon
     */
    public Carte sommetTalon() {
        return talon.getSommet();
    }

    /**
     * la fonction nous permet de savoir si un joueur est humain ou s'il est un bot
     *
     * @return un boolean
     */
    public boolean estHumain() {
        return joueurs[indexJoueurCourant].estHumain();
    }

    /**
     * getter sur la main du joueur courant
     *
     * @return le paquet de cartes du joueur courant
     */
    public PaquetDeCartes getMainJoueur() {
        return joueurs[indexJoueurCourant].getMain();
    }

    /**
     * fonction qui nous donne l'indice du joueur courant
     *
     * @return l'indice du joueur courant
     */
    public int getIndexJoueurCourant() {
        return indexJoueurCourant;
    }

    /**
     * fonction qui nous donne le sens dans lequel tourne le jeu
     *
     * @return le sens du jeu
     */
    public boolean getSens() {
        return sens;
    }

    /**
     * le nombre de joueurs dans la partie d'uno
     *
     * @return le nombre de joueurs
     */
    public int nbJoueurs() {
        return joueurs.length;
    }

    /**
     * la fonction nous donne le nom du joueur courant
     *
     * @return nom de joueur
     */
    public String getNom() {
        return joueurs[indexJoueurCourant].getNom();
    }

    /**
     * fonction qui nous donne le nombre de cartes d'un joueur
     *
     * @param index index du joueur
     * @return la valeur de son nombre de cartes
     */
    public int getNbCartes(int index) {
        return joueurs[index].nbCartes();
    }

    /**
     * fonction qui nous donne le nombre de cartes du joueur courant
     *
     * @return la valeur de son nombre de cartes
     */
    public int getNbCartes() {
        return getNbCartes(indexJoueurCourant);
    }

    /**
     * fonction qui nous donne le joueur gagnant
     *
     * @return nom d'un joueur
     */
    public String getNomGagnant() {
        return joueurs[indexJoueurCourant].getNom();
    }
}
