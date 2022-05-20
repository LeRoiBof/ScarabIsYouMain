package org.scarab.Elements;

import java.io.File;
import java.io.FileNotFoundException;

public class Is extends Elements
{
    /**
     *
     * @param name
     * @param posX
     * @param posY
     * @param direction
     * @throws FileNotFoundException
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
