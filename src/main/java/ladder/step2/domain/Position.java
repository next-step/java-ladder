package ladder.step2.domain;

import ladder.step2.dto.LadderResultDTO;

import java.util.HashMap;
import java.util.List;

public class Position {
    private final int position;
    
    public Position(final int position) {
        this.position = position;
    }
    
    public int getPosition() {
        return position;
    }
    
    public Position move(final List<PartLine> partLines) {
        if (partLines.get(position).isExist()) {
            return new Position(position - 1);
        }
        
        if (partLines.size() > position + 1 && partLines.get(position + 1).isExist()) {
            return new Position(position + 1);
        }
        return this;
    }
}
