package ladder.refactoring.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder of(int sizeOfParticipants, Height height) {
        List<LadderLine> lines = Stream.generate(() -> LadderLine.of(sizeOfParticipants))
                .limit(height.getValue())
                .collect(Collectors.toList());
        return new Ladder(lines);
    }

    public List<LadderLine> getLines() {
        return lines;
    }

    public int move(int postion) {
        for (LadderLine line : lines) {
            postion = line.move(postion);
        }
        return postion;
    }
}
