package nextstep.ladder.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LadderRow {

    private final LinkedList<LadderPoint> ladderPoints;

    public LadderRow(int countOfPerson, DirectionStrategy directionStrategy) {
        this.ladderPoints = new LinkedList<>();
        this.ladderPoints.add(LadderPoint.generateFirst(directionStrategy));
        for (int i = 1; i < countOfPerson - 1; i++) {
            LadderPoint last = ladderPoints.getLast();
            this.ladderPoints.add(LadderPoint.generateNext(last, directionStrategy));
        }
        this.ladderPoints.add(LadderPoint.generateLast(ladderPoints.getLast()));
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
