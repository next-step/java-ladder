package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.domain.ladder.Ladder.MINIMUM_HEIGHT;
import static nextstep.ladder.domain.ladder.Ladder.MINIMUM_WIDTH;

public class LadderFactory {

    private final LineFactory lineFactory;

    public LadderFactory(LineFactory lineFactory) {
        this.lineFactory = lineFactory;
    }

    public Ladder createLadder(int height, int width) {
        validateHeight(height);
        validateWidth(width);

        List<Line> lines = Stream.generate(() -> lineFactory.createLine(width))
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

}
