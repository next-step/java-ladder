package ladder.domain.nextstep;

import ladder.domain.engine.Line;
import ladder.domain.engine.Point;

import java.util.Collections;
import java.util.List;

public class NextStepLine implements Line {
    private final List<NextStepPoint> points ;

    public NextStepLine(List<NextStepPoint> points){
        this.points = points;
    }

    public List<Point> points(){
        return Collections.unmodifiableList(points);
    }

    public int move(int position){
         return position + points.get(position).move();
    }
}
