package step2.view;


import step2.domain.*;

import java.util.stream.Collectors;

public class OutputView {
    public static final String PRINT_LADDER_RESULT = "사다리 결과";
    public static final String PRINT__RESULT = "실행 결과";
    private static final String HEIGHT_LINE = "|";
    private static final String PLAY_LINE = "-----";
    private static final String PLAY_NO_LINE = "     ";

    private OutputView() {
    }

    public static void printLadderResult() {
        System.out.println(PRINT_LADDER_RESULT);
    }

    public static void printResult() {
        System.out.println(PRINT__RESULT);
    }

    public static void printPlayers(Players players) {
        System.out.print("     ");
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
        line.getLadderPoints()
                .forEach(ladderPoint -> appendLine(ladder, ladderPoint.getDirection()));
        ladder.append("\n");
    }

    private static void appendLine(StringBuilder ladder, Direction direction) {
        if (direction == Direction.LEFT) {
            ladder.append(PLAY_LINE);
            ladder.append(HEIGHT_LINE);
            return;
        }
        ladder.append(PLAY_NO_LINE);
        ladder.append(HEIGHT_LINE);
    }

    public static void printRewards(Rewards rewards) {
        System.out.print("     ");
        System.out.println(rewards.getRewards()
                .stream()
                .map(Reward::getName)
                .map(name -> String.format("%-6s", name))
                .collect(Collectors.joining()));
    }

}
