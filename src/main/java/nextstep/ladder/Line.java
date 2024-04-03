package nextstep.ladder;

import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private List<Boolean> points;

    public Line(List<Boolean> points) {
        checkOverLabLine(points);
        this.points = points;
    }

    private void checkOverLabLine(List<Boolean> points) {
        boolean foundOverLab = IntStream.range(0, points.size()-1)
                .anyMatch(i -> points.get(i) && points.get(i+1));

        if(foundOverLab)
            throw new IllegalArgumentException("라인이 중복되면 안됩니다.");
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
