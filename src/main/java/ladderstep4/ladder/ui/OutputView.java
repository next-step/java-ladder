package ladderstep4.ladder.ui;

import ladderstep4.ladder.domain.*;
import ladderstep4.ladder.util.function.MathFunction;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String REWARD_RESULT_MESSAGE = "실행 결과";
    private static final int NAME_PADDING = 6;
    private static final char SPACE = ' ';
    private static final String TWO_SPACE = "  ";
    private static final String EMPTY_DELIMITER = "";
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final int STRING_BUILDER_DEFAULT_LENGTH = 0;
    private static final String RAIL_VALUE = "|";
    private static final String RUNG_VALUE = "-----";
    private static final String EMPTY_RUNG_VALUE = "     ";
    private static final String PRINT_ALL_FORMAT = "%s : %s\n";
    private static final String LINE_BREAK = "\n";

    private OutputView() {}

    public static void printLadderGame(Players players, Ladder2 ladder2, Prizes prizes) {
        enter();
        System.out.println(LADDER_RESULT_MESSAGE);
        enter();
        printPlayers(players);
        printLadders(ladder2);
        printPrizes(prizes);
    }

    private static void printPlayers(Players players) {
        List<Player> nameList = players.getValues();
        System.out.println(nameList.stream()
                .map(player -> padding(player.getName()))
                .collect(Collectors.joining(EMPTY_DELIMITER)));
    }

    private static String padding(String name) {
        clearStringBuilder();
        STRING_BUILDER.append(name);
        while (STRING_BUILDER.length() < NAME_PADDING) {
            append();
        }
        return STRING_BUILDER.toString();
    }

    private static void append() {
        if (MathFunction.EVEN_NUMBER.test(STRING_BUILDER.length())) {
            STRING_BUILDER.append(SPACE);
            return;
        }

        STRING_BUILDER.insert(STRING_BUILDER_DEFAULT_LENGTH, SPACE);
    }

    private static void printLadders(Ladder2 ladder2) {
        clearStringBuilder();
        List<LadderLine> ladderLines = ladder2.getLadderLines();
        for (LadderLine ladderLine : ladderLines) {
            STRING_BUILDER.append(TWO_SPACE).append(RAIL_VALUE);
            printLadderLine(ladderLine);
        }
        System.out.println(STRING_BUILDER);
    }

    private static void printLadderLine(LadderLine ladderLine) {
        List<Point> points = ladderLine.getPoints();
        for (int i = 0; i < points.size() - 1; i++) {
            printPoints(points, i);
        }
        STRING_BUILDER.append(LINE_BREAK);
    }

    private static void printPoints(List<Point> points, int i) {
        if (points.get(i).getMoveDirection().canMoveRight()) {
            STRING_BUILDER.append(RUNG_VALUE).append(RAIL_VALUE);
            return;
        }
        STRING_BUILDER.append(EMPTY_RUNG_VALUE).append(RAIL_VALUE);
    }

    private static void printPrizes(Prizes prizes) {
        List<Prize> values = prizes.getValues();
        System.out.println(values.stream()
                .map(prize -> padding(prize.value()))
                .collect(Collectors.joining(EMPTY_DELIMITER)));
    }

    public static void printResult(Prize prize) {
        System.out.println(REWARD_RESULT_MESSAGE);
        System.out.println(prize.value());
    }

    public static void printResults(ResultMatcher resultMatcher) {
        resultMatcher.getPlayers()
                .forEach(player ->
                        System.out.printf(
                                PRINT_ALL_FORMAT,
                                player.getName(), resultMatcher.match(player.getName()).value()));
    }

    private static void enter() {
        System.out.println();
    }

    private static void clearStringBuilder() {
        STRING_BUILDER.setLength(STRING_BUILDER_DEFAULT_LENGTH);
    }
}
