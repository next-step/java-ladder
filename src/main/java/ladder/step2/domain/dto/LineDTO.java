package ladder.step2.domain.dto;

import java.util.List;

public class LineDTO {
    private final List<Boolean> partLines;
    
    public LineDTO(List<Boolean> partLines) {
        this.partLines = partLines;
    }
    
    public List<Boolean> getPartLines() {
        return partLines;
    }
}
