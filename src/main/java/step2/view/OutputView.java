package step2.view;

import step2.domain.Ladder;
import step2.domain.Line;
import step2.domain.Player;
import step2.domain.Players;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    public static final String PRINT_RESULT = "실행 결과";
    private static final String HEIGHT_LINE = "|";
    private static final String PLAY_LINE = "-----";
    private static final String PLAY_NO_LINE = "     ";
    public static final int DEFAULT_BLANK_LENGTH = 6;


    public static void printResult() {
        System.out.println(PRINT_RESULT);
    }

    public static void printPlayers(Players players) {
        System.out.println(players.getPlayers()
                .stream()
                .map(Player::getName)
                .map(name -> String.format("%-6s", name))
                .collect(Collectors.joining()));
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        ladder.getLines()
                .forEach(line -> lineBuilder(sb, line));
        System.out.println(sb);
    }

    private static void lineBuilder(StringBuilder ladder, Line line) {
        ladder.append(HEIGHT_LINE);
        line.getPoints()
                .forEach(b -> appendLine(ladder, b));
        ladder.append("\n");
    }

    private static void appendLine(StringBuilder ladder, Boolean existLine) {
        if (existLine) {
            ladder.append(PLAY_LINE);
            ladder.append(HEIGHT_LINE);
            return;
        }
        ladder.append(PLAY_NO_LINE);
        ladder.append(HEIGHT_LINE);
    }
}
