package nextstep.ladder.domain;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final Connections connections;

    public Line(int width, ConnectionCreationStrategy connectionCreationStrategy) {
        this.connections = createConnections(width, connectionCreationStrategy);
    }

    private Connections createConnections(int width, ConnectionCreationStrategy connectionCreationStrategy) {
        ConnectionCreator connectionCreator = new ConnectionCreator();

        return new Connections(IntStream.range(0, width)
                .mapToObj(point -> connectionCreator.create(point, connectionCreationStrategy))
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }

    public Connections getConnections() {
        return connections;
    }
}
