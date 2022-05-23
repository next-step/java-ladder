package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Members {
    private static final String DELIMITER = " ";
    private static final String NAME_DELIMITER = ",";

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

    public String getPrettyString() {
        return members.stream()
                .map(Member::toString)
                .map(name -> name + DELIMITER.repeat(Name.MAX_NAME_LENGTH - name.length()))
                .collect(Collectors.joining(DELIMITER))
                .strip();
    }

    public int size() {
        return this.members.size();
    }

    @Override
    public String toString() {
        return this.members.toString();
    }
}
