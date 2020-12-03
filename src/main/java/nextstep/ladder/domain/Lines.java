package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Lines fromHeight(int width, int height, ConnectionCreationStrategy connectionCreationStrategy) {
        return new Lines(IntStream.range(0, height)
                .mapToObj(idx -> new Line(width, connectionCreationStrategy))
                .collect(Collectors.toList()));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getHeight() {
        return lines.size();
    }

    public List<Connection> getConnectionList(int heightPoint) {
        return this.lines.get(heightPoint)
                .getConnections()
                .getConnections();
    }
}
