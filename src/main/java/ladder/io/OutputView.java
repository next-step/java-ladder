package ladder.io;

import ladder.*;

import java.util.List;
import java.util.Map;

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

    public static void printPrizes(Prizes playerresults) {
        playerresults.getPrizes()
                .forEach(n -> System.out.print(n.getPrizePad()));
        System.out.println();
    }

    public static void printResult(Map<Player, Prize> result) {
        System.out.println("실행결과");
        result.forEach((player, prize) -> System.out.println(player.getName() + " : " + prize.getPrize()));
    }

    public static void printResult(ResultLadder result) {
        System.out.println("실행결과");
        System.out.println(result.getPlayer().getName() + " : " + result.getPrize().getPrize());
    }
}
