package org.scarab.Elements;

import org.scarab.Grid;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Elements
{
    protected ImageView bestt = null;
    protected String name;
    protected int posX;
    protected int posY;
    protected int direction;

    protected boolean IsYou = false;
    protected boolean IsPush = false;
    protected boolean IsStop = false;

    protected boolean IsBest = false;

    protected boolean IsHot = false;
    protected boolean IsSink = false;

    protected boolean Win = false;

    protected ImageView imageView;
    private static boolean canMove = true;

    public Elements(String name, int posX, int posY,int direction) throws FileNotFoundException
    {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
        this.imageView = new ImageView(new Image(new FileInputStream("src/main/resources/img/" + this.name +".png")));
    }

    /**
     * @param canMove_ Prends en paramètre un booléen
     *                 Méthode permettant de changer la valeur de la condition de déplacement
     */
    public static void changeMove(boolean canMove_){
        canMove = canMove_;
    }


    public boolean move(KeyCode key, Grid grid)
    {
        if (canMove) {
            boolean Success = true;

        int v = 0;
        int h = 0;
        switch (key.getCode()) {
            case 38 -> v = -1;
            case 40 -> v = 1;
            case 37 -> h = -1;  // gauche
            case 39 -> h = 1;   // droite
            default -> v = 0;
        }
        ArrayList<Elements> nextelems = grid.getElementsAtPos(this.posX + h, this.posY + v);
        ArrayList<Elements> toMove = new ArrayList<Elements>();
        if (nextelems != null) {
            for (Elements e : nextelems) {
                if (e.getIsStop())
                    return false;
            }
                for (Elements e : nextelems) {

                    if (e.getIsPush())
                        toMove.add(e);
                }
            }
            for (Elements e : toMove)
                Success = e.move(key, grid);
            if (Success) {

                grid.removeElementAtPos(this.posX, this.posY, this);
                this.posY += v;
                this.posX += h;
                grid.addElementAtPos(this.posX, this.posY, this);

                this.imageView.setTranslateX(this.imageView.getTranslateX() + (h * 40));
                this.imageView.setTranslateY(this.imageView.getTranslateY() + (v * 40));


            }
        }
       return true;
    }


    public String getName(){return name;}
    public int getPosX(){return posX;}
    public int getPosY(){return posY;}
    public int getDirection(){return direction;}

    public boolean getIsYou(){return IsYou; }
    public void setIsYou(boolean you) {IsYou = you;}

    public boolean getIsPush() {return IsPush;}
    public void setIsPush(boolean push){IsPush = push;}
    public boolean getIsStop() {return IsStop;}
    public void setIsStop(boolean stop) {IsStop = stop;}

    public boolean getIsWin() {return Win;}

    public void setIsWin(boolean win) {Win = win;}

    public boolean getIsSink() {return IsSink;}

    public void setIsSink(boolean sink) {this.IsSink = sink;}

    public boolean getIsHot() {
        return IsHot;
    }

    public void setHot(boolean Hot) {
        IsHot = Hot;
    }

    public boolean getIsBest() {
        return IsBest;
    }

    public void setBest(boolean best) {IsBest = best;}

    public ImageView getImageView() {return imageView;}

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public ImageView getBestt(){return bestt;}

    public void setBestt(ImageView bestt) {
        this.bestt = bestt;
    }
}


