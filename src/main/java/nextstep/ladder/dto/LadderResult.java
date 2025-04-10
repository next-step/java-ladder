package nextstep.ladder.dto;

import java.util.List;

public class LadderResult {
    private final List<String> ladderUsers;
    private final List<List<Boolean>> ladder;

    public LadderResult(List<String> ladderUsers, List<List<Boolean>> ladder) {
        this.ladderUsers = ladderUsers;
        this.ladder = ladder;
    }

    public List<String> getLadderUsers() {
        return ladderUsers;
    }

    public List<List<Boolean>> getLadder() {
        return ladder;
    }
}
