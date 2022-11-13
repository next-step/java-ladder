package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {

    private final LineFactory lineFactory;

    public LadderFactory(LineFactory lineFactory) {
        this.lineFactory = lineFactory;
    }

    public Ladder generateLadder(int countOfUser, LadderHeight height) {
        List<Line> lines = IntStream.range(0, height.getValue())
                .boxed()
                .map(i -> lineFactory.generateRandomLine(countOfUser))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }
}
