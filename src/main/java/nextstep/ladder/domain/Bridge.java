package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Bridge {
    private final boolean value;

    private static final Map<Boolean, Bridge> cacheBridge = new HashMap<>();

    static {
        cacheBridge.put(Boolean.TRUE, new Bridge(true));
        cacheBridge.put(Boolean.FALSE, new Bridge(false));
    }

    private Bridge(boolean value) {
        this.value = value;
    }

    static Bridge of(boolean value) {
        return cacheBridge.get(value);
    }

    public boolean canCrossBridge() {
        return value;
    }

    public Bridge next() {
        if (this.value) {
            return of(false);
        }
        return of(ThreadLocalRandom.current().nextBoolean());
    }
}
