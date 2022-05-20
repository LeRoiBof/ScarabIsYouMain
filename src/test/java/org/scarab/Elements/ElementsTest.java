package org.scarab.Elements;

import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.Test;
import org.scarab.Map;

import static org.junit.jupiter.api.Assertions.*;
public class ElementsTest
{
    @Test
    void testJeu(){
        assertTrue(true);
    }

    @Test
    void testMove(){
        Map map = new Map("src/main/resources/maps/map0.txt");
        Elements baba = map.getGrid().getElementsAtPos(6,9).get(0);
        int x = baba.getPosX();
        int y = baba.getPosY();
        Rules.updaterules(map);

        baba.move(KeyCode.DOWN, map.getGrid());
        baba.move(KeyCode.DOWN, map.getGrid());
        baba.move(KeyCode.DOWN, map.getGrid());
        baba.move(KeyCode.DOWN, map.getGrid());
        baba.move(KeyCode.DOWN, map.getGrid());
        baba.move(KeyCode.DOWN, map.getGrid());

        assertEquals(x, baba.getPosX());
        assertEquals(y, baba.getPosY() - 1);

    }


}
