package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderParticipationResult;
import nextstep.ladder.dto.CommaSeparatedResult;
import nextstep.ladder.dto.Names;
import nextstep.ladder.dto.ResultDto;
import nextstep.ladder.generator.RandomNonConsecutiveFlagGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    public void playGame() {
        LadderParticipationResult ladderParticipationResult = LadderParticipationResult();
        Ladder ladder = ladder(ladderParticipationResult);
        OutputView.renderLadder(ladderParticipationResult.names(), ladder, ladderParticipationResult.ladderResult());

        ResultDto result = ladderParticipationResult.match(ladder.result());
        while (true) {
            String name = InputView.readUserName();
            OutputView.renderResult(result, name);
        }
    }

    private LadderParticipationResult LadderParticipationResult() {
        CommaSeparatedResult names = new Names(InputView.readNames());
        CommaSeparatedResult results = new CommaSeparatedResult(InputView.readResult());
        return new LadderParticipationResult(names, results);
    }

    private Ladder ladder(LadderParticipationResult ladderParticipationResult) {
        return new Ladder(InputView.readHeight(), ladderParticipationResult.size(),
                new RandomNonConsecutiveFlagGenerator());
    }

}
