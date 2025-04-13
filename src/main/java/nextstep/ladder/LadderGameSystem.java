package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.edge.LadderPrizes;
import nextstep.ladder.domain.edge.LadderUsers;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderGameSystem {

    public static void main(String[] args) {
        List<String> names = List.of(InputView.showNamesInput().split(","));
        List<String> prizes = List.of(InputView.showResultsInput().split(","));
//        OutputView.showLadderResult(new Ladder(new LadderUsers(names), new LadderPrizes(results), InputView.showLadderHeightInput()).toLadderResult());
    }
}
