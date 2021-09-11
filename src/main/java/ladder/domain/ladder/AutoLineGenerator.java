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

    public List<Boolean> generate(int maxLadderWidth) {
        postLine = false;
        return Stream.generate(this::determine)
                .limit(maxLadderWidth)
                .collect(Collectors.toList());
    }

    private boolean determine() {
        postLine = postLine ? false : random.nextBoolean();
        return postLine;
    }
}
