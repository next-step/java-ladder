package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private static final int MIN_JOIN_MEMBER_COUNT = 2;
    private final List<Name> names;

    public Names(List<String> joinMembers) {
        validate(joinMembers.size());

        this.names = joinMembers.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(this.names);
    }

    public int countJoinMembers() {
        return this.names.size();
    }

    private void validate(int joinMembersCount) {
        if (joinMembersCount < MIN_JOIN_MEMBER_COUNT) {
            throw new IllegalArgumentException("최소 2명 이상의 참가자를 입력해야 합니다.");
        }
    }
}
