package nextstep.ladder.domain;

import java.util.function.Predicate;

public interface ConnectCondition extends Predicate<Line> {
    boolean test(Line line);
}
