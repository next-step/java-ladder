package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Members {
    private final List<Member> members;

    public Members(List<Member> members) {
        this.members = members;
    }

    public Position position(String name) {
        return new Position(members.indexOf(new Member(name)));
    }

    public int countOfMember() {
        return members.size();
    }

    public List<String> names() {
        return members.stream().map(Member::name).collect(Collectors.toList());
    }
}
