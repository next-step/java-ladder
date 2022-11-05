package ladder.dto;

import ladder.domain.LadderLine;

import java.util.List;

public class LineDto {
    private final List<Boolean> parts;

    public LineDto(LadderLine ladderLine) {
        this.parts = ladderLine.parts();
    }

    public List<Boolean> parts() {
        return parts;
    }
}
