package ladder.view;

import ladder.domain.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String LADDER_PIPE = "|";
    private static final String LADDER_LINE = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String RESULT_EMPTY = "   ";
    private static final String ENTER = "\n";
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String GAME_RESULT = "실행 결과";
    private static final String TARGET_ALL = "all";

    public static void printPlayers(Players players) {
        System.out.printf(ENTER);
        System.out.println(LADDER_RESULT);
        System.out.printf(RESULT_EMPTY);
        System.out.println(
                players.getPlayers()
                        .stream()
                        .map(Player::getName)
                        .collect(Collectors.joining(RESULT_EMPTY)));
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder output = new StringBuilder();
        int sizeOfColumn = ladder.getCountOfColumn();
        ladder.getRows()
                .forEach(row -> {
                    output.append(LADDER_EMPTY);
                    output.append(generateLinePrinting(row, sizeOfColumn - 1));
                    output.append(LADDER_PIPE);
                    output.append(ENTER);
                });
        System.out.printf(output.toString());
    }

    public static void printRewards(Rewards rewards) {
        System.out.printf(RESULT_EMPTY);
        System.out.println(
                rewards.getRewards()
                        .stream()
                        .collect(Collectors.joining(RESULT_EMPTY)));
    }

    public static void printGameResult(String resultTarget, GameResult gameResult) {
        validateTarget(resultTarget, gameResult);
        System.out.printf(ENTER);
        System.out.println(GAME_RESULT);
        if (TARGET_ALL.equals(resultTarget)) {
            System.out.println(gameResult);
            return;
        }
        System.out.println(gameResult.getResult(resultTarget));
    }

    private static String generateLinePrinting(Row row, int column) {
        StringBuilder output = new StringBuilder();
        IntStream
                .range(0, column)
                .forEach(col -> {
                    output.append(LADDER_PIPE);
                    output.append(row.hasLine(col) ? LADDER_LINE : LADDER_EMPTY);
                });
        return output.toString();
    }

    private static void validateTarget(String target, GameResult gameResult) {
        if (!gameResult.getResult(target).isPresent() && !TARGET_ALL.equals(target)) {
            throw new IllegalArgumentException("입력한 참가자 이름이 없습니다.");
        }
    }
}
