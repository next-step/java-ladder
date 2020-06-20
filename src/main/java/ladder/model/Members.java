package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Members {

    private static final String COMMA_DELIMITER = ",";

    private final List<Member> members;

    private Members(final List<Member> members) {
        this.members = members;
    }

    public static Members create(final String inputMembers) {
        validate(inputMembers);
        return create(inputMembers.split(COMMA_DELIMITER));
    }

    private static void validate(final String inputMembers) {
        if (Objects.isNull(inputMembers) || inputMembers.isEmpty()) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람이 없습니다.");
        }
    }

    private static Members create(final String[] memberNames) {
        List<Member> members = Arrays.stream(memberNames)
            .map(Member::create)
            .collect(Collectors.toList());

        return Members.create(members);
    }

    private static Members create(final List<Member> members) {
        return new Members(members);
    }

    public int count() {
        return members.size();
    }

    public Member get(final int index) {
        return members.get(index);
    }
}
