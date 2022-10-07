package ladder.step2.dto;

import ladder.step2.domain.Line;
import ladder.step2.domain.PartLine;

import java.util.List;

public class LineDTO {
    private final List<PartLine> partLines;
    
    public LineDTO(Line line) {
        this.partLines = line.getPartLines();
    }
    
    public List<PartLine> getPartLines() {
        return partLines;
    }
}
