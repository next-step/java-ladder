package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JoinMembers {
    private final List<Member> members = new ArrayList<>();

    public JoinMembers(List<Member> members) {
        this.members.addAll(members);
    }

    public static JoinMembers from(List<String> members) {
        return new JoinMembers(members.stream()
                .map(Member::new)
                .collect(Collectors.toList()));
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public int getNumberOfMembers() {
        return members.size();
    }
}
