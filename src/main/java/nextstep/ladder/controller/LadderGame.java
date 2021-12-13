package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.LadderResults;
import nextstep.ladder.model.Participants;
import nextstep.ladder.model.value.Height;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputVIew;

public class LadderGame {

    public void start() {
        Participants participants = InputView.inputJoinParticipants();
        LadderResults ladderResults = InputView.inputLadderResults();
        Height ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = Ladder.of(ladderHeight.getHeight(), participants.size());

        OutputVIew outputVIew = new OutputVIew();
        outputVIew.printResult(participants, ladder, ladderResults);
    }

}
