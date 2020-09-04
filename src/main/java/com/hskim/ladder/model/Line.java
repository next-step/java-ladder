package com.hskim.ladder.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private LinkedList<LadderPoint> ladderPoints = new LinkedList<>();

    public Line(LadderLineIterator iterator, RowIndexMaker rowIndexMaker) {
        makePoints(iterator, rowIndexMaker);
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
            ladderPoints.add(new LadderPoint(null, Point.BLANK, Point.COLUMN));
            return;
        }

        LadderPoint prevPoint = ladderPoints.getLast();

        if (iterator.isOnLastIndex()) {
            ladderPoints.add(new LadderPoint(prevPoint.getCurrentPoint(), Point.COLUMN, null));
            return;
        }

        Point nextPoint = iterator.isTargetCounter(targets)
                ? Point.ROW
                : Point.BLANK;

        ladderPoints.add(new LadderPoint(prevPoint.getCurrentPoint(), Point.COLUMN, nextPoint));
        ladderPoints.add(new LadderPoint(Point.COLUMN, nextPoint, Point.COLUMN));
    }

    public RouteInfo<Integer> getRouteInfo() {
        List<LadderPoint> columnList = ladderPoints.stream()
                .filter(LadderPoint::isColumn)
                .collect(Collectors.toList());

        return new RouteInfo<>(
                IntStream.range(0, columnList.size())
                        .boxed()
                        .collect(Collectors.toMap(key -> key, key -> getEndPoint(columnList.get(key), key)))
        );
    }

    private Integer getEndPoint(LadderPoint ladderPoint, Integer startPoint) {
        if (ladderPoint.isLeftDirection()) {
            return startPoint - 1;
        }

        if (ladderPoint.isRightDirection()) {
            return startPoint + 1;
        }

        return startPoint;
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
