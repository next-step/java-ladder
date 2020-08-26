package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final LadderData ladderData;
    private final List<Line> lines;

    public Ladder(LadderData ladderData) {
        this.ladderData = ladderData;
        int nameLength = ladderData.getNames().length();

        lines = Stream.generate(() -> new Line(nameLength, RandomSingleton::nextBoolean))
                .limit(ladderData.getHeight())
                .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return ladderData.getNames().getNames();
    }

    public List<String> getLadderString() {
        return lines.stream()
                .map(line -> lineToString(line.getLineList()))
                .collect(Collectors.toList());
    }

    private String lineToString(List<String> line) {
        return String.join("", line);
    }
}
