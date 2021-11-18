package nextstep.step2.domain;

import nextstep.step2.dto.LadderInformation;
import nextstep.step2.vo.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Lines lines;
    private final Width width;
    private final Height height;

    private Ladder(Lines lines, Width width, Height height) {
        this.lines = lines;
        this.width = width;
        this.height = height;
    }

    public static Ladder create(Lines lines, Width width, Height height) {
        return new Ladder(lines, width, height);
    }

    public static Ladder createWithLadderInformation(LadderInformation info, BooleanGenerateStrategy strategy) {
        Width width = info.getWidth();
        Height height = info.getHeight();

        List<Line> lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> Line.createWithWidth(width, strategy))
                .collect(Collectors.toList());

        return create(Lines.create(lines), width, height);
    }

    public List<Line> getLineList() {
        return lines.getLines();
    }
}
