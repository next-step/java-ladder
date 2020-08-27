package ladder.domain.core.line.name;

import ladder.domain.core.line.Line;
import ladder.ui.result.DisplayResult;
import ladder.ui.result.NamesDisplayResult;

public class LadderResultLine implements Line {
    private final Names names;

    LadderResultLine(Names names) {
        this.names = names;
    }

    public static LadderResultLine of(String ladderResults) {
        return new LadderResultLine(Names.ofLadderResults(ladderResults));
    }

    @Override
    public String getResult(int index) {
        return names.get(index);
    }

    @Override
    public int getWidth() {
        return names.getCount();
    }

    @Override
    public DisplayResult toDisplayResult() {
        return new NamesDisplayResult(names);
    }

}
