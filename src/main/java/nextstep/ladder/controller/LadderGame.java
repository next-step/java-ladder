package nextstep.ladder.controller;

import nextstep.common.Assert;
import nextstep.ladder.model.LineGenerator;
import nextstep.ladder.model.Lines;
import nextstep.ladder.model.Participants;
import nextstep.ladder.model.Positive;
import nextstep.ladder.model.RandomPointPainter;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.LinesResponse;
import nextstep.ladder.view.dto.NamesResponse;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public final class LadderGame {

    private final InputView inputView;
    private final ResultView resultView;

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
        Participants participants = Participants.from(inputView.participants());
        resultView.print(
                NamesResponse.from(participants),
                LinesResponse.from(Lines.of(Positive.from(inputView.ladderHeight()), lineGenerator(participants)))
        );
    }

    private LineGenerator lineGenerator(Participants participants) {
        return LineGenerator.of(Positive.from(participants.numberOfGaps()), RandomPointPainter.from(new Random()));
    }
}
