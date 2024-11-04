package nextstep.ladder.controller;

import java.util.List;
import nextstep.ladder.domain.*;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.stream.Collectors;

public class LadderGame {
    public static void main(String[] args) {
        Participants participants = initializeParticipants();
        LadderResult result = initializeResult();
        int height = InputView.inputHeight();

        Ladder ladder = Ladder.createLadder(participants, result, height, new RandomLineDecisionStrategy());
        ResultView.printLadder(ladder);
    }

    private static Participants initializeParticipants() {
        return new Participants(InputView.inputParticipantsName()
                .stream()
                .map(Participant::new)
                .collect(Collectors.toList()));
    }

    private static LadderResult initializeResult() {
        return new LadderResult(InputView.inputResult());
    }
}
