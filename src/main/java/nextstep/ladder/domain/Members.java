package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Members implements Iterable<Member> {

    public static final String DILIMETER = ",";
    private final List<Member> members;

    private Members(List<Member> members) {
        this.members = members;
    }

    public static Members from(String names) {
        return new Members(Arrays.stream(names.split(DILIMETER))
            .map(Member::from)
            .collect(Collectors.toList()));
    }

    public int size() {
        return members.size();
    }

    @Override
    public Iterator<Member> iterator() {
        return members.iterator();
    }
}
