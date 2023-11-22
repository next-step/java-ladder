package nextstep.ladder.result;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.input.Input;
import nextstep.ladder.util.Formatter;

public class Result {
    private Result() {
        throw new IllegalStateException("Utility class");
    }

    public static void printLadderRunResult(final LadderResult ladderResult) {
        int count = 0;

        while (count < 3) {
            final String userName = Input.inputPrintUserName();
            printUserRunResult(ladderResult, userName);

            count++;
        }
    }

    private static void printUserRunResult(final LadderResult ladderResult, final String userName) {
        System.out.println("\n실행 결과");

        if ("all".equals(userName)) {
            printAllUserRunResult(ladderResult);
            return;
        }

        printEachUserRunResult(ladderResult, userName);
    }

    private static void printEachUserRunResult(final LadderResult ladderResult, final String userName) {
        System.out.println(ladderResult.result().get(userName));
    }

    private static void printAllUserRunResult(final LadderResult ladderResult) {
        ladderResult.result()
                .forEach((key, value) -> System.out.println(key + " : " + value));
    }

    public static void printMakingLadderResult(final Ladder ladder) {
        System.out.println("\n사다리 결과\n");

        System.out.println(Formatter.userNamesFormat(ladder.userNames()));
        System.out.println(Formatter.ladderFormat(ladder.ladderLines()));
        System.out.println(Formatter.userResultsFormat(ladder.userResults()));
    }
}
