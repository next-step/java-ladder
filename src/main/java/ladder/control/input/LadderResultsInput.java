package ladder.control.input;

import ladder.model.LadderResult;
import ladder.view.View;

public class LadderResultsInput extends MultipleInput<LadderResult> {
    public LadderResultsInput(View view) {
        super(view);
    }

    @Override
    protected LadderResult parse(String rawValue) {
        return new LadderResult(rawValue);
    }
}
