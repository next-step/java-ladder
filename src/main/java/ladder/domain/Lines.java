package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines from(List<Line> lines) {
        return new Lines(Collections.unmodifiableList(lines));
    }

    public Map<Integer, Integer> resultIndices() {
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
            System.out.printf("%d %d\n", lineIndex, index);
            Line currentLine = lines.get(lineIndex);
            Link currentLink = currentLine.linkOf(index);

            lineIndex++;
            index = currentLink.nextIndex(index);
        }
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "Lines{" +
            "lines=" + lines +
            '}';
    }

    public List<Line> value() {
        return lines;
    }
}
