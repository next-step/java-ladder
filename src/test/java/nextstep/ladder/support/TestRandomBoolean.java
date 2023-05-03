package nextstep.ladder.support;

import java.util.LinkedList;
import java.util.Queue;

public class TestRandomBoolean implements RandomBoolean {
    private final Queue<Boolean> booleans;

    public TestRandomBoolean(LinkedList<Boolean> booleans) {
        this.booleans = booleans;
    }

    @Override
    public boolean nextBoolean() {
        Boolean aBoolean = booleans.poll();
        return aBoolean != null && aBoolean;
    }
}
