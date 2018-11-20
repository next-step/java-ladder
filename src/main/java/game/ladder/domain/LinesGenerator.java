package game.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinesGenerator {

    private final Height height;

    public LinesGenerator(Height height) {
        this.height = height;
    }

    public Lines generate(final int blockSize) {

        List<Line> lines = IntStream.range(0, blockSize)
                .mapToObj(i -> Line.of(blockSize))
                .collect(Collectors.toList());

        return new Lines(lines);
    }

}
