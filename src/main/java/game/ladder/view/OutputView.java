package game.ladder.view;

import game.ladder.domain.GameResults;
import game.ladder.domain.Ladder;
import game.ladder.domain.Level;

public class OutputView {

    public static void printLadder(Ladder ladder) {
        System.out.println("사다리 결과");
        System.out.println();
        System.out.println(ladder.makeStringLadder());
    }

    public static void printLevel(Level level) {
        System.out.println("실행할 사다리의 난이도는?");
        System.out.println(level.getName());
        System.out.println();
    }

    public static void printGameResults(GameResults gameResults) {
        System.out.println("실행 결과");
        System.out.println(gameResults.getStringGameResults());
    }
}
