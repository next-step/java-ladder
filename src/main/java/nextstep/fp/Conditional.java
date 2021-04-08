package nextstep.fp;

import java.util.function.Predicate;

public interface Conditional extends Predicate<Integer> {
    boolean test(Integer number);
}
