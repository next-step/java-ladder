package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.RandomLineDecisionStrategy;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        Participants participants = new Participants(InputView.inputParticipantsName());
        int height = InputView.inputHeight();
        Ladder ladder = Ladder.createLadder(participants, height, new RandomLineDecisionStrategy());
        ResultView.printLadder(ladder);
    }
}
