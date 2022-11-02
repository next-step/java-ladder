package ladder;

import java.util.ArrayList;
import java.util.List;

public class RowGenerator {

    public RowGenerator() {
    }

    public Row create(int people) {
        List<Boolean> points = new ArrayList<>();
        points.add(RandomBooleanGenerator.generator());

        for (int index = 1; index < people-1; index++) {
            points.add(isConnected(points, index-1));
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
