package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class JoinMembers {
    private List<Member> members;

    public JoinMembers(List<Member> members) {
        this.members = members;
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public int getNumberOfMembers() {
        return members.size();
    }
}
