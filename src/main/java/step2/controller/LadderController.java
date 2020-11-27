package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class LadderController {

    private LadderController() {}

    public static void runLadder() {
        Players players = Players.of(NameSplitter.splitParticipationNames(InputView.putParticipation()));
        int ladderHeight = InputView.putLadderHeight();

        OutputView.printResult();
        Ladder ladder = Ladder.of(players, ladderHeight, new RandomLineStrategy());

        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);
    }
}
