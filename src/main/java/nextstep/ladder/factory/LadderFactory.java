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
        List<Name> playerNames = creatNames(names);
        return new Ladder(playerNames, createLines(playerNames, new Height(height), isDraw));
    }

    private static List<Name> creatNames(List<String> names) {
        return names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static List<Line> createLines(List<Name> playerNames,
                                          Height ladderheight,
                                          Supplier<Boolean> isDraw) {
        return IntStream.range(0, ladderheight.height())
                .mapToObj(value -> createLine(playerNames, isDraw))
                .collect(Collectors.toList());
    }

    private static Line createLine(List<Name> playerNames,
                                   Supplier<Boolean> isDraw) {
        List<Point> list = new ArrayList<>();
        int lineCount = playerNames.size();
        Point point = Point.first(isDraw.get());
        list.add(point);
        for (int i = 1; i < lineCount - 1; i++) {
            point = point.draw(mayBeDraw(isDraw, point));
            list.add(point);
        }
        list.add(point.last());


        return new Line(list);
    }

    private static boolean mayBeDraw(Supplier<Boolean> isDraw,
                                     Point point) {
        return point.canDrawNext() && isDraw.get();
    }
}
