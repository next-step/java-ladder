package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Members {
    private static final String EXCEPTION_MESSAGE_MEMBERS = "참가자 수가 1보다 작은 수 입니다.";
    private static final String DEFAULT_SPLIT_CHARACTER = ",";
    private static final int DEFAULT_MEMBER_NUMBER = 1;

    private final List<Member> members;

    public Members(List<Member> members) {
        this.members = members;
    }

    public Members(String... members) {
        this(toMembers(members));
    }

    public Members(String memberNames) {
        this(toMembers(getNames(memberNames)));
    }

    private static List<Member> toMembers(String[] memberNames){
        return Arrays.stream(memberNames)
                        .map(Member::new)
                        .collect(Collectors.toList());
    }

    private static String[] getNames(String memberNames) {
        String[] splitMemberNames = memberNames.split(DEFAULT_SPLIT_CHARACTER);
        validateNames(splitMemberNames);
        return splitMemberNames;
    }

    private static void validateNames(String[] splitMemberNames) {
        if (splitMemberNames.length < DEFAULT_MEMBER_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MEMBERS);
        }
    }

    public int countOfMember() {
        return members.size();
    }

    public List<Member> getMembers() {
        return members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Members members1 = (Members) o;
        return Objects.equals(members, members1.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(members);
    }
}
