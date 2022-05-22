package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        IntStream.range(0, countOfPerson - 1).forEach(i -> makePoint());
    }

    private void makePoint(){
        if (points.isEmpty()) {
            points.add(isTrueOrFalse());
            return;
        }

        Boolean prevLine = points.get(points.size()-1);
        if(!prevLine) {
            points.add(isTrueOrFalse());
            return;
        }

        points.add(false);
    }

    private boolean isTrueOrFalse() {
        Random rd = new Random();
        return rd.nextBoolean();
    }

    public int getLineLength() {
        return points.size();
    }

    public List<Boolean> getLine() {
        return points;
    }
}
