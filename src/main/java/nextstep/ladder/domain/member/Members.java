package nextstep.ladder.domain.member;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Members {
    private static final int MIN_MEMBER_COUNT = 2;

    private final List<Member> members;
    private final int memberCount;

    public Members(List<Member> members) {
        this.members = members;
        this.memberCount = members.size();
    }

    public static Members of(List<String> names) {
        validateMemberCount(names.size());
        return new Members(getMembersFromNames(names)
        );
    }

    private static List<Member> getMembersFromNames(List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(position -> Member.of(names.get(position), position))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    private static void validateMemberCount(int memberCount) {
        if (memberCount < MIN_MEMBER_COUNT) {
            throw new InvalidMemberCountException();
        }
    }

    public int getCount() {
        return memberCount;
    }

    public List<String> getNames() {
        return members.stream()
                .map(Member::getName)
                .collect(Collectors.toList());
    }

    public int findMemberPosition(MemberName name) {
        return members.stream()
                .filter(member -> member.hasName(name))
                .map(Member::getPosition)
                .findFirst()
                .orElseThrow(MemberNotFoundException::new);
    }

    public String getMemberNameAtPosition(Integer position) {
        return members.get(position).getName();
    }
}
