package ladder.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointFactory {

    private static final Random RANDOM = new Random();

    private Boolean before = false;

    public List<Boolean> points(int countOfPoints) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < countOfPoints; i++) {
            points.add(point());
        }

        return points;
    }

    private Boolean point() {
        Boolean point = RANDOM.nextBoolean();
        while (!creatable(point)) {
            point = RANDOM.nextBoolean();
        }
        before = point;
        return point;
    }

    private boolean creatable(Boolean point) {
        return !(before == true && point == true);
    }

}
