package Ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int BEGIN_POINT = 0;
    private static final int BEFORE_COUNT = 1;
    private static final Boolean LINEAR = true;
    private static final Boolean BLANK = false;

    private List<Point> points = new ArrayList<>();
    private int count;

    public Line(int countOfPerson) {
        this.count = countOfPerson;

    }

    public void initLine() {
        for (int i = 0; i < count - BEFORE_COUNT; i++) {
            points.add(calculatePoint(i));
        }
    }

    public Point calculatePoint(int count) {
        if (count == BEGIN_POINT) {
            return new PointGenerator().getRandomBoolean();
        }
        //이전이 직선인지 아닌지 확인!
        if (validationCheck(points)) {
            return Point.of(BLANK);
        }
        return new PointGenerator().getRandomBoolean();

    }

    public Boolean validationCheck(List<Point> points) {
        return points.get(points.size() - BEFORE_COUNT).equals(Point.of(LINEAR));
    }

    @Override
    public String toString() {
        StringBuilder lineString = new StringBuilder();
        lineString.append("    |");
        points.stream().forEach(point -> lineString.append(point.toString()));
        return lineString.toString();
    }

    //한 라인마다 결과값을 구하는거! 현재위 위치를 주고 그 위치에서 어디로 가야할지 정하는거!
    public int decideDestination(int position) {
            if(position==BEGIN_POINT) {
                return isRight(position);
            }
            if(position==points.size()){
                return isLeft(position);
            }
            int before_position = position - BEFORE_COUNT;

            return where(before_position, position);

    }
    //맨처음 포인트에 있는 데이터일 경우
    public int isRight(int position){
        if(points.get(position).equals(Point.of(LINEAR))){
            return ++position;
        }
        return position;
    }

    //맨 마지막에 있는 포인트에 있는 데이터일 경우
    public int isLeft(int position){
        if(points.get(position - BEFORE_COUNT).equals(Point.of(LINEAR))){
            return --position;
        }
        return position;
    }

    //중간에 있는 포인트들 일 경우
    public int where(int before_position ,int position){
        if(points.get(before_position).equals(Point.of(LINEAR))){
            return --position;
        }
        if(points.get(position).equals(Point.of(LINEAR))){
            return ++position;
        }
        return position;

    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return count == line.count &&
                Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, count);
    }
}



