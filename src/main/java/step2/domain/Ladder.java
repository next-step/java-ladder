package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<String> names;
    private final List<Line> lines;

    public Ladder(List<String> names, int height) {
        this.names = names;
        lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(names.size()));
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : names) {
            stringBuilder.append(String.format("%6s", name));
        }
        stringBuilder.append("\n");

        for (Line line : lines) {
            stringBuilder.append(line);
        }

        return stringBuilder.toString();
    }
}
