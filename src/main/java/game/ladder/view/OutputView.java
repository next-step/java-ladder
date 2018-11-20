package game.ladder.view;

import game.ladder.domain.GameResults;
import game.ladder.domain.Ladder;

public class OutputView {
    public static void printLadder(Ladder ladder) {
        System.out.println("사다리 결과");
        System.out.println();
        System.out.println(ladder.makeStringLadder());
    }

    public static void printGameResults(GameResults gameResults) {
        System.out.println("실행 결과");
        System.out.println(gameResults.getStringGameResults());
    }
}
