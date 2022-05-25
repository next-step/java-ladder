package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;

public class Line {

    private static final int EDGE_CNT = 2;
    private static final int EDGE_WIDTH = 1;
    private static final int MIN_POINT_CNT = 0;

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validate(points);
        this.points = unmodifiableList(points);
    }

    private void validate(List<Boolean> points){
        if(points == null){
            throw new IllegalArgumentException("Line의 points는 null일 수 없습니다.");
        }
    }

    public static Line of(int cnt, PointCreationRule pointCreationRule){
        if(cnt < MIN_POINT_CNT){
            throw new IllegalArgumentException("0개 이상의 point개수를 가진 라인만 생성할 수 있습니다.");
        }
        List<Boolean> points = new ArrayList<>();
        for(int i=0; i<cnt+EDGE_CNT; i++){
            points.add(false);
        }
        IntStream.rangeClosed(EDGE_WIDTH, cnt)
                .filter((num)->pointCreationRule.canCreate())
                .filter(index-> isValid(points, index))
                .forEach(index -> createPoint(points, index));
        return new Line(points);
    }

    private static boolean isValid(List<Boolean> line, int index){
        return !line.get(index-1) && !line.get(index+1);
    }

    private static void createPoint(List<Boolean> line, int index){
        line.set(index, true);
    }

    public List<Boolean> getPoints(){
        return points;
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
