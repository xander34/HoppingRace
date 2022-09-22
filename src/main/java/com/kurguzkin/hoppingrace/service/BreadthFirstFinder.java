package com.kurguzkin.hoppingrace.service;

import com.kurguzkin.hoppingrace.domain.TestCase;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BreadthFirstFinder {

    public static class Situation {

        public final int x, y, vx, vy, nHop;

        public Situation(int x, int y, int vx, int vy, int nHop) {
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
            this.nHop = nHop;
        }

        public String key() {
            return String.format("%s_%s_%s_%s", x, y, vx, vy);
        }
    }

    public static String find(TestCase testCase, int maxSpeed) {
        int result = getHopsNumber(testCase, maxSpeed);
        if (result > -1) return String.format("Optimal solution takes %d hops", result);
        return "No solution";
    }

    /**
     * Gets through possible situations using Breadth First graph traversal approach. Memoization used to
     * avoid cycles.
     * @param testCase test case game data
     * @param maxSpeed limit of hopper speed
     * @return -1 if finish is unreachable, best number of hops otherwise
     */
    public static int getHopsNumber(TestCase testCase, int maxSpeed) {

        Deque<Situation> situations = new LinkedList<>();
        Set<String> memory = new HashSet<>();

        // adding initial node
        situations.add(new Situation(testCase.startX, testCase.startY, 0, 0, 0));

        while (!situations.isEmpty()) {
            Situation situation = situations.pollFirst();

            // base cases

            if (Math.abs(situation.vx) > maxSpeed || Math.abs(situation.vy) > maxSpeed) continue; // too fast
            if (situation.x < 0 || situation.x >= testCase.sizeX
                    || situation.y < 0 || situation.y >= testCase.sizeY) continue; // outside borders
            if (testCase.isObstacle(situation.x, situation.y)) continue; // inside obstacle
            if (memory.contains(situation.key())) continue; // been there

            // final base case - race finished!
            if (situation.x == testCase.finishX && situation.y == testCase.finishY) {
                return situation.nHop;
            }

            // iterate and add next nodes

            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    int newVx = situation.vx + dx;
                    int newVy = situation.vy + dy;
                    int newX = situation.x + newVx;
                    int newY = situation.y + newVy;
                    Situation newSituation = new Situation(newX, newY, newVx, newVy, situation.nHop + 1);
                    situations.add(newSituation);
                }
            }

            // memorization

            memory.add(situation.key());

        }

        return -1;
    }
}
