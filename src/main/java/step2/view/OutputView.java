package step2.view;

import step2.model.Ladder;
import step2.model.LadderGame;
import step2.model.Player;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String WIDTH = "%6s";

    public static void viewLadder(LadderGame ladderGame, List<Player> players) {
        viewPlayers(players);

        ladderGame.getLines().forEach(line -> {
            System.out.print(Ladder.LINE_ONLY.getShape());
            System.out.print(line);
            System.out.println();
        });
    }

    public static void viewPlayers(List<Player> players) {
        System.out.println(players.stream()
                .map(player -> nameFormat(player.getName()))
                .collect(Collectors.joining()));
    }

    private static StringBuilder nameFormat(String name) {
        return new StringBuilder().append(String.format(WIDTH, name));
    }
}
