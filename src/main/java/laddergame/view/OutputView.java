package laddergame.view;

import laddergame.domain.Player;
import laddergame.domain.Players;
import laddergame.domain.Result;
import laddergame.domain.Results;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Line;
import laddergame.domain.ladder.Point;

import java.util.Map;

public class OutputView {

    public static final String EMPTY = "     ";
    public static final String SUB_LINE = "-----";
    public static final String MAIN_LINE = "|";

    private OutputView() {
    }

    public static void printLadder(Players players, Ladder ladder, Results results) {
        System.out.println();
        System.out.println("실행 결과");
        printPlayers(players);
        printLadderFrame(ladder);
        printResults(results);
    }

    public static void printResult(Map<Player, Result> totalResult, Player name) {
        System.out.println("실행결과");
        if (name.equals(new Player("all"))) {
            totalResult.forEach((key, value) -> System.out.printf("%s : %s \n", key.getName(), value.getResult()));
            return;
        }
        System.out.println(totalResult.get(name).getResult());
    }

    private static void printPlayers(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.printf("%6s", player.getName());
        }
        System.out.println();
    }

    private static void printResults(Results results) {
        for (Result result : results.getResults()) {
            System.out.printf("%6s", result.getResult());
        }
        System.out.println();
    }

    private static void printLadderFrame(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            for (Point point : line.getPoints()) {
                System.out.print(createLine(point));
                System.out.print(MAIN_LINE);
            }
            System.out.println();
        }
    }

    private static String createLine(Point point) {
        if (point.getDirection().getLeft()) {
            return SUB_LINE;
        }
        return EMPTY;
    }
}
