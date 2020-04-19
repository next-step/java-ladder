package nextstep.ladder.domain;

import static nextstep.ladder.util.RandomGenerator.generate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nextstep.ladder.engine.LadderCreator;

public class DefaultLadderCreator implements LadderCreator {
    private static final int SIZE_OF_FIRST_AND_LAST_POINT = 2;

    private final int numberOfPlayers;
    private final int height;

    public DefaultLadderCreator(final int numberOfPlayers, final int height) {
        this.numberOfPlayers = numberOfPlayers;
        this.height = height;
    }

    @Override
    public Ladder create() {
        return new Ladder(IntStream.rangeClosed(1, this.height)
                                   .mapToObj(time -> generateLadderLine())
                                   .collect(Collectors.toList())
        );
    }

    private LadderLine generateLadderLine() {
        boolean current = generate();
        List<ImprovingPoint> points = new ArrayList<>();
        ImprovingPoint point = initFirst(points, current);
        final int betweenSize = getBetweenSize();
        for (int number = 0; number < betweenSize; number++) {
            current = getNext(current);
            point = point.next(current);
            points.add(point);
        }
        initLast(points, point);
        return new LadderLine(points);
    }

    private boolean getNext(final boolean current) {
        return !(current || generate());
    }

    private int getBetweenSize() {
        return numberOfPlayers - SIZE_OF_FIRST_AND_LAST_POINT;
    }

    private void initLast(List<ImprovingPoint> points, ImprovingPoint point) {
        point = point.last();
        points.add(point);
    }

    private ImprovingPoint initFirst(List<ImprovingPoint> points, boolean start) {
        ImprovingPoint point = ImprovingPoint.first(start);
        points.add(point);
        return point;
    }
}
