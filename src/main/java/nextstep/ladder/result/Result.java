package nextstep.ladder.result;

import nextstep.ladder.domain.Ladder;

public class Result {
    private Result() {
        throw new IllegalStateException("Utility class");
    }

    public static void printResult(final Ladder ladder) {
        printMakingLadderResult(ladder);
    }

    private static void printMakingLadderResult(final Ladder ladder) {
        System.out.println("\n실행결과\n");
        System.out.println(ladder);
    }
}
