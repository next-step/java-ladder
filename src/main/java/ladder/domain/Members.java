package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Members {

    private final List<Member> values;

    public Members(List<Member> values) {
        this.values = values;
    }

    public Members(String... values) {
        this(Arrays.stream(values).map(Member::new).collect(Collectors.toList()));
    }

    public List<Member> values() {
        return values;
    }

    public int countOfMembers() {
        return values.size();
    }

    public boolean contains(String person) {
        return values.contains(new Member(person));
    }
}
