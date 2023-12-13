package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JoinMembers {
    private final List<Member> members = new ArrayList<>();

    public JoinMembers(List<Member> members) {
        this.members.addAll(members);
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public int getNumberOfMembers() {
        return members.size();
    }
}
