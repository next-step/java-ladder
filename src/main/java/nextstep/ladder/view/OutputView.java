package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

public class OutputView {
    private static final String COL = "|";
    private static final String LINE = "----";
    private static final String EMPTY_LINE = "    ";
    private static String PLAYERS_COUNT_ERROR_MESSAGE = "최소 2명 이상 입력하세요";

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
            printPoint(point);
        }
        System.out.println();
    }

    private static void printPoint(Point point) {
        if (point.isTrue()) {
            System.out.print(LINE);
            System.out.print(COL);
            return;
        }
        System.out.print(EMPTY_LINE);
        System.out.print(COL);
    }

    private static void printPlayers(Players players) {
        List<Player> playerList = players.playersName();
        for (Player player : playerList) {
            System.out.printf("%-6s",player.getName());
        }
        System.out.println();
    }

    public static void printPlayersCountError() {
        System.out.println(PLAYERS_COUNT_ERROR_MESSAGE);
    }
}
