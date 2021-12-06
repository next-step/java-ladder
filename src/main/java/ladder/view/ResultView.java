package ladder.view;

import ladder.model.Line;
import ladder.model.point.Point;
import ladder.model.player.Player;
import ladder.model.player.Players;

import java.util.Collections;
import java.util.List;

public class ResultView {

    public static void printResult(Players players, List<Line> lines) {
        System.out.println("실행결과");
        System.out.println();
        printPlayerName(players.get());
        printLines(lines);
    }

    private static void printPlayerName(List<Player> players) {
        players.forEach(player -> System.out.printf("%5s ", player.name()));
        System.out.println();
    }

    private static void printLines(List<Line> lines) {
        lines.forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        line.getPoints()
                .get()
                .forEach(ResultView::printPoint);
        System.out.println();
    }

    private static void printPoint(Point point) {
        String value = " ";
        if(point.getIsLine()) {
            value = "-";
        }
        System.out.print(String.join("", Collections.nCopies(5, value)) + "|");
    }
}
