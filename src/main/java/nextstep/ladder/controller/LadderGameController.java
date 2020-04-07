package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderGameController {

    public static void play(InputView inputView, OutputView outputView) {
        List<Participant> participants = inputView.getParticipants();
        LadderResults ladderResults = new LadderResults(inputView.getRadderResults());
        Ladder ladder = new Ladder(participants.size(), inputView.getHeight());

        LadderGame ladderGame = new LadderGame(participants, ladder, ladderResults);
        outputView.showLadder(ladderGame);

        GameResults gameResults = ladderGame.play();
        outputView.showGameResults(gameResults);
    }
}
