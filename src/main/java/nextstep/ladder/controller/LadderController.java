package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Names;
import nextstep.ladder.generator.LadderWidthSize;
import nextstep.ladder.generator.RandomNonConsecutiveFlagGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    public void playGame() {
        Names names = new Names(InputView.readNames());
        Ladder ladder = new Ladder(InputView.readHeight(),
                new RandomNonConsecutiveFlagGenerator(new LadderWidthSize(names.size() - 1)));
        OutputView.rendering(names, ladder);
    }
}
