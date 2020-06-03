package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Point;

import java.util.List;

public final class ResultView {

    private final static String PIN = "|";
    private final static String POINT = "-----";
    private final static String EMPTY_POINT = "     ";
    private final static String TAB = "\t";

    private ResultView() {
    }

    private static void printResultTitle() {
        System.out.println("실행결과");
    }

    public static void printLadder(Ladder ladder) {
        printResultTitle();
        printPlayers(ladder.getPlayers());

        List<Line> lines = ladder.getLines().toList();
        lines.forEach(line -> {
            System.out.print(TAB + PIN);
            line.toList().forEach(point -> System.out.print(getPointPin(point)));
            System.out.println();
        });
    }

    private static void printPlayers(Players players) {
        players.toList().forEach(player -> System.out.print(player + TAB));
        System.out.println();
    }

    private static String getPointPin(Point point) {
        return (point.hasPoint() ? POINT : EMPTY_POINT) + PIN;
    }
}
