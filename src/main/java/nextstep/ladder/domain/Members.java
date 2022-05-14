package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Members {
    private final static String NAME_DELIMITER = ",";

    private final List<Member> members;

    public Members(String names) {
        this(toList(names));
    }

    Members(List<Member> members) {
        this.members = members;
    }

    static Members of(List<String> names) {
        return new Members(join(names));
    }

    private static String join(List<String> names) {
        return String.join(NAME_DELIMITER, names);
    }

    private static List<Member> toList(String names) {
        return Arrays.stream(names.split(NAME_DELIMITER))
                .map(Member::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.members.toString();
    }
}
