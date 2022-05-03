package nextstep.ladder.controller;

import nextstep.common.Assert;
import nextstep.ladder.model.ParticipantsWithResults;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.LineGenerator;
import nextstep.ladder.model.Lines;
import nextstep.ladder.model.Participant;
import nextstep.ladder.model.Participants;
import nextstep.ladder.model.Positive;
import nextstep.ladder.model.RandomPointPainter;
import nextstep.ladder.model.Results;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.LadderResponse;
import nextstep.ladder.view.dto.ParticipantResultResponse;
import nextstep.ladder.view.dto.ResultResponse;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public final class LadderGame {

    private static final String ALL_TARGET_MESSAGE = "all";

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
        Participants participants = participants();
        Ladder ladder = ladder(participants);
        resultView.print(LadderResponse.from(ladder));
        execute(ladder);
    }

    private void execute(Ladder ladder) {
        String resultTarget = inputView.resultTarget();
        while (!ALL_TARGET_MESSAGE.equals(resultTarget)) {
            resultView.print(ResultResponse.from(ladder.result(Participant.from(resultTarget))));
            resultTarget = inputView.resultTarget();
        }
        resultView.print(ParticipantResultResponse.listFrom(ladder.participantResults()));
    }

    private Participants participants() {
        return Participants.from(inputView.participants());
    }

    private Ladder ladder(Participants participants) {
        return Ladder.of(
                ParticipantsWithResults.of(participants, Results.from(inputView.results())),
                Lines.of(Positive.from(inputView.ladderHeight()), lineGenerator(participants.size()))
        );
    }

    private LineGenerator lineGenerator(int pointCount) {
        return LineGenerator.of(Positive.from(pointCount), RandomPointPainter.from(new Random()));
    }
}
