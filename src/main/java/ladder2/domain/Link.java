package ladder2.domain;

import java.util.function.Function;

public enum Link {

    LEFT_LINK(index -> index - 1),
    RIGHT_LINK(index -> index + 1),
    NO_LINK(index -> index);

    private final Function<Integer, Integer> nextIndexFunction;

    Link(Function<Integer, Integer> nextIndexFunction) {
        this.nextIndexFunction = nextIndexFunction;
    }

    public int nextIndex(int index) {
        return nextIndexFunction.apply(index);
    }
}
