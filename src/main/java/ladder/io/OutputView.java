package ladder.io;

import ladder.Ladder;
import ladder.Line;
import ladder.Players;
import ladder.Prizes;

public class OutputView {
    public static void printNames(Players players) {
        players.getPlayers()
                .forEach(n -> System.out.print(n.getNamePad()));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLadder()) {
            printLadder(line);
            System.out.println("|");
        }
    }

    private static void printLadder(Line line) {
        for (Boolean point : line.getPoints()) {
            System.out.print("|");
            printLine(point);
        }
    }

    private static void printLine(Boolean point) {
        if (point){
            System.out.print("-".repeat(5));
            return;
        }
        System.out.print(" ".repeat(5));
    }

    public static void printResults(Prizes playerresults) {
        playerresults.getPrizes()
                .forEach(n -> System.out.print(n.getPrizePad()));
        System.out.println();
    }
}
