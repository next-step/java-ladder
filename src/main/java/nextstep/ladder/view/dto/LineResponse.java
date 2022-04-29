package nextstep.ladder.view.dto;

import nextstep.ladder.model.Line;
import nextstep.ladder.model.Point;

import java.util.List;
import java.util.stream.Collectors;

public final class LineResponse {

    private final List<Boolean> connections;

    private LineResponse(List<Boolean> connections) {
        this.connections = connections;
    }

    static LineResponse from(Line line) {
        return new LineResponse(line.points()
                .stream()
                .map(Point::isConnected)
                .collect(Collectors.toList()));
    }

    public List<Boolean> getConnections() {
        return connections;
    }
}
