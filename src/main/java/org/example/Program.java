package org.example;

import org.apache.commons.lang3.StringUtils;
import org.example.Class.ColumnsHandler;
import org.example.Class.Machine;
import org.example.Class.Recap;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Recap recap = new Recap();
        recap = recap.deserialiserJson();

        ColumnsHandler columnsHandler = new ColumnsHandler();
        columnsHandler.deserialiserJson();

        List<List<String>> listDesValeurs =  columnsHandler.positionAleatoire();
        Machine machine = new Machine(listDesValeurs,recap);

        String reponseUtilisateurRejouer;
        Scanner premiereReponse = new Scanner(System.in);
        System.out.println("Vous avez :" + recap.getCoins() + " jetons.");
        System.out.println("Bienvenue !!! voulez vous jouer ? O/N");
        String reponseUtilisateur = premiereReponse.nextLine();

        boolean continuerPartie = true;

        if ("O".equals(reponseUtilisateur) || "o".equals(reponseUtilisateur)) {
            while(continuerPartie){
                int choixUtilisateur = choixNbJetons();
                machine.lancerLaMachine(columnsHandler,choixUtilisateur);
                machine.nbPointsAttribuesParPartie(choixUtilisateur);
                recap.serialiserJson(recap);
                System.out.println("Vous avez :" + recap.getCoins() + " jetons.");
                System.out.println("Souhaitez-vous rejouer ? O/N ");
                reponseUtilisateurRejouer = premiereReponse.nextLine();
                if("O".equals(reponseUtilisateurRejouer)|| "o".equals(reponseUtilisateurRejouer)){
                    continuerPartie=true;
                }else{
                    continuerPartie=false;
                }
            }
            System.out.println("La prochaine fois vous aurez " + recap.getCoins() + " jetons pour vous amuser");
            System.out.println("A bientôt !!!");
        }
    }

    private static int choixNbJetons(){
        Scanner scanner = new Scanner(System.in);
        int selectedTokens = promptForTokens(scanner);


        if (isValidTokenSelection(selectedTokens)) {
            System.out.println("Sélection valide : " + selectedTokens + " jeton(s)");
        } else {
            System.out.println("Sélection invalide. Veuillez choisir 1, 2 ou 3 jetons.");
        }
        return selectedTokens;
    }

    /**
     * Verifier la conformité de la saisie du nombre de jetons de l'utilisateur
     * @param scanner ==> Saisie "1", "2" ou "3"
     * @return la valeur saisie par l'utilisateur (1,2 ou 3)
     */
    private static int promptForTokens(Scanner scanner) {
        int selectedTokens;

        while (true) {
            System.out.print("Choisissez le nombre de jetons (1, 2 ou 3) : ");
            String input = scanner.nextLine();
            try {
                selectedTokens = Integer.parseInt(input);
                if (selectedTokens >= 1 && selectedTokens <= 3) {
                    break;
                } else {
                    System.out.println("Veuillez choisir 1, 2 ou 3 jetons.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un nombre entier.");
            }
        }
        return selectedTokens;
    }

    // Vérification avec StringUtils
    private static boolean isValidTokenSelection(int selectedTokens) {
        String validOptions = "123";
        return StringUtils.contains(validOptions, Integer.toString(selectedTokens));
    }
}


