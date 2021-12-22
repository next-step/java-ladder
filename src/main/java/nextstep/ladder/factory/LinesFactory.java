package nextstep.ladder.factory;

import nextstep.ladder.generator.LineGenerator;
import nextstep.ladder.generator.LineRandomGenerator;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Lines;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LinesFactory {
    private LinesFactory() {
    }

    public static Lines of(int width, int height, LineGenerator generator) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, height).forEach(index -> lines.add(LineFactory.of(width, generator)));
        return new Lines(lines);
    }

    public static Lines of(int width, int height) {
        return of(width, height, new LineRandomGenerator());
    }
}
