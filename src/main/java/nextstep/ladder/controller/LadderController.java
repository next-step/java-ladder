package nextstep.ladder.controller;

import engine.LinesCreator;
import factory.LinesFactoryBean;
import nextstep.ladder.domain.LadderExecutor;
import nextstep.ladder.domain.ExecuteResult;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.MachingResult;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.strategy.LadderLineStrategy;
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

        Participants participants = new Participants(names);

        ExecuteResult executeResult = new ExecuteResult(participants.size(), executeResultStr);

        LinesCreator linesCreator = LinesFactoryBean.createNextStepLadderFactory(participants.size(), maxLadder, new LadderLineStrategy());

        LadderExecutor ladderExecutor = new LadderExecutor(linesCreator, participants);
        MachingResult machingResult = ladderExecutor.play();

        LadderResult ladderResult = machingResult.map(participants, executeResult);

        outputView.outputParticipants(participants);
        outputView.outputResult(executeResult, linesCreator, ladderResult);

        String participant = inputView.inputParticipantResult();
        outputView.outputParticipantResult(ladderResult.getReward(participant));

        participant = inputView.inputParticipantResult();
        outputView.outputParticipantResult(ladderResult.getReward(participant));

        outputView.outputParticipantAllResult(ladderResult);
    }

}
