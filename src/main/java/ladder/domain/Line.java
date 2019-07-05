package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public int size() {
        return points.size();
    }
    
    public boolean isLine(int point) {
        return points.get(point);
    }

    public List<Boolean> getLine() {
    	return Collections.unmodifiableList(points);
    }

    public Stream<Boolean> getStream() {
        return points.stream();
    }


}
