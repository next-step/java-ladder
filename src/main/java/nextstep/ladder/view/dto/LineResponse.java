package nextstep.ladder.view.dto;

import nextstep.ladder.model.Line;
import nextstep.ladder.model.Lines;
import nextstep.ladder.model.Point;

import java.util.List;
import java.util.stream.Collectors;

public final class LineResponse {

    private final List<Boolean> points;

    private LineResponse(List<Boolean> points) {
        this.points = points;
    }

    public static List<LineResponse> listFrom(Lines lines) {
        return lines.list()
                .stream()
                .map(LineResponse::from)
                .collect(Collectors.toList());
    }

    private static LineResponse from(Line line) {
        return new LineResponse(line.points()
                .stream()
                .map(Point::isConnected)
                .collect(Collectors.toList()));
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
