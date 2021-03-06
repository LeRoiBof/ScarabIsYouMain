package org.scarab;
import org.scarab.Elements.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map
{

    private static int map_width;
    private static int map_height;

    private Grid grid;

    private static ArrayList<Elements> AllElements = new ArrayList<Elements>();

    /**
     * Méthode qui permet de lire un fichier .txt pour générer les éléments de la map dans un tableau
     * @param path Chemin d'accès
     */
    public Map(String path)
    {

        try
        {
            File MyMap = new File(path);                   // lecture du fichier map
            Scanner Lecture = new Scanner(MyMap);
            if(!Lecture.hasNextLine())
                return;
            String FirstLine = Lecture.nextLine();
            String[] superficieMap = FirstLine.split(" ");
            map_width = Integer.parseInt(superficieMap[0]) + 2;
            map_height = Integer.parseInt(superficieMap[1]) + 2;
            grid = new Grid(map_width, map_height, this);

            while(Lecture.hasNextLine()) {
                String data = Lecture.nextLine();                         // lecture des elements ligne par ligne
                String[] obj = data.split(" ");
                Elements element = null;
                if(obj.length > 2 && (Integer.parseInt(obj[1]) > map_width || Integer.parseInt(obj[2]) > map_height)) {
                    grid = null;
                    return;
                }

                if (obj[0].equals("is")) {
                    element = new Is(obj[0], Integer.parseInt(obj[1]), Integer.parseInt(obj[2]), obj.length > 3 ? Integer.parseInt(obj[3]) : 0);

                } else if (obj[0].length() > 5 && obj[0].substring(0, 5).equals("text_")) {
                    element = new Texts(obj[0], Integer.parseInt(obj[1]), Integer.parseInt(obj[2]), obj.length > 3 ? Integer.parseInt(obj[3]) : 0);
                } else if (obj[0].equals("rock") || obj[0].equals("wall") || obj[0].equals("lava") || obj[0].equals("water") || obj[0].equals("baba") || obj[0].equals("flag") || obj[0].equals("skull") || obj[0].equals("grass") || obj[0].equals("metal")) {
                    element = new Material(obj[0], Integer.parseInt(obj[1]), Integer.parseInt(obj[2]), obj.length > 3 ? Integer.parseInt(obj[3]) : 0);
                } else if (obj[0].equals("you") || obj[0].equals("win") || obj[0].equals("stop") || obj[0].equals("push") || obj[0].equals("hot") || obj[0].equals("sink") || obj[0].equals("best")) {
                    element = new Action(obj[0], Integer.parseInt(obj[1]), Integer.parseInt(obj[2]), obj.length > 3 ? Integer.parseInt(obj[3]) : 0);
                }
                if (element != null) {
                    grid.addElementAtPos(element.getPosX(), element.getPosY(), element);
                    AllElements.add(element);     // ajoute chaque elements dans le tableau afin de sauvgarder les entities
                }
            }
            Lecture.close();
        }
        catch(FileNotFoundException e )
        {
            e.printStackTrace();
        }

    }

    /**
     *  Méthode de sauvegarde d'un niveau. Ecrit la position de chaque élément conformément à la typologie dans un fichier .txt
     */
    public static void save()
    {
        try {
            FileWriter savemap = new FileWriter("src/main/resources/save/save"+ SceneChanger.getCount()+ ".txt");
            savemap.write((map_width - 2) + " " + (map_height - 2) + "\n");
            for (Elements e : getAllElements()) {
                if (!e.getName().equals("border"))
                    savemap.write(e.getName() + " " + e.getPosX() + " " + e.getPosY() + " " + e.getDirection() + "\n");
            }
                savemap.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try {
            int newCount = SceneChanger.getCount()-1;
            File save = new File("src/main/resources/save/save"+ newCount +".txt");
            save.delete();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Méthode permettant de supprimer tous les éléments d'un tableau (de la map)
     */
    public static void clearElements(){
        AllElements.clear();
    }


    /**
     * Méthode renvoyant la hauteur de la map
     * @return l'entier hauteur
     */
    public int getMap_height() {return map_height;}

    /**
     * Méthode renvoyant la largeur de la map
     * @return l'entier largeur
     */
    public int getMap_width(){return map_width;}

    /**
     * Méthode renvoyant tous les éléments de la map
     * @return un tableau d'éléments
     */
    public static ArrayList<Elements> getAllElements() {
        return AllElements;
    }

    /**
     * Méthode renvoyant la grille du jeu
     * @return la grille
     */

    public Grid getGrid() {
        return grid;
    }
}
