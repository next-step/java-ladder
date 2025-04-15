package nextstep.ladder.line;

import nextstep.ladder.Location;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private List<Line> lines;

    public Lines(Location height, int playerCount) {
        this.lines = createLines(height.getValue(), playerCount);
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

    private List<Line> createLines(int height, int playerCount) {
        return Stream.generate(() -> new Line(playerCount))
                .limit(height)
                .collect(Collectors.toList());
    }
}
