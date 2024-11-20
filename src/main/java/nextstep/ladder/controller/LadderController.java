package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.dto.CommaSeparatedResult;
import nextstep.ladder.dto.Names;
import nextstep.ladder.generator.RandomNonConsecutiveFlagGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    public void playGame() {
        CommaSeparatedResult commaSeparatedResult = new Names(InputView.readNames());
        Ladder ladder = new Ladder(InputView.readHeight(), commaSeparatedResult.size(),
                new RandomNonConsecutiveFlagGenerator());
        OutputView.rendering(commaSeparatedResult, ladder);
    }
}
