package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Point> points;

    public Line(int countOfPlayer, PointFactory pointFactory) {
        this.points = pointFactory.createPoints(countOfPlayer);
    }

    @Override
    public String toString() {
        return points.stream().map(Point::toString).collect(Collectors.joining(""));
    }

    public int move(int pointIndex) {
        pointsRangeCheck(pointIndex);

        if (isStartIndex(pointIndex)) {
            return moveToRightPoint(pointIndex);
        }

        if (isEndIndex(pointIndex)){
            return moveToLeftPoint(pointIndex);
        }

        return moveToBothPoint(pointIndex);
    }

    private void pointsRangeCheck(int pointIndex) {
        int maxIndex = points.size()-1;

        if (pointIndex < 0 || maxIndex < pointIndex){
            throw new IllegalArgumentException("point index는 0~"+maxIndex+" 입니다.");
        }
    }

    private boolean isStartIndex(int pointIndex){
        return pointIndex == 0;
    }

    private boolean isEndIndex(int pointIndex){
        return points.size()-1 == pointIndex;
    }

    private int moveToBothPoint(int pointIndex){
        int leftPointIndex = moveToLeftPoint(pointIndex);

        if (leftPointIndex == pointIndex){
            return moveToRightPoint(pointIndex);
        }

        return leftPointIndex;
    }

    private int moveToLeftPoint(int pointIndex){
        if (isMovable(pointIndex)){
            return pointIndex-1;
        }

        return pointIndex;
    }

    private int moveToRightPoint(int pointIndex){
        if (isMovable(pointIndex + 1)){
            return pointIndex+1;
        }

        return pointIndex;
    }

    private Boolean isMovable(int pointIndex) {
        return points.get(pointIndex).isMovable();
    }


}
