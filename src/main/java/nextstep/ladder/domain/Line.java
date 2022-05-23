package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;

public class Line {
    private static final int EDGE_CNT = 2;
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = unmodifiableList(points);
    }

    public static Line of(int cnt, PointCreationRule pointCreationRule){
        List<Boolean> line = new ArrayList<>();
        for(int i=0; i<cnt+EDGE_CNT; i++){
            line.add(false);
        }
        IntStream.rangeClosed(1, cnt)
                .filter(pointCreationRule::canCreate)
                .filter(index-> isValid(line, index))
                .forEach(index -> createPoint(line, index));
        return new Line(line);
    }

    private static boolean isValid(List<Boolean> line, int index){
        return !line.get(index-1) && !line.get(index+1);
    }

    private static void createPoint(List<Boolean> line, int index){
        line.set(index, true);
    }

    public List<Boolean> getPointList(){
        return points.subList(1, points.size()-1);
    }

    @Override
    public String toString(){
        return "Line: " + points;
    }

}
