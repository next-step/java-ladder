package ladder.dto;

import ladder.domain.LadderMembers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MembersDto {
    private final List<MemberDto> members;

    public MembersDto(LadderMembers ladderMembers) {
        this.members = ladderMembers.getMembers()
                .stream()
                .map(MemberDto::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public MemberDto findByMember(int memberIndex) {
        return IntStream.range(memberIndex, memberIndex+1)
                .mapToObj(members::get)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 member가 없습니다."));
    }

    public List<MemberDto> info() {
        return members;
    }
}
