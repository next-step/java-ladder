package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.member.Members;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private final Members members;
    private final List<Line> lines;
    private final int height;

    public Ladder(Members members, List<Line> lines) {
        this.members = members;
        this.lines = lines;
        this.height = lines.size();
    }

    public static Ladder of(Members members, List<Line> lines) {
        return new Ladder(members, lines);
    }

    public static Ladder of(Members members, int height) {
        validateHeight(height);
        int memberCount = members.getCount();
        return new Ladder(members, IntStream.range(0, height)
                .mapToObj(i -> Line.withPerson(memberCount))
                .collect(Collectors.toList())
        );
    }

    private static void validateHeight(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new InvalidLadderHeightException();
        }
    }

    public int getMembersCount() {
        return members.getCount();
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return height;
    }

    public List<String> getMemberNames() {
        return members.getNames();
    }
}
