package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final LadderData ladderData;
    private final List<Line> lineList;

    public Ladder(LadderData ladderData) {
        this.ladderData = ladderData;
        int nameLength = ladderData.getNames().length();

        lineList = Stream.iterate(0, i -> i + 1)
                .limit(ladderData.getHeight())
                .map(i -> new Line(nameLength, RandomSingleton::nextBoolean))
                .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return ladderData.getNames().getNames();
    }

    public List<String> getLadderString() {
        return lineList.stream()
                .map(line -> lineToString(line.getLineList()))
                .collect(Collectors.toList());
    }

    private String lineToString(List<String> line) {
        return String.join("", line);
    }
}
