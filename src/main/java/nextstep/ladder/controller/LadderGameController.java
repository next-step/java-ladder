package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderGameController {

    public static void play(InputView inputView, OutputView outputView) {
        List<Participant> participants = inputView.getParticipants();
        Ladder ladder = new Ladder(participants.size(), inputView.getHeight());

        LadderGame ladderGame = new LadderGame(participants, ladder);
        outputView.showLadder(ladderGame);
    }
}
