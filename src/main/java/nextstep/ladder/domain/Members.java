package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Members {

    private List<Member> members;

    private Members(List<Member> members) {
        this.members = members;
    }

    public static Members of(String ... name) {
        List<Member> members = Stream.of(name)
                .map(Member::new)
                .collect(Collectors.toList());

        return new Members(members);
    }

    public int getNumberOfMembers() {
        return members.size();
    }
}
