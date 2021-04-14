package nextstep.refactoring.ladder.concrete.dto;

import nextstep.refactoring.ladder.engine.Line;
import nextstep.refactoring.ladder.engine.Position;
import nextstep.refactoring.ladder.engine.dto.LineDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineDtoImpl implements LineDto {

    private final List<Boolean> pointConnections;

    public LineDtoImpl(List<Boolean> pointConnections) {
        this.pointConnections = pointConnections;
    }

    public static LineDto of(Line line) {
        return IntStream.range(0, line.getWidth() - 1)
                        .mapToObj(Position::of)
                        .map(line::isConnectedToRight)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), LineDtoImpl::new));
    }

    @Override
    public List<Boolean> connectionList() {
        return pointConnections;
    }
}
