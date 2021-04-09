package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Point;

import java.util.HashMap;
import java.util.Map;

public class ResultView {
    private final static String MESSAGE_LADDER_RESULT = "사다리 결과";
    private final static Map<Point, String> printPoints = new HashMap<>();

    static {
        printPoints.put(Point.LEFT, "--|");
        printPoints.put(Point.DOWN, "     |");
        printPoints.put(Point.RIGHT, "     |---");
    }

    private ResultView() {
    }

    private static void printPlayers(Players players){
        players.players()
                .stream()
                .map(player -> String.format("%6s", player.name()))
                .forEach(System.out::print);
        System.out.println();
    }

    private static void printLadder(Ladder ladder){
        ladder.lines()
                .stream()
                .forEach(line -> {
                    line.points()
                            .forEach(point -> System.out.print(printPoints.get(point)));
                    System.out.println();
                });
    }

    public static void printResult(Players players, Ladder ladder) {
        System.out.println();
        System.out.println(MESSAGE_LADDER_RESULT);
        System.out.println();
        printPlayers(players);
        printLadder(ladder);
    }
}
