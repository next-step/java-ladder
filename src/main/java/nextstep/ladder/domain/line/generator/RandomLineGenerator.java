package nextstep.ladder.domain.line.generator;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineGenerator implements LineGenerator {

    private static final int START = 0;
    private static final Random random = new Random();

    @Override
    public List<Boolean> generator(int countOfPerson) {
        AtomicBoolean previousBridge = new AtomicBoolean(false);
        return IntStream.range(START, countOfPerson)
                .mapToObj(i-> {
                    boolean hasBridge = !previousBridge.get() && random.nextBoolean();
                    previousBridge.set(hasBridge);
                    return hasBridge;
                })
                .collect(Collectors.toList());
    }
}
