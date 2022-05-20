package org.scarab.Elements;

import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class Material extends Elements
{
    /**
     *
     * @param name
     * @param posX
     * @param posY
     * @param direction
     * @throws FileNotFoundException
     */
    public Material(String name, int posX, int posY,int direction) throws FileNotFoundException {
        super(name, posX, posY, direction);
        if (name.equals("border")) {
            this.IsStop = true;
        }
    }



}

