package ladder.control.output;

import ladder.model.LadderMatch;
import ladder.model.result.LadderResult;
import ladder.view.View;
import ladder.view.result.match.LadderMatchResultView;
import ladder.view.result.match.LadderMatchesView;

import java.util.List;

public class LadderMatchOutput {
    private final View info;
    private final View output;

    public LadderMatchOutput(View outputView, List<LadderMatch> matches) {
        this.info = outputView;
        this.output = new LadderMatchesView(matches);
    }

    public LadderMatchOutput(View outputView, LadderResult result) {
        this.info = outputView;
        this.output = new LadderMatchResultView(result);
    }

    public void print() {
        info.render();
        output.render();
    }
}
