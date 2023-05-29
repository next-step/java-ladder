package ladder.view;

import ladder.dto.Ladder;
import ladder.dto.Line;
import ladder.dto.Players;
import ladder.dto.Point;

import java.util.List;

public class ResultView {
    private final static String RESULT = "실행결과";
    private final static String LADDER_LEG = "|";
    private final static String LADDER_BOTTOM_TRUE = "-----";
    private final static String LADDER_BOTTOM_FALSE = "     ";

    public static void viewResult() {
        System.out.println(RESULT);
        System.out.println();
    }

    public static void viewPlayerNames(Players players) {
        for (int i = 0; i < players.getCountOrPerson(); i++) {
            printBlankBeforName(players, i);
            System.out.print(players.getPlayerName(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void printBlankBeforName(Players players, int i) {
        if (i != 0) {
            System.out.print(" ".repeat(5 - players.getPlayerName(i).length()));
        }
    }

    public static void viewLadder(Players players, Ladder ladder) {
        ladder.getLines().forEach(line -> {
            System.out.print(" ".repeat(players.getPlayerName(0).length() - 1));
            System.out.print(LADDER_LEG);
            viewLine(line);
            System.out.println();
        });
    }

    private static void viewLine(Line line) {
        line.getPoints().forEach(point -> {
            viewPoint(point);
            System.out.print(LADDER_LEG);
        });
    }

    private static void viewPoint(Point point) {
        if (point.isTrue()) {
            System.out.print(LADDER_BOTTOM_TRUE);
            return;
        }
        System.out.print(LADDER_BOTTOM_FALSE);
    }
}
