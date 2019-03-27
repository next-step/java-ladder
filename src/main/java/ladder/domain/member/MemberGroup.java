package ladder.domain.member;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MemberGroup {
    private final List<Member> members;

    public MemberGroup(List<Member> members) {
        this.members = members;
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    @Override
    public String toString() {
        return this.members.stream()
                .map(Member::toString)
                .collect(Collectors.joining(" "))
                .trim();
    }
}
