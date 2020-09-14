package refactor.domain.pointGenerate;

import java.util.Random;

public class RandomPoint implements  PointStrategy{

    private Random random = new Random();

    @Override
    public boolean generatePoint() {
        return random.nextBoolean();
    }
}
