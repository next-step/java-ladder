package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Members {

    private static final String COMMA_DELIMITER = ",";

    private final List<Member> members;

    public Members(List<Member> members) {
        validate(members);
        this.members = members;
    }

    private void validate(List<Member> members) {
        if (Objects.isNull(members) || members.isEmpty()) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람이 없습니다.");
        }
    }

    public static Members create(String inputMembers) {
        return create(inputMembers.split(COMMA_DELIMITER));
    }

    public static Members create(final String[] memberNames) {
        List<Member> members = Arrays.stream(memberNames)
            .map(Member::create)
            .collect(Collectors.toList());

        return Members.create(members);
    }

    public static Members create(final List<Member> members) {
        return new Members(members);
    }

    public int count() {
        return members.size();
    }

    public List<Member> getMembers() {
        return members;
    }
}
