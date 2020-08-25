package com.hskim.ladder.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private List<LadderPoint> ladderPoints = new LinkedList<>();

    public Line(LadderLineIterator iterator, RowIndexMaker rowIndexMaker) {
        makePoints(iterator, rowIndexMaker);
    }

    public static List<Line> makeLinesFromLineNum(int lineNum, int userNum, RowIndexMaker rowIndexMaker) {
        return IntStream.range(0, lineNum)
                .mapToObj(i -> new Line(new LadderLineIterator(userNum), rowIndexMaker))
                .collect(Collectors.toList());
    }

    private void makePoints(LadderLineIterator iterator, RowIndexMaker rowIndexMaker) {
        List<Integer> targets = rowIndexMaker.getNumbers(iterator.getSize());

        while (iterator.hasNext()) {
            setPoint(iterator, targets);
            iterator.next();
        }
    }

    private void setPoint(LadderLineIterator iterator, List<Integer> targets) {
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
