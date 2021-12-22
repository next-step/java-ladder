package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;

public final class OutputView {
    private static final String RESULT_OUTPUT_MESSAGE = "\n실행결과\n";

    private OutputView() {
    }

    public static void printLadderResult(Ladder run) {
        System.out.print(RESULT_OUTPUT_MESSAGE);
        System.out.print("\n" +
                "pobi  honux crong   jk\n" +
                "    |-----|     |-----|\n" +
                "    |     |-----|     |\n" +
                "    |-----|     |     |\n" +
                "    |     |-----|     |\n" +
                "    |-----|     |-----|\n");
    }
}
