package ladder.step2.dto;

import ladder.step2.domain.PartLine;

import java.util.List;

public class LineDTO {
    private final List<PartLine> partLines;
    
    public LineDTO(List<PartLine> partLines) {
        this.partLines = partLines;
    }
    
    public List<PartLine> getPartLines() {
        return partLines;
    }
}
