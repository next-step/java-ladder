package nextstep.ladder.domain;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {

    private final Random random = new Random();

    @Override
    public Point nextPoint(Point current) {
        if(current.hasLadder()){
            return Point.of(false);
        }

        return random();
    }

    @Override
    public Point first() {
        return random();
    }

    private Point random(){
        return  Point.of(random.nextBoolean());
    }
}
