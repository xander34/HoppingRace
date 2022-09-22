package com.kurguzkin.hoppingrace.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameConditionsTest {

    @Test
    void gameConditionsTest() {

        String testInput = "2\n" +
                "5 5\n" +
                "4 0 4 4\n" +
                "1\n" +
                "1 4 2 3\n" +
                "3 3\n" +
                "0 0 2 2\n" +
                "2\n" +
                "1 1 0 2\n" +
                "0 2 1 1\n";

        GameConditions gameConditions = GameConditions.readFromString(testInput);
        assertEquals(2, gameConditions.testCases.size());
        TestCase case1 = gameConditions.testCases.get(0);
        assertEquals(5, case1.sizeX);
        assertEquals(5, case1.sizeY);
        assertEquals(4, case1.startX);
        assertEquals(0, case1.startY);
        assertEquals(4, case1.finishX);
        assertEquals(4, case1.finishY);

        assertEquals(1, case1.obstacles.size());
        Obstacle ob1 = case1.obstacles.get(0);
        assertEquals(1, ob1.startX);
        assertEquals(4, ob1.endX);
        assertEquals(2, ob1.startY);
        assertEquals(3, ob1.endY);


        assertEquals(3, gameConditions.testCases.get(1).sizeX);
        assertEquals(3, gameConditions.testCases.get(1).sizeY);
        assertEquals(2, gameConditions.testCases.get(1).obstacles.size());

    }

}