package laddergame.domain;

import laddergame.utils.Validation;

public class Depth {

    private final int count;

    public Depth(final int count) {
        Validation.lengthOfDepth(count);
        this.count = count;
    }

    public int size() {
        return count;
    }
}
