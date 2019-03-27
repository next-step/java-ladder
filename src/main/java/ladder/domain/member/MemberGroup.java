package ladder.domain.member;

import java.util.Collections;
import java.util.List;

public class MemberGroup {
    private final List<Member> members;

    public MemberGroup(List<Member> members) {
        this.members = members;
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }
}
