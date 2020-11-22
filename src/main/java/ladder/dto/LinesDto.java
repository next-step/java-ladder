package ladder.dto;

import java.util.List;

public class LinesDto {
    private final List<LineDto> lines;

    public LinesDto(List<LineDto> lines) {
        this.lines = lines;
    }

    public List<LineDto> getLines() {
        return lines;
    }
}
