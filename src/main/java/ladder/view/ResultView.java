package ladder.view;

import ladder.domain.ladder.Game;
import ladder.domain.result.Results;

public class ResultView {
    public static void printResult(Game game) {
        System.out.println("실행 결과");
        printLadder(game);
    }

    private static void printLadder(Game game) {
        System.out.println(game.toString());
    }

    public static void printResults(Results results) {
        System.out.println(results.toString());
    }
}
