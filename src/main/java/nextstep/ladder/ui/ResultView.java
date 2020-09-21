package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Point;

import java.util.List;

public class ResultView {

    private static final String PRINT_INTERVAL = "%6s";
    private static final String HORIZONTAL = "-----";
    private static final String VERTICAL = "|";

    public static void printLadder(Ladder ladder, List<Player> players) {
        System.out.println("실행 결과");
        printNames(players);
        printLines(ladder);
    }

    private static void printNames(List<Player> players) {
        players.stream().forEach(name -> System.out.printf(PRINT_INTERVAL, name));
        System.out.println();
    }

    private static void printLines(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.printf(PRINT_INTERVAL, "|");
            printPoints(line.getPoints());
            System.out.println();
        }
    }

    private static void printPoints(List<Point> points) {
        points.stream()
                .map(point -> point.isConnection() ? HORIZONTAL + VERTICAL : VERTICAL)
                .forEach(point -> System.out.printf(PRINT_INTERVAL, point));
    }
}
