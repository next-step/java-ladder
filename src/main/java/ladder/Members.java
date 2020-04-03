package ladder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Members {

    private final List<Member> members;

    private Members(final List<Member> members) {
        validate(members);
        this.members = Collections.unmodifiableList(members);
    }

    public static Members newInstance(final List<Member> members) {
        return new Members(members);
    }

    private void validate(List<Member> members) {
        if (Objects.isNull(members) || members.isEmpty()) {
            throw new IllegalArgumentException("Member must be existed.");
        }
    }

    public int size() {
        return members.size();
    }
}
