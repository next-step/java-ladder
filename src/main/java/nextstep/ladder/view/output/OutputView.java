package nextstep.ladder.view.output;

import nextstep.ladder.Visible;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.result.MatchResult;
import nextstep.ladder.view.output.list.LadderResulView;
import nextstep.ladder.view.output.list.PlayerNamesView;

import java.util.List;

public class OutputView implements Visible {

    private final List<Visible> composite;

    public OutputView() {
        composite = List.of(
                new OpeningView(),
                new PlayerNamesView(),
                new LadderView(),
                new LadderResulView(),
                new ResultView()
        );
    }

    @Override
    public void view(MatchResult matchResult, Ladder ladder) {
        composite.forEach(visible -> visible.view(matchResult, ladder));
    }
}
