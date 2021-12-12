package nextstep.ladder.domain.line;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import nextstep.ladder.domain.LineCount;

public class RandomLineStrategy implements LineGenerateStrategy {
    private static final Random RANDOM = new Random();

    private final AtomicBoolean previousPoint = new AtomicBoolean(RANDOM.nextBoolean());

    @Override
    public List<Boolean> generate(LineCount lineCount) {
        return Stream.generate(this::generatePoint)
                .limit(lineCount.toInt())
                .collect(Collectors.toList());
    }

    public boolean generatePoint() {
        return previousPoint.getAndSet(!previousPoint.get() && RANDOM.nextBoolean());
    }
}
