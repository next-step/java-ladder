package laddergame.view;

import laddergame.domain.*;

public class OutputView {

    public static final String EMPTY = "     ";
    public static final String SUB_LINE = "-----";
    public static final String MAIN_LINE = "|";

    private OutputView() {
    }

    public static void printResult(Players players, Ladder ladder) {
        System.out.println();
        System.out.println("실행 결과");
        printPlayers(players);
        printLadder(ladder);
    }

    private static void printPlayers(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.printf("%6s", player.getName());
        }
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.print(EMPTY + MAIN_LINE);
            for (Point point : line.getStates()) {
                System.out.print(createLine(point));
                System.out.print(MAIN_LINE);
            }
            System.out.println();
        }
    }

    private static String createLine(Point point) {
        if (point.isExist()) {
            return SUB_LINE;
        }
        return EMPTY;
    }
}
