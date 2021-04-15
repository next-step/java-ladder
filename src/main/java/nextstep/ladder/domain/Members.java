package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Members implements Iterable<Member> {

    public static final String DILIMETER = ",";
    private final List<Member> members;

    private Members(List<Member> members) {
        this.members = members;
    }

    public static Members of(String names) {
        return new Members(Arrays.stream(names.split(DILIMETER))
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

    public int findHorizontalNumber(Member member) {
        return IntStream.range(0, members.size())
            .filter(i -> member.equals(members.get(i)))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("참가자가 아닙니다."));
    }
}
