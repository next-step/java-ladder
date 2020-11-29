package nextstep.ladder;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final int length;

    public Line(int length) {
        this.length = length;
    }

    public Connections createConnections(ConnectionCreationStrategy connectionCreationStrategy) {
        boolean isConnectionCreated = false;

        return new Connections(IntStream.range(0, length)
                .filter(i -> connectionCreationStrategy.isAble())
                .mapToObj(Connection::new)
                .collect(Collectors.toList()));
    }
}
