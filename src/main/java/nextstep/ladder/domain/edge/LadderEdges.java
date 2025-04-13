package nextstep.ladder.domain.edge;

import java.util.List;

public class LadderEdges {
    private final LadderUsers users;
    private final LadderPrizes results;

    public LadderEdges(List<String> names, List<String> results) {
        this(new LadderUsers(names), new LadderPrizes(results));
    }

    public LadderEdges(LadderUsers users, LadderPrizes results) {
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
