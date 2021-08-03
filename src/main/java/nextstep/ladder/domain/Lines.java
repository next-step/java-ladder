package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {

    private final int height;
    private final List<Line> lines = new ArrayList<>();

    public Lines(int height) {
        this.height = height;
    }

    public void add() {
        if (lines.isEmpty()) {
            lines.add(Line.of(height));
            return;
        }

        Line prev = lines.get(lines.size() - 1);
        lines.add(Line.of(prev));
    }

    public int size() {
        return lines.size();
    }

    public int getHeight() {
        return height;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Boolean> getExists(int index) {
        return lines.stream()
            .map(line -> line.lineExists(index))
            .collect(Collectors.toList());
    }
}
