package nextstep.ladder.factory;

import nextstep.ladder.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {

    private LadderFactory() {
    }

    public static Ladder create(List<String> names,
                                int height,
                                Supplier<Boolean> isDraw) {
        Names playerNames = creatNames(names);
        return new Ladder(playerNames, createLines(playerNames, new Height(height), isDraw));
    }

    private static Names creatNames(List<String> names) {
        return new Names(names.stream()
                .map(Name::new)
                .collect(Collectors.toList()));
    }

    private static Lines createLines(Names playerNames,
                                     Height ladderheight,
                                     Supplier<Boolean> isDraw) {
        return new Lines(IntStream.range(0, ladderheight.height())
                .mapToObj(value -> createLine(playerNames, isDraw))
                .collect(Collectors.toList()));
    }

    private static Line createLine(Names playerNames,
                                   Supplier<Boolean> isDraw) {
        return new Line(createPoints(playerNames, isDraw));
    }

    private static List<Point> createPoints(Names playerNames,
                                            Supplier<Boolean> isDraw) {
        Point firstPoint = Point.first(isDraw.get());
        List<Point> points = new ArrayList<>();
        points.add(firstPoint);

        Point previousPoint = firstPoint;
        for (int i = 1; i < playerNames.size() - 1; i++) {
            Point newPoint = previousPoint.draw(mayBeDraw(isDraw, previousPoint));
            points.add(newPoint);
            previousPoint = newPoint;
        }

        points.add(previousPoint.last());

        return points;
    }

    private static boolean mayBeDraw(Supplier<Boolean> isDraw,
                                     Point point) {
        return point.canDrawNext() && isDraw.get();
    }
}
