package nextstep.fp;

import java.util.function.IntPredicate;

@FunctionalInterface
public interface Conditional extends IntPredicate {
    @Override
    boolean test(int value);
}
