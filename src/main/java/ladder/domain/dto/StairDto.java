package ladder.domain.dto;

import ladder.domain.ladder.Ladder;

import java.util.ArrayList;
import java.util.List;

public class StairDto {

    private final List<Boolean> lines;

    private StairDto(final List<Boolean> lines) {
        this.lines = lines;
    }

    public static List<StairDto> from(final Ladder ladder) {
        return new ArrayList<>();
    }
}
