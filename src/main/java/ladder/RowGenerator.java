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
            points.add(isConnected(points, i-1));
        }
        points.add(false);
        return new Row(points);
    }

    public boolean isConnected(List<Boolean> points, int index) {
        boolean generator = RandomBooleanGenerator.generator();

        if (!points.get(index)) {
            return generator;
        }
        return false;
    }
}
