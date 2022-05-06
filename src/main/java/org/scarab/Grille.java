package org.scarab;
import org.scarab.Elements.Elements;
import org.scarab.Elements.Is;

import java.util.ArrayList;

public class Grille
{
    private ArrayList<ArrayList<ArrayList<Elements>>> Grid = new ArrayList<ArrayList<ArrayList<Elements>>>();
    private ArrayList<Elements> arrayIs = new ArrayList<Elements>();

    private final int width;
    private final int height;
    public Grille(int width, int height)
    {
        this.width = width;
        this.height = height;
        for (int i = 0; i < width; i++)
        {
            Grid.add(i, new ArrayList<ArrayList<Elements>>());
            for (int j = 0; j < height; j++)
                Grid.get(i).add(new ArrayList<Elements>());
        }
    }
    
    public void addElementAtPos(int x, int y, Elements elem)
    {
        Grid.get(x).get(y).add(elem);
        if (elem instanceof Is)
            arrayIs.add(elem);
    }

    public ArrayList<Elements> getElementsAtPos(int x, int y)
    {
        if (x < width && y < height)
            return Grid.get(x).get(y);
        return null;
    }

    public void removeElementAtPos(int x, int y, Elements elem)
    {
        Grid.get(x).get(y).remove(elem);
    }

    public ArrayList<ArrayList<ArrayList<Elements>>> getGrid()
    {
        return Grid;
    }
    public ArrayList<Elements> getArrayIs() {return arrayIs;}
}
