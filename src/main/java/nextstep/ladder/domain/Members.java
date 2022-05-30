package nextstep.ladder.domain;

import java.util.ArrayList;
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
        String[] split = names.split(NAME_DELIMITER);

        List<Member> members = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            members.add(new Member(split[i], i));
        }

        return members;
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

    public void movePositions(Lines lines) {
        this.members.forEach(lines::move);
    }

    public Member findByName(String name) {
        return this.members.stream()
                .filter(member -> member.matchName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다."));
    }

    @Override
    public String toString() {
        return this.members.toString();
    }
}
