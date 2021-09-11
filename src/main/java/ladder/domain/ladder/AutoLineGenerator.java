package ladder.domain.ladder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutoLineGenerator implements LadderLineGenerator {
    private static boolean postLine = false;
    private static final Random random = new Random();

    public static AutoLineGenerator create() {
        return new AutoLineGenerator();
    }

    public boolean generate(boolean postLine) {
        return postLine ? false : random.nextBoolean();
    }
}
