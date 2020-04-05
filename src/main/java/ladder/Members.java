package ladder;

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

    private void validate(List<Member> members) {
        if (Objects.isNull(members) || members.isEmpty()) {
            throw new IllegalArgumentException("Member must be existed.");
        }
    }

    public static Members newInstance(final List<Member> members) {
        return new Members(members);
    }

    public static Members newInstance(final String[] memberNames) {
        List<Member> members = Arrays.stream(memberNames)
                .map(Member::newInstance)
                .collect(Collectors.toList());

        return newInstance(members);
    }

    public static Members newInstance(String inputMembers) {
        return newInstance(separateLineWithComma(inputMembers));
    }

    public MemberCount count() {
        return new MemberCount(members.size());
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
