package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Ladders;

import java.util.stream.IntStream;

public class ResultView {
    public static final String RESULT = "실행결과";
    private static final String BAR = "|";
    private static final String BLANK = "     ";
    private static final String LADDER = "-----";

    protected static void printResult(Ladders ladders) {
        for (Ladder ladder : ladders.getLadders()) {
            printLadderLine(ladder);
        }
    }

    private static void printLadderLine(Ladder ladder) {
        IntStream.range(0, ladder.getValue().size())
                .mapToObj(index -> getLadder(ladder, index))
                .forEach(System.out::print);
        System.out.println();
    }

    private static String getLadder(Ladder ladder, int index) {
        if (index % 2 == 0) {
            return BAR;
        }
        if (Boolean.TRUE.equals(ladder.getValue().get(index))) {
            return LADDER;
        }
        return BLANK;
    }

}
