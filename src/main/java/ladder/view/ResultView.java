package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Ladders;

public class ResultView {
    public static final String RESULT = "실행결과";

    protected static void printResult(Ladders ladders) {
        for (Ladder ladder : ladders.getLadders()) {
            ladder.getValue().forEach(System.out::print);
            System.out.println();
        }
    }
}
