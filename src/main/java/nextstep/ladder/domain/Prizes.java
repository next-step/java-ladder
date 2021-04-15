package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes implements Iterable<Member> {

    public static final String DILIMETER = ",";
    private final List<Member> members;

    private Prizes(List<Member> members) {
        this.members = members;
    }

    public static Prizes of(String names) {
        return new Prizes(Arrays.stream(names.split(DILIMETER))
            .map(Member::of)
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
