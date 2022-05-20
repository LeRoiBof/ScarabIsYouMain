package org.scarab.Elements;


import java.io.FileNotFoundException;

public class Material extends Elements
{
    /**
     * Constructeur des matériaux tels que ROCK, WATER
     * @param name Le nom de l'élément
     * @param posX La position X de l'élément
     * @param posY La position Y de l'élément
     * @param direction La direction de l'élément
     * @throws FileNotFoundException Renvoie une exception si l'élément est introuvable
     */
    public Material(String name, int posX, int posY,int direction) throws FileNotFoundException {
        super(name, posX, posY, direction);
        if (name.equals("border")) {
            this.IsStop = true;
        }
    }



}

