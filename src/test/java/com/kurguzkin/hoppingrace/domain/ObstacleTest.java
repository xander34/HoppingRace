package com.kurguzkin.hoppingrace.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObstacleTest {

    @Test
    void obstacleTest() {

        Obstacle obstacle = new Obstacle(1, 1, 1, 1);

        assertFalse(obstacle.isObstacle(0, 0));
        assertTrue(obstacle.isObstacle(1, 1));
        assertFalse(obstacle.isObstacle(2, 2));
    }


}