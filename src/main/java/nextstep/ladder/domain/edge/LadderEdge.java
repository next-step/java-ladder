package nextstep.ladder.domain.edge;

import nextstep.ladder.domain.result.LadderResults;
import nextstep.ladder.domain.user.LadderUsers;

import java.util.List;

public class LadderEdge {
    private final LadderUsers users;
    private final LadderResults results;


    public LadderEdge(List<String> names, List<String> results) {
        this(new LadderUsers(names), new LadderResults(results));
    }

    public LadderEdge(LadderUsers users, LadderResults results) {
        if (users.size() != results.size()) {
            throw new IllegalArgumentException("유저 수와 결과 수는 같아야 합니다.");
        }
        this.users = users;
        this.results = results;
    }

    public int userSize() {
        return users.size();
    }

    public List<String> getLadderUserNames() {
        return users.getLadderUserNames();
    }
}
