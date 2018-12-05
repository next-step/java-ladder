package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<LadderLine> lines;

    Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    static Ladder of(int participantCount, int height) {
        List<LadderLine> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(LadderLine.initialize(participantCount, new RandomValueGenerator()));
        }

        return new Ladder(lines);
    }

    Position play(Position position) {
        for (LadderLine line : lines) {
            position = line.move(position);
        }
        return position;
    }

    @Override
    public String toString() {
        return lines.stream()
            .map(LadderLine::toString)
            .collect(Collectors.joining("\n"));
    }
}
