package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.LineFactory;
import nextstep.ladder.dto.Connections;
import nextstep.ladder.dto.LadderDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private static final int MINIMUM_HEIGHT = 1;
    private static final int MINIMUM_WIDTH = 2;

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, int width) {
        validateHeight(height);
        validateWidth(width);

        List<Line> lines = Stream.generate(() -> LineFactory.createLine(width))
                                 .limit(height)
                                 .collect(Collectors.toList());

        return new Ladder(lines);
    }

    private static void validateHeight(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }

    private static void validateWidth(int width) {
        if (width < MINIMUM_WIDTH) {
            throw new IllegalArgumentException("사다리 너비는 2 이상이어야 합니다.");
        }
    }

    public LadderDto export() {
        List<Connections> connectionsList = lines.stream()
                                                 .map(Line::exportConnections)
                                                 .collect(Collectors.toList());
        
        return new LadderDto(connectionsList);
    }
}
