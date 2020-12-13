package nextstep.ladder.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LadderRow {

    private final LinkedList<LadderPoint> ladderPoints;

    public LadderRow(int countOfPerson) {
        this.ladderPoints = new LinkedList<>();
        this.ladderPoints.add(new LadderPoint());
        for (int i = 1; i < countOfPerson; i++) {
            LadderPoint last = ladderPoints.getLast();
            this.ladderPoints.add(new LadderPoint(last, i, countOfPerson));
        }
    }

    public List<LadderPoint> export() {
        return Collections.unmodifiableList(this.ladderPoints);
    }

    public int move(int index) {
        int curIndex = index;
        LadderPoint ladderPoint = ladderPoints.get(curIndex);
        return ladderPoint.move(curIndex);
    }
}
