package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.strategy.BridgeStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

import static nextstep.ladder.view.InputView.getResults;

public class LadderGame {

    private final BridgeStrategy strategy;

    public LadderGame(BridgeStrategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        Participants participants = new Participants(getParticipants());
        Result result = Result.of(participants, getResults());

        Height height = new Height(getLadderHeight());

        List<Line> ladder = Ladder.of(participants)
                .create(height, strategy);

        OutputView.printResult(participants, ladder);
    }

    private int getLadderHeight() {
        OutputView.printAskLadderHeightMessage();
        return InputView.getLadderHeight();
    }

    private String getParticipants() {
        OutputView.printParticipantsMessage();
        return InputView.getParticipants();
    }
}
