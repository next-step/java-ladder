package ladder.dto;

import ladder.domain.LadderMembers;

import java.util.List;
import java.util.stream.Collectors;

public class MembersDto {
    private final List<MemberDto> members;

    public MembersDto(LadderMembers ladderMembers) {
        this.members = ladderMembers.getMembers()
                .stream()
                .map(MemberDto::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<MemberDto> info() {
        return members;
    }
}
