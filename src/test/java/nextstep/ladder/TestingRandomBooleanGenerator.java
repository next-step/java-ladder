package nextstep.ladder;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class TestingRandomBooleanGenerator implements RandomBooleanGenerator {

    private final Queue<Boolean> queue;

    public TestingRandomBooleanGenerator(Boolean... booleans) {
        queue = new ArrayDeque<>(Arrays.asList(booleans));
    }

    @Override
    public Boolean nextBoolean() {
        return queue.poll();
    }
}
