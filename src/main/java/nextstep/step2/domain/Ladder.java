package nextstep.step2.domain;

import nextstep.step2.dto.LadderInformation;
import nextstep.step2.vo.BooleanGenerateStrategy;
import nextstep.step2.vo.Height;
import nextstep.step2.vo.Lines;
import nextstep.step2.vo.Width;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int START_LINE = 0;

    private final Lines lines;

    private Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder of(Lines lines) {
        return new Ladder(lines);
    }

    public static Ladder of(LadderInformation info, BooleanGenerateStrategy strategy) {
        Width width = info.getWidth();
        Height height = info.getHeight();

        List<Line> lines = IntStream.range(START_LINE, height.getValue())
                .mapToObj(i -> Line.of(width, strategy))
                .collect(Collectors.toList());

        return of(Lines.of(lines));
    }

    public List<Line> getLineList() {
        return lines.getLines();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    public Point play(Point start) {
        return lines.move(start);
    }
}
