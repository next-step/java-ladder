package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public int height() {
        return ladder.size();
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public Point_old resultByPlayer (Point_old pointOldOfPlayer){
        Point_old pointOld = pointOldOfPlayer;
        for (Line line : ladder) {
            if (pointOld.isFirst()) {
                pointOld = pointOld.move(Direction_old.first(line.isLine(pointOld.getIndex())));
                continue;
            }
            if (!pointOld.isFirst() && !pointOld.isLast(line.size())) {
                pointOld = pointOld.move(Direction_old.of(line.isLine(pointOld.getIndex() - 1), line.isLine(pointOld.getIndex())));
                continue;
            }
            if (pointOld.isLast(line.size())) {
                pointOld = pointOld.move(Direction_old.last(line.isLine(pointOld.getIndex() - 1)));
                continue;
            }
        }
        return pointOldOfPlayer;
    }
}
