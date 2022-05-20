package org.scarab.Elements;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.scarab.Grid;
import org.scarab.Map;

import java.io.FileInputStream;

public class Rules
{
    /**
     * Méthode vérifiant les les règles pour les conditions de victoire ou de défaite
     * @param map La map du niveau
     * @return 0 si la partie est gagnée, dans les autres cas la partie continue
     */
    public static int check(Map map)
    {
        boolean youe = false;
       for(int i = 0; i < map.getMap_height();i++)
       {
           for(int j = 0; j < map.getMap_width(); j++)
           {
               boolean sink = false;
               boolean hot = false;
               boolean win = false;
               boolean you = false;
             for(Elements e : map.getGrid().getElementsAtPos(i,j))
             {
                 if(e.getIsWin())
                     win = true;
                 if(e.getIsSink())
                     sink = true;
                 if(e.getIsHot())
                    hot = true;
                 if(e.getIsYou()) {
                    you = true;
                    youe = true;
                }
                 if (e.getIsBest()) {
                     if (e.getBestt() == null && e.getIsBest()) {
                         try {
                             ImageView a = new ImageView(new Image(new FileInputStream("src/main/resources/img/best.gif")));
                             e.setBestt(a);
                             ((Group) e.getImageView().getParent()).getChildren().add(a);
                             a.setTranslateX(e.getImageView().getTranslateX());
                             a.setTranslateY(e.getImageView().getTranslateY());
                         } catch (Exception ex) {
                             ex.printStackTrace();
                         }

                     }
                 }
                     else if(!e.getIsBest())
                     {

                         ImageView tmp = e.getBestt();

                         if (tmp != null) {
                             ((Group)tmp.getParent()).getChildren().remove(tmp);
                             e.setBestt(null);
                        }

                 }
             }
             if (win && you)
                   return 0;

             if(sink)
                 if(sink && map.getGrid().getElementsAtPos(i,j).size() > 1)
                   for(Elements del : map.getGrid().getElementsAtPos(i,j))
                     if(del.getIsSink()) {
                       map.getGrid().removeElementAtPos(del.getPosX(), del.getPosY(),del);
                         map.getAllElements().remove(del);
                       Elements ref = map.getGrid().getElementsAtPos(del.getPosX(), del.getPosY()).get(0);
                       if (!(ref instanceof  Material)) {
                           map.getGrid().addElementAtPos(del.getPosX(), del.getPosY(),del);
                           break;
                       }
                         ((Group)del.getImageView().getParent()).getChildren().remove(del.getImageView());
                         if(ref instanceof Material) {
                             map.getGrid().removeElementAtPos(ref.getPosX(), ref.getPosY(),ref);
                             map.getAllElements().remove(ref);

                            ((Group)ref.getImageView().getParent()).getChildren().remove(ref.getImageView());
                         }

                     }
           }
       }
       if (!youe)
           return 3;
       return 4;
    }

    /**
     * Méthode parcourant la map pour vérifier les conditions et les règles associées aux éléments
     * @param map La map du niveau
     */

    public static void updaterules(Map map) {
        Grid grid = map.getGrid();
        for (Elements i : grid.getArrayIs()) {
            for (Elements leftelem : grid.getElementsAtPos(i.getPosX() - 1, i.getPosY())) {
                if (leftelem instanceof Texts) {
                    for (Elements rightelem : grid.getElementsAtPos(i.getPosX() + 1, i.getPosY())) {
                        if (rightelem instanceof Action || rightelem instanceof Texts) {
                            if (rightelem.getName().equals("you"))
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts) leftelem).getRef()))
                                        textelem.setIsYou(true);
                                    else
                                        textelem.setIsYou(false);

                            else if (rightelem.getName().equals("push")) {
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts) leftelem).getRef()))
                                        textelem.setIsPush(true);
                                    else
                                        textelem.setIsPush(false);
                            } else if (rightelem.getName().equals("stop")) {
                                for (Elements textelem : map.getAllElements()) {
                                    if (textelem.getName().equals(((Texts) leftelem).getRef()) || textelem.getName().equals("border"))
                                        textelem.setIsStop(true);
                                    else {
                                        textelem.setIsStop(false);
                                    }
                                }
                            } else if (rightelem.getName().equals("win")) {
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts) leftelem).getRef()))
                                        textelem.setIsWin(true);
                                    else
                                        textelem.setIsWin(false);
                            } else if (rightelem.getName().equals("sink")) {
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts) leftelem).getRef()))
                                        textelem.setIsSink(true);
                                    else
                                        textelem.setIsSink(false);
                            } else if (rightelem.getName().equals("hot")) {
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts) leftelem).getRef()))
                                        textelem.setHot(true);
                                    else
                                        textelem.setHot(false);
                            } else if (rightelem.getName().equals("best")) {
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts) leftelem).getRef()))
                                        textelem.setBest(true);
                                    else {
                                        textelem.setBest(false);
                                    }
                            }
                        }
                    }
                }
            }


            for (Elements upelem : grid.getElementsAtPos(i.getPosX(), i.getPosY() - 1)) {
                if (upelem instanceof Texts) {
                    for (Elements downelem : grid.getElementsAtPos(i.getPosX(), i.getPosY() + 1)) {
                        if (downelem instanceof Action || downelem instanceof Texts) {
                            if (downelem.getName().equals("you"))
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts) upelem).getRef()))
                                        textelem.setIsYou(true);
                                    else
                                        textelem.setIsYou(false);

                            else if (downelem.getName().equals("push")) {
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts) upelem).getRef()))
                                        textelem.setIsPush(true);
                                    else
                                        textelem.setIsPush(false);
                            } else if (downelem.getName().equals("stop")) {
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts) upelem).getRef()))
                                        textelem.setIsStop(true);
                                    else
                                        textelem.setIsStop(false);
                            } else if (downelem.getName().equals("win")) {
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts) upelem).getRef()))
                                        textelem.setIsWin(true);
                                    else
                                        textelem.setIsWin(false);
                            } else if (downelem.getName().equals("sink")) {
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts) upelem).getRef()))
                                        textelem.setIsSink(true);
                                    else
                                        textelem.setIsSink(false);
                            } else if (downelem.getName().equals("hot")) {
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts) upelem).getRef()))
                                        textelem.setHot(true);
                                    else
                                        textelem.setHot(false);
                            } else if (downelem.getName().equals("best")) {
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts) upelem).getRef())) {
                                        textelem.setBest(true);
                                    } else
                                        textelem.setBest(false);
                            }
                        }
                    }
                }
            }
        }
    }
}



