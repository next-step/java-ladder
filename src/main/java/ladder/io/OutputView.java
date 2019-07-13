package ladder.io;

import ladder.*;

public class OutputView {
    public static void printNames(Players players) {
        players.getPlayers()
                .forEach(n -> System.out.print(n.getNamePad()));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLadder()) {
            printLadder(line);
        }
    }

    private static void printLadder(Line line) {
        for (Point point : line.getPoints()) {
            System.out.print("|");
            System.out.print(point.getLine());
        }
        System.out.println();
    }

    public static void printResults(Prizes playerresults) {
        playerresults.getPrizes()
                .forEach(n -> System.out.print(n.getPrizePad()));
        System.out.println();
    }
}
