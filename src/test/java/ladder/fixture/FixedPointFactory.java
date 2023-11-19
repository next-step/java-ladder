package ladder.fixture;

import ladder.factory.PointFactory;

import java.util.ArrayList;
import java.util.List;

public class FixedPointFactory extends PointFactory {

    private List<Boolean> givenPoints;

    public FixedPointFactory(List<Boolean> givenPoints) {
        this.givenPoints = givenPoints;
    }

    public List<Boolean> points(int countOfPoints) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < countOfPoints; i++) {
            result.add(this.givenPoints.get(i));
        }

        return result;
    }

}
