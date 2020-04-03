package nextstep.ladder.domain;

import java.util.Random;

public class RandomStrategy implements MovableStrategy{
    @Override
    public boolean isMovable() {
        return new Random().nextInt(10) >= 6;
    }
}
