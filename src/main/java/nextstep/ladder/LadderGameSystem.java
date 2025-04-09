package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.line.strategy.HalfProbabilityLineCreateStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGameSystem {

    public static void main(String[] args) {
        OutputView.showLadder(new Ladder(
            InputView.showNamesInput(),
            InputView.showLadderHeightInput(),
            new HalfProbabilityLineCreateStrategy()
        ));
    }
}
