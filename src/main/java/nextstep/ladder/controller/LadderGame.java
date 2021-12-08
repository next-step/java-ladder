package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Participants;
import nextstep.ladder.model.value.Height;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputVIew;

public class LadderGame {

    public void start() {
        Participants participants = InputView.inputJoinParticipants();
        Height ladderHeight = InputView.inputLadderHeight();

        System.out.println("참가자 수 : " + participants.size());

        Ladder ladder = Ladder.of(ladderHeight.getHeight(), participants.size());

        OutputVIew outputVIew = new OutputVIew();
        outputVIew.printResult(participants, ladder);
    }

}
