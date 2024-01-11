package org.example.Class;


import java.util.ArrayList;

import java.util.Random;



import java.util.List;

public class Machine {

    private List<List<String>> colonnes;  // Colonnes désérialisées depuis le JSON
    private String[][] matrice;           // Matrice 3x3 qui accueillera les symboles choisis aléatoirement

    private Recap recap;
    public Machine(List<List<String>> colonnes, Recap recap) {
        this.colonnes = colonnes;
        this.matrice = new String[3][3];
        this.recap = recap;
    }

    /**
     * L'utilisateur joue
     * @param columnsHandler
     * @param nbJetons
     */
    public void lancerLaMachine(ColumnsHandler columnsHandler, int nbJetons){
        List<List<String>> listDesValeurs =columnsHandler.positionAleatoire();
        initialiserMachine(listDesValeurs);
        recap.setCoins(recap.getCoins()-nbJetons);
        recap.setGames_played(recap.getGames_played()+1);
        afficherMatrice();
    }

    /**
     * Changer les valeurs affichées sur la machine
     * @param valeurs
     */
    public void initialiserMachine(List<List<String>> valeurs) {
        this.colonnes=valeurs;
        int j=0;
        for (List<String> c : colonnes){
            int i=0;
            for(String str:c){
                if(str.length()==1) {
                    str = " " + str + " ";
                }
               matrice[i][j]=str;
               i++;
            }
            j++;
        }
    }

    /**
     * Met en forme l'affichage de la matrice
     */
    public void afficherMatrice(){
       for(int i = 0; i<matrice.length; i++){
           for(int j = 0; j<matrice[i].length;j++){
               System.out.print(matrice[i][j] + "|");
           }
           System.out.println();
       }
    }

    /**
     * Génère un nombre de points en fonction des valeurs alignées sur la matrice
     * @return
     */
    public boolean nbPointAlignementLigneCentral(){
        boolean ligneGagnante = false;
        if (matrice [1][0]== matrice[1][1] && matrice [1][0] == matrice[1][2]){
            switch(matrice[1][0]) {
                case " 7 ":
                    ajoutPoints(300);
                    break;
                case "BAR":
                    ajoutPoints(100);
                    break;
                case " R ":
                    ajoutPoints(15);
                    break;
                case  " P ":
                    ajoutPoints(15);
                    break;
                case  " T ":
                    ajoutPoints(15);
                    break;
                case  " C ":
                    ajoutPoints(8);
                    break;
            }ligneGagnante=true;
        }
        return ligneGagnante;
    }
    /**
     * Génère un nombre de points en fonction des valeurs alignées sur la matrice
     * @return
     */
    public boolean nbPointAlignementLigneHaut(){
        boolean ligneGagnante = false;
        if (matrice [0][0]== matrice[0][1] && matrice [0][0] == matrice[0][2]){
            switch(matrice[0][0]) {
                case " 7 ":
                    ajoutPoints(300);
                    break;
                case "BAR":
                    ajoutPoints(100);
                    break;
                case " R ":
                    ajoutPoints(15);
                    break;
                case  " P ":
                    ajoutPoints(15);
                    break;
                case  " T ":
                    ajoutPoints(15);
                    break;
                case  " C ":
                    ajoutPoints(8);
                    break;
            }
            ligneGagnante=true;
        }
        return ligneGagnante;
    }
    /**
     * Génère un nombre de points en fonction des valeurs alignées sur la matrice
     * @return
     */
    public boolean nbPointAlignementLigneBas(){
        boolean ligneGagnante = false;
        if (matrice [2][0]== matrice[2][1] && matrice [2][0] == matrice[2][2]){
            switch(matrice[2][0]) {
                case " 7 ":
                    ajoutPoints(300);
                    break;
                case "BAR":
                    ajoutPoints(100);
                    break;
                case " R ":
                    ajoutPoints(15);
                    break;
                case  " P ":
                    ajoutPoints(15);
                    break;
                case  " T ":
                    ajoutPoints(15);
                    break;
                case  " C ":
                    ajoutPoints(8);
                    break;
            }ligneGagnante=true;
        }
        return ligneGagnante;
    }
    /**
     * Génère un nombre de points en fonction des valeurs alignées sur la matrice
     * @return
     */
    public boolean nbPointAlignementDiagonale1(){
        boolean ligneGagnante = false;
        if (matrice [0][0]== matrice[1][1] && matrice [0][0] == matrice[2][2]){
            switch(matrice[2][0]) {
                case " 7 ":
                    ajoutPoints(300);
                    break;
                case "BAR":
                    ajoutPoints(100);
                    break;
                case " R ":
                    ajoutPoints(15);
                    break;
                case  " P ":
                    ajoutPoints(15);
                    break;
                case  " T ":
                    ajoutPoints(15);
                    break;
                case  " C ":
                    ajoutPoints(8);
                    break;

            }ligneGagnante=true;
        }
        return ligneGagnante;
    }
    /**
     * Génère un nombre de points en fonction des valeurs alignées sur la matrice
     * @return
     */
    public boolean nbPointAlignementDiagonale2(){
        boolean ligneGagnante = false;
        if (matrice [2][0]== matrice[1][1] && matrice [2][0] == matrice[0][0]){
            switch(matrice[0][0]) {
                case " 7 ":
                    ajoutPoints(300);
                    break;
                case "BAR":
                    ajoutPoints(100);
                    break;
                case " R ":
                    ajoutPoints(15);
                    break;
                case  " P ":
                    ajoutPoints(15);
                    break;
                case  " T ":
                    ajoutPoints(15);
                    break;
                case  " C ":
                    ajoutPoints(8);
                    break;

                default:
                    ajoutPoints(0);
                    break;
            }
            ligneGagnante=true;
        }
        return ligneGagnante;
    }

    /**
     * Gestion des différentes actions en cas de gain
     * @param points
     */
    private void ajoutPoints(int points){
        recap.setCoins(recap.getCoins()+ points);
        recap.setCoins_spent((recap.getCoins_spent()+ points));
        recap.setGames_won((recap.getGames_won())+1);
    System.out.println("Vous avez gagné " + points  + " points.");
    }
    public int nbPointsAttribuesParPartie(int nbCoins){
        switch(nbCoins){
            case 1 :
                if(nbPointAlignementLigneCentral()){
                }else{
                    System.out.println("Vous n'avez pas marqué de point");
                }
                break;

            case 2 :
                if(nbPointAlignementLigneCentral() && nbPointAlignementLigneBas()&&nbPointAlignementLigneHaut()){
                }else{
                    System.out.println("Vous n'avez pas marqué de point");
                }
                break;

            case 3 :
                if(nbPointAlignementLigneCentral() && nbPointAlignementLigneBas() && nbPointAlignementLigneHaut() &&nbPointAlignementDiagonale1() && nbPointAlignementDiagonale2()){
                }else{
                System.out.println("Vous n'avez pas marqué de point");
            }
                break;

            default:
                System.out.println("Merci de saisir une valeur entre 1 et 3");

        }
        return 0;
    }
}















