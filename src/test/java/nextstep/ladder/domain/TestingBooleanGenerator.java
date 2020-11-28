package nextstep.ladder.domain;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TestingBooleanGenerator implements BooleanGenerator {

    private final Queue<Boolean> queue;

    public TestingBooleanGenerator(Boolean... booleans) {
        queue = new ArrayDeque<>(Arrays.asList(booleans));
    }

    @Override
    public Boolean nextBoolean() {
        return queue.poll();
    }
}
