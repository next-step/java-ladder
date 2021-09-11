package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AutoLadderGenerator implements LadderGenerator {
    private static int FIRST_INDEX = 0;
    private static boolean postLine = false;
    private static final Random random = new Random();

    public List<Line> generate(int height, int width) {
        return IntStream.range(FIRST_INDEX, height)
                .mapToObj(n -> new Line(
                                Stream
                                        .generate(this::determine)
                                        .limit(width - 1)
                                        .collect(Collectors.toList())
                        )
                ).collect(Collectors.toList());
    }

    private boolean determine() {
        postLine = postLine ? false : random.nextBoolean();
        return postLine;
    }
}
