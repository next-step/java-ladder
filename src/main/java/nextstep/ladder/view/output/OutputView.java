package nextstep.ladder.view.output;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.PlayerGroup;
import nextstep.ladder.Visible;

import java.util.List;

public class OutputView implements Visible {

    private final List<Visible> composite;

    public OutputView() {
        composite = List.of(
                new OpeningView(),
                new PlayerGroupView(),
                new LadderView()
        );
    }

    @Override
    public void view(PlayerGroup playerGroup, Ladder ladder) {
        composite.forEach(visible -> visible.view(playerGroup, ladder));
    }
}
