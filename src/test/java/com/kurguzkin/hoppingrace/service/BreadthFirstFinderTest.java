package com.kurguzkin.hoppingrace.service;

import com.kurguzkin.hoppingrace.domain.Obstacle;
import com.kurguzkin.hoppingrace.domain.TestCase;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstFinderTest {

    private static final Logger log = LoggerFactory.getLogger(BreadthFirstFinderTest.class);

    @Test
    void line2Test() {
        TestCase testCase = new TestCase(2, 1, 0, 0, 1, 0, List.of());
        int hopsNumber = BreadthFirstFinder.getHopsNumber(testCase, 3);

        log.trace("hops number: {}", hopsNumber);
        assertEquals(1, hopsNumber);
    }

    @Test
    void line3Test() {
        TestCase testCase = new TestCase(3, 1, 0, 0, 2, 0, List.of());
        int hopsNumber = BreadthFirstFinder.getHopsNumber(testCase, 3);

        log.trace("hops number: {}", hopsNumber);
        assertEquals(2, hopsNumber);
    }

    @Test
    void line5withObstacleTest() {
        Obstacle obstacle = new Obstacle(2, 3, 0, 0);
        TestCase testCase = new TestCase(5, 1, 0, 0, 4, 0, List.of(obstacle));
        int hopsNumber = BreadthFirstFinder.getHopsNumber(testCase, 3);

        log.trace("hops number: {}", hopsNumber);
        assertEquals(-1, hopsNumber);
    }


    @Test
    void square3x3withObstacleTest() {
        Obstacle obstacle = new Obstacle(1, 1, 1, 1);
        TestCase testCase = new TestCase(3, 3, 0, 0, 2, 2, List.of(obstacle));
        int hopsNumber = BreadthFirstFinder.getHopsNumber(testCase, 3);

        log.trace("hops number: {}", hopsNumber);
        assertEquals(3, hopsNumber);
    }

}