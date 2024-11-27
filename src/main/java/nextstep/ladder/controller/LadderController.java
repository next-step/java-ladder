package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderParticipationResult;
import nextstep.ladder.dto.CommaSeparatedResult;
import nextstep.ladder.dto.ResultDto;
import nextstep.ladder.dto.UniqueNames;
import nextstep.ladder.generator.RandomNonConsecutiveFlagGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    public ResultDto playGame() {
        LadderParticipationResult ladderParticipationResult = ladderParticipationResult();
        Ladder ladder = ladder(ladderParticipationResult);
        OutputView.renderLadder(ladderParticipationResult.names(), ladder, ladderParticipationResult.ladderResult());
        return ladderParticipationResult.match(ladder.result());
    }

    public void showResultForUser(ResultDto result) {
        while (true) {
            String name = InputView.readUserName();
            OutputView.renderResult(result, name);
        }
    }

    private LadderParticipationResult ladderParticipationResult() {
        CommaSeparatedResult names = new UniqueNames(InputView.readNames());
        CommaSeparatedResult results = new CommaSeparatedResult(InputView.readResult());
        return new LadderParticipationResult(names, results);
    }

    private Ladder ladder(LadderParticipationResult ladderParticipationResult) {
        return new Ladder(InputView.readHeight(), ladderParticipationResult.size(),
                new RandomNonConsecutiveFlagGenerator());
    }

}
