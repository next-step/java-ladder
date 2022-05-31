package ladder.view;

import ladder.domain.Rewards;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    public static void showLadderResult(Players players, Ladder ladder, Rewards rewards) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();

        showPlayers(players);

        showLadder(ladder);
        
        showResultValue(rewards);
    }

    private static void showPlayers(Players players) {
        players.getPlayers().stream()
                .forEach(player ->
                        { System.out.print(String.format("%7s", player.toString())); }
                );

        System.out.println();
    }

    private static void showLadder(Ladder ladder) {
        int height = ladder.getLines().size();
        for (int i = 0; i < height; i++) {
            Line line = ladder.getLines().get(i);
            showLine(line);
        }
    }

    private static void showLine(Line line) {
        List<Boolean> nowLine = line.getSpotList();

        System.out.print(String.format("%7s", "|"));
        for (Boolean isLine : nowLine) {
            showValidLine(isLine);
            System.out.print("|");
        }
        System.out.println();
    }

    public static void showValidLine(Boolean isLine) {
        if (isLine) {
            showContent("-");
            return;
        }
        showContent(" ");
    }

    private static void showContent(String contents) {
        IntStream.range(0, 6).mapToObj(j -> contents).forEach(System.out::print);
    }

    private static void showResultValue(Rewards rewards) {
        rewards.getResultValues().stream()
                .forEach(reward ->
                        { System.out.print(String.format("%7s", reward)); }
                );
        System.out.println();
        System.out.println();
    }

    public static void showRewardResultMessage() {
        System.out.println();
        System.out.println("실행결과");
    }
    public static void showRewardOnePlayer(Rewards rewards, int reward) {
        System.out.println(rewards.getResultValues().get(reward));
    }

    public static void showRewardOnePlayer(Rewards rewards, int reward, Player player) {
        System.out.println(player.toString() + " : " + rewards.getResultValues().get(reward));
    }
}
