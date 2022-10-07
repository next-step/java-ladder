package ladder.step2.domain;

import java.util.List;

public class Position {
    private final int position;
    
    public Position(final int position) {
        this.position = position;
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
    
    public int getPosition() {
        return position;
    }
}
