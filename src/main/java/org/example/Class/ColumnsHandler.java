package org.example.Class;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ColumnsHandler {
    private List<String> c1;
    private List<String>c2;
    private List<String> c3;

    public List<String> getC1() {
        return c1;
    }

    public void setC1(List<String> c1) {
        this.c1 = c1;
    }

    public List<String> getC2() {
        return c2;
    }

    public void setC2(List<String> c2) {
        this.c2 = c2;
    }

    public List<String> getC3() {
        return c3;
    }

    public void setC3(List<String> c3) {
        this.c3 = c3;
    }

    public ColumnsHandler(List<String> c1, List<String> c2, List<String> c3) {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }
    public ColumnsHandler() {
    }


    /**
     * Diviser le fichier colonnes.json en 3 lignes séparées pour faire les 3 colonnes de la matrice
     */
    public void deserialiserJson(){
        Gson gson = new Gson();
        InputStream inputStream = ColumnsHandler.class.getResourceAsStream("/colonnes.json");
List<List<String>> list = gson.fromJson(new InputStreamReader(inputStream), new TypeToken<List<List<String>>>(){}.getType());
        c1=list.get(0);
        c2=list.get(1);
        c3=list.get(2);
    }

    /**
     * Positionner un curseur de manière aléatoire sur une ligne extraite dans deserialiserJson
     * selectionner la valeur de l'index choisi
     * selectionner la valeur de l'index précedent
     * selecitonner la valeur de l'index suivant
     * si l'index est en 0 ou .length, on forme une boucle pour evoter les erreurs
     *
     */
    public List<List<String>> positionAleatoire(){
        Random random = new Random();

        int indexC1 = random.nextInt(c1.size());
        String elementC1 = c1.get(indexC1);
        String elementSuivantC1 = (indexC1==c1.size()-1? c1.get(0):c1.get(indexC1+1));
        String elementPrecedantC1 = (indexC1==0 ? c1.get(c1.size()-1): c1.get(indexC1-1));
        List <String> listC1 = Arrays.asList(elementPrecedantC1,elementC1,elementSuivantC1);

        int indexC2 = random.nextInt(c2.size());
        String elementC2 = c2.get(indexC2);
        String elementSuivantC2 = (indexC2==c2.size()-1? c2.get(0):c2.get(indexC2+1));
        String elementPrecedantC2 = (indexC2==0 ? c2.get(c2.size()-1): c2.get(indexC2-1));
        List <String> listC2 = Arrays.asList(elementPrecedantC2,elementC2,elementSuivantC2);

        int indexC3 = random.nextInt(c3.size());
        String elementC3 = c3.get(indexC3);
        String elementSuivantC3 = (indexC3==c3.size()-1? c3.get(0):c3.get(indexC3+1));
        String elementPrecedantC3 = (indexC3==0 ? c3.get(c3.size()-1): c3.get(indexC3-1));
        List <String> listC3 = Arrays.asList(  elementPrecedantC3,elementC3,elementSuivantC3);

        List <List<String>> listRegroupees = Arrays.asList(listC1,listC2,listC3);

        return listRegroupees;
    }
}
