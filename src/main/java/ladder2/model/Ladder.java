package ladder2.model;

import ladder2.util.LadderPointGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    List<LadderLine> lines;

    private Ladder(List<LadderLine> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.lines = lines;
    }

    public static Ladder from(List<LadderLine> lines) {
        return new Ladder(lines);
    }

    public static Ladder from(int countOfLine, Participants participants, LadderPointGenerator ladderPointGenerator) {
        List<LadderLine> lines = IntStream.range(0, countOfLine)
                .mapToObj(index -> LadderLine.from(participants.size()).generate(ladderPointGenerator))
                .collect(Collectors.toList());
        return new Ladder(lines);
    }

    public List<LadderLine> getLines() {
        // ref: https://www.baeldung.com/java-immutable-list
        return Collections.unmodifiableList(lines);
    }

    public int moveFrom(int beginIndex) {
        int lastIndex = beginIndex;
        for (LadderLine line : lines) {
            lastIndex = line.move(lastIndex);
        }
        return lastIndex;
    }

    public boolean isMatchPointCount(int count) {
        return lines.get(0).pointSize() == count;
    }
}
