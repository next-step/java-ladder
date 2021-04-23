package ladder.domain.ladder;

import ladder.exception.IllegalBooleanArgumentsException;

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

    public static Heading valueOf(boolean left, boolean current) {
        return Arrays.stream(Heading.values())
                .filter(heading -> isStateSame(heading, left, current))
                .findFirst()
                .orElseThrow(()-> new IllegalBooleanArgumentsException(left, current));
    }

    private static final boolean isStateSame(Heading heading, boolean left, boolean current) {
        return (heading.left == left) && (heading.current == current);
    }

    public final int go(int position) {
        return Math.addExact(position, change);
    }
}
