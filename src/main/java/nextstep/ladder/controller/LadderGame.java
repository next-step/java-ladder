package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderGame {

    public static void play(InputView inputView, OutputView outputView) {
        List<Participant> participants = inputView.getParticipants();
        int height = inputView.getHeight();

        Ladder ladder = new Ladder(participants.size(), height);
        outputView.showLadder(ladder, participants);
    }
}
