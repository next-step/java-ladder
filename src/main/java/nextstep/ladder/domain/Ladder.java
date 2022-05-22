package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.dto.LadderStandardDto;
import nextstep.ladder.exception.LadderLineNullException;
import nextstep.ladder.generator.PositionGenerator;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateNullAndEmpty(lines);
        this.lines = lines;
    }

    public Ladder(PositionGenerator productionGenerator, LadderStandardDto ladderStandardDto) {
        this(createLines(productionGenerator, ladderStandardDto));
    }

    private void validateNullAndEmpty(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new LadderLineNullException();
        }
    }

    private static List<Line> createLines(PositionGenerator productionGenerator, LadderStandardDto ladderStandardDto) {
        return IntStream.range(0, ladderStandardDto.getHeight())
                .mapToObj(i -> new Line(productionGenerator, ladderStandardDto.getWidth()))
                .collect(Collectors.toList());
    }

    public int ride(int position) {
        for (Line line : lines) {
            position = line.ride(position);
        }

        return position;
    }

    public List<Line> getLines() {
        return lines;
    }
}
