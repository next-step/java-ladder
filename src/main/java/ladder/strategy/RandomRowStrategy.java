package ladder.strategy;

import ladder.domain.Point;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomRowStrategy implements RowStrategy {

    private static final Random random = new Random();

    @Override
    public List<Point> generate(long size) {

        AtomicLong index = new AtomicLong(1);
        return Stream.iterate(Point.first(random()), previous -> {
                    if (last(size, index)) {
                        return previous.last();
                    }

                    if (previous.right()) {
                        return previous.next(false);
                    }

                    return previous.next(random());
                })
                .limit(size)
                .collect(Collectors.toList());
    }

    private boolean last(long size, AtomicLong index) {
        long current = index.incrementAndGet();
        return size == current;

    }

    private Boolean random() {
        return random.nextBoolean();
    }
}
