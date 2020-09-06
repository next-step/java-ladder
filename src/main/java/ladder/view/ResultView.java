package ladder.view;

import ladder.domain.line.Ladder;
import ladder.domain.line.LadderLine;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.point.Point;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

public class ResultView {
    private static final String PRINT_RESULT_MESSAGE = "실행 결과";
    private static final String PRINT_NAME_FORMAT = "%6s";
    private static final String PRINT_POINT_TRUE = "-----|";
    private static final String PRINT_POINT_FALSE = "     |";

    private ResultView() {}

    public static void printLadderResult(Players players, Ladder ladder) {
        System.out.println(PRINT_RESULT_MESSAGE);
        printPlayerNames(players);
        printLadder(ladder);
    }

    private static void printPlayerNames(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.print(String.format(PRINT_NAME_FORMAT, player.getName()));
        }
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        for (LadderLine line : ladder.getLines()) {
            printLadderLine(line);
            System.out.println();
        }
    }

    private static void printLadderLine(LadderLine ladderLine) {
        for (Point point : ladderLine.getPoints()) {
            System.out.print(point.isLeft() ? PRINT_POINT_TRUE : PRINT_POINT_FALSE);
        }
    }

    public static void printRewards(Rewards rewards) {
        for (Reward reward : rewards.getRewards()) {
            System.out.print(String.format(PRINT_NAME_FORMAT, reward.getPrize()));
        }
    }
}
