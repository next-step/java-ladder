package ladder.domain.member;

import java.util.List;
import java.util.stream.Collectors;

public class MemberGroup {
    private static final int MIN_MEMBERS_SIZE = 2;

    private final List<Member> members;
    private static final String WHITE_SPACE = " ";

    public MemberGroup(List<Member> members) {
        validateMembers(members);

        this.members = members;
    }

    private void validateMembers(List<Member> members) {
        if (members.size() < MIN_MEMBERS_SIZE) {
            throw new IllegalArgumentException("The number of members must be at least " + MIN_MEMBERS_SIZE);
        }
    }

    public int getNumberOfMembers() {
        return this.members.size();
    }

    @Override
    public String toString() {
        return this.members.stream()
                .map(Member::toString)
                .collect(Collectors.joining(WHITE_SPACE))
                .trim();
    }
}
