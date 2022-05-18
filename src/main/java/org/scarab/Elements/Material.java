package org.scarab.Elements;

import java.io.FileNotFoundException;

public class Material extends Elements
{
    public Material(String name, int posX, int posY,int direction) throws FileNotFoundException {
        super(name, posX, posY, direction);
        if (name.equals("border")) {
            this.IsStop = true;
        }
    }
}

