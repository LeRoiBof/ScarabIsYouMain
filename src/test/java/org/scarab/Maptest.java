package org.scarab;

import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.Test;
import org.scarab.Map;

import static org.junit.jupiter.api.Assertions.*;

public class Maptest
{
    @Test

    void testmap()
    {

        Map map = new Map("src/main/resources/maps/map0.txt");
        Map map1 = new Map("src/test/resources/maps/maptest1.txt");
        Map map2 = new Map("src/test/resources/maps/maptest2.txt");

        assertNotEquals(map.getGrid(), null);
        assertEquals(map1.getGrid(), null);
        assertEquals(map2.getGrid(), null);

    }

}
