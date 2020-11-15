package nextstep.ladder.domain.member;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Members {
    private static final int MIN_MEMBER_COUNT = 2;

    private final List<Member> members;

    public Members(List<Member> members) {
        this.members = members;
    }

    public static Members of(List<String> names) {
        validateMemberCount(names.size());
        return new Members(names.stream()
                .map(Member::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList))
        );
    }

    private static void validateMemberCount(int memberCount) {
        if (memberCount < MIN_MEMBER_COUNT) {
            throw new InvalidMemberCountException();
        }
    }

    public int getCount() {
        return members.size();
    }

    public List<String> getNames() {
        return members.stream()
                .map(Member::getName)
                .collect(Collectors.toList());
    }
}
