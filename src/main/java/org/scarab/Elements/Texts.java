package org.scarab.Elements;

import java.io.FileNotFoundException;


public class Texts extends Elements
{
    private String ref = "";

    /**
     *
     * @param name
     * @param posX
     * @param posY
     * @param direction
     * @throws FileNotFoundException
     */
   public Texts(String name, int posX, int posY, int direction) throws FileNotFoundException
   {
       super(name,posX,posY,direction);
       this.ref = name.substring(5);
   }

    /**
     *
     * @return Ref
     */
    public String getRef() {return ref;}

    /**
     *
     * @return vrai pour la methode push
     */

    @Override
    public boolean getIsPush() {
        return true;
    }
}
