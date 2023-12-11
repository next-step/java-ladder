package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
    public static void main(String[] args) {
        String participantNames = InputView.participants();
        int ladderHeight = InputView.ladderHeight();

        Participants participants = new Participants(participantNames);
        Ladder ladder = new Ladder(ladderHeight, participants);

        ResultView.ladderView(ladder, participants);
    }
}
