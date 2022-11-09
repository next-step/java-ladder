package ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum LadderFactory {
    INSTANCE;

    private static final int MIN_HEIGHT = 2;

    public Ladder generateLadder(int countOfUser, int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 높이의 최소값은 %d입니다. 입력높이: %d", MIN_HEIGHT, height));
        }

        List<Line> lines = IntStream.range(0, height)
                .boxed()
                .map(i -> LineFactory.INSTANCE.generateRandomLine(countOfUser))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }
}
