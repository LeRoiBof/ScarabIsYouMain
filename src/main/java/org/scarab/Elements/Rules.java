package org.scarab.Elements;

import org.scarab.Grid;
import org.scarab.Map;

public class Rules
{
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
