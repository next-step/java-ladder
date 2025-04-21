package ladder.view;

import ladder.*;

import java.util.List;

public class OutputView {
    public static void printResult(List<Player> players, Ladder ladder) {
        System.out.println("\n실행결과\n");
        printNames(players);
        printLadder(ladder);
    }

    private static void printNames(List<Player> players) {
        for (Player player: players) {
            System.out.printf("%-6s", player.toString());
        }
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        for (Line line : ladder.lines()) {
            StringBuilder row = new StringBuilder();
            for (Point point : line.points()) {
                row.append("|");
                row.append(point.hasRight() ? "-----" : "     ");
            }
            row.append("|");
            System.out.println("    " + row);
        }
    }

}
