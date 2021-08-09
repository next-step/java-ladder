package nextstep.ladder.domain.dto;

import java.util.List;

public class RowDto {
    private final List<Boolean> directions;

    private RowDto(final List<Boolean> directions) {
        this.directions = directions;
    }

    public static RowDto from(final List<Boolean> directions) {
        return new RowDto(directions);
    }

    public List<Boolean> getDirections() {
        return directions;
    }
}
