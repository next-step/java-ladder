package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static ladder.utils.LadderUtil.separateLineWithComma;

public class Members {

    private final List<Member> members;

    private Members(final List<Member> members) {
        validate(members);
        this.members = Collections.unmodifiableList(members);
    }

    private void validate(final List<Member> members) {
        if (Objects.isNull(members) || members.isEmpty()) {
            throw new IllegalArgumentException("Member must be existed.");
        }
    }

    public static Members newInstance(final List<Member> members) {
        return new Members(members);
    }

    public static Members newInstance(final String[] memberNames) {
        List<Member> members = Arrays.stream(memberNames)
                .map(Member::of)
                .collect(Collectors.toList());

        return newInstance(members);
    }

    public static Members newInstance(final String membersString) {
        return newInstance(separateLineWithComma(membersString));
    }

    public Member get(final int index) {
        return members.get(index);
    }

    public int count() {
        return members.size();
    }

    public List<Member> getMembers() {
        return members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Members)) return false;
        Members members1 = (Members) o;
        return Objects.equals(getMembers(), members1.getMembers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMembers());
    }
}
