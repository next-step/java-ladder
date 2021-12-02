package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

public class OutputView {
    private static final String COL = "|";
    private static final String LINE = "----";
    private static final String EMPTY_LINE = "    ";

    private OutputView() {
    }

    public static void printLadder(Players players, Ladder ladder) {
        printPlayers(players);

        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            System.out.print(COL);
            List<Point> points = line.getPoints();
            printPoints(points);
        }
    }

    private static void printPoints(List<Point> points) {
        for (Point point : points) {
            if (point.isTrue()) {
                System.out.print(LINE);
            } else {
                System.out.print(EMPTY_LINE);
            }
            System.out.print(COL);
        }
        System.out.println();
    }

    private static void printPlayers(Players players) {
        List<Player> playerList = players.playersName();
        for (Player player : playerList) {
            System.out.printf("%-6s",player.getName());
        }
        System.out.println();
    }
}
