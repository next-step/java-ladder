package nextstep.ladder.domain.alternative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static nextstep.ladder.utils.Lists.last;
import static nextstep.ladder.utils.BinaryOperators.nope;

class PointListBuilder {
    private final Boolean[] rightMovables;

    public PointListBuilder(Boolean[] rightMovables) {
        this.rightMovables = rightMovables;
    }

    public List<Point> build() {
        List<Point> result = Arrays.stream(rightMovables)
                .collect(collectPointsTo(ArrayList::new));
        addLast(result);
        return result;
    }

    private Collector<Boolean, List<Point>, List<Point>> collectPointsTo(Supplier<List<Point>> supplier) {
        return Collector.of(supplier,
                            this::addPoint,
                            nope()
        );
    }

    private void addPoint(List<Point> list, Boolean right) {
        if (list.isEmpty()) {
            addFirst(list, right);
            return;
        }
        addNext(list, right);
    }

    private void addFirst(List<Point> list, Boolean right) {
        list.add(Point.first(right));
    }

    private static void addNext(List<Point> list, Boolean right) {
        list.add(last(list).next(right));
    }

    private void addLast(List<Point> result) {
        result.add(last(result).last());
    }
}
