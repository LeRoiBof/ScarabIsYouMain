package org.scarab.Elements;

import java.io.File;
import java.io.FileNotFoundException;

public class Is extends Elements
{
    public Is(String name, int posX, int posY,int direction) throws FileNotFoundException
    {
        super(name,posX,posY,direction);
    }
    @Override
    public boolean getIsPush() {
        return true;
    }

}
