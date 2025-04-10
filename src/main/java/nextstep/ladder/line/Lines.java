package nextstep.ladder.line;

import nextstep.ladder.Height;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private List<Line> lines;

    public Lines(Height height, int playerCount) {
        this.lines = createLines(height.getValue(), playerCount);
    }

    private List<Line> createLines(int height, int playerCount) {
        return Stream.generate(() -> new Line(playerCount))
                .limit(height)
                .collect(Collectors.toList());
    }

    public int size() {
        return lines.size();
    }

    public Line get(int index) {
        return lines.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Line line : lines) {
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }
}
