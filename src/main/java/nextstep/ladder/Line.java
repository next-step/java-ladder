package nextstep.ladder;

import nextstep.ladder.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson, LineStrategy lineStrategy) {
        int size = countOfPerson - 1;
        this.points = new ArrayList<>(size);
        draw(lineStrategy, size);
    }

    private void draw(LineStrategy lineStrategy, int size) {
        for (int i = 0; i < size; i++) {
            points.add(isAddTrue(i) && lineStrategy.isDraw());
        }
    }

    private boolean isAddTrue(int index) {
        return index == 0 || !points.get(index - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}