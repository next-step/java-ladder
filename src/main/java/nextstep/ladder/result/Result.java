package nextstep.ladder.result;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.util.Formatter;

public class Result {
    private Result() {
        throw new IllegalStateException("Utility class");
    }

    public static void printResult(final Ladder ladder) {
        printMakingLadderResult(ladder);
    }

    private static void printMakingLadderResult(final Ladder ladder) {
        System.out.println("\n실행결과\n");
        System.out.println(Formatter.userNamesFormat(ladder.userNames()));
        System.out.println(ladder);
    }
}
