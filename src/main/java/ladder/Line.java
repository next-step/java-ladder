package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    private void lineGenerator(int countOfPerson) {
        Random random = new Random();
        for (int i = 0; i < countOfPerson; i++) {
            points.add(random.nextBoolean());
        }
    }

}
