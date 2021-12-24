package rick.view;

import rick.domain.Ladder;
import rick.domain.Line;
import rick.domain.Player;
import rick.domain.Players;
import rick.domain.Point;

public class ResultView {

    private ResultView() {
    }

    public static void drawResult(Players players, Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();

        players.getPlayers()
            .stream()
            .map(Player::getName)
            .forEach(name -> System.out.printf("%6s", name));

        System.out.println();

        for (Line line : ladder.getLines()) {
            drawLine(line);
        }
    }

    private static void drawLine(Line line) {
        System.out.print("     |");
        for (Point point : line.getPoints()) {
            drawPoint(point);
        }
        System.out.println();
    }

    private static void drawPoint(Point point) {
        if (point.movable()) {
            System.out.print("-----|");
            return;
        }

        System.out.print("     |");
    }
}
