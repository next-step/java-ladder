package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;
import nextstep.ladder.domain.strategy.RandomBridgeStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
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
        if (width < 2 || height < 1) {
            throw new IllegalArgumentException("높이는 1 이상, 넓이는 2 이상이여야 합니다.");
        }
    }

    public List<Line> create() {
        return IntStream.rangeClosed(1, height)
                .mapToObj(i -> new Line(width, strategy))
                .collect(Collectors.toList());
    }
}
