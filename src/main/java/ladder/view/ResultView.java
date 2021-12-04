package ladder.view;

import ladder.model.Line;
import ladder.model.Player;

import java.util.List;

public class ResultView {

    public static void printResult(List<Player> players, List<Line> lineList) {
        System.out.println("실행결과");
        System.out.println();
        printPlayerName(players);
        printLineList(lineList);
    }

    private static void printPlayerName(List<Player> players) {
        players.forEach(player -> System.out.printf("%5s ", player.name()));
        System.out.println();
    }

    private static void printLineList(List<Line> lineList) {
        lineList.forEach((line) -> {
            line.draw().forEach(System.out::print);
            System.out.println();
        });
    }
}
