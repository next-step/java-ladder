package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.strategy.BridgeStrategy;

import java.util.List;

import static nextstep.ladder.view.InputView.*;
import static nextstep.ladder.view.OutputView.printLadder;
import static nextstep.ladder.view.OutputView.printResult;

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

        printLadder(participants, result, ladder);

        while (true){
            String gameResult = result.gameResult(participants, getParticipantName(), ladder);
            printResult(gameResult);
        }
    }
}
