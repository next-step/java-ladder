package ladder.controller;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.LadderGameResult;
import ladder.domain.LadderJudge;
import ladder.domain.Participant;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderConsole {

    private static final String WHOLE_PARTICIPANT_SIGN = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderConsole(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<Participant> participants = inputView.inputParticipants();
        List<String> results = inputView.inputResults();
        int height = inputView.inputHeight();

        Ladder ladder = LadderFactory.generate(participants.size(), height);
        outputView.printLadder(ladder, participants, results);

        LadderGameResult gameResult = LadderJudge.judge(participants, results, ladder.result());
        showGameResult(participants, gameResult);
    }

    private void showGameResult(List<Participant> participants, LadderGameResult gameResult) {
        String participantToCheck = inputView.inputParticipantToCheckResult();
        if (WHOLE_PARTICIPANT_SIGN.equals(participantToCheck)) {
            outputView.printWholeGameResult(participants, gameResult);
            return;
        }
        Participant participant = Participant.from(participantToCheck);
        outputView.printGameResult(participant, gameResult);

        showGameResult(participants, gameResult);
    }
}
