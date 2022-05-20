package org.scarab.Elements;

import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.Test;
import org.scarab.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RulesTest
{

    @Test
    void testRules(){
        Map map = new Map("src/main/resources/maps/map0.txt");
        Elements baba = map.getGrid().getElementsAtPos(6,9).get(0);
        Elements isstop = map.getGrid().getElementsAtPos(5,7).get(0);

        Rules.updaterules(map);
        boolean x = isstop.getIsStop();


        baba.move(KeyCode.LEFT, map.getGrid());
        baba.move(KeyCode.LEFT, map.getGrid());
        baba.move(KeyCode.LEFT, map.getGrid());
        baba.move(KeyCode.UP, map.getGrid());
        baba.move(KeyCode.UP, map.getGrid());
        baba.move(KeyCode.UP, map.getGrid());
        baba.move(KeyCode.RIGHT, map.getGrid());
        baba.move(KeyCode.RIGHT, map.getGrid());
        baba.move(KeyCode.UP, map.getGrid());
        baba.move(KeyCode.UP, map.getGrid());
        baba.move(KeyCode.DOWN, map.getGrid());
        baba.move(KeyCode.DOWN, map.getGrid());
        baba.move(KeyCode.DOWN, map.getGrid());

        isstop.setIsStop(false);
        Rules.updaterules(map);


        assertEquals(!x, isstop.getIsStop());

    }

    @Test
    void checkwin(){
        Map map = new Map("src/main/resources/maps/map0.txt");
        Elements baba = map.getGrid().getElementsAtPos(6,9).get(0);
        Elements iswin = map.getGrid().getElementsAtPos(14,13).get(0);


        baba.move(KeyCode.RIGHT, map.getGrid());
        baba.move(KeyCode.RIGHT, map.getGrid());
        baba.move(KeyCode.RIGHT, map.getGrid());
        baba.move(KeyCode.RIGHT, map.getGrid());
        baba.move(KeyCode.RIGHT, map.getGrid());
        baba.move(KeyCode.RIGHT, map.getGrid());
        baba.move(KeyCode.RIGHT, map.getGrid());

        Rules.updaterules(map);
        int res = Rules.check(map);
        assertEquals(res, 0);

    }
    @Test

    void testlose() {
        Map map = new Map("src/main/resources/maps/map0.txt");
        Elements baba = map.getGrid().getElementsAtPos(6, 9).get(0);
        Elements isyou = map.getGrid().getElementsAtPos(5, 13).get(0);


        baba.move(KeyCode.LEFT, map.getGrid());
        baba.move(KeyCode.LEFT, map.getGrid());
        baba.move(KeyCode.LEFT, map.getGrid());
        baba.move(KeyCode.DOWN, map.getGrid());
        baba.move(KeyCode.DOWN, map.getGrid());
        baba.move(KeyCode.DOWN, map.getGrid());
        baba.move(KeyCode.RIGHT, map.getGrid());
        baba.move(KeyCode.RIGHT, map.getGrid());
        baba.move(KeyCode.DOWN, map.getGrid());
        baba.move(KeyCode.DOWN, map.getGrid());

        Rules.updaterules(map);
        int res = Rules.check(map);
        assertEquals(res, 3);

    }

}
