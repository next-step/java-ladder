package nextstep.ladder.domain;

import nextstep.ladder.input.LadderHeight;
import nextstep.ladder.input.UserNames;

public class UserInput {
    private final UserNames userNames;
    private final LadderHeight ladderHeight;

    public UserInput(final UserNames userNames, final LadderHeight ladderHeight) {
        this.userNames = userNames;
        this.ladderHeight = ladderHeight;
    }

    public UserNames userNames() {
        return this.userNames;
    }

    public LadderHeight ladderHeight() {
        return this.ladderHeight;
    }

    public int height() {
        return this.ladderHeight.height();
    }

    public int userNamesSize() {
        return this.userNames.size();
    }
}
