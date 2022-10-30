package ladder;

import java.util.ArrayList;
import java.util.List;

public class RowGenerator {

    public RowGenerator() {
    }

    public Row create(int people) {
        List<Boolean> points = new ArrayList<>();
        points.add(RandomBooleanGenerator.generator());

        for (int i = 1; i < people-1; i++) {
            boolean generator = RandomBooleanGenerator.generator();
            if (points.get(i - 1).equals(false)) {
                points.add(generator);
            } else {
                points.add(false);
            }
        }
        points.add(false);
        return Row.from(points);
    }
}
