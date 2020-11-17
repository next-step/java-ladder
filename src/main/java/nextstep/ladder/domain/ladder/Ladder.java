package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.member.Members;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final Members members;
    private final List<Line> lines;
    private final LadderHeight ladderHeight;

    public Ladder(Members members, List<Line> lines, LadderHeight ladderHeight) {
        this.members = members;
        this.lines = lines;
        this.ladderHeight = ladderHeight;
    }

    public static Ladder of(Members members, List<Line> lines) {
        return new Ladder(members, lines, LadderHeight.of(lines.size()));
    }

    public static Ladder of(Members members, int height) {
        return new Ladder(members, createLines(height, members.getCount()), LadderHeight.of(height));
    }

    private static List<Line> createLines(int height, int memberCount) {
        return IntStream.range(0, height)
                .mapToObj(i -> Line.withPerson(memberCount))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public int getMembersCount() {
        return members.getCount();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getHeight() {
        return ladderHeight.getHeight();
    }

    public List<String> getMemberNames() {
        return members.getNames();
    }
}
