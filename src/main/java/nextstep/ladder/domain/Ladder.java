package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final ArrayList<Line> lines;

    public static Ladder generate(int countOfParticipant, int ladderHeight) {
        return new Ladder((ArrayList<Line>) Stream.generate(() -> new Line(countOfParticipant))
                .limit(ladderHeight)
                .collect(Collectors.toList()));
    }

    public Ladder(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public int getHeight() {
        return lines.size();
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}
