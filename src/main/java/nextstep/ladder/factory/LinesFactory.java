package nextstep.ladder.factory;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Points;
import nextstep.ladder.dto.LinesInformation;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinesFactory {

    private LinesFactory() {
    }

    public static Lines createLines(LinesInformation linesInformation,
                                    Supplier<Boolean> isDraw) {
        return new Lines(IntStream.range(0, linesInformation.height())
                .mapToObj(value -> createLine(linesInformation.width(), isDraw))
                .collect(Collectors.toList()));
    }

    private static Line createLine(int lineSize,
                                   Supplier<Boolean> isDraw) {
        return new Line(createPoints(lineSize, isDraw));
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
