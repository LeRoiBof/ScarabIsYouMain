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

    /**
     *
     * @param name
     * @param posX
     * @param posY
     * @param direction
     * @throws FileNotFoundException
     */
    public Elements(String name, int posX, int posY,int direction) throws FileNotFoundException
    {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
        this.imageView = new ImageView(new Image(new FileInputStream("src/main/resources/img/" + this.name +".png")));
    }

    public static void changeMove(boolean canMove_){
        canMove = canMove_;
    }

    /**
     * methode qui sert a deplacer un ou plusieurs Elements dans la grille et dans la map.
     * @param key la touche
     * @param grid la grille
     * @return vrai ou faux
     */
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


    /**
     *
     * @return le nom
     */
    public String getName(){return name;}

    /**
     *
     * @return la position x
     */
    public int getPosX(){return posX;}

    /**
     *
     * @return la position y
     */
    public int getPosY(){return posY;}

    /**
     *
     * @return la direction
     */
    public int getDirection(){return direction;}

    /**
     *
     * @return si l'elements est Isyou
     */

    public boolean getIsYou(){return IsYou; }

    /**
     *
     * @param you
     */
    public void setIsYou(boolean you) {IsYou = you;}

    /**
     *
     * @return si l'elements est Ispush
     */

    public boolean getIsPush() {return IsPush;}

    /**
     *
     * @param push
     */
    public void setIsPush(boolean push){IsPush = push;}

    /**
     *
     * @return si l'elements est IsStop
     */
    public boolean getIsStop() {return IsStop;}

    /**
     *
     * @param stop
     */
    public void setIsStop(boolean stop) {IsStop = stop;}

    /**
     *
     * @return  si l'elements est IsWin
     */

    public boolean getIsWin() {return Win;}

    /**
     *
     * @param win
     */
    public void setIsWin(boolean win) {Win = win;}

    /**
     *
     * @return si l'elements est IsSink
     */

    public boolean getIsSink() {return IsSink;}

    /**
     *
     * @param sink
     */

    public void setIsSink(boolean sink) {this.IsSink = sink;}

    /**
     *
     * @return si l'elements est est IsHot
     */

    public boolean getIsHot() {
        return IsHot;
    }

    /**
     *
     * @param Hot
     */

    public void setHot(boolean Hot) {
        IsHot = Hot;
    }

    /**
     *
     * @return si l'elements est Isbest
     */
    public boolean getIsBest() {
        return IsBest;
    }

    /**
     *
     * @param best
     */

    public void setBest(boolean best) {IsBest = best;}

    /**
     *
     * @return l'image de l'Elements
     */

    public ImageView getImageView() {return imageView;}

    /**
     *
     * @param imageView
     */

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    /**
     *
     * @return l'image de best
     */

    public ImageView getBestt(){return bestt;}

    /**
     *
     * @param bestt
     */

    public void setBestt(ImageView bestt) {
        this.bestt = bestt;
    }
}


