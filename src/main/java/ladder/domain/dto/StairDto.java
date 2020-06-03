package ladder.domain.dto;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Pillar;
import ladder.domain.ladder.Stair;
import ladder.exception.ErrorMessage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StairDto {

    private final List<Boolean> lines;

    private StairDto(final List<Boolean> lines) {
        validateLines(lines);
        this.lines = lines;
    }

    public static List<StairDto> from(final Ladder ladder) {
        return ladder.getPillars()
                .stream()
                .map(Pillar::getStairs)
                .map(StairDto::of)
                .collect(Collectors.toList());
    }

    private static StairDto of(final List<Stair> stairs) {
        return new StairDto(stairs.stream()
                .map(Stair::isExistLine)
                .collect(Collectors.toList()));
    }

    private void validateLines(final List<Boolean> lines) {
        if (Objects.isNull(lines) || lines.size() == 0) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }
    }

    public List<Boolean> getLines() {
        return lines;
    }
}
