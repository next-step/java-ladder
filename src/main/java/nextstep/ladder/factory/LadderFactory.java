package nextstep.ladder.factory;

import nextstep.ladder.domain.*;
import nextstep.ladder.dto.Height;

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
        return new Line(createPoints(playerNames.size(), isDraw));
    }

    private static Points createPoints(int lineSize,
                                       Supplier<Boolean> isDraw) {
        Points points = Points.drawFirst(isDraw.get());
        IntStream.range(1, lineSize - 1)
                .mapToObj(i -> isDraw.get())
                .forEach(points::drawNext);
        points.drawLast();

        return points;
    }

}
