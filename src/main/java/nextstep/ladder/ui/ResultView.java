package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;

public class ResultView {
    public static final String RESULT_MESSAGE = "실행 결과";

    public static void printLadder(Ladder ladder) {
        printBlankLine();
        System.out.println(ladder.toString());
    }

    private static void printResultMessage() {
        printBlankLine();
        System.out.println(RESULT_MESSAGE);
    }

    private static void printBlankLine() {
        System.out.println();
    }
}
