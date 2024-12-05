package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderExecutor;
import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.domain.ExecuteResult;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startLadder() {
        String names = inputView.inputName();
        int maxLadder = inputView.inputMaxLadder();
        String executeResultStr = inputView.inputExecuteResult();

        Participants participants  = new Participants(names);

        ExecuteResult executeResult = new ExecuteResult(participants.size(), executeResultStr);

        Lines lines = LadderFactory.createLadder(participants, maxLadder);

        LadderExecutor ladderExecutor = new LadderExecutor(lines, participants);
        ladderExecutor.executeLadder();

        LadderResult ladderResult = new LadderResult(executeResult, ladderExecutor);
        ladderResult.combineLadderResult();

        outputView.outputResult(participants, lines, ladderResult);

        String participant = inputView.inputParticipantResult();
        outputView.outputParticipantResult(ladderResult.getParticipantResult(participant));

        participant = inputView.inputParticipantResult();
        outputView.outputParticipantResult(ladderResult.getParticipantResult(participant));

        outputView.outputParticipantAllResult(ladderResult);
    }

}
