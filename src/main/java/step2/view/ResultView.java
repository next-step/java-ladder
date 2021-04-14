package step2.view;

import step2.domain.Line;
import step2.domain.Player;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void printLadder(List<Line> lines) {
        lines.stream()
                .forEach(line -> {
                    System.out.print("\n     ");
                    System.out.print(line.toString());
                    System.out.print("|");
                });
    }

    public static void printPlayer(List<Player> players) {
        players.stream()
                .map(Player::getName)
                .forEach(System.out::print);
    }
}
