package ladder.domain;

import ladder.exception.LadderException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Way {

    private final static Map<String, Way> cache;
    private final boolean left;
    private final boolean right;

    static {
        Map<String, Way> tmp = new HashMap<>();
        tmp.put("left", new Way(true, false));
        tmp.put("right", new Way(false, true));
        tmp.put("none", new Way(false, false));
        cache = Collections.unmodifiableMap(tmp);
    }

    public Way(final boolean left, final boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    public static Way left() {
        return cache.get("left");
    }

    public static Way right() {
        return cache.get("right");
    }

    public static Way none() {
        return cache.get("none");
    }

    private void validate(final boolean left, final boolean right) {
        if (left && right) {
            throw new LadderException("양방향 이동은 불가");
        }
    }

    public boolean isMovableLeft() {
        return this.left;
    }

    public boolean isMovableRight() {
        return this.right;
    }
}
