package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinesFactory {
    private static final int MIN_COL_COUNT = 1;

    private LinesFactory() {
    }

    public static Lines of(int colCount, BooleanListGenerator listGenerator) {
        validateLines(colCount, listGenerator);
        List<Line> lines = IntStream.range(0, colCount)
                .mapToObj(i -> LineGenerator.generate(listGenerator.generate()))
                .collect(Collectors.toList());

        return Lines.from(lines);
    }

    private static void validateLines(int colCount, BooleanListGenerator generator) {
        if (colCount < MIN_COL_COUNT) {
            throw new IllegalArgumentException();
        }
        if (Objects.isNull(generator)) {
            throw new IllegalArgumentException();
        }
    }
}
