package ladder.domain.dto;

import ladder.domain.ladder.Ladder2;
import ladder.domain.ladder.RowPillars;
import ladder.domain.ladder.Stair;
import ladder.exception.ErrorMessage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StairDto2 {

    private final List<Boolean> lines;

    private StairDto2(final List<Boolean> lines) {
        validateLines(lines);
        this.lines = lines;
    }

    public static List<StairDto2> from(final Ladder2 ladder) {
        return ladder.getRowPillars()
                .stream()
                .map(RowPillars::getStairs)
                .map(StairDto2::of)
                .collect(Collectors.toList());
    }

    private static StairDto2 of(final List<Stair> stairs) {
        return new StairDto2(stairs.stream()
                .map(Stair::isRightLineExist)
                .collect(Collectors.toList()));
    }

    private void validateLines(final List<Boolean> lines) {
        if (Objects.isNull(lines)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public List<Boolean> getLines() {
        return lines;
    }
}
