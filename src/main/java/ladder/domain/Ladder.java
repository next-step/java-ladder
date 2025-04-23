package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = List.copyOf(lines);
    }

    public static Ladder of(int height, Participants participants, LineDrawStrategy strategy) {
        List<Line> result = new ArrayList<>();
        int numLines = participants.getParticipantsCount();
        for (int i = 0; i < height; i++) {
            result.add(Line.generate(numLines, strategy));
        }
        return new Ladder(result);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int move(int position) {
        return lines.stream()
                .reduce(position, (pos, line) -> line.move(pos), (a, b) -> b);
    }
}
