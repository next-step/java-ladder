package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MemberPolePosition {

    private final List<Member> members;

    private MemberPolePosition(final List<Member> members) {
        validate(members);
        this.members = Collections.unmodifiableList(members);
    }

    private void validate(List<Member> members) {
        if (Objects.isNull(members) || members.isEmpty()) {
            throw new IllegalArgumentException("Member must be existed.");
        }
    }

    public static MemberPolePosition newInstance(final List<Member> members) {
        return new MemberPolePosition(members);
    }
}
