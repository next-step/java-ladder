package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {

    private final int height;
    private final List<Line> lines = new ArrayList<>();

    private Lines(int height) {
        this.height = height;
    }

    public static Lines of(int height, int playerCount) {
        Lines lines = new Lines(height);
        for (int i = 0; i < playerCount - 1; i++) {
            lines.add();
        }

        return lines;
    }

    private void add() {
        if (lines.isEmpty()) {
            lines.add(Line.of(height));
            return;
        }

        Line prev = lines.get(lines.size() - 1);
        lines.add(Line.of(height));
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
