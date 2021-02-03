package step2.UI;

import step2.Line;
import step2.Player;
import step2.Players;
import step2.Results;

import java.util.List;

public class OutputView {

    public static final String RESULT_MESSAGE ="실행결과";
    public static final String LADDER_HEIGHT_DRAWING = "|";

    public static void outputLadder(List<Line> lines, Players players, Results results) {
        System.out.println(RESULT_MESSAGE);

        printPlayers(players);
        printLadder(lines);
        printResult(results);
    }

    private static void printPlayers(Players players) {
        System.out.println(players.toString());
    }

    private static void printLadder(List<Line> lines) {
        for (Line line : lines) {
            System.out.println(LADDER_HEIGHT_DRAWING + line.toString());
        }
    }

    private static void printResult(Results results) {
        System.out.println(results.toString());
    }
}
