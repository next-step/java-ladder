package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Point;
import ladder.domain.Way;

import java.util.List;

import static ladder.domain.Player.PRINT_SIZE;

public class ResultView {

    private static final String EMPTY_FIRST = "    ";
    private static final char SPOT = '|';
    private static final String RESULT = "\n실행결과\n";

    public static void printResult() {
        System.out.println(RESULT);
    }

    public static void printPlayers(Players players) {
        players.getPlayers()
                .forEach(player -> printPlayer(player.getName()));
        System.out.println();
    }

    private static void printPlayer(String name) {
        int emptySize = PRINT_SIZE - name.length();
        System.out.print(empty(emptySize) + name);
    }

    private static String empty(int emptySize) {
        return new String(new char[emptySize]).replace('\0', ' ');
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(line -> print(line.getPoints()));
        System.out.println();
    }

    private static void print(List<Point> points) {
        System.out.print(EMPTY_FIRST);
        points.forEach(point -> {
            System.out.print(SPOT);
            print(point);
        });
        System.out.println();
    }

    private static void print(Point point) {
        Way way = point.getWay();
        System.out.print(way.getLoad());
    }
}
