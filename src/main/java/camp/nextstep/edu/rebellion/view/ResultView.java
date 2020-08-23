package camp.nextstep.edu.rebellion.view;

import camp.nextstep.edu.rebellion.domain.ladder.Ladder;
import camp.nextstep.edu.rebellion.domain.ladder.Row;
import camp.nextstep.edu.rebellion.domain.player.Player;
import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.reward.Reward;
import camp.nextstep.edu.rebellion.domain.reward.RewardResults;
import camp.nextstep.edu.rebellion.domain.reward.Rewards;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String LADDER_PIPE = "|";
    private static final String LADDER_HORIZON_LINE = "-----";
    private static final String LADDER_HORIZON_EMPTY = "     ";
    private static final String REWARD_TITLE = "실행결과";
    private static final String ENTER = "\n";

    public static void printAll(Players players, Rewards rewards, Ladder ladder) {
        printPlayers(players);
        printLadder(ladder);
        printRewards(rewards);
    }

    public static void printRewardResults(RewardResults rewardResults) {
        StringBuilder output = new StringBuilder();
        output.append(REWARD_TITLE).append(ENTER);
        rewardResults.getRewardResults()
                .forEach(r -> output.append(r.getName() + ":" + r.getReward()).append(ENTER));
        System.out.println(output.toString());
    }

    private static void printPlayers(Players players) {
        System.out.println(
                players.getPlayers()
                .stream()
                .map(Player::getName)
                .collect(Collectors.joining(LADDER_HORIZON_EMPTY)));
    }

    private static void printRewards(Rewards rewards) {
        System.out.println(
                rewards.getRewards()
                        .stream()
                        .map(Reward::getName)
                        .collect(Collectors.joining(LADDER_HORIZON_EMPTY)));
    }

    private static void printLadder(Ladder ladder) {
        StringBuilder output = new StringBuilder();
        int cols = ladder.getSizeOfPoints();

        ladder.getRows()
                .forEach(row -> {
                    output.append(generatePrintingRow(row, cols - 1));
                    output.append(LADDER_PIPE);
                    output.append(ENTER);
                });
        System.out.print(output.toString());
    }

    private static String generatePrintingRow(Row row, int cols) {
        StringBuilder output = new StringBuilder();
        IntStream
                .range(0, cols)
                .forEach(col -> {
                    output.append(LADDER_PIPE);
                    output.append(row.hasHorizonLine(col) ?
                            LADDER_HORIZON_LINE :
                            LADDER_HORIZON_EMPTY);
                });
        return output.toString();
    }
}
