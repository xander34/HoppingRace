package com.kurguzkin.hoppingrace.domain;

public class Obstacle {

    public final int startX, endX, startY, endY;

    public Obstacle(int startX, int endX, int startY, int endY) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }

    public boolean isObstacle(int x, int y) {
        return x >= startX && x <= endX && y >= startY && y <= endY;
    }

    @Override
    public String toString() {
        return "Obstacle{" +
                "startX=" + startX +
                ", endX=" + endX +
                ", startY=" + startY +
                ", endY=" + endY +
                '}';
    }
}