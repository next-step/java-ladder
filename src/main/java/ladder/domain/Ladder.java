package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Ladder {

    private static final String EMPTY_LADDER_EXCEPTION_MESSAGE = "사다리는 Line이 1개 이상 있어야 합니다";

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }


    public static Ladder from(List<Line> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LADDER_EXCEPTION_MESSAGE);
        }
        List<Line> unmodifiableLines = Collections.unmodifiableList(lines);
        return new Ladder(unmodifiableLines);
    }

    public LadderResult result() {
        Map<Integer, Integer> resultIndices = resultIndices();
        return LadderResult.from(resultIndices);
    }

    private Map<Integer, Integer> resultIndices() {
        Map<Integer, Integer> resultIndices = new HashMap<>();
        for (int i = 0; i < lines.get(0).size(); i++) {
            int resultIndex = resultIndexOf(i);
            resultIndices.put(i, resultIndex);
        }
        return resultIndices;
    }

    private int resultIndexOf(int index) {
        int lineIndex = 0;
        while (lineIndex < lines.size()) {
            Line currentLine = lines.get(lineIndex);
            Link currentLink = currentLine.linkOf(index);

            lineIndex++;
            index = currentLink.nextIndex(index);
        }
        return index;
    }

    public List<Line> lines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
            "lines=" + lines +
            '}';
    }
}
