package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

public class Line {

    private static final String CANNOT_NULL_FOR_POINTS = "Line의 points는 null일 수 없습니다.";
    private static final int MIN_POINT_CNT = 1;

    private final List<Point> points;

    public Line(List<Point> points) {
        validate(points);
        this.points = unmodifiableList(points);
    }

    private void validate(List<Point> points){
        if(points == null){
            throw new IllegalArgumentException(CANNOT_NULL_FOR_POINTS);
        }
    }

    public static Line of(int cnt, PointCreationRule pointCreationRule){
        if(cnt < MIN_POINT_CNT){
            throw new IllegalArgumentException(MIN_POINT_CNT+"개 이상의 point개수를 가진 라인만 생성할 수 있습니다.");
        }
        List<Point> points = new ArrayList<>();

        Point firstPoint = initFirst(points, pointCreationRule);
        Point lastBeforePoint = initBody(cnt-2, points, firstPoint, pointCreationRule);
        initLast(points, lastBeforePoint);

        return new Line(points);
    }

    private static Point initBody(int count, List<Point> points, Point point, PointCreationRule pointCreationRule) {
        for(int i=0; i<count; i++){
            point = point.next(pointCreationRule.canCreate());
            points.add(point);
        }
        return point;
    }

    private static Point initFirst(List<Point> points, PointCreationRule pointCreationRule){
        Point point = Point.first(pointCreationRule.canCreate());
        points.add(point);
        return point;
    }

    private static void initLast(List<Point> points, Point lastBeforePoint){
        Point point = lastBeforePoint.last();
        points.add(point);
    }

    public List<Point> getPoints(){
        return points;
    }

    public int moveFrom(int position) {
        Point point = getPoints().get(position);
        return point.move();
    }

    @Override
    public String toString(){
        return "Line: " + points;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || obj.getClass() != getClass()){
            return false;
        }
        Line line = (Line) obj;
        return Objects.equals(line.points, this.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
