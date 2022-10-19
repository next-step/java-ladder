package nextstep.laddar;

import java.util.Random;

public class RandomGenerator implements BooleanGenerator {

    private final Random RAMDOM = new Random();

    @Override
    public boolean generate() {
        boolean b = RAMDOM.nextBoolean();
        System.out.println(b);
        return b;
    }
}
