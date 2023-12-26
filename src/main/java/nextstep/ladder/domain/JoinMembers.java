package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoinMembers {
    public static final String NAME_SPLITTER = ",";

    private final List<Member> members;

    public JoinMembers(String names) {
        this(Stream.of(names.split(NAME_SPLITTER))
                .map(Member::new)
                .collect(Collectors.toList()));
    }

    public JoinMembers(List<Member> members) {
        this.members = members;
    }

    public Member getMember(int idx) {
        return this.members.get(idx);
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public int countOfMembers() {
        return members.size();
    }
}
