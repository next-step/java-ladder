package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {

    private final List<Line> lines;

    public LadderLine(int playerCount, int ladderHeight) {
        this.lines = Stream.generate(() -> new Line(playerCount, RandomSingleton::nextBoolean))
                           .limit(ladderHeight)
                           .collect(Collectors.toList());
    }

    public List<String> toStringList() {
        return lines.stream()
                    .map(line -> lineToString(line.lineToString()))
                    .collect(Collectors.toList());
    }

    private String lineToString(List<String> line) {
        return String.join("", line);
    }

    public int getResultOf(int startIndex) {

        int currentIndex = startIndex;

        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }

        return currentIndex;
    }
}
