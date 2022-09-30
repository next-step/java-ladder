package ladder.step2.view.output;

import ladder.step2.domain.Ladder;
import ladder.step2.domain.Players;

public class ResultView {
    
    private static final String RESULT_MESSAGE = "실행결과";
    
    public static void resultMessagePrint() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        System.out.println();
    }
    
    public static void playerNamesPrint(Players players) {
        System.out.println(players);
    }
    
    public static void ladderPrint(Ladder ladder) {
        System.out.println(ladder);
    }
}
