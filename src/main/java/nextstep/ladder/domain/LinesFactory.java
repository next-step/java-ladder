package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinesFactory {
    private LinesFactory() {
    }

    public static Lines of(int rowCount, int colCount, LineGenerator lineGenerator, BooleanListGenerator listGenerator) {
        List<Line> lines = IntStream.range(0, colCount)
                .mapToObj(i -> lineGenerator.generate(listGenerator.generate(rowCount)))
                .collect(Collectors.toList());

        return Lines.from(lines);
    }
}
