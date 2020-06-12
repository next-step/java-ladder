package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;

public class OutputView {
    private static final String PRINT_RESULT_MESSAGE = "실행 결과";
    private static final String PLAYER_NAME_FORMAT = "%6s";
    private static final String PRINT_POINT_TRUE = "-----|";
    private static final String PRINT_POINT_FALSE = "     |";

    public static void printResult(Players players, Ladder ladder) {
        printResultMessage();
        printPlayerNames(players);
        printLadder(ladder);
    }

    private static void printResultMessage() {
        System.out.println(PRINT_RESULT_MESSAGE);
    }

    private static void printPlayerNames(Players players) {
        players.getPlayers().forEach(player ->
                System.out.print(String.format(PLAYER_NAME_FORMAT, player.getName()))
        );
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(line -> {
                    line.getPoints().forEach(point -> {
                        if (point.isPoint()) {
                            System.out.print(PRINT_POINT_TRUE);
                        } else {
                            System.out.print(PRINT_POINT_FALSE);
                        }
                    });
                    System.out.println();
                });
    }
}
