package ladder;

import java.util.List;

public class Members {

    private final List<Member> members;

    private Members(List<Member> members) {
        this.members = members;
    }

    public static Members newInstance(List<Member> members) {
        return new Members(members);
    }
}
