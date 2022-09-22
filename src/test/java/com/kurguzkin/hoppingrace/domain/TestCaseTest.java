package com.kurguzkin.hoppingrace.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestCaseTest {

    @Test
    void testCaseTest() {
        List<Obstacle> obstacles = List.of(
                new Obstacle(1, 1, 1, 1),
                new Obstacle(2, 2, 2, 2)
        );
        TestCase testCase = new TestCase(4, 4, 0, 0, 3, 3, obstacles);

        assertFalse(testCase.isObstacle(0, 0));
        assertTrue(testCase.isObstacle(1, 1));
        assertTrue(testCase.isObstacle(2, 2));
        assertFalse(testCase.isObstacle(3, 3));
    }

}