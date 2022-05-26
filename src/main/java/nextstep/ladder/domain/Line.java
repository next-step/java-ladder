package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;

public class Line {

    private static final String CANNOT_NULL_FOR_POINTS = "Line의 points는 null일 수 없습니다.";
    private static final String INVALID_LINE_POINT_CNT = "0개 이상의 point개수를 가진 라인만 생성할 수 있습니다.";
    private static final int EDGE_CNT = 2;
    private static final int EDGE_WIDTH = 1;
    private static final int MIN_POINT_CNT = 0;
    private static final int DIFF_BETWEEN_CUR_AND_BEFORE_INDEX = 1;


    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validate(points);
        this.points = unmodifiableList(points);
    }

    private void validate(List<Boolean> points){
        if(points == null){
            throw new IllegalArgumentException(CANNOT_NULL_FOR_POINTS);
        }
    }

    public static Line of(int cnt, PointCreationRule pointCreationRule){
        if(cnt < MIN_POINT_CNT){
            throw new IllegalArgumentException(INVALID_LINE_POINT_CNT);
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
        return !line.get(index-DIFF_BETWEEN_CUR_AND_BEFORE_INDEX) && !line.get(index+DIFF_BETWEEN_CUR_AND_BEFORE_INDEX);
    }

    private static void createPoint(List<Boolean> line, int index){
        line.set(index, true);
    }

    public List<Boolean> getPoints(){
        return points;
    }

    public int moveFrom(int index) {
        if(points.get(index)){
            return index-DIFF_BETWEEN_CUR_AND_BEFORE_INDEX;
        }
        if(points.get(index+1)){
            return index+DIFF_BETWEEN_CUR_AND_BEFORE_INDEX;
        }
        return index;
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
