package ladder.step2.domain;

import ladder.step2.dto.LadderDTO;

import java.util.List;

public class Ladder {
    private final List<Line> lines;
    
    public Ladder(List<Line> lines) {
        this.lines = lines;
    }
    
    public LadderDTO ladderInformation() {
        return new LadderDTO(lines);
    }
}
