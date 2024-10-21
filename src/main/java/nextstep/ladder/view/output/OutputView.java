package nextstep.ladder.view.output;

import nextstep.ladder.Visible;
import nextstep.ladder.dto.ViewDto;
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
    public void view(ViewDto viewDto) {
        composite.forEach(visible -> visible.view(viewDto));
    }
}
