package nextstep.ladder.domain.ladder;

import java.util.Random;

public class RandomPointAddStrategy implements PointAddStrategy {
    private static final Random random = new Random();

    @Override
    public boolean confirmPointLocation(boolean canPlace) {
        if (canPlace) {
            return random.nextBoolean();
        }
        return false;
    }
}
