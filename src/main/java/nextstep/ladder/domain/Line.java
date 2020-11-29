package nextstep.ladder.domain;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final int length;
    private final ConnectionCreationStrategy connectionCreationStrategy;

    public Line(int length, ConnectionCreationStrategy connectionCreationStrategy) {
        this.length = length;
        this.connectionCreationStrategy = connectionCreationStrategy;
    }

    public Connections createConnections() {
        ConnectionCreator connectionCreator = new ConnectionCreator();

        return new Connections(IntStream.range(0, length)
                .mapToObj(point -> connectionCreator.create(point, connectionCreationStrategy))
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }
}
