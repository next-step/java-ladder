package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder of(int numberOfColumns, int height) {
        List<LadderLine> lines = IntStream.range(0, height)
                .mapToObj(i -> LadderLine.from(numberOfColumns))
                .collect(Collectors.toList());
        return new Ladder(lines);
    }

    public LadderLine getLine(int indexOfHeight) {
        return lines.get(indexOfHeight);
    }

    public int getHeight() {
        return lines.size();
    }

}
