package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    private Ladder(Height height, int countOfPlayers) {
        IntStream.range(0, height.getHeight())
                .forEach(i -> this.lines.add(Line.of(countOfPlayers)));
    }

    public static Ladder of(Height height, int countOfPlayers) {
        return new Ladder(height, countOfPlayers);
    }

    public int getLineSize() {
        return lines.size();
    }

    public Integer makeResult(Integer index) {
        for (Line line : lines) {
            index = line.move(index).move(index);
        }

        return index;
    }

    @Override
    public String toString() {
        return this.lines.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }
}
