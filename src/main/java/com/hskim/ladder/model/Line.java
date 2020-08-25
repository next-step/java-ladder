package com.hskim.ladder.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {

    private List<LadderPoint> ladderPoints = new LinkedList<>();

    public Line(LineIterator iterator, RowIndexMaker rowIndexMaker) {
        makePoints(iterator, rowIndexMaker);
    }

    private void makePoints(LineIterator iterator, RowIndexMaker rowIndexMaker) {
        List<Integer> targets = rowIndexMaker.getNumbers(iterator.getSize());

        while (iterator.hasNext()) {
            setPoint(iterator, targets);
            iterator.next();
        }
    }

    private void setPoint(LineIterator iterator, List<Integer> targets) {
        if (iterator.isOnStartIndex()) {
            ladderPoints.add(LadderPoint.BLANK);
            return;
        }

        if (iterator.isOnLastIndex()) {
            ladderPoints.add(LadderPoint.COLUMN);
            return;
        }

        ladderPoints.add(LadderPoint.COLUMN);

        if (iterator.isTargetCounter(targets)) {
            ladderPoints.add(LadderPoint.ROW);
            return;
        }

        ladderPoints.add(LadderPoint.BLANK);
    }

    public List<LadderPoint> getLadderPoints() {
        return ladderPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(ladderPoints, line.ladderPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderPoints);
    }
}
