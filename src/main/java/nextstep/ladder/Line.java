package nextstep.ladder;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final int length;

    public Line(int length) {
        this.length = length;
    }

    public Connections createConnections(ConnectionCreationStrategy connectionCreationStrategy) {
        ConnectionCreator connectionCreator = new ConnectionCreator(connectionCreationStrategy);

        return new Connections(IntStream.range(0, length)
                .mapToObj(connectionCreator::create)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }
}
