package nextstep.ladder.view;

import nextstep.common.Assert;

import java.io.PrintStream;

public final class ResultView {

    private static final String CONNECTED_POINT_LINE_MESSAGE = "-----";
    private static final String POINT_DELIMITER = "|";
    private static final String RESULT_MESSAGE = "실행결과";

    private final PrintStream output;

    private ResultView(PrintStream output) {
        Assert.notNull(output, "output must not be null");
        this.output = output;
    }

    public static ResultView from(PrintStream output) {
        return new ResultView(output);
    }
}
