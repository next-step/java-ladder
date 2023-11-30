package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
        updateFirsLineToFalse();
    }

    private void updateFirsLineToFalse() {
        lines.forEach(Line::updateFirsLineToFalse);
    }


    public static Ladder of(int height, int playerCount) {
        return new Ladder(
            IntStream.range(0, height)
                .mapToObj(i -> Line.from(playerCount))
                .collect(Collectors.toList()));
    }

    public List<Line> lines() {
        return lines;
    }

    public int ladderSize() {
        return lines.size();
    }
}
