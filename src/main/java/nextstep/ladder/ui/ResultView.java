package nextstep.ladder.ui;

import nextstep.ladder.domain.*;

import java.util.List;

public class ResultView {

    private static final String PRINT_INTERVAL = "%6s";
    private static final String CONNECTED = "-----|";
    private static final String DISCONNECTED = "|";

    public static void printLadder(Ladder ladder, List<Player> players) {
        System.out.println("실행 결과");
        printNames(players);
        printLines(ladder);
    }

    private static void printNames(List<Player> players) {
        players.stream()
                .map(Player::toString)
                .forEach(ResultView::printByFormat);
        System.out.println();
    }

    private static void printLines(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printByFormat("|");
            printPoints(line.getPoints());
            System.out.println();
        }
    }

    private static void printPoints(List<Point> points) {
        points.stream()
                .map(ResultView::mapToString)
                .forEach(ResultView::printByFormat);
    }

    private static void printByFormat(String value) {
        System.out.printf(PRINT_INTERVAL, value);
    }

    private static String mapToString(Point point) {
        return point.isConnection() ? CONNECTED : DISCONNECTED;
    }
}
