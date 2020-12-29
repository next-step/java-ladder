package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Members {

    private List<Member> members;

    private Members(List<Member> members) {
        this.members = members;
    }

    public static Members of(List<String> names) {
        return names.stream()
                .map(Member::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Members::new));
    }

    public int getNumberOfMembers() {
        return members.size();
    }

    public List<String> getNames() {
        return members.stream()
                .map(Member::getName)
                .collect(Collectors.toList());
    }

    public Member findMemberByName(String name) {
        return members.stream()
                .filter(member -> name.equals(member.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("그런 사람 없습니다."));
    }

    public int getPositionOfMember(Member member) {
        return members.indexOf(member);
    }
}
