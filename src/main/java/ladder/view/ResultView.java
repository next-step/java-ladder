package ladder.view;

import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.user.Player;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;

public class ResultView {

    public static final String LADDER_SPACE = "     |";
    public static final String LADDER_LINE = "-----|";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printPlayerName(List<Player> players) {
        System.out.println("실행결과");
        System.out.println();
        System.out.printf("%-5s", players.get(0));
        range(1, players.size() - 1)
                .forEach(i -> System.out.printf("%6s", players.get(i)));
        System.out.printf("%6s%n", players.get(players.size()-1));
    }

    public static void printLadder(List<Line> ladder) {
        ladder.forEach(line -> {
            printLine(line);
            System.out.println();
        });
    }

    private static void printLine(Line line) {
        List<Point> points = line.getPoints();
        points.forEach(ResultView::printPoint);
    }

    private static void printPoint(Point point) {
        if (point.isFirst()) {
            System.out.print(LADDER_SPACE);
            return;
        }
        if (point.isRight()) {
            System.out.print(LADDER_LINE);
            return;
        }
        System.out.print(LADDER_SPACE);
    }

}
