package ladder.view;

import ladder.domain.line.Ladder;
import ladder.domain.line.LadderLine;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.point.Point;
import ladder.domain.result.LadderResult;
import ladder.domain.result.LadderResults;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

public class ResultView {
    private static final String PRINT_RESULT_MESSAGE = "실행 결과";
    private static final String PRINT_LADDER_MESSAGE = "사다리 결과";
    private static final String PRINT_NAME_FORMAT = "%6s";
    private static final String PRINT_POINT_TRUE = "-----|";
    private static final String PRINT_POINT_FALSE = "     |";
    private static final String ALL_PLAYERS = "all";

    private ResultView() {}

    public static void printLadderResult(Players players, Ladder ladder) {
        System.out.println(PRINT_LADDER_MESSAGE);
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
            System.out.print(point.getDirection().isLeft() ? PRINT_POINT_TRUE : PRINT_POINT_FALSE);
        }
    }

    public static void printRewards(Rewards rewards) {
        for (Reward reward : rewards.getRewards()) {
            System.out.print(String.format(PRINT_NAME_FORMAT, reward.getPrize()));
        }
        System.out.println();
    }

    public static void printResults(String playerName, LadderResults ladderResults) {
        System.out.println();
        System.out.println(PRINT_RESULT_MESSAGE);

        if (ALL_PLAYERS.equals(playerName)) {
            printResultAll(ladderResults);
            return;
        }

        printResultByName(playerName, ladderResults);
    }

    private static void printResultByName(String name, LadderResults ladderResults) {
        LadderResult result = ladderResults.findByName(name);
        System.out.println(result.getRewardPrize());
    }

    private static void printResultAll(LadderResults ladderResults) {
        for (LadderResult ladderResult : ladderResults.getLadderResults()) {
            System.out.println(ladderResult.toString());
        }
    }
}
