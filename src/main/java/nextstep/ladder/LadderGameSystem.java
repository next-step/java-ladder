package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderGameSystem {

    public static void main(String[] args) {
        OutputView.showLadderResult(
            new Ladder(
                List.of(InputView.showNamesInput().split(",")),
                InputView.showLadderHeightInput()
            ).toLadderResult()
        );
    }
}
