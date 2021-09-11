package step2.domain;

import java.util.Random;

public class PointRandomStrategy implements PointStrategy{
    @Override
    public boolean create() {
        return new Random().nextBoolean();
    }
}
