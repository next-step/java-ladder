package step4.dto;

import java.util.List;

import step4.domain.LadderLine;

public class LaddersDto {
    private final List<LadderLine> lines;

    public LaddersDto(List<LadderLine> lines) {
        this.lines = lines;
    }

    public List<LadderLine> getLadderLines() {
        return this.lines;
    }
}
