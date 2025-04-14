package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int move(int startIndex) {
        int position = startIndex;
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(line).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
