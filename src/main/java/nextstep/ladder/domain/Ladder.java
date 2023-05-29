package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {

    private static final int BEGIN_INDEX = 0;

    private final int verticalLineCount;
    private final Lines lines;

    public Ladder(int verticalLineCount, Lines lines) {
        this.verticalLineCount = verticalLineCount;
        this.lines = lines;
    }

    public Ladder(int verticalLineCount, int height) {
        this(verticalLineCount, new Lines(generateLines(verticalLineCount, height)));
    }

    private static List<Line> generateLines(int verticalLineCount, int height) {
        return Stream.generate(() -> new Line(verticalLineCount))
                .limit(height)
                .collect(Collectors.toList());
    }

    public Lines lines() {
        return lines;
    }

    public String[][] result() {
        List<Line> lines = this.lines.value();

        int width = verticalLineCount * 2 - 1;
        int height = this.lines.value().size();

        String[][] ladder = new String[height][width];

        IntStream.range(BEGIN_INDEX, height)
                .forEach(i -> IntStream.range(BEGIN_INDEX, width)
                        .forEach(j -> {
                            if (isVerticalLine(j)) {
                                ladder[i][j] = "v";
                                return;
                            }
                            if (isHorizontalLine(lines, i, j)) {
                                ladder[i][j] = "h";
                            }
                        }));
        return ladder;
    }

    private boolean isVerticalLine(int j) {
        return j % 2 == 0;
    }

    private Boolean isHorizontalLine(List<Line> lines, int i, int j) {
        return lines.get(i).value().get((j - 1) / 2);
    }

}
