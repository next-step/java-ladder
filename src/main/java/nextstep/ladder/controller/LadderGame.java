package nextstep.ladder.controller;

import java.util.List;
import nextstep.ladder.domain.*;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.stream.Collectors;

public class LadderGame {
    public static void main(String[] args) {
        Participants participants = initializeParticipants();
        List<String> result = InputView.inputResult();
        int height = InputView.inputHeight();

        Ladder ladder = Ladder.createLadder(participants, height, new RandomLineDecisionStrategy());
        ResultView.printLadder(ladder);
    }

    private static Participants initializeParticipants() {
        return new Participants(InputView.inputParticipantsName()
                .stream()
                .map(Participant::new)
                .collect(Collectors.toList()));
    }
}
