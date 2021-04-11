package step2.dto;

import step2.domain.Members;

public class RequestLadderDTO {
    private final Members members;
    private final int ladderHeight;

    public RequestLadderDTO(Members members, int ladderHeight) {
        this.members = members;
        this.ladderHeight = ladderHeight;
    }

    public Members getMembers() {
        return members;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
