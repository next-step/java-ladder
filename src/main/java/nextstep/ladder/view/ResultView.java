package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

public class ResultView {
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-----";
    private static final String EMPTY = "     ";

    public static void printPlayers(Players players) {
        players.getPlayers().forEach(player ->
                System.out.printf("%-6s", player.getName()));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            for (Point point : line.getPoints()) {
                System.out.print(VERTICAL);
                if (point.hasRight()) {
                    System.out.print(HORIZONTAL);
                } else {
                    System.out.print(EMPTY);
                }
            }
            System.out.println();
        }
    }
}
