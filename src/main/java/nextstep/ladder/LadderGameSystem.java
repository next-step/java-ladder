package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.edge.LadderEdge;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderGameSystem {

    public static void main(String[] args) {
        List<String> names = List.of(InputView.showNamesInput().split(","));
        List<String> results = List.of(InputView.showResultsInput().split(","));
        LadderEdge ladderEdge = new LadderEdge(names, results);
        OutputView.showLadderResult(new Ladder(ladderEdge, InputView.showLadderHeightInput()).toLadderResult());
    }
}
