package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {
    private static final int ONE = 1;
    private static final int ZERO = 0;
    private final LineFactory lineFactory;

    public LadderFactory(LineFactory lineFactory) {
        this.lineFactory = lineFactory;
    }

    public Ladder create(Participants participants, int height) {
        return create(participants.size(), height);
    }

    public Ladder create(int numberOfLine, int height) {
        validateHeight(height);
        return new Ladder(lines(numberOfLine, height));
    }

    private List<Line> lines(int numberOfLine, int height) {
        return IntStream.range(ZERO, height)
                .mapToObj(index -> lineFactory.create(numberOfConnections(numberOfLine)))
                .collect(Collectors.toUnmodifiableList());
    }

    private int numberOfConnections(int numberOfLine) {
        return numberOfLine - ONE;
    }

    private void validateHeight(int height) {
        if(height <= ZERO) {
            throw new IllegalArgumentException("사다리의 높이는 0 이하일 수 없습니다: " + height);
        }
    }
}
