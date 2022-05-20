package org.scarab.Elements;

import java.io.FileNotFoundException;


public class Texts extends Elements
{
    private String ref = "";

    /**
     * Contructeur des éléments de texte
     * @param name Le nom de l'élément
     * @param posX La position X de l'élément
     * @param posY La position Y de l'élément
     * @param direction La direction de l'élément
     * @throws FileNotFoundException Renvoie une exception si l'élément est introuvable
     */
   public Texts(String name, int posX, int posY, int direction) throws FileNotFoundException
   {
       super(name,posX,posY,direction);
       this.ref = name.substring(5);
   }

    /**
     * Méthode renvoyant un string de référence
     * @return la chaine de caractère de référence
     */
    public String getRef() {return ref;}

    /**
     * Méthode modifiant la condtion de PUSH
     * @return vrai pour la methode push
     */

    @Override
    public boolean getIsPush() {
        return true;
    }
}
