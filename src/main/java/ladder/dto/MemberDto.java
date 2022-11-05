package ladder.dto;

import ladder.domain.LadderMember;

public class MemberDto {
    private final String name;

    public MemberDto(LadderMember ladderMember) {
        this.name = ladderMember.name();
    }

    public String name() {
        return name;
    }
}
