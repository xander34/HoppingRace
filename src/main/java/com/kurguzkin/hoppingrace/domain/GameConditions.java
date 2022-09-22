package com.kurguzkin.hoppingrace.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameConditions {

    public enum ReadStage {
        N_CASES, SIZE, START_FINISH, N_OBSTACLES, OBSTACLE
    }

    final public List<TestCase> testCases;

    public GameConditions(List<TestCase> testCases) {
        this.testCases = new ArrayList<>(testCases);
    }

    public static GameConditions readFromString(String inputString) {
        int nCases = 0, caseIndex = 0;
        int sizeX = 0, sizeY = 0, startX = 0, startY = 0, finishX = 0, finishY = 0;
        int nObstacles = 0, obstacleIndex=0;
        final List<Obstacle> obstacles = new LinkedList<>();

        ReadStage readStage = ReadStage.N_CASES;

        final List<TestCase> testCases = new LinkedList<>();

        String[] lines = inputString.split("\n");

        linesLoop: for (String line : lines) {

            switch (readStage) {
                case N_CASES:
                    nCases = Integer.parseInt(line.trim());
                    readStage = ReadStage.SIZE;
                    break;
                case SIZE:
                    String[] sizeNumbers = line.trim().split(" ");
                    sizeX = Integer.parseInt(sizeNumbers[0]);
                    sizeY = Integer.parseInt(sizeNumbers[1]);
                    readStage = ReadStage.START_FINISH;
                    break;
                case START_FINISH:
                    String[] startFinishNumbers = line.trim().split(" ");
                    startX = Integer.parseInt(startFinishNumbers[0]);
                    startY = Integer.parseInt(startFinishNumbers[1]);
                    finishX = Integer.parseInt(startFinishNumbers[2]);
                    finishY = Integer.parseInt(startFinishNumbers[3]);
                    readStage = ReadStage.N_OBSTACLES;
                    break;
                case N_OBSTACLES:
                    nObstacles = Integer.parseInt(line.trim());
                    readStage = ReadStage.OBSTACLE;
                    break;
                case OBSTACLE:
                    String[] obstacleNumbers = line.trim().split(" ");
                    int obstacleStartX = Integer.parseInt(obstacleNumbers[0]);
                    int obstacleEndX = Integer.parseInt(obstacleNumbers[1]);
                    int obstacleStartY = Integer.parseInt(obstacleNumbers[2]);
                    int obstacleEndY = Integer.parseInt(obstacleNumbers[3]);
                    obstacles.add(new Obstacle(obstacleStartX, obstacleEndX, obstacleStartY, obstacleEndY));
                    obstacleIndex++;
                    if (obstacleIndex >= nObstacles) { // all obstacles have been read

                        testCases.add(new TestCase(sizeX, sizeY, startX, startY, finishX, finishY, obstacles));

                        // re-initialize test case variables
                        obstacles.clear();
                        obstacleIndex = 0;

                        readStage = ReadStage.SIZE;
                        caseIndex++;
                        if (caseIndex >= nCases) { // all cases have been read
                            break linesLoop;
                        }
                    }
                    break;
            }

        } // linesLoop

        return new GameConditions(testCases);
    }

    @Override
    public String toString() {
        return "GameConditions{" +
                "testCases=" + testCases +
                '}';
    }
}
