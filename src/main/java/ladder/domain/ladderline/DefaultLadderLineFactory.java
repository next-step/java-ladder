package ladder.domain.ladderline;

import ladder.domain.model.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.model.Index.START_INDEX;

public class DefaultLadderLineFactory implements LadderLineFactory {

    private final RandomGenerator randomGenerator;

    public DefaultLadderLineFactory(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public LadderLines create(int size, int height) {
        return LadderLines.of(IntStream.range(START_INDEX, height)
                .mapToObj(index -> makeLine(size))
                .collect(Collectors.toList()));
    }

    private LadderLine makeLine(int size) {
        return makeLineThatContainsAllPoint(makeLineThatContainsStartPoint(size));
    }

    private LadderLine makeLineThatContainsAllPoint(LadderLine defaultLine) {
        List<Point> ladderLine = new ArrayList<>();
        ladderLine.add(defaultLine.getStartPoint());
        return makeLineByLadderLineRule(defaultLine, ladderLine);
    }

    private LadderLine makeLineByLadderLineRule(LadderLine defaultLine, List<Point> ladderLine) {
        int size = defaultLine.getSize();
        defaultLine.getLines().stream()
                .reduce((point1, point2) -> {
                    Point point = LadderLineRule.of(randomGenerator, point1, point2.getIndex(), size).makePoint();
                    ladderLine.add(point);
                    return point;
                });
        return LadderLine.of(ladderLine);
    }

    private LadderLine makeLineThatContainsStartPoint(int size) {
        return LadderLine.of(IntStream.range(START_INDEX, size)
                .mapToObj(index -> LadderLineRule.of(randomGenerator, Point.empty(), Index.of(index), size).makePoint())
                .collect(Collectors.toList()));
    }
}
