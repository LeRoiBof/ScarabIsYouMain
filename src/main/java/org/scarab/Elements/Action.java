package org.scarab.Elements;

import java.io.FileNotFoundException;



public class Action extends Elements
{
    /**
     * Constructeur des actions jeu telles que PUSH, ou STOP
     * @param name Le nom de l'élément
     * @param posX La position X de l'élément
     * @param posY La position Y de l'élement
     * @param direction La direction de l'élément
     * @throws FileNotFoundException Renvoie une exception si l'élément est introuvable
     */
    public Action(String name, int posX, int posY,int direction) throws FileNotFoundException
    {
        super(name,posX,posY,direction);
    }

    @Override
    public boolean getIsPush() {
        return true;
    }
}
