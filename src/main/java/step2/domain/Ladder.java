package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<String> names;
    private final List<Line> lines;

    public Ladder(List<String> names, int height) {
        this.names = names;
        this.lines = Stream.generate(() -> new Line(names.size()))
                .limit(height)
                .collect(Collectors.toList());
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
