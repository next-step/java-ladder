package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;

import java.util.List;

public class OutputView {

    private static final int NAME_WIDTH = 6;

    public static void printPlayers(List<Player> players) {
        for (Player player : players) {
            System.out.printf("%" + NAME_WIDTH + "." + NAME_WIDTH + "s",
                    player.getName());
        }
        System.out.println();
    }

    public static void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        System.out.print("    |");
        line.getPoints().forEach(
                point -> System.out.print(point ? "-----|" : "     |")
        );
        System.out.println();
    }
}
