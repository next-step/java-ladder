package step2.dto;

import step2.domain.Members;
import step2.domain.Results;

public class RequestLadderDTO {
    private final Members members;
    private final int ladderHeight;
    private final Results results;

    public RequestLadderDTO(Members members, int ladderHeight, Results results) {
        this.members = members;
        this.ladderHeight = ladderHeight;
        this.results = results;
    }

    public Members getMembers() {
        return members;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public Results getResults() {
        return results;
    }
}
