package nextstep.ladder.domain;

import java.util.LinkedList;

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
}
