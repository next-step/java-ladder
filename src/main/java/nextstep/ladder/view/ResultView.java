package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;

public class ResultView {

    private static final int ZERO = 0;
    private final static String RESULT_MESSAGE = "실행결과";

    private ResultView() {
    }

    public static void println() {
        println("");
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printResult(Ladder ladder) {
        println(RESULT_MESSAGE);
        println();
        println(ladder.people());
        println(ladder.lines());
    }
}
