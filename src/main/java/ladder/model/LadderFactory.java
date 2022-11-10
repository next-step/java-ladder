package ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum LadderFactory {
    INSTANCE;

    public Ladder generateLadder(int countOfUser, LadderHeight height) {
        List<Line> lines = IntStream.range(0, height.getValue())
                .boxed()
                .map(i -> LineFactory.INSTANCE.generateRandomLine(countOfUser))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }
}
