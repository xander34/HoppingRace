package com.kurguzkin.hoppingrace.domain;

import java.util.ArrayList;
import java.util.List;

public class TestCase {

    public final int sizeX, sizeY;
    public final int startX, startY, finishX, finishY;
    public final List<Obstacle> obstacles;

    public TestCase(int sizeX, int sizeY, int startX, int startY, int finishX, int finishY, List<Obstacle> obstacles) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.startX = startX;
        this.startY = startY;
        this.finishX = finishX;
        this.finishY = finishY;
        this.obstacles = new ArrayList<>(obstacles);
    }

    public boolean isObstacle(int x, int y) {
        return obstacles.stream().anyMatch(obstacle -> obstacle.isObstacle(x, y));
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "sizeX=" + sizeX +
                ", sizeY=" + sizeY +
                ", startX=" + startX +
                ", startY=" + startY +
                ", finishX=" + finishX +
                ", finishY=" + finishY +
                ", obstacles=" + obstacles +
                '}';
    }
}
