package ladder.view;

import ladder.domain.*;

public class OutputView {
    private static final String PRINT_RESULT_MESSAGE = "실행 결과";
    private static final String PLAYER_FORMAT = "%6s";
    private static final String PRINT_POINT_TRUE = "|-----";
    private static final String PRINT_POINT_FALSE = "|     ";
    private static final String PRINT_POINT_FIRST = "     ";

    public static void printResult(Players players, Rewards rewards, Ladder ladder) {
        printResultMessage();
        printPlayerNames(players);
        printLadder(ladder);
        printRewards(rewards);
    }

    private static void printResultMessage() {
        System.out.println(PRINT_RESULT_MESSAGE);
    }

    private static void printPlayerNames(Players players) {
        players.getPlayers().forEach(player ->
                System.out.print(String.format(PLAYER_FORMAT, player.getName()))
        );
        System.out.println();
    }

    private static void printRewards(Rewards rewards) {
        rewards.getRewards().forEach(reward ->
                System.out.print(String.format(PLAYER_FORMAT, reward.getReward()))
        );
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(line -> {
                    System.out.print(PRINT_POINT_FIRST);
                    printLine(line);
                    System.out.println();
                });
    }

    private static void printLine(Line line) {
        line.getPoints()
                .forEach(point -> System.out.print(decidePoint(point)));
    }

    private static String decidePoint(Point point) {
        if (point.getDirection().isRight()) {
            return PRINT_POINT_TRUE;
        }
        return PRINT_POINT_FALSE;
    }
}
