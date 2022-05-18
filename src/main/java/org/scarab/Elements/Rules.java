package org.scarab.Elements;

import org.scarab.Grid;
import org.scarab.Map;

public class Rules
{
    public static int check(Map map)
    {
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
                 if(e.getIsSink()) {
                     System.out.println("SINK TRUE");
                     sink = true; }
                 else if(e.getIsHot()) {
                     System.out.println("HOT TRUE");
                     hot = true; }
                 else if(e.getIsYou()) {
                     System.out.println("YOU TRUE");
                     you = true; }
                 else if(e.getIsWin()) {
                     System.out.println("WIN TRUE");
                     win = true;
                 }
             }
             if (!you) {
                 System.out.println("1er if");
                 return 3;
             }
             else if (win && you){
                 System.out.println("2e if");
                 return 0;
             }
             else if(sink && you) {
                 System.out.println("3e if");
                 return 1;
             }
             else if(hot && you) {
                 System.out.println("4e if");
                 return 2;
               }

           }
       }
       return 4;
    }


    public static void updaterules(Map map)
    {
        Grid grid = map.getGrid();
        for(Elements i : grid.getArrayIs())
        {
           for( Elements leftelem : grid.getElementsAtPos(i.getPosX()-1, i.getPosY()))
           {
               if(leftelem instanceof Texts)
               {
                   for (Elements rightelem : grid.getElementsAtPos(i.getPosX() + 1, i.getPosY()))
                   {
                       if (rightelem instanceof Action || rightelem instanceof Texts)
                       {
                           if (rightelem.getName().equals("you"))
                               for (Elements textelem : map.getAllElements())
                                   if (textelem.getName().equals(((Texts)leftelem).getRef()))
                                        textelem.setIsYou(true);
                                    else
                                        textelem.setIsYou(false);

                           else if (rightelem.getName().equals("push"))
                           {
                              for (Elements textelem : map.getAllElements())
                                  if(textelem.getName().equals(((Texts)leftelem).getRef()))
                                      textelem.setIsPush(true);
                                  else
                                      textelem.setIsPush(false);
                           }
                           else if (rightelem.getName().equals("stop"))
                           {
                               for (Elements textelem : map.getAllElements())
                                   if(textelem.getName().equals(((Texts)leftelem).getRef()))
                                       textelem.setIsStop(true);
                                   else
                                       textelem.setIsStop(false);
                           }
                           else if (rightelem.getName().equals("win"))
                           {
                               for (Elements textelem : map.getAllElements())
                                   if(textelem.getName().equals(((Texts)leftelem).getRef()))
                                       textelem.setIsWin(true);
                                   else
                                       textelem.setIsWin(false);
                           }
                           else if (rightelem.getName().equals("sink"))
                           {
                               for (Elements textelem : map.getAllElements())
                                   if(textelem.getName().equals(((Texts)leftelem).getRef()))
                                       textelem.setIsSink(true);
                                   else
                                       textelem.setIsSink(false);
                           }

                       }
                   }
               }
           }

            for( Elements upelem : grid.getElementsAtPos(i.getPosX(), i.getPosY() -1))
            {
                if(upelem instanceof Texts)
                {
                    for (Elements downelem : grid.getElementsAtPos(i.getPosX() , i.getPosY() +1))
                    {
                        if (downelem instanceof Action || downelem instanceof Texts)
                        {
                            if (downelem.getName().equals("you"))
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Texts)upelem).getRef()))
                                        textelem.setIsYou(true);
                                    else
                                        textelem.setIsYou(false);

                            else if (downelem.getName().equals("push"))
                            {
                                for (Elements textelem : map.getAllElements())
                                    if(textelem.getName().equals(((Texts)upelem).getRef()))
                                        textelem.setIsPush(true);
                                    else
                                        textelem.setIsPush(false);
                            }
                            else if (downelem.getName().equals("stop"))
                            {
                                for (Elements textelem : map.getAllElements())
                                    if(textelem.getName().equals(((Texts)upelem).getRef()))
                                        textelem.setIsStop(true);
                                    else
                                        textelem.setIsStop(false);
                            }
                            else if (downelem.getName().equals("win"))
                            {
                                for (Elements textelem : map.getAllElements())
                                    if(textelem.getName().equals(((Texts)upelem).getRef()))
                                        textelem.setIsWin(true);
                                    else
                                        textelem.setIsWin(false);
                            }
                        }
                    }
                }
            }
        }
    }
}
