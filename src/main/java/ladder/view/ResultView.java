package ladder.view;

import ladder.model.Line;
import ladder.model.Player;

import java.util.List;

public class ResultView {

    public static void printPlayerName(List<Player> players) {
        players.forEach(player -> System.out.printf("%5s ", player.name()));
        System.out.println();
    }

    public static void printLineList(List<Line> lineList) {
        lineList.forEach((line) -> {
            line.draw().forEach(System.out::print);
            System.out.println();
        });
    }
}
