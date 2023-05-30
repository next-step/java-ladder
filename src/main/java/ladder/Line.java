package ladder;

import ladder.util.RandomValueGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            if (isInValidPosition(i)) {
                points.add(false);
            } else {
                points.add(RandomValueGenerator.generate());
            }
        }
    }

    private boolean isInValidPosition(int position) {
        return isLeftTrue(position);
    }

    private boolean isLeftTrue(int position) {
        return (position - 1 >= 0 && points.get(position - 1));
    }


    public List<Boolean> getPoints() {
        return points;
    }
}
