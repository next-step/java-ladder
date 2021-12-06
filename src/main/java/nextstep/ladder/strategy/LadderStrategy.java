package nextstep.ladder.strategy;

import java.util.List;

@FunctionalInterface
public interface LadderStrategy {
    List<Boolean> makeLadder(int size);
}
