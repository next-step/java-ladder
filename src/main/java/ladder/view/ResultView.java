package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;

public class ResultView {

    private final static String MESSAGE_RESULT = "실행결과";
    
    private ResultView(){}

    public static void printResult(Players players, Ladder ladder) {
        System.out.println();
        System.out.println(MESSAGE_RESULT);
        System.out.println();
        System.out.println(players);
        System.out.println(ladder);
    }

}
