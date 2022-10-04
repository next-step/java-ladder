package ladder.step2.domain.dto;

import ladder.step2.domain.Line;

import java.util.List;

public class LadderDTO {
    private final List<Line> lines;
    
    public LadderDTO(List<Line> lines) {
        this.lines = lines;
    }
    
    public List<Line> getLines() {
        return lines;
    }
}
