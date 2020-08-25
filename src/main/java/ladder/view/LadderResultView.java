package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.common.Printable;

public class LadderResultView {
    public static void printPersonWithLadder(LadderGame ladderGame) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        System.out.println(ladderGame.print());
    }

    public static void printLadderGameResult(Printable printableResult) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println(printableResult.print());
    }
}
