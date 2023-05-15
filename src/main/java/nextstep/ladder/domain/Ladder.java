package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;
import nextstep.ladder.domain.strategy.RandomBridgeStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private static final int MIN_WIDTH = 2;
    private static final int MIN_HEIGHT = 1;
    private final BridgeStrategy strategy;
    private final int height;
    private final int width;

    public static List<Line> of(List<String> participantsName, int ladderHeight) {
        Ladder ladder = new Ladder(participantsName.size(), ladderHeight);
        return ladder.create();
    }

    private Ladder(int width, int height) {
        validate(width, height);
        this.width = width;
        this.height = height;
        this.strategy = new RandomBridgeStrategy();
    }

    private void validate(int width, int height) {
        if (width < MIN_WIDTH || height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 1 이상, 넓이는 2 이상이여야 합니다.");
        }
    }

    private List<Line> create() {
        return Stream.generate(() -> new Line(width, strategy))
                .limit(height)
                .collect(Collectors.toList());
    }
}
