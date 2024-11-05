package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.stream.Collectors;

public class LadderGame {

    private static final String PRINT_ALL_RESULT_COMMAND = "all";

    public static void main(String[] args) {
        Participants participants = initializeParticipants();
        LadderResult result = initializeResult();
        int height = InputView.inputHeight();

        Ladder ladder = Ladder.createLadder(participants, result, height, new RandomLineDecisionStrategy());
        ResultView.printLadder(ladder);

        processResults(ladder);
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

    private static void processResults(Ladder ladder) {
        String name = InputView.inputResultName();
        while (!isGameEnd(name)) {
            ResultView.printResult(name, ladder);
            name = InputView.inputResultName();
        }
        ResultView.printResult(name, ladder);
    }

    private static boolean isGameEnd(String name) {
        return PRINT_ALL_RESULT_COMMAND.equalsIgnoreCase(name);
    }

}
