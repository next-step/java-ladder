package nextstep.ladder.dto;

import java.util.List;

public class LadderBarStatusDto {

    private final List<LineBarStatusDto> lineBarStatus;

    public LadderBarStatusDto(final List<LineBarStatusDto> lineBarStatus) {
        this.lineBarStatus = lineBarStatus;
    }

    public List<LineBarStatusDto> getLineBarStatus() {
        return lineBarStatus;
    }
}
