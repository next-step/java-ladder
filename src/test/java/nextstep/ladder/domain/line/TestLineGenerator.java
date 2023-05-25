package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.generator.LineGenerator;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestLineGenerator implements LineGenerator {

    private static final int START = 0;

    @Override
    public List<Boolean> generator(int countOfPerson) {
        AtomicBoolean previousBridge = new AtomicBoolean(false);
        return IntStream.range(START, countOfPerson)
                .mapToObj(i-> {
                    boolean hasBridge = !previousBridge.get() && true;
                    previousBridge.set(hasBridge);
                    return hasBridge;
                })
                .collect(Collectors.toList());
    }
}
