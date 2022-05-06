package org.scarab.Elements;

import java.io.FileNotFoundException;

public class Action extends Elements
{
    public Action(String name, int posX, int posY,int direction) throws FileNotFoundException
    {
        super(name,posX,posY,direction);
    }

    @Override
    public boolean getIsPush() {
        return true;
    }
}
