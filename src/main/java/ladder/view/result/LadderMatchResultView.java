package ladder.view.result;

import ladder.model.result.LadderResult;
import ladder.view.View;

public class LadderMatchResultView implements View {
    private final LadderResult result;

    public LadderMatchResultView(LadderResult result) {
        this.result = result;
    }

    @Override
    public void render() {
        System.out.println(result.value());
    }
}
