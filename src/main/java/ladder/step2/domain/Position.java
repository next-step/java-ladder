package ladder.step2.domain;

import java.util.List;

public class Position {
    private final int position;
    
    public Position(final int position) {
        this.position = position;
    }
    
    public Position move(final List<PartLine> partLines) {
        if (isExistLeftPartLine(partLines)) {
            return new Position(position - 1);
        }
        
        if (isExistRightPartLine(partLines)) {
            return new Position(position + 1);
        }
        return this;
    }
    
    private boolean isExistRightPartLine(final List<PartLine> partLines) {
        return partLines.size() > position + 1 && partLines.get(position + 1).isExist();
    }
    
    private boolean isExistLeftPartLine(final List<PartLine> partLines) {
        return partLines.get(position).isExist();
    }
    
    public int getPosition() {
        return position;
    }
}
