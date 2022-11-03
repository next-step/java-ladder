package step3.view;

import step3.domain.*;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ResultView {

    private static final String LADDER_SHAPE = "|";
    private static final String LINE = "-";
    private static final String BLANK = " ";
    private static final String RESULT_TEXT = System.lineSeparator() + "사다리 결과" + System.lineSeparator();
    private static final int REPEAT_COUNT = 5;
    private static final String RESULT_PRINT_SEPARATOR = " : ";
    private static final String GAME_RESULT_PRINT_TEXT = System.lineSeparator() + "실행 결과";

    public static void printLadderGame(Users users, Ladder ladder, Results results) {
        System.out.println(RESULT_TEXT);
        printNames(users);
        printLadders(ladder);
        printResults(results);
    }

    public static void printLadders(Ladder ladder) {
        ladder.getLadders().stream()
                .forEach(floor -> {
                    System.out.print(System.lineSeparator() + BLANK.repeat(3));
                    printLines(floor);
                    System.out.print(LADDER_SHAPE);
                });
        System.out.println();
    }

    private static void printLines(Lines floor) {
        floor.getLines().stream()
                .forEach(isLine -> {
                    System.out.print(LADDER_SHAPE);
                    System.out.print(getLine(isLine.booleanValue()));
                });
    }

    private static String getLine(boolean isLine) {
        if (isLine) {
            return LINE.repeat(REPEAT_COUNT);
        }
        return BLANK.repeat(REPEAT_COUNT);
    }

    private static void printNames(Users users) {
        AtomicInteger index = new AtomicInteger();
        users.getNames().stream()
                .map(name -> getString(index, name))
                .forEach(System.out::print);
    }

    private static void printResults(Results results) {
        AtomicInteger index = new AtomicInteger();
        results.getResults().stream()
                .map(name -> getString(index, name))
                .forEach(System.out::print);
        System.out.println();
    }

    private static String getString(AtomicInteger index, String string) {
        if (index.getAndIncrement() != 0) {
            return BLANK.repeat(REPEAT_COUNT - string.length()).concat(string).concat(BLANK);
        }
        return string.concat(BLANK.repeat(REPEAT_COUNT - string.length())).concat(BLANK);
    }

    public static void printLadderGameResults(GameResult gameResult, Users users, Results results) {
        System.out.println(GAME_RESULT_PRINT_TEXT);
        Map<Integer, Integer> gameResults = gameResult.getGameResults();
        if (gameResults.size() == 1) {
            System.out.println(results.getResults().get(gameResults.get(0)));
        } else {
            printLadderGameAllResults(gameResults, users, results);
        }
    }

    public static void printLadderGameAllResults(Map<Integer, Integer> gameResult, Users users, Results results) {
        for (Integer key : gameResult.keySet()) {
            System.out.println(users.getNames().get(key) + RESULT_PRINT_SEPARATOR + results.getResults().get(gameResult.get(key)));
        }
    }
}
