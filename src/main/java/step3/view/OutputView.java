package step3.view;

import step3.model.Ladder;
import step3.model.LadderGame;
import step3.model.Player;
import step3.model.Prize;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String WIDTH = "%6s";

    public static void viewLadder(LadderGame ladderGame, List<Player> players, List<Prize> prizes) {
        viewPlayers(players);

        ladderGame.getLines().forEach(line -> {
            System.out.print(Ladder.LINE_ONLY.getShape());
            System.out.print(line);
            System.out.println();
        });

        viewPrizes(prizes);
    }

    public static void viewPlayers(List<Player> players) {
        System.out.println(players.stream()
                .map(player -> nameFormat(player.getName()))
                .collect(Collectors.joining()));
    }

    public static void viewResult(List<String> ladderResult) {
        ladderResult.forEach(System.out::println);
    }

    public static void viewPrizes(List<Prize> prizes) {
        System.out.println(prizes.stream()
                .map(prize -> nameFormat(prize.getValue()))
                .collect(Collectors.joining()));
    }

    private static StringBuilder nameFormat(String name) {
        return new StringBuilder().append(String.format(WIDTH, name));
    }
}
