package step4.view;

import step4.domain.*;

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
    private static final String ALL_TEXT = "all";

    public static void printLadderGame(Users users, Ladders ladder, Results results) {
        System.out.println(RESULT_TEXT);
        printNames(users);
        printLadders(ladder);
        printResults(results);
    }

    public static void printLadders(Ladders ladder) {
        for (LadderLevel lines : ladder.ladderLevels()) {
            System.out.print(System.lineSeparator() + BLANK.repeat(3));
            printLines(lines);
            System.out.print(LADDER_SHAPE);
        }
        System.out.println();
    }

    private static void printLines(LadderLevel lines) {
        for (Line line : lines.getLines()) {
            System.out.print(LADDER_SHAPE);
            System.out.print(getLine(line.isLine()));
        }
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

    public static void printLadderGameResults(String selectedPerson, GameResult gameResult) {
        System.out.println(GAME_RESULT_PRINT_TEXT);
        if (selectedPerson.equals(ALL_TEXT)) {
            printLadderGameAllResults(gameResult.getGameResults());
        } else {
            System.out.println(gameResult.getGameResults().get(selectedPerson));
        }
    }

    public static void printLadderGameAllResults(Map<String, String> gameResult) {
        for (String key : gameResult.keySet()) {
            System.out.println(key + RESULT_PRINT_SEPARATOR + gameResult.get(key));
        }
    }
}
