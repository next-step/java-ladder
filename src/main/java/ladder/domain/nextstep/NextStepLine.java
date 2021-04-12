package ladder.domain.nextstep;

import ladder.domain.engine.Line;
import ladder.domain.engine.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NextStepLine implements Line {
    private final List<Point> points ;

    public NextStepLine(List<Point> points){
        this.points = points;
    }

    public List<Point> points(){
        return Collections.unmodifiableList(points);
    }

    public int move(int position){
         return position += points.get(position).move();
    }
}
