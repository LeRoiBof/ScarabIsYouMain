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
     * Constructeur des éléments de la grille
     * @param name Nom de l'élément
     * @param posX Position X dans la grille
     * @param posY Position Y dans la grille
     * @param direction Direction de l'élément
     * @throws FileNotFoundException Renvoie une exception si le ficher est introuvable
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
     * Méthode permettant de déplacer des éléments dans la map
     * @param key La touche appuyée
     * @param grid La grille du jeu
     * @return Vrai ou faux si le déplacement peut avoir lieu
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
        ArrayList<Elements> toMove = new ArrayList<>();
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
     * Méthode permettant d'obtenir le nom d'un élément
     * @return le nom de l'élément
     */
    public String getName(){return name;}

    /**
     * Méthode permettant d'obtenir la position X d'un élément
     * @return la position x
     */
    public int getPosX(){return posX;}

    /**
     * Méthode permettant d'obtenir la position Y d'un élément
     * @return la position y
     */
    public int getPosY(){return posY;}

    /**
     * Méthode permettant d'obtenir la direction d'un élément
     * @return la direction
     */
    public int getDirection(){return direction;}

    /**
     * Méthode retournant les conditions de déplacement "IS YOU"
     * @return un booléen
     */

    public boolean getIsYou(){return IsYou; }

    /**
     * Méthode permettant de changer la valeur booléenne de "IS YOU"
     * @param you le paramètre booléen de changement
     */
    public void setIsYou(boolean you) {IsYou = you;}

    /**
     * Méthode retournant les conditions de "PUSH"
     * @return un booléen
     */

    public boolean getIsPush() {return IsPush;}

    /**
     * Méthode permettant de changer la valeur booléenne de "IS PUSH"
     * @param push le paramètre booléen de changement
     */
    public void setIsPush(boolean push){IsPush = push;}

    /**
     * Méthode retournant les conditions de "STOP"
     * @return un booléen
     */
    public boolean getIsStop() {return IsStop;}

    /**
     * Méthode permettant de changer la valeur booléeene de "IS STOP"
     * @param stop le paramètre booléen de changement
     */
    public void setIsStop(boolean stop) {IsStop = stop;}

    /**
     * Méthode retournant les conditions de "WIN"
     * @return un booléen
     */

    public boolean getIsWin() {return Win;}

    /**
     * Méthode permettant de changer la valeur booléeene de "IS WIN"
     * @param win le paramètre booléen de changement
     */
    public void setIsWin(boolean win) {Win = win;}

    /**
     * Méthode retournant les conditions de "SINK"
     * @return un booléen
     */

    public boolean getIsSink() {return IsSink;}

    /**
     * Méthode permettant de changer la valeur booléenne de "IS SINK"
     * @param sink le paramètre booléen de changement
     */

    public void setIsSink(boolean sink) {this.IsSink = sink;}

    /**
     * Méthode retournant les conditions de "HOT"
     * @return un booléen
     */

    public boolean getIsHot() {
        return IsHot;
    }

    /**
     * Méthode permettant de changer la valeur booléenne de "iS HOT"
     * @param Hot le paramètre booléen de changement
     */

    public void setHot(boolean Hot) {
        IsHot = Hot;
    }

    /**
     * Méthode retournant les conditions de "BEST"
     * @return un booléen
     */
    public boolean getIsBest() {
        return IsBest;
    }

    /**
     * Méthode permettant de changer la valeur booléeen de "IS BEST"
     * @param best le paramètre booléen de changement
     */

    public void setBest(boolean best) {IsBest = best;}

    /**
     * Méthode retournant l'image de l'élément
     * @return une ImageView
     */

    public ImageView getImageView() {return imageView;}

    /**
     * Méthode retournant l'image de best
     * @return une ImageView de l'élément best
     */

    public ImageView getBestt(){return bestt;}

    /**
     * Méthode permettant de changer l'image de best
     * @param bestt la paramètre ImageView de changement
     */

    public void setBestt(ImageView bestt) {
        this.bestt = bestt;
    }
}


