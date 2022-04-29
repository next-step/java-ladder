package nextstep.ladder.controller;

import nextstep.common.Assert;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public final class LadderGame {

    private InputView inputView;
    private ResultView resultView;

    private LadderGame(InputStream inputStream, PrintStream printStream) {
        Assert.notNull(inputStream, "inputStream must not be null");
        Assert.notNull(printStream, "printStream must not be null");
        this.inputView = InputView.of(new Scanner(inputStream), printStream);
        this.resultView = ResultView.from(printStream);
    }

    public static LadderGame of(InputStream inputStream, PrintStream printStream) {
        return new LadderGame(inputStream, printStream);
    }

    public void start() {
    }
}
