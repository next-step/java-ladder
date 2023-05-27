package ladder.view;

import ladder.dto.Line;

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

    public static void viewPlayerNames(List<String> players) {
        for (int i = 0; i < players.size(); i++) {
            printBlankBeforName(players, i);
            System.out.print(players.get(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void printBlankBeforName(List<String> players, int i) {
        if (i != 0) {
            System.out.print(" ".repeat(5 - players.get(i).length()));
        }
    }

    public static void viewLadder(List<String> players, List<Line> ladder) {
        ladder.forEach(line -> {
            System.out.print(" ".repeat(players.get(0).length() - 1));
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

    private static void viewPoint(Boolean point) {
        if (point) {
            System.out.print(LADDER_BOTTOM_TRUE);
            return;
        }
        System.out.print(LADDER_BOTTOM_FALSE);
    }
}
