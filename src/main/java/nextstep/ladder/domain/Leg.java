package nextstep.ladder.domain;

import java.util.Random;

public class Leg {
    public static final Random random = new Random();

    private final boolean exist;

    public Leg(boolean exist) {
        this.exist = exist;
    }

    public static Leg random() {
        return new Leg(random.nextBoolean());
    }

    public static Leg ofNotExist() {
        return new Leg(false);
    }

    public boolean isExist() {
        return exist;
    }
}
