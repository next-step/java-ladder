package ladder.step2.domain;

import java.util.Random;

public class PartLineFactory {
    public static PartLine random() {
        return new PartLine(randomBoolean());
    }
    
    private static boolean randomBoolean() {
        return new Random().nextBoolean();
    }
}
