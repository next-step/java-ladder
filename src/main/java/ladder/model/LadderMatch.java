package ladder.model;

import ladder.model.participant.Name;
import ladder.model.result.LadderResult;

public class LadderMatch {
    private final Name name;
    private final LadderResult result;

    public LadderMatch(Name name, LadderResult result) {
        this.name = name;
        this.result = result;
    }

    public Name name() {
        return name;
    }

    public LadderResult result() {
        return result;
    }
}
