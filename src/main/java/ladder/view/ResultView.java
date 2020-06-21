package ladder.view;

import ladder.domain.ladder.Game;

public class ResultView {
    public static void printResult(Game game) {
        System.out.println("실행 결과");
        printLadder(game);
    }

    private static void printLadder(Game game) {
        System.out.println(game.toString());
    }
}
