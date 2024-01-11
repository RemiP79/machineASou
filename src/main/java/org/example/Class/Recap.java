package org.example.Class;

import com.google.gson.Gson;

import java.io.*;

public class Recap {
        private int coins;
        private int games_played;
        private int games_won;
        private int coins_spent;

    public Recap(int coins, int games_played, int games_won, int coins_spent) {
        this.coins = coins;
        this.games_played = games_played;
        this.games_won = games_won;
        this.coins_spent = coins_spent;
    }
    public Recap() {

    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getGames_played() {
        return games_played;
    }

    public void setGames_played(int games_played) {
        this.games_played = games_played;
    }

    public int getGames_won() {
        return games_won;
    }

    public void setGames_won(int games_won) {
        this.games_won = games_won;
    }

    public int getCoins_spent() {
        return coins_spent;
    }

    public void setCoins_spent(int coins_spent) {
        this.coins_spent = coins_spent;
    }

    @Override
    public String toString() {
        return "Recap{" +
                "coins=" + coins +
                ", games_played=" + games_played +
                ", games_won=" + games_won +
                ", coins_spent=" + coins_spent +
                '}';
    }

    /**
     *
     * @return
     */
    public Recap deserialiserJson() {
        Gson gson = new Gson();
        InputStream inputStream = ColumnsHandler.class.getResourceAsStream("/recap.json");
        Recap recap = gson.fromJson(new InputStreamReader(inputStream), Recap.class);
       return recap;
    }

    public void serialiserJson(Recap recap) {
        String filePath = "C:/Users/remre/Documents/Rem/CGI-IPI/IPI/cours/Java/cours_Alexandre_Chevalier_POO_java/evaluation/machineASouPockemon/src/main/resources/recap.json";
        Gson gson = new Gson();
        String modifiedJson = gson.toJson(recap);
        writeJsonToFile(filePath, modifiedJson);
    }

    private static void writeJsonToFile(String filePath, String modifiedJson) {
    try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(modifiedJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
