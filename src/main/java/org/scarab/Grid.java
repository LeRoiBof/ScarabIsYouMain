package org.scarab;
import org.scarab.Elements.Elements;
import org.scarab.Elements.Is;
import org.scarab.Elements.Material;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Grid
{
    private ArrayList<ArrayList<ArrayList<Elements>>> Grid = new ArrayList<ArrayList<ArrayList<Elements>>>();
    private ArrayList<Elements> arrayIs = new ArrayList<Elements>();

    private final int width;
    private final int height;

    /**
     * Méthode qui crée la grille de jeu
     * @param width largeur de la map
     * @param height hauteur de la map
     * @param map la map
     */
    public Grid(int width, int height, Map map)
    {
        this.width = width;
        this.height = height;
        for (int i = 0; i < width; i++)
        {
            Grid.add(i, new ArrayList<ArrayList<Elements>>());
            for (int j = 0; j < height; j++)
                Grid.get(i).add(new ArrayList<Elements>());
        }
        try {
            for (int i = 0; i < width; i++) {
                Elements newElem = new Material("border", i, 0, 0);
                this.addElementAtPos(i, 0, newElem);
                map.getAllElements().add(newElem);
            }
            for (int i = 0; i < height; i++) {
                Elements newElem = new Material("border", 0, i, 0);
                this.addElementAtPos(0, i, newElem);
                map.getAllElements().add(newElem);
            }
            for (int i = 0; i < height; i++) {
                Elements newElem = new Material("border", width -1, i, 0);
                this.addElementAtPos(width-1, i, newElem);
                map.getAllElements().add(newElem);
            }
            for (int i = 0; i < width; i++) {
                Elements newElem = new Material("border", i, height-1, 0);
                this.addElementAtPos(i, height-1, newElem);
                map.getAllElements().add(newElem);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    /**
     * Méthode qui ajoute les éléments à une position donnée
     * Si l'élément est un "IS" l'élément est ajouté dans un tableau dynamique ArrayIs
     * @param x Position X dans la grille
     * @param y Position Y dans la grille
     * @param elem L'élement à ajouter
     */
    public void addElementAtPos(int x, int y, Elements elem)
    {
        if (y > 0 && x > 0 && x < width && y < height)
            Grid.get(x).get(y).add(elem);
        if (elem instanceof Is)
            arrayIs.add(elem);

    }

    /**
     * Méthode permettant de récupérer la position d'un élément à une position
     * @param x Position X dans la grille
     * @param y Position Y dans la grille
     * @return Renvoie un tableau comprenant les positions des éléments
     */
    public ArrayList<Elements> getElementsAtPos(int x, int y)
    {
        if (y > 0 && x > 0 && x < width && y < height);
        return Grid.get(x).get(y);
    }

    /**
     * Méthode permettant de supprimer un élément à une position
     * @param x Position X dans la grille
     * @param y Position Y dans la grille
     * @param elem L'élement à supprimer
     */
    public void removeElementAtPos(int x, int y, Elements elem)
    {
        if (x < width - 1 && y < height - 1)
            Grid.get(x).get(y).remove(elem);
    }

    /**
     * Méthode renvoyant la grille du jeu
     * @return la grille
     */
    public ArrayList<ArrayList<ArrayList<Elements>>> getGrid()
    {
        return Grid;
    }

    /**
     * Méthode renvoyant le tableau dynamique ArrayIs
     * @return le tableau de Is
     */
    public ArrayList<Elements> getArrayIs() {return arrayIs;}

    /**
     * Méthode renvoyant la hauteur de la grille
     * @return la hauteur
     */
    public int getHeight() {
        return height;
    }

    /**
     * Méthode renvoyant la largeur de la grille
     * @return la largeur
     */
    public int getWidth() {
        return width;
    }
}
