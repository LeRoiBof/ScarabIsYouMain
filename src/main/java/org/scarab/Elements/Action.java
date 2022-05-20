package org.scarab.Elements;

import java.io.FileNotFoundException;



public class Action extends Elements
{
    /**
     *
     * @param name
     * @param posX
     * @param posY
     * @param direction
     * @throws FileNotFoundException
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
