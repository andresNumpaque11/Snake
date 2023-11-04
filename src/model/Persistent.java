package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Persistent {
   
public  static ArrayList read(String path) {
    
    ArrayList levels = new ArrayList();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datas = linea.split(";");
                String level = datas[0];
                Long speed = Long.parseLong(datas[1]);
                Long speedFood = Long.parseLong(datas[2]);
                Long boom = Long.parseLong(datas[3]);
                int size = Integer.parseInt(datas[4]);
                levels.add(new Level(level, speed,speedFood, boom,size));
            }
            fr.close();
            br.close();

        } catch (IOException ex) {
            System.out.println("Error leyendo el archivo");


        }return levels;
    }
  public static void writePlayers(String path, ArrayList<Player> players) {
        try (FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(players);
        } catch (IOException ex) {
            System.out.println("Error escribiendo el archivo de jugadores: " + ex.getMessage());
        }
    }

    // Método para leer la información de jugadores usando serialización
    public static ArrayList<Player> readPlayers(String path) {
        ArrayList<Player> players = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(path);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            players = (ArrayList<Player>) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error leyendo el archivo de jugadores: " + ex.getMessage());
        }
        return players;
    }
    
}
