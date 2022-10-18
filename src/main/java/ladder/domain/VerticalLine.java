package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class VerticalLine {

    private final List<LineUnit> lineUnits;

    private final HorizontalPosition horizontalPosition;

    public VerticalLine(List<LineUnit> lineUnits, HorizontalPosition horizontalPosition) {
        this.lineUnits = lineUnits;
        this.horizontalPosition = horizontalPosition;
    }


    public void move(LadderPosition ladderPosition, LadderLength ladderLength) {
        if (ladderPosition.isArrived(ladderLength)) {
            return;
        }
        LineUnit unit = this.lineUnits.get(ladderPosition.length());
        ladderPosition.down();
        if (unit.hasPrevious()) {
            ladderPosition.previous();
            return;
        }
        if (unit.hasNext()) {
            ladderPosition.next();
            return;
        }
        move(ladderPosition, ladderLength);
    }


    public List<LineUnit> getLineUnits() {
        return lineUnits;
    }

    public boolean isSamePosition(HorizontalPosition horizontalPosition) {
        return this.horizontalPosition.equals(horizontalPosition);
    }
}
