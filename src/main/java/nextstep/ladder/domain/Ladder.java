package nextstep.ladder.domain;

import nextstep.ladder.support.DefaultRandomBoolean;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final Members members;

    public Ladder(Members members, int height) {
        this.members = members;
        this.lines = IntStream.range(0, height)
                              .mapToObj(h -> new Line(members.countOfMember(), new DefaultRandomBoolean()))
                              .collect(Collectors.toList());
    }

    public Ladder(Members members, List<Line> lines) {
        this.members = members;
        this.lines = lines;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(this.lines);
    }

    public int move(String memberName) {
        int position = members.position(memberName);
        for (Line line : lines) {
            position = line.position(position);
        }
        return position;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}
