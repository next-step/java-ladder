package ladder.view;

import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.GameResults;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;
import ladder.game.Ladder;
import ladder.tdd.LadderLine;

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

    public static void printAll(Players players, Rewards rewards, Ladder ladder) {
        printPlayers(players);
        printLadder(ladder);
        printRewards(rewards);
    }

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

        ladder.getLadderLines()
                .forEach(ladderLine -> {
                    output.append(LADDER_EMPTY);
                    output.append(generateLinePrinting(ladderLine, sizeOfColumn - 1));
                    output.append(LADDER_PIPE);
                    output.append(ENTER);
                });
        System.out.printf(output.toString());
    }

    private static void printRewards(Rewards rewards) {
        System.out.printf(RESULT_EMPTY);
        System.out.println(
                rewards.getRewards()
                        .stream()
                        .map(Reward::getName)
                        .collect(Collectors.joining(RESULT_EMPTY)));
    }

    public static void printGameResults(GameResults gameResults) {
        StringBuilder output = new StringBuilder();
        output.append(GAME_RESULT).append(ENTER);
        gameResults.getGameResults()
                .forEach(result -> output.append(result.getName() + ":" + result.getReward()).append(ENTER));
        System.out.println(output.toString());
    }

    private static String generateLinePrinting(LadderLine ladderLine, int column) {
        StringBuilder output = new StringBuilder();
        IntStream
                .range(0, column)
                .forEach(col -> {
                    output.append(LADDER_PIPE);
                    output.append(ladderLine.hasLine(col) ? LADDER_LINE : LADDER_EMPTY);
                });
        return output.toString();
    }

}
