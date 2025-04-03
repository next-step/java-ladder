package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;
import java.util.Random;

public class LadderGameController {

    public static void main(String[] args) {
        List<String> participantNames = InputView.inputParticipantNames();
        Participants participants = Participants.from(participantNames);

        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = Ladder.createRandomLadder(ladderHeight, participants.size(), new Random());

        ResultView.printResult(participants, ladder);
    }
}
