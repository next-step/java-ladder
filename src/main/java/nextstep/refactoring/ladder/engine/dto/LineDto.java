package nextstep.refactoring.ladder.engine.dto;

import nextstep.refactoring.ladder.engine.Line;
import nextstep.refactoring.ladder.engine.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineDto {

    private final List<Boolean> pointConnections;

    public LineDto(List<Boolean> pointConnections) {
        this.pointConnections = pointConnections;
    }

    public static LineDto of(Line line) {
        return IntStream.range(0, line.getWidth() - 1)
                        .mapToObj(Position::of)
                        .map(line::isConnectedToRight)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), LineDto::new));
    }

    public List<Boolean> connectionList() {
        return pointConnections;
    }
}
