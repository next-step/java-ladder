package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final int participantCount;
    private final List<LadderLine> lines;

    Ladder(int participantCount, List<LadderLine> lines) {
        this.participantCount = participantCount;
        this.lines = lines;
    }

    static Ladder of(int participantCount, int height) {
        List<LadderLine> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(LadderLine.initialize(participantCount, new RandomValueGenerator()));
        }

        return new Ladder(participantCount, lines);
    }

    public PlayResults play() {
        PlayResults results = new PlayResults();

        for (int i = 0; i < participantCount; i++) {
            Position end = goDown(Position.from(i));
            results.add(new PlayResult(Position.from(i), end));
        }

        return results;
    }

    Position goDown(Position position) {
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
