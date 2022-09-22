package com.kurguzkin.hoppingrace;

import com.kurguzkin.hoppingrace.domain.GameConditions;
import com.kurguzkin.hoppingrace.service.BreadthFirstFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static final String INPUT_STRING = "2\n" +
            "5 5\n" +
            "4 0 4 4\n" +
            "1\n" +
            "1 4 2 3\n" +
            "3 3\n" +
            "0 0 2 2\n" +
            "2\n" +
            "1 1 0 2\n" +
            "0 2 1 1\n";

    public static final int MAX_SPEED = 3;

    public static void main(String[] args) {

        GameConditions gameConditions = GameConditions.readFromString(INPUT_STRING);

        log.info("Game conditions: {}", gameConditions);

        gameConditions.testCases.forEach(testCase -> log.info(BreadthFirstFinder.find(testCase, MAX_SPEED)));
    }
}
