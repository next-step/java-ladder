package ladder;

import java.util.List;

public class Members {

    private final List<Member> members;

    private Members(final List<Member> members) {
        this.members = members;
    }

    public static Members newInstance(final List<Member> members) {
        return new Members(members);
    }
}
