package nextstep.ladder.domain.edge;

import nextstep.ladder.domain.result.LadderResults;
import nextstep.ladder.domain.user.LadderUsers;

public class LadderEdge {
    private final LadderUsers users;
    private final LadderResults results;

    public LadderEdge(LadderUsers users, LadderResults results) {
        this.users = users;
        this.results = results;
    }
}
