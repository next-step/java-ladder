package nextstep.ladder.dto;

import java.util.List;

public class RowDto {
    private final List<Boolean> steps;

    private RowDto(List<Boolean> steps) {
        this.steps = steps;
    }

    public static RowDto from(List<Boolean> steps) {
        return new RowDto(steps);
    }

    public List<Boolean> getSteps() {
        return steps;
    }
}
