package ladder.domain.next;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {

    private List<Point> points;

    LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        if( points.size() <= position )throw new IllegalArgumentException("존재하지 않는 이동위치 입니다");
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point first = initFirst(points);
        Point current = initBody(sizeOfPerson, points, first);
        initLast(points, current);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point first) {
        Point current = first;
        for( int i = 1 ; i < sizeOfPerson - 1 ; i++ ){
            Point next = current.next();
            points.add(next);
            current = next;
        }
        return current;
    }

    private static void initLast(List<Point> points, Point current) {
        points.add(current.last());
    }

    private static Point initFirst(List<Point> points) {
        Point first = Point.first(DirectionGenerator.generate());
        points.add(first);
        return first;
    }

    @Override
    public String toString() {
        String str = points.stream()
                .map( point -> point.toString())
                .collect(Collectors.joining());
        return "      " + str;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private List<Point> points;
        private Point current;
        private int index;

        public Builder() {
            this.points = new ArrayList<>();
            this.index = 0;
        }

        public Builder first(boolean right){
            current = new Point(index++, Direction.first(right));
            points.add(current);
            return this;
        }

        public Builder next(boolean right){
            current = current.next(right);
            points.add(current);
            return this;
        }

        public Builder last(){
            points.add(current.last());
            return this;
        }

        public LadderLine build(){
            return new LadderLine(points);
        }

    }
}
