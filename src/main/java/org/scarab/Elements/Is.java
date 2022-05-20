package org.scarab.Elements;

import java.io.FileNotFoundException;

public class Is extends Elements
{
    /**
     * Contructeur des éléments de connexion tels que IS
     * @param name Le nom de l'élément
     * @param posX La position X de l'élément
     * @param posY La position Y de l'élément
     * @param direction La direction de l'élément
     * @throws FileNotFoundException Renvoie un exception si l'élément est introuvable
     */
    public Is(String name, int posX, int posY,int direction) throws FileNotFoundException
    {
        super(name,posX,posY,direction);
    }
    @Override
    public boolean getIsPush() {
        return true;
    }

}
