package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        while (!hasLine()) {
            lineGenerator(countOfPerson);
        }
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    boolean hasLine() {
        return points.contains(true);
    }

    boolean isLinesOverlap() {
        for (int i = 0; i < points.size(); i++) {
            if (isOverlap(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOverlap(int i) {
        if (i < points.size() - 1 && points.get(i) && points.get(i + 1)) {
            return true;
        }
        return false;
    }

    private void lineGenerator(int countOfPerson) {
        Random random = new Random();
        for (int i = 0; i < countOfPerson; i++) {
            points.add(random.nextBoolean());
        }
    }

}
