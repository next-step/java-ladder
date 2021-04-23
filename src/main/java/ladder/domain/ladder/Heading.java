package ladder.domain.ladder;

import java.util.Arrays;

public enum Heading {

    RIGHT(1, false, true),
    LEFT(-1, true, false),
    PASS(0, false, false);

    final int change;
    final boolean left;
    final boolean current;

    Heading(int change, boolean left, boolean current) {
        this.change = change;
        this.left = left;
        this.current = current;
    }



    private static final boolean isStateSame(Heading heading, boolean left, boolean current) {
        return (heading.current && current) && (heading.left && left);
    }

    public final int go(int position) {
        return Math.addExact(position, change);
    }
}
