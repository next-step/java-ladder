package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.strategy.BridgeStrategy;

import static nextstep.ladder.view.InputView.*;
import static nextstep.ladder.view.OutputView.printLadder;

public class LadderGame {

    private final BridgeStrategy strategy;

    public LadderGame(BridgeStrategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        Participants participants = new Participants(getParticipants());
        Result result = Result.of(participants, getResults());

        Height height = new Height(getLadderHeight());

        Ladder ladder = Ladder.of(participants,height,strategy);

        printLadder(participants, result, ladder);

//        while (true){
//            String gameResult = result.gameResult(participants, getParticipantName(), ladder);
//            printResult(gameResult);
//        }
    }
}
