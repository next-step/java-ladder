package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final LineStrategy strategy;
    private List<Boolean> points = new ArrayList<>();


    public Line(int countOfPerson, LineStrategy strategy) {
        this.strategy = strategy;

        points.add(strategy.addLine());

        for (int i = 1; i < countOfPerson - 1; i++) {
            points.add(addLine(i));
        }
    }

    public List<Boolean> getPoints() {
        return this.points;
    }

    private boolean addLine(int index) {
        if (points.get(index - 1)) {
            return false;
        }

        return strategy.addLine();
    }


}
